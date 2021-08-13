package br.com.professorisidro.isilanguage.ast;
import java.util.ArrayList;
public class CommandRepeticao1 extends AbstractCommand{

	private String stopcondition;
	private ArrayList<AbstractCommand> bloco;
	
	public CommandRepeticao1(String stopcondition, ArrayList<AbstractCommand> bloco) {
		// TODO Auto-generated constructor stub
		this.bloco=bloco;
		this.stopcondition=stopcondition;
	}

	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("while (" + stopcondition + "){\n");
		for(AbstractCommand cmd: bloco) {
			str.append(cmd.generateJavaCode());
			str.append("\n");
		}str.append("}");
		return str.toString();
	}
	
	@Override
	public String toString() {
		return "CommandRepeticao1 [condition=" + stopcondition + ", bloco=" + bloco +"]";
	}

}