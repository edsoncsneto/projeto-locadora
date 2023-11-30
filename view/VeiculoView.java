package view;

import controller.ClienteController;
import controller.SeguroController;
import controller.VeiculoController;
import model.SeguroModel;
import model.VeiculoModel;

import java.util.Optional;
import java.util.Scanner;

public class VeiculoView {
    Scanner sc = new Scanner(System.in);

    public void veiculo(VeiculoController veiculoController, SeguroController seguroController, ClienteController clienteController) {
        menu();
        int opcao = sc.nextInt();
        sc.nextLine();

        if(opcao == 1){
            criarVeiculo(veiculoController, seguroController);
        } else if (opcao == 2) {
            veiculoController.imprimir();
        } else if (opcao == 3) {
            imprimirUmVeiculo(veiculoController, clienteController);
        } else if (opcao == 4) {
            editarVeiculo(veiculoController);
        } else if (opcao == 5) {
            removerVeiculo(veiculoController);
        }
    }

    public void menu() {
        System.out.println("\nMENU VEÍCULO: ");
        System.out.println("----------------------------");
        System.out.print("[1] Criar Veículo \n" +
                "[2] Imprimir todos os Veículos \n" +
                "[3] Imprimir um Veículo \n" +
                "[4] Editar um Veículo \n" +
                "[5] Remover um Veículo \n \n" +
                "DIGITE A OPÇÃO: ");
    }

    public void criarVeiculo(VeiculoController veiculoController, SeguroController seguroController) {
        System.out.println("Digite a placa do veículo: ");
        String placaVeiculo = sc.nextLine();
        System.out.println("Digite a cor do veículo: ");
        String corVeiculo = sc.nextLine();
        System.out.println("Digite a marca do veículo: ");
        String marcaVeiculo  = sc.nextLine();
        System.out.println("Digite a categoria do veículo: ");
        String categoriaVeiculo = sc.nextLine();
        System.out.println("Digite o chassi do veículo: ");
        String chassiVeiculo = sc.nextLine();
        System.out.println("Digite o modelo do veículo: ");
        String modeloVeiculo = sc.nextLine();
        System.out.println("Digite a apolice do seguro: ");
        String apoliceSeguro = sc.nextLine();
        Optional<SeguroModel> seguroModelO = seguroController.findById(apoliceSeguro);
        if(seguroController.seguroIsPresent(apoliceSeguro)){
            VeiculoModel veiculoModel = new VeiculoModel(
                    placaVeiculo,corVeiculo,marcaVeiculo,categoriaVeiculo,chassiVeiculo,modeloVeiculo,
                    seguroController.findById(apoliceSeguro).get());
            veiculoController.criar(veiculoModel);
            System.out.println("----------------------------");
            System.out.println("Veículo criado com sucesso!");
            System.out.println("----------------------------");
        }
        else{
            System.out.println("----------------------------");
            System.out.println("Apolice inválida! ");
            System.out.println("----------------------------");
        }
    }

    public void imprimirUmVeiculo(VeiculoController veiculoController, ClienteController clienteController) {
        System.out.println("\nDigite a placa do veiculo: ");
        String placaVeiculo = sc.nextLine();
        Optional<VeiculoModel> veiculoModelO = veiculoController.findById(placaVeiculo);
        if(veiculoController.veiculoIsPresent(placaVeiculo)){
            clienteController.imprimirUm(placaVeiculo);
        } else {
            System.out.println("----------------------------");
            System.out.println("Placa inválida! ");
            System.out.println("----------------------------");
        }
    }

    public void editarVeiculo(VeiculoController veiculoController) {
        System.out.println("\nDigite a placa do veículo que será editado: ");
        String placaVeiculo = sc.nextLine();
        if(veiculoController.veiculoIsPresent(placaVeiculo)){
            veiculoController.editar(placaVeiculo);
        } else {
            System.out.println("Placa inválida!");
        }
    }

    public void removerVeiculo(VeiculoController veiculoController) {
        System.out.println("\nDigite a placa do veículo a ser removido: ");
        String placaVeiculo = sc.nextLine();
        if(veiculoController.veiculoIsPresent(placaVeiculo)){
            veiculoController.remover(placaVeiculo);
        } else {
            System.out.println("----------------------------");
            System.out.println("Placa inválida!");
            System.out.println("----------------------------");
        }
    }
}
