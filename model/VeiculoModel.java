package model;

public class VeiculoModel {
	private String placa;
	private String cor;
	private String marca;
	private String categoria;
	private String chassi;
	private String modelo;
	private SeguroModel seguro;
	private ManutencaoModel manutencao;
	private boolean ativo;
	
	public VeiculoModel(String placa, String cor, String marca, String categoria, String chassi, String modelo,
			SeguroModel seguro, ManutencaoModel manutencao) {
		this.placa = placa;
		this.cor = cor;
		this.marca = marca;
		this.categoria = categoria;
		this.chassi = chassi;
		this.modelo = modelo;
		this.seguro = seguro;
		this.manutencao = manutencao;
		this.ativo = true;
	}

	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getChassi() {
		return chassi;
	}


	public void setChassi(String chassi) {
		this.chassi = chassi;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public SeguroModel getSeguro() {
		return seguro;
	}


	public void setSeguro(SeguroModel seguro) {
		this.seguro = seguro;
	}


	public ManutencaoModel getManutencao() {
		return manutencao;
	}


	public void setManutencao(ManutencaoModel manutencao) {
		this.manutencao = manutencao;
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
