package br.com.professorisidro.isilanguage.ast;
import java.util.ArrayList;
import java.util.Stack;
public class CommandSwitch extends AbstractCommand{

	private String var;
	private ArrayList<AbstractCommand> bloco;
	private Stack<ArrayList<AbstractCommand>> temp;
	private int cont;
	
	public CommandSwitch(String var, Stack<ArrayList<AbstractCommand>> temp, int cont) {
		this.var=var;
		this.temp=temp;
		this.cont=cont;
	}

	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
