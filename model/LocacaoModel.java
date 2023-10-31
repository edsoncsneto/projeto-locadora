package model;

import java.util.Date;

public class LocacaoModel {
	private ClientePFModel clientePF;
	private ClientePJModel clientePJ;
	private Date dataInicio;
	private Date dataFim;
	private VeiculoModel[] veiculos;
	private FuncionarioModel funcionario;

	// construtor para cliente pf
	public LocacaoModel(ClientePFModel clientePF, Date dataInicio, Date dataFim, VeiculoModel[] veiculos,
			FuncionarioModel funcionario) {
		this.clientePF = clientePF;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.veiculos = veiculos;
		this.funcionario = funcionario;
	}

	// construtor para cliente pj
	public LocacaoModel(ClientePJModel clientePJ, Date dataInicio, Date dataFim, VeiculoModel[] veiculos,
			FuncionarioModel funcionario) {
		this.clientePJ = clientePJ;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.veiculos = veiculos;
		this.funcionario = funcionario;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
