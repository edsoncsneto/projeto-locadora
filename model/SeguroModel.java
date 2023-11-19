package model;

import java.util.Date;

public class SeguroModel {
	private String apolice;
	private double valor;
	private Date dataInicio;
	private Date dataFim;
	private String tipoCobertura;
	private String historicoSinistro;
	private String franquia;
	private boolean ativo;
	private VeiculoModel veiculo;

	public SeguroModel(){
	}

	public SeguroModel(String apolice, double valor, Date dataInicio, Date dataFim, String tipoCobertura,
			String historicoSinistro, String franquia) {

		this.apolice = apolice;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tipoCobertura = tipoCobertura;
		this.historicoSinistro = historicoSinistro;
		this.franquia = franquia;
		this.ativo = true;
	}

	public String getApolice() {
		return apolice;
	}

	public void setApolice(String apolice) {
		this.apolice = apolice;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getdataInicio() {
		return dataInicio;
	}

	public void setdataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getdataFim() {
		return dataFim;
	}

	public void setdataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String gettipoCobertura() {
		return tipoCobertura;
	}

	public void settipoCobertura(String tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public String gethistoricoSinistro() {
		return historicoSinistro;
	}

	public void sethistoricoSinistro(String historicoSinistro) {
		this.historicoSinistro = historicoSinistro;
	}

	public String getFranquia() {
		return franquia;
	}

	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public VeiculoModel getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoModel veiculo) {
		this.veiculo = veiculo;
	}

}
