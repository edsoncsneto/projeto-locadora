package controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import model.ClienteModel;
import model.FuncionarioModel;
import model.LocacaoModel;
import model.VeiculoModel;
import view.LocacaoView;

import javax.swing.text.html.Option;

public class LocacaoController implements IController{
	ClienteController clienteController;
	VeiculoController veiculoController;
	FuncionarioController funcionarioController;

	LocacaoModel locacaoModel;
	LocacaoView locacaoView;

	public LocacaoController(LocacaoModel locacaoModel, LocacaoView locacaoView) {
		this.locacaoModel = locacaoModel;
		this.locacaoView = locacaoView;
	}

	DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	List<LocacaoModel> locacoes = new ArrayList<>();

	@Override
	public void criar(Object obj) {
		locacoes.add((LocacaoModel) obj);
	}

	@Override
	public void editar(String id) {
		for (LocacaoModel locacao:locacoes){
			if(locacao.getCodLocacao().equals(id)){
				Scanner sc = new Scanner(System.in);
				System.out.println("[1] Código da locação");
				System.out.println("[2] Alterar data de início");
				System.out.println("[3] Alterar data do fim");
				System.out.println("[4] Remover veículo");
				System.out.print("Digite a opção: ");
				String opcao = sc.nextLine();

				switch(opcao){
					case "1":
						System.out.print("Digite o novo código da locação: ");
						String novoCL = sc.nextLine();
						locacao.setCodLocacao(novoCL);
						break;
					case "2":
						try {
							System.out.print("Digite a nova data de início: ");
							String novaDataInicio = sc.nextLine();
							LocalDate novaDI = LocalDate.parse(novaDataInicio, formataData);
							locacao.setDataInicio(novaDI);
						}catch (DateTimeParseException e) {
							System.out.println("Erro: A data fornecida não está no formato esperado (dd/MM/yyyy).");
						}
						break;
					case "3":
						try {
							System.out.print("Digite a nova data final: ");
							String novaDataFinal = sc.nextLine();
							LocalDate novaDF = LocalDate.parse(novaDataFinal, formataData);
							locacao.setDataFim(novaDF);
						}catch (DateTimeParseException e) {
							System.out.println("Erro: A data fornecida não está no formato esperado (dd/MM/yyyy).");
						}
						break;
					case "4":
						System.out.print("Digite a placa do veículo para remoção: ");
						String placaRemove = sc.nextLine();
						Optional<VeiculoModel> veiculoRemoveO = veiculoController.findById(placaRemove);

						if(veiculoRemoveO.isEmpty()){
							System.out.println("Não existe esse veículo!");
						} else{
							if(locacao.getVeiculos().contains(veiculoRemoveO.get())){
								List<VeiculoModel> veiculosAtualizados = locacao.getVeiculos();
								veiculosAtualizados.remove(veiculoRemoveO.get());
								locacao.setVeiculos(veiculosAtualizados);
								System.out.println("Veículo removido com sucesso!");
							} else{
								System.out.println("Esse veículo não está na lista!");
							}
						}
						break;
				}
			}
		}
	}

	@Override
	public void imprimir() {
		for(LocacaoModel locacao:locacoes){
			imprimirUm(locacao.getCodLocacao());
		}
	}

	@Override
	public void remover(String id) {
		for(LocacaoModel locacao:locacoes){
			if(locacao.getCodLocacao().equals(id)){
				locacao.setAtivo(false);
			}
		}
	}

	@Override
	public void imprimirUm(String codLocacao) {
		System.out.println("\nDADOS DA LOCAÇÃO ");
		System.out.println("----------------------------");
		for (LocacaoModel loc : locacoes){
			if(loc.getCodLocacao().equals(codLocacao)){
				System.out.println("Código da locação: "+loc.getCodLocacao());
				System.out.println("Código do cliente: "+loc.getCliente().getcodCliente());
				System.out.println("Data de início: "+loc.getDataInicio());
				System.out.println("Data do fim: "+loc.getDataFim());
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

	public Optional<LocacaoModel> findById(String codLocacao){
		for(LocacaoModel locacao:locacoes){
			if(locacao.getCodLocacao().equals(codLocacao)){
				return Optional.of(locacao);
			}
		}
		return Optional.empty();
	}

	public boolean LocacaoIsPresent(String codLocacao){
		Optional<LocacaoModel> locacaoModelO = findById(codLocacao);
		return locacaoModelO.isPresent();
	}
}