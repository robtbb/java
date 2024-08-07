package model.entities.exception;

import model.entities.Cliente;

public class ClienteNaoEncontradoClass extends Cliente{
	private static final long serialVersionUID = 1L;

	static String mensagem = "Cliente não existente para o Id: ";

	public ClienteNaoEncontradoClass() {
	}

	public static String getMensagem() {
		return mensagem;
	}

	public static void setMensagem(String mensagem) {
		ClienteNaoEncontradoClass.mensagem = mensagem;
	}
}
