package model;

public class ClientePFModel extends ClienteModel {
	private String nome;
	private String cpf;
	private String cnh;

	public ClientePFModel(String codCliente, String telefone, String bairro, String logradouro, String cidade,
			String uf, String cep, String numero, String nome, String cpf, String cnh) {
		super(codCliente, telefone, bairro, logradouro, cidade, uf, cep, numero);
		this.nome = nome;
		this.cpf = cpf;
		this.cnh = cnh;
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getCnh() {
		return cnh;
	}



	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

}
