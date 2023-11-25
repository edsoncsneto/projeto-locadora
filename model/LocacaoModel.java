package model;

import java.time.LocalDate;
import java.util.List;

public class LocacaoModel {
	private String codLocacao;
	private ClienteModel cliente;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private List<VeiculoModel> veiculos;
	private FuncionarioModel funcionario;
	private boolean ativo;

	public LocacaoModel(String codLocacao, ClienteModel cliente, LocalDate dataInicio, LocalDate dataFim, List<VeiculoModel> veiculos,
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

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public List<VeiculoModel> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoModel> veiculos) {
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
