grammar IsiLang;

@header{
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.IsiProgram;
	import br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import br.com.professorisidro.isilanguage.ast.CommandDecisao;
	import br.com.professorisidro.isilanguage.ast.CommandRepeticao1;
	import br.com.professorisidro.isilanguage.ast.CommandRepeticao2;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
	private int _tipo;
	private int ncases;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	private ArrayList<String> stackUsedVariables = new ArrayList<String>();
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Symbol "+id+" not declared");
		}
	}
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
}

prog	: 'programa' decl bloco fimprog
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	 
           } 
		;
		
fimprog : 'fimprog;' {		
		if(!stackUsedVariables.isEmpty())
			throw new IsiSemanticException("Variable "+stackUsedVariables.get(0)+" not used");
	}
;

		
decl    :  (declaravar)+
        ;
        
        
declaravar :  tipo ID  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  stackUsedVariables.add(_varName);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    } 
              (  VIR 
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  stackUsedVariables.add(_varName);
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    }
              )* 
               SC
           ;
           
tipo       : 'numero' { _tipo = IsiVariable.NUMBER;  }
           | 'texto'  { _tipo = IsiVariable.TEXT;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao
 		|  cmdrepet1
 		|  cmdrepet2
		;
		
cmdleitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        } 
                     FP 
                     SC 
                     
              {
              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }   
			;
			
cmdescrita	: 'escreva' 
                 AP 
                 (
                 	ID { verificaID(_input.LT(-1).getText());
	                  _writeID = _input.LT(-1).getText();
	                  if(stackUsedVariables.contains(_writeID))
	                  	stackUsedVariables.remove(stackUsedVariables.indexOf(_writeID));
                     }
                    | STRING {_writeID = _input.LT(-1).getText() ;}
                  
                 ) 
                 FP 
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;
			
cmdattrib	:  ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                   } 
               ATTR { _exprContent = ""; } 
               (expr | STRING {_exprContent += _input.LT(-1).getText() ;}) 
               SC
               {
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
               	 stack.peek().add(cmd);
               }
			;
					
cmdselecao  :  'se' AP
                    ID    
                    { 
                    	verificaID(_input.LT(-1).getText());
                    	_exprDecision = _input.LT(-1).getText();
                    	if(stackUsedVariables.contains(_exprDecision))
	                  		stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
                    }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (
                    	ID
                    	{
                    		verificaID(_input.LT(-1).getText());
                    		_exprDecision += _input.LT(-1).getText();
                    		if(stackUsedVariables.contains(_exprDecision))
	                  			stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
                    	}
                    	| NUMBER
                    	{
                    		_exprDecision += _input.LT(-1).getText();
                    	}
                    ) 
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('senao' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 } 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;
            
cmdrepet1 : 'enquanto' AP
					   ID    
					   { 
					   	verificaID(_input.LT(-1).getText());
					   	_exprDecision = _input.LT(-1).getText();
					   	if(stackUsedVariables.contains(_exprDecision))
					   		stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
					   }
					   OPREL { _exprDecision += _input.LT(-1).getText(); }
					   (
					   	ID
					   	{
					   		verificaID(_input.LT(-1).getText());
					   		_exprDecision += _input.LT(-1).getText();
					   		if(stackUsedVariables.contains(_exprDecision))
					   			stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
					   	}
					   	| NUMBER
					   	{
					   		_exprDecision += _input.LT(-1).getText();
					   	}
					   ) 
					   FP
					   ACH 
	                   { curThread = new ArrayList<AbstractCommand>(); 
	                     stack.push(curThread);
	                   }
	                   (cmd)+
	                   FCH
	                   {
	                   	listaTrue = stack.pop();
	                   	CommandRepeticao1 cmd = new CommandRepeticao1(_exprDecision, listaTrue);
	                   	stack.peek().add(cmd);
	                   }
			;
			
cmdrepet2 : 'para' AP

				   ID 
				   {
				   	_exprDecision = "";
				   	verificaID(_input.LT(-1).getText());
				    _exprDecision = _input.LT(-1).getText();
				    if(stackUsedVariables.contains(_exprDecision))
				    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
				   }
				   ATTR { _exprDecision +="="; }
	               expr2 {_exprDecision += ";";}
				   SC


				   ID
				   {
				   	verificaID(_input.LT(-1).getText());
				   	_exprDecision += _input.LT(-1).getText();
				   	if(stackUsedVariables.contains(_exprDecision))
				    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
				   }
				   OPREL { _exprDecision += _input.LT(-1).getText(); }
				   (ID | NUMBER) 
				   {
				   	_exprDecision += _input.LT(-1).getText();
				   	_exprDecision += ";";
				   }
				   SC


				   ID 
				   {
				   	verificaID(_input.LT(-1).getText());
				   	_exprID = _input.LT(-1).getText();
				   	_exprDecision += _input.LT(-1).getText();
				   	if(stackUsedVariables.contains(_exprDecision))
				    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
				   }
				   ATTR { _exprDecision +="=";}
				   expr2
				   
				   FP
				   
				   ACH
				   {
				   	curThread = new ArrayList<AbstractCommand>(); 
	                stack.push(curThread);
	               }
	               (cmd)+
	               FCH
                   {
                   	listaTrue = stack.pop();
                   	CommandRepeticao2 cmd2 = new CommandRepeticao2(_exprDecision, listaTrue);
                   	stack.peek().add(cmd2);
                   }
			;
			
cmdswitch	: 'switch'	AP
						ID 
					   	{
					   		_exprDecision = "";
						   	verificaID(_input.LT(-1).getText());
						    _exprDecision = _input.LT(-1).getText();
						    if(stackUsedVariables.contains(_exprDecision))
						    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
					   	}
					   	FP
					   	ACH
					   	(
					   		'case'
					   		COLON
					   		NUMBER
					   	)+ 
					   	{
					   		ncases += 1;
					   	}
					   	(
					   		'default'
					   	)?
					   	FCH
			;			
			
expr		:  termo ( 
	             OP  { _exprContent += _input.LT(-1).getText();}
	            termo
	            )*
			;
			
expr2		:  termo2 ( 
	             OP
	             { 
	             	_exprDecision += _input.LT(-1).getText();	
	             }
	            termo2
	            )*
			;
			
termo		: ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
                 } 
            | 
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
              }
			;
		
termo2		: ID { verificaID(_input.LT(-1).getText());
	               _exprDecision += _input.LT(-1).getText();
                 } 
            | 
              NUMBER
              {
              	_exprDecision += _input.LT(-1).getText();
              }
			;			

ASP : '"'
	;

AP	: '('
	;
	
FP	: ')'
	;
	
COLON 	: ':'
		;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
	 
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
STRING	:ASP ([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9] | WS)+ ASP
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;