package view;

import controller.ManutencaoController;
import controller.SeguroController;
import controller.VeiculoController;
import model.ManutencaoModel;
import model.VeiculoModel;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class ManutencaoView {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter ftd = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void manutencao(ManutencaoController manutencaoController, VeiculoController veiculoController, SeguroController seguroController)  throws ParseException {
        menu();
        int opcao = sc.nextInt();
        sc.nextLine();

        if(opcao == 1){
            criarManutencao(manutencaoController, veiculoController);
        } else if (opcao == 2) {
            manutencaoController.imprimir();
        } else if (opcao == 3) {
            imprimirUmaManutencao(manutencaoController, seguroController);
        } else if (opcao == 4) {
            editarManutencao(manutencaoController, seguroController);
        } else if (opcao == 5) {
            removerManutencao(manutencaoController, seguroController);
        }
    }

    public void menu() {
        System.out.println("\nMENU MANUTENÇÃO: ");
        System.out.println("----------------------------");
        System.out.print("\n[1] Criar Manutenção \n" +
                "[2] Imprimir todas as Manutençoes \n" +
                "[3] Imprimir uma Manutenção \n" +
                "[4] Editar uma Manutenção \n" +
                "[5] Remover uma Manutenção \n \n" +
                "DIGITE A OPÇÃO: ");
    }

    public void criarManutencao(ManutencaoController manutencaoController, VeiculoController veiculoController) {
        System.out.println("Digite a ordem de serviço da manutenção: ");
        String ordemServicoManutencao = sc.nextLine();
        System.out.println("Digite a data da manutenção: ");
        String dataManutencao = sc.nextLine();
        LocalDate nDataManutencao = LocalDate.parse(dataManutencao,ftd);
        System.out.println("Digite o tipo da manutenção: ");
        String tipoManutencao = sc.nextLine();
        System.out.println("Digite a placa do veículo que será atribuido a manutenção: ");
        String placaVeiculo = sc.nextLine();
        Optional<VeiculoModel> veiculoModelO = veiculoController.findById(placaVeiculo);
        if(veiculoController.veiculoIsPresent(placaVeiculo)){
            ManutencaoModel manutencaoModel = new ManutencaoModel(ordemServicoManutencao,nDataManutencao,
                    tipoManutencao, veiculoController.findById(placaVeiculo).get());
            manutencaoController.criar(manutencaoModel);
        } else {
            System.out.println("Veículo inexistente! ");
        }
    }

    public void imprimirUmaManutencao(ManutencaoController manutencaoController, SeguroController seguroController) {
        System.out.println("Digite a ordem de serviço da manutenção: ");
        String ordemServico = sc.nextLine();
        Optional<ManutencaoModel> manutencaoModelO = manutencaoController.findById(ordemServico);
        if(manutencaoController.manutencaoIsPresent(ordemServico)){
            seguroController.imprimirUm(ordemServico);
        } else {
            System.out.println("Ordem de serviço inválida! ");
        }
    }

    public void editarManutencao(ManutencaoController manutencaoController, SeguroController seguroController) {
        System.out.println("Digite a ordem de serviço que será editado: ");
        String ordemServico = sc.nextLine();
        if(seguroController.seguroIsPresent(ordemServico)){
            try {
                seguroController.editar(ordemServico);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Ordem de serviço inválida!");
        }
    }

    public void removerManutencao(ManutencaoController manutencaoController, SeguroController seguroController) {
        System.out.println("Digite a Ordem de serviço a ser removido: ");
        String ordemServico = sc.nextLine();
        if(seguroController.seguroIsPresent(ordemServico)){
            seguroController.remover(ordemServico);
        } else {
            System.out.println("Ordem de serviço inválida!");
        }
    }
}
