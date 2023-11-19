package model;

public class FuncionarioModel {
	private String matricula;
	private String nome;
	private String cpf;
	private double salario;
	private int quantidadeLocacoes;
	private FuncionarioModel supervisor;
	private boolean ativo;

	public FuncionarioModel(String matricula, String nome, String cpf, double salario, FuncionarioModel supervisor) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.supervisor = supervisor;
		this.ativo = true;
	}
	
	public FuncionarioModel(String matricula, String nome, String cpf, double salario) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.ativo = true;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getQuantidadeLocacoes() {
		return quantidadeLocacoes;
	}

	public void setQuantidadeLocacoes(int quantidadeLocacoes) {
		this.quantidadeLocacoes = quantidadeLocacoes;
	}

	public FuncionarioModel getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(FuncionarioModel supervisor) {
		this.supervisor = supervisor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
