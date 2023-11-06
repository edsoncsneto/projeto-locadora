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
		if(obj instanceof VeiculoModel) {
			Scanner sc = new Scanner(System.in);
			System.out.println("[1] Placa \n"+
			"[2] Cor \n" +
			"[3] Marca \n" +
			"[4] Categoria \n" +
			"[5] Modelo \n" +
			"Digite a opção");
			
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
		
	}



	@Override
	public void imprimir() {
		for(VeiculoModel veic : veiculos) {
			System.out.println(veic.getPlaca());
			System.out.println(veic.getModelo());
			System.out.println(veic.getMarca());
			System.out.println(veic.getCor());
			System.out.println(veic.getSeguro());
			System.out.println("-------");
		}
		
	}



	@Override
	public void remover(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirUm(String placa) {
		for(VeiculoModel veic : veiculos) {
			if(placa.equals(veic.getPlaca())) {
				System.out.println(veic.getPlaca());
				System.out.println(veic.getModelo());
				System.out.println(veic.getMarca());
				System.out.println(veic.getCor());
				System.out.println(veic.getSeguro());
				System.out.println("-------");
			}
		}
	}

}
