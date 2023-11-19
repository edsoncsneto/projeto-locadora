package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.SeguroModel;

public class SeguroController implements IController{
	List<SeguroModel> seguros = new ArrayList<>();

	@Override
	public void criar(Object obj) {
		seguros.add((SeguroModel) obj);
	}

	@Override
	public void editar(Object obj) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[1] Apólice");
		System.out.println("[2] Valor");
		System.out.println("[3] Data início");
		System.out.println("[4] Data fim");
		System.out.println("[5] Tipo cobertura");
		System.out.println("[6] Histórico sinistro");
		System.out.println("[7] Franquia");
		System.out.print("Digite a opção: ");

		String opcao = sc.nextLine();

		switch (opcao){
			case "1":
				System.out.print("Digite a nova apólice: ");
				String novaApolice = sc.nextLine();
				((SeguroModel) obj).setApolice(novaApolice);
				break;
			case "2":
				System.out.print("Digite o novo valor: ");
				double novoValor = sc.nextDouble();
				((SeguroModel) obj).setValor(novoValor);
				break;
			case "3":
				System.out.print("Digite a nova data de início: ");
				String novaDI = sc.nextLine(); //convertar String para Date
				//((SeguroModel) obj).setdataInicio(novaDI);
				break;
			case "4":
				System.out.print("Digite a nova data fim: ");
				String novaDF = sc.nextLine(); //converter String para Date
				//((SeguroModel) obj).getdataFim(novaDF);
				break;
			case "5":
				System.out.print("Digite o novo tipo de cobertura: ");
				String novoTC = sc.nextLine();
				((SeguroModel) obj).settipoCobertura(novoTC);
				break;
			case "6":
				System.out.print("Digite o novo histórico sinistro: ");
				String novoHS = sc.nextLine();
				((SeguroModel) obj).sethistoricoSinistro(novoHS);
				break;
			case "7":
				System.out.println("Digite a nova franquia: ");
				String novaFranquia = sc.nextLine();
				((SeguroModel) obj).setFranquia(novaFranquia);
				break;
		}
		
	}

	@Override
	public void imprimir() {
		for(SeguroModel seg : seguros){
			imprimirUm(seg.getApolice());
		}
	}

	@Override
	public void remover(Object obj) {
		if(!((SeguroModel) obj).isAtivo()){
			System.out.println("Esse já não é um seguro ativo!");
		}else{
			((SeguroModel) obj).getVeiculo().setSeguro(null);
			((SeguroModel) obj).setAtivo(false);
		}
	}

	@Override
	public void imprimirUm(String apolice) {
		for (SeguroModel seg : seguros){
			if(apolice.equals(seg.getApolice())){
				System.out.println("Apólice: "+seg.getApolice());
				System.out.println("Franquia: "+seg.getFranquia());
				System.out.println("Tipo de cobertura: "+seg.gettipoCobertura());
				System.out.println("Valor: "+seg.getValor());
				System.out.println("Data início: "+seg.getdataInicio());
				System.out.println("Data fim: "+seg.getdataFim());
				System.out.println("Histórico sinsitro: "+seg.gethistoricoSinistro());
				if(seg.isAtivo()){
					System.out.println("Status: ativo");
				}else{
					System.out.println("Status: inativo");
				}
				System.out.println("---------------");
			}
		}
	}
}
