package model;

public class ClienteModel {
	protected String codCliente;
	protected String telefone;
	protected String bairro;
	protected String logradouro;
	protected String cidade;
	protected String uf;
	protected String cep;
	protected String numero;
	protected boolean ativo;

	public ClienteModel(String codCliente, String telefone, String bairro, String logradouro, String cidade, String uf,
			String cep, String numero) {
		this.codCliente = codCliente;
		this.telefone = telefone;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.numero = numero;
		this.ativo = true;
	}

	public String getcodCliente() {
		return codCliente;
	}

	public void setcodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
