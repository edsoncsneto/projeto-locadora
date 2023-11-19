package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ManutencaoModel;
import model.VeiculoModel;

import javax.management.modelmbean.ModelMBeanConstructorInfo;

public class ManutencaoController implements IController{
	List<ManutencaoModel> manutencoes = new ArrayList<>();
	VeiculoModel veiculo;
	
	@Override
	public void criar(Object obj) {
		manutencoes.add((ManutencaoModel) obj);
	}
	
	@Override
	public void editar(Object obj){
		Scanner sc = new Scanner(System.in);
		System.out.println("[1] Ordem de serviço");
		System.out.println("[2] Data");
		System.out.println("[3] Tipo Manutenção");
		System.out.print("Digite a opção: ");

		String opcao = sc.nextLine();

		switch (opcao){
			case "1":
				System.out.print("Digite a nova ordem de serviço: ");
				String novaOS = sc.nextLine();
				((ManutencaoModel) obj).setOrdemServico(novaOS);
				break;
			case "2":
				System.out.print("Digite a nova data: ");
				String novaData = sc.nextLine(); //converter String para tipo Date
				//((ManutencaoModel) obj).setData(novaData);
				break;
			case "3":
				System.out.print("Digite o novo tipo de manutenção: ");
				String novoTM = sc.nextLine();
				((ManutencaoModel) obj).setTipoManutencao(novoTM);
				break;
		}
	}
	
	@Override
	public void imprimir() {
		for(ManutencaoModel manutencao : manutencoes){
			imprimirUm(manutencao.getOrdemServico());
		}
	}
	
	@Override
	public void remover(Object obj) {
		if(!((ManutencaoModel) obj).isAtivo()){
			System.out.println("Essa já não é uma manutenção ativa!");
		}else{
			((ManutencaoModel) obj).getVeiculo().setManutencao(null);
			((ManutencaoModel) obj).setAtivo(false);
		}
	}

	@Override
	public void imprimirUm(String ordemServico) {
		for(ManutencaoModel manutencao : manutencoes){
			if(ordemServico.equals(manutencao.getOrdemServico())){
				System.out.println("Ordem de serviço: "+manutencao.getOrdemServico());
				System.out.println("Tipo da manutenção: "+manutencao.getTipoManutencao());
				System.out.println("Data:" +manutencao.getData());
				if(manutencao.isAtivo()){
					System.out.println("Status: ativa");
				}else{
					System.out.println("Status: inativa");
				}
				System.out.println("---------------");
			}
		}
	}
}
