package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.LocacaoModel;
import model.VeiculoModel;

public class LocacaoController implements IController{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	List<LocacaoModel> locacoes = new ArrayList<>();

	@Override
	public void criar(Object obj) {
		locacoes.add((LocacaoModel) obj);
	}

	@Override
	public void editar(String id) {
		for (LocacaoModel locacao:locacoes){
			if(locacao.getCod_locacao().equals(id)){
				Scanner sc = new Scanner(System.in);
				System.out.println("[1] Código da locação");
				System.out.println("[2] Cliente");
				System.out.println("[3] Data de início");
				System.out.println("[4] Data do fim");
				System.out.println("[5] Remover veículo");
				System.out.println("[6] Adicionar veículo");
				System.out.println("[7] Editar funcionário");
				System.out.print("Digite a opção: ");
				String opcao = sc.nextLine();

				//TODO implementar switch case.
				/*Regra de negócio: edição de datas assim como foi feito em seguro
				 *Trocar um cliente por outro
				 *Remover e adicionar veículos da lista
				 * Trocar funcionário por outro. Obs.: funcionário que sai tem uma locação a menos.
				 * 	locacao.getFuncionario.setQuantidadeLocacoes(locacao.getFuncionario()-1)
				 */

			}
		}
	}

	@Override
	public void imprimir() {
		for(LocacaoModel locacao:locacoes){
			imprimirUm(locacao.getCod_locacao());
		}
	}

	@Override
	public void remover(String id) {
		for(LocacaoModel locacao:locacoes){
			if(locacao.getCod_locacao().equals(id)){
				locacao.setAtivo(false);
			}
		}
	}

	@Override
	public void imprimirUm(String cod_locacao) {
		for (LocacaoModel loc : locacoes){
			if(loc.getCod_locacao().equals(cod_locacao)){
				System.out.println("Código da locação: "+loc.getCod_locacao());
				System.out.println("Código do cliente: "+loc.getCliente().getcodCliente());
				System.out.println("Data de início: "+sdf.format(loc.getDataInicio()));
				System.out.println("Data do fim: "+sdf.format(loc.getDataFim()));
				System.out.println("Matrícula do funcionário: "+loc.getFuncionario().getMatricula());
				if(loc.isAtivo()){
					System.out.println("Status: ativo");
				}else{
					System.out.println("Status: inativo");
				}
				System.out.println("Lista de carros: ");
				for (VeiculoModel veiculo : loc.getVeiculos()){
					System.out.println(veiculo.getPlaca());
				}
			}
		}
	}
}