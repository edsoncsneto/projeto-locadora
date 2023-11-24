package model;

import java.util.Date;

public class LocacaoModel {
	private String codLocacao;
	private ClienteModel cliente;
	private Date dataInicio;
	private Date dataFim;
	private VeiculoModel[] veiculos;
	private FuncionarioModel funcionario;
	private boolean ativo;

	public LocacaoModel(String codLocacao, ClienteModel cliente, Date dataInicio, Date dataFim, VeiculoModel[] veiculos,
			FuncionarioModel funcionario) {
		this.codLocacao = codLocacao;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.veiculos = veiculos;
		this.funcionario = funcionario;
		this.funcionario.setQuantidadeLocacoes(funcionario.getQuantidadeLocacoes()+1);
		this.ativo = true;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public VeiculoModel[] getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(VeiculoModel[] veiculos) {
		this.veiculos = veiculos;
	}

	public FuncionarioModel getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioModel funcionario) {
		this.funcionario = funcionario;
	}

	public String getCodLocacao() {
		return codLocacao;
	}

	public void setCodLocacao(String codLocacao) {
		this.codLocacao = codLocacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
