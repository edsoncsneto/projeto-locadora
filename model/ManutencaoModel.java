package model;

import java.util.Date;

public class ManutencaoModel {
	private String ordemServico;
	private Date data;
	private String tipoManutencao;
	
	public ManutencaoModel(String ordemServico, Date data, String tipoManutencao) {
		this.ordemServico = ordemServico;
		this.data = data;
		this.tipoManutencao = tipoManutencao;
	}

	public String getOrdemServico() {
		return ordemServico;
	}



	public void setOrdemServico(String ordemServico) {
		this.ordemServico = ordemServico;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public String getTipoManutencao() {
		return tipoManutencao;
	}



	public void setTipoManutencao(String tipoManutencao) {
		this.tipoManutencao = tipoManutencao;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
