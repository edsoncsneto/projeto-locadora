package model;

import java.time.LocalDate;
import java.util.Date;

public class ManutencaoModel {
	private String ordemServico;
	private LocalDate data;
	private String tipoManutencao;
	private boolean ativo;
	private VeiculoModel veiculo;
	
	public ManutencaoModel(String ordemServico, LocalDate data, String tipoManutencao, VeiculoModel veiculo) {
		this.ordemServico = ordemServico;
		this.data = data;
		this.tipoManutencao = tipoManutencao;
		this.ativo = true;
		this.veiculo = veiculo;
	}

	public String getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(String ordemServico) {
		this.ordemServico = ordemServico;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getTipoManutencao() {
		return tipoManutencao;
	}

	public void setTipoManutencao(String tipoManutencao) {
		this.tipoManutencao = tipoManutencao;
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
