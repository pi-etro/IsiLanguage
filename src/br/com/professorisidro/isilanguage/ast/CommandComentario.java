package br.com.professorisidro.isilanguage.ast;

public class CommandComentario extends AbstractCommand {

	private String comment;
	
	public CommandComentario(String comment) {
		this.comment = comment;
	}

	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return comment; //"//"+
	}

	@Override
	public String toString() {
		return "CommandCommentario [id=" + comment + "]";
	}
	
}
