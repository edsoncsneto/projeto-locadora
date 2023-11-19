package model;

public class ClientePJModel extends ClienteModel {
	private String cnpj;
	private String razaoSocial;
	
	public ClientePJModel(String codCliente, String telefone, String bairro, String logradouro, String cidade,
			String uf, String cep, String numero, String cnpj, String razaoSocial) {
		super(codCliente, telefone, bairro, logradouro, cidade, uf, cep, numero);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

}
