package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.VeiculoModel;

public class VeiculoController implements IController{
	
	List<VeiculoModel> veiculos = new ArrayList<>();

	@Override
	public void criar(Object obj) {
		if(obj instanceof VeiculoModel) {
			veiculos.add((VeiculoModel) obj);
		}
	}

	@Override
	public void editar(Object obj) {
		Scanner sc = new Scanner(System.in);
		if(obj instanceof VeiculoModel) {
			System.out.println("[1] Placa \n"+
			"[2] Cor \n" +
			"[3] Marca \n" +
			"[4] Categoria \n" +
			"[5] Modelo \n" +
			"Digite a op��o");
			
			String opcao = sc.nextLine();

			switch(opcao){
				case "1":
					System.out.println("Digite a nova placa: ");
					String novaPlaca = sc.nextLine();
					((VeiculoModel) obj).setPlaca(novaPlaca);
					break;
				case "2":
					System.out.println("Digite a nova cor: ");
					String novaCor = sc.nextLine();
					((VeiculoModel) obj).setCor(novaCor);
					break;
				case "3":
					System.out.println("Digite a nova Marca: ");
					String novaMarca = sc.nextLine();
					((VeiculoModel) obj).setMarca(novaMarca);
					break;
				case "4":
					System.out.println("Digite a nova categoria: ");
					String novaCategoria = sc.nextLine();
					((VeiculoModel) obj).setCategoria(novaCategoria);
					break;
				case "5":
					System.out.println("Digite o novo modelo: ");
					String novoModelo = sc.nextLine();
					((VeiculoModel) obj).setModelo(novoModelo);
					break;
            }
            imprimirUm(((VeiculoModel) obj).getPlaca());
		}
		sc.close();
	}

	@Override
	public void imprimir() {
		for(VeiculoModel veic : veiculos) {
			imprimirUm(veic.getPlaca());
		}
	}

	@Override
	public void remover(Object obj) {
		if(obj instanceof VeiculoModel){
			((VeiculoModel) obj).setAtivo(false);
			((VeiculoModel) obj).getManutencao().setAtivo(false);
			((VeiculoModel) obj).getSeguro().setAtivo(false);
			//inativando a manutenção e o seguro desse veículo
		}
	}

	@Override
	public void imprimirUm(String placa) {
		for(VeiculoModel veic : veiculos) {
			if(placa.equals(veic.getPlaca())) {
				System.out.println("Placa: "+veic.getPlaca());
				System.out.println("Modelo: "+veic.getModelo());
				System.out.println("Marca: "+veic.getMarca());
				System.out.println("Cor: "+veic.getCor());
				if(veic.getManutencao()==null){
					System.out.println("Manutenção nula");
				}else{
					System.out.println("Ordem de serviço da manutenção: " + veic.getManutencao().getOrdemServico());
				}

				if(veic.getSeguro()==null){
					System.out.println("Seguro nulo");
				}else{
					System.out.println("Apólice do veículo: " + veic.getSeguro().getApolice());
				}

				if(veic.isAtivo()){
					System.out.println("Status: ativo");
				}else{
					System.out.println("Status: inativo");
				}
				System.out.println("---------------");
			}
		}
	}
}
