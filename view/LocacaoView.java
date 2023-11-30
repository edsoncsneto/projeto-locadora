package view;

import controller.ClienteController;
import controller.FuncionarioController;
import controller.LocacaoController;
import controller.VeiculoController;
import model.LocacaoModel;
import model.VeiculoModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LocacaoView {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter ftd = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void locacao(LocacaoController locacaoController, ClienteController clienteController, VeiculoController veiculoController, FuncionarioController funcionarioController) {
        menu();
        int opcao = sc.nextInt();
        sc.nextLine();

        if(opcao == 1){
            criarLocacao(locacaoController, clienteController, veiculoController, funcionarioController);
        } else if (opcao == 2) {
            locacaoController.imprimir();
        } else if (opcao == 3) {
            imprimirUmaLocacao(locacaoController);
        } else if (opcao == 4) {
            editarLocacao(locacaoController);
        } else if (opcao == 5) {
            removerLocacao(locacaoController);
        }
    }

    public void menu() {
        System.out.println("\nMENU LOCAÇÃO: ");
        System.out.println("----------------------------");
        System.out.print("[1] Criar Locaçao \n" +
                "[2] Imprimir todas as Locações \n" +
                "[3] Imprimir uma Locação \n" +
                "[4] Editar uma Locação \n" +
                "[5] Remover uma Locação \n \n" +
                "DIGITE A OPÇÃO: ");
    }

    public void criarLocacao(LocacaoController locacaoController, ClienteController clienteController, VeiculoController veiculoController, FuncionarioController funcionarioController) {
        ArrayList<VeiculoModel> veiculosLocacao = new ArrayList<VeiculoModel>();
        System.out.println("Digite o código da locação: ");
        String codLocacao = sc.nextLine();
        System.out.println("Digite a data de início da locação: ");
        String dataInicioLocacao = sc.nextLine();
        //Parse String to LocalDate type
        LocalDate nDataInicioLocacao = LocalDate.parse(dataInicioLocacao,ftd);
        System.out.println("Digite a data de fim da locação: ");
        String dataFimLocacao = sc.nextLine();
        //Parse String to LocalDate type
        LocalDate nDataFimLocacao = LocalDate.parse(dataFimLocacao,ftd);
        System.out.println("A locação está sendo por PF ou PJ? [PF/PJ]");
        String tipoCliente = sc.nextLine().toUpperCase();
        //Lógica de Locacao para PF. APENAS 1 VEICULO
        if(tipoCliente.equals("PF")){
            System.out.println("Digite o CPF do Cliente: ");
            String cpfCliente = sc.nextLine();
            if(clienteController.clienteIsPresent(cpfCliente)){
                System.out.println("Qual a placa do veículo que será locado?");
                String placaVeiculo = sc.nextLine();
                if(veiculoController.veiculoIsPresent(placaVeiculo)){
                    System.out.println("Qual o CPF do Funcionario que está realizando a locacao? ");
                    String cpfFuncionario = sc.nextLine();
                    if(funcionarioController.funcionarioIsPresent(cpfFuncionario)){
                        veiculosLocacao.add(veiculoController.findById(placaVeiculo).get());
                        LocacaoModel locacaoModel = new LocacaoModel(codLocacao,clienteController.findById(cpfCliente).get(),
                                nDataInicioLocacao,nDataFimLocacao,veiculosLocacao,
                                funcionarioController.findById(cpfFuncionario).get());
                    }
                }
            }
            //LÓGICA PARA PJ. +DE 1 VEICULO
        } else if (tipoCliente.equals("PJ")) {
            System.out.println("Digite o CNPJ do Cliente: ");
            String cnpjCliente = sc.nextLine();
            System.out.println("Quantos veículos serão locados? ");
            int quantLocacoes = sc.nextInt();
            sc.nextLine();
            if(clienteController.clienteIsPresent(cnpjCliente)){
                System.out.println("Qual o CPF do Funcionario que está realizando a locacao? ");
                String cpfFuncionario = sc.nextLine();
                if(funcionarioController.funcionarioIsPresent(cpfFuncionario)){
                    for(int i=0; i<quantLocacoes; i++){
                        System.out.println("Qual a placa do veículo que será locado?");
                        String placaVeiculo = sc.nextLine();
                        if(veiculoController.veiculoIsPresent(placaVeiculo)){
                            veiculosLocacao.add(veiculoController.findById(placaVeiculo).get());
                        }
                    }
                    LocacaoModel locacaoModel = new LocacaoModel(codLocacao,clienteController.findById(cnpjCliente).get(),
                            nDataInicioLocacao,nDataFimLocacao,veiculosLocacao, funcionarioController.findById(cpfFuncionario).get());
                }
            }
        }
    }

    public void imprimirUmaLocacao(LocacaoController locacaoController) {
        System.out.println("Digite o Código da Locação: ");
        String codLocacao = sc.nextLine();
        if(locacaoController.LocacaoIsPresent(codLocacao)){
            locacaoController.imprimirUm(codLocacao);
        }
        else {
            System.out.println("Código de Locação inválido! ");
        }
    }

    public void editarLocacao(LocacaoController locacaoController) {
        System.out.println("Digite o Código da Locação que será editado:");
        String codLocacao = sc.nextLine();
        if(locacaoController.LocacaoIsPresent(codLocacao)){
            locacaoController.editar(codLocacao);
        } else {
            System.out.println("Código de locação inválido! ");
        }
    }

    public void removerLocacao(LocacaoController locacaoController) {
        System.out.println("Digite o código da locação que será removida: ");
        String codLocacao = sc.nextLine();
        if (locacaoController.LocacaoIsPresent(codLocacao)) {
            locacaoController.remover(codLocacao);
        }else{
            System.out.println("Código de Locação inválido! ");
        }
    }
}
