package view;

import controller.ManutencaoController;
import controller.SeguroController;
import controller.VeiculoController;
import model.ManutencaoModel;
import model.VeiculoModel;
import model.exceptions.OpcaoInvalidaException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class ManutencaoView {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter ftd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    int opcao;
    public void manutencao(ManutencaoController manutencaoController, VeiculoController veiculoController, SeguroController seguroController)  throws ParseException {
       try {
           menu();
           if (opcao == 1) {
               criarManutencao(manutencaoController, veiculoController);
           } else if (opcao == 2) {
               manutencaoController.imprimir();
           } else if (opcao == 3) {
               imprimirUmaManutencao(manutencaoController);
           } else if (opcao == 4) {
               editarManutencao(manutencaoController);
           } else if (opcao == 5) {
               removerManutencao(manutencaoController);
           }
       }catch (OpcaoInvalidaException e) {
           System.out.println("Erro: " + e.getMessage());
           opcao = -1;
       } catch (InputMismatchException e) {
           System.out.println("Erro: Por favor, digite um valor numérico..");
           sc.nextLine();
           opcao = -1;
       }
    }

    public void menu() throws OpcaoInvalidaException {
        System.out.println("\nMENU MANUTENÇÃO: ");
        System.out.println("----------------------------");
        System.out.print("\n[1] Criar Manutenção \n" +
                "[2] Imprimir todas as Manutençoes \n" +
                "[3] Imprimir uma Manutenção \n" +
                "[4] Editar uma Manutenção \n" +
                "[5] Remover uma Manutenção \n \n" +
                "DIGITE A OPÇÃO: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        if (opcao < 1 || opcao > 5) {
            throw new OpcaoInvalidaException("Opção inválida!");
        }
        this.opcao = opcao;
    }

    public void criarManutencao(ManutencaoController manutencaoController, VeiculoController veiculoController) {
       try {
           System.out.println("SÓ É POSSÍVEL CRIAR UMA MANUTENÇÃO, CASO O VÉICULO EXISTA! CADASTRE UM VEÍCULO ANTES! ");
           System.out.println("Digite a ordem de serviço da manutenção: ");
           String ordemServicoManutencao = sc.nextLine();
           System.out.println("Digite a data da manutenção: ");
           String dataManutencao = sc.nextLine();
           LocalDate nDataManutencao = LocalDate.parse(dataManutencao, ftd);
           System.out.println("Digite o tipo da manutenção: ");
           String tipoManutencao = sc.nextLine();
           System.out.println("Digite a placa do veículo que será atribuido a manutenção: ");
           String placaVeiculo = sc.nextLine();
           Optional<VeiculoModel> veiculoModelO = veiculoController.findById(placaVeiculo);
           if (veiculoController.veiculoIsPresent(placaVeiculo)) {
               ManutencaoModel manutencaoModel = new ManutencaoModel(ordemServicoManutencao, nDataManutencao,
                       tipoManutencao, veiculoController.findById(placaVeiculo).get());
               manutencaoController.criar(manutencaoModel);
               veiculoController.findById(placaVeiculo).get().setManutencao(manutencaoModel);
           } else {
               System.out.println("Veículo inexistente! ");
           }
       }catch (DateTimeParseException e) {
           System.out.println("Erro: A data fornecida não está no formato esperado (dd/MM/yyyy).");
       }

    }

    public void imprimirUmaManutencao(ManutencaoController manutencaoController) {
        System.out.println("Digite a ordem de serviço da manutenção: ");
        String ordemServico = sc.nextLine();
        Optional<ManutencaoModel> manutencaoModelO = manutencaoController.findById(ordemServico);
        if(manutencaoController.manutencaoIsPresent(ordemServico)){
            manutencaoController.imprimirUm(ordemServico);
        } else {
            System.out.println("Ordem de serviço inválida! ");
        }
    }

    public void editarManutencao(ManutencaoController manutencaoController) {
        System.out.println("Digite a ordem de serviço que será editado: ");
        String ordemServico = sc.nextLine();
        if(manutencaoController.manutencaoIsPresent(ordemServico)){
            try {
                manutencaoController.editar(ordemServico);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Ordem de serviço inválida!");
        }
    }

    public void removerManutencao(ManutencaoController manutencaoController) {
        System.out.println("Digite a Ordem de serviço a ser removido: ");
        String ordemServico = sc.nextLine();
        if(manutencaoController.manutencaoIsPresent(ordemServico)){
            manutencaoController.remover(ordemServico);
        } else {
            System.out.println("Ordem de serviço inválida!");
        }
    }
}
