package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.SeguroModel;

public class SeguroController implements IController{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	List<SeguroModel> seguros = new ArrayList<>();

	@Override
	public void criar(Object obj) {
		seguros.add((SeguroModel) obj);
	}

	@Override
	public void editar(String id) throws ParseException {
		for(SeguroModel seguro:seguros){
			if(seguro.getApolice().equals(id)){
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
						seguro.setApolice(novaApolice);
						break;
					case "2":
						System.out.print("Digite o novo valor: ");
						double novoValor = sc.nextDouble();
						seguro.setValor(novoValor);
						break;
					case "3":
						System.out.print("Digite a nova data de início: ");
						String novaDIString = sc.nextLine();
						Date novaDI = sdf.parse(novaDIString);
						seguro.setdataInicio(novaDI);
						break;
					case "4":
						System.out.print("Digite a nova data fim: ");
						String novaDFString = sc.nextLine();
						Date novaDF = sdf.parse(novaDFString);
						seguro.setdataFim(novaDF);
						break;
					case "5":
						System.out.print("Digite o novo tipo de cobertura: ");
						String novoTC = sc.nextLine();
						seguro.settipoCobertura(novoTC);
						break;
					case "6":
						System.out.print("Digite o novo histórico sinistro: ");
						String novoHS = sc.nextLine();
						seguro.sethistoricoSinistro(novoHS);
						break;
					case "7":
						System.out.println("Digite a nova franquia: ");
						String novaFranquia = sc.nextLine();
						seguro.setFranquia(novaFranquia);
						break;
				}
				imprimirUm(seguro.getApolice());
				sc.close();
			}
		}
	}

	@Override
	public void imprimir() {
		for(SeguroModel seg : seguros){
			imprimirUm(seg.getApolice());
		}
	}

	@Override
	public void remover(String id) {
		for(SeguroModel seguro:seguros){
			if (seguro.getApolice().equals(id)){
				if(!seguro.isAtivo()){
					System.out.println("Esse já não é um seguro ativo!");
				}else{
					seguro.getVeiculo().setSeguro(null);
					seguro.setAtivo(false);
				}
			}
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
				System.out.println("Data fim: "+sdf.format(seg.getdataFim()));
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
