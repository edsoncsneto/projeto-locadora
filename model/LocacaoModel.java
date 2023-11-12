package model;

import java.util.Date;

public class LocacaoModel {
	private String cod_locacao;
	private ClientePFModel clientePF;
	private ClientePJModel clientePJ;
	private Date dataInicio;
	private Date dataFim;
	private VeiculoModel[] veiculos;
	private FuncionarioModel funcionario;
	private boolean ativo;

	// construtor para cliente pf
	public LocacaoModel(String cod_locacao, ClientePFModel clientePF, Date dataInicio, Date dataFim, VeiculoModel[] veiculos,
			FuncionarioModel funcionario) {
		this.cod_locacao = cod_locacao;
		this.clientePF = clientePF;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.veiculos = veiculos;
		this.funcionario = funcionario;
		this.ativo = true;
	}

	// construtor para cliente pj
	public LocacaoModel(String cod_locacao, ClientePJModel clientePJ, Date dataInicio, Date dataFim, VeiculoModel[] veiculos,
			FuncionarioModel funcionario) {
		this.cod_locacao = cod_locacao;
		this.clientePJ = clientePJ;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.veiculos = veiculos;
		this.funcionario = funcionario;
		this.ativo = true;
	}

	public ClientePFModel getClientePF() {
		return clientePF;
	}

	public void setClientePF(ClientePFModel clientePF) {
		this.clientePF = clientePF;
	}

	public ClientePJModel getClientePJ() {
		return clientePJ;
	}

	public void setClientePJ(ClientePJModel clientePJ) {
		this.clientePJ = clientePJ;
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

	public String getCod_locacao() {
		return cod_locacao;
	}

	public void setCod_locacao(String cod_locacao) {
		this.cod_locacao = cod_locacao;
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
