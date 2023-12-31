package view;

import controller.ClienteController;
import controller.FuncionarioController;
import controller.LocacaoController;
import controller.VeiculoController;
import model.LocacaoModel;
import model.VeiculoModel;
import model.exceptions.OpcaoInvalidaException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LocacaoView {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter ftd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    int opcao;
    public void locacao(LocacaoController locacaoController, ClienteController clienteController, VeiculoController veiculoController, FuncionarioController funcionarioController) {
        try {
            menu();

            if (opcao == 1) {
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
        }catch (OpcaoInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
            opcao = -1;
        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, digite um valor numérico..");
            sc.nextLine();
            opcao = -1;
        }

    }

    public void menu() throws OpcaoInvalidaException{
        System.out.println("\nMENU LOCAÇÃO: ");
        System.out.println("----------------------------");
        System.out.print("[1] Criar Locaçao \n" +
                "[2] Imprimir todas as Locações \n" +
                "[3] Imprimir uma Locação \n" +
                "[4] Editar uma Locação \n" +
                "[5] Remover uma Locação \n \n" +
                "DIGITE A OPÇÃO: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        if (opcao < 1 || opcao > 5) {
            throw new OpcaoInvalidaException("Opção inválida!");
        }
        this.opcao = opcao;
    }

    public void criarLocacao(LocacaoController locacaoController, ClienteController clienteController, VeiculoController veiculoController, FuncionarioController funcionarioController) {
        System.out.println("ALERTA! SÓ É POSSÍVEL CRIAR LOCAÇÃO, CASO POSSUA UM VEICULO, UM CLIENTE E UM FUNCIONÁRIO CRIADO ENTÃO, CRIE ESSAS CLASSES ANTES!");
        try {
            ArrayList<VeiculoModel> veiculosLocacao = new ArrayList<VeiculoModel>();
            ArrayList<VeiculoModel> veiculosLocados = new ArrayList<VeiculoModel>();
            System.out.println("Digite o código da locação: ");
            String codLocacao = sc.nextLine();
            System.out.println("Digite a data de início da locação: ");
            String dataInicioLocacao = sc.nextLine();
            //Parse String to LocalDate type
            LocalDate nDataInicioLocacao = LocalDate.parse(dataInicioLocacao, ftd);
            System.out.println("Digite a data de fim da locação: ");
            String dataFimLocacao = sc.nextLine();
            //Parse String to LocalDate type
            LocalDate nDataFimLocacao = LocalDate.parse(dataFimLocacao, ftd);
            System.out.println("A locação está sendo por PF ou PJ? [PF/PJ]");
            String tipoCliente = sc.nextLine().toUpperCase();
            //Lógica de Locacao para PF. APENAS 1 VEICULO
            if (tipoCliente.equals("PF")) {
                System.out.println("Digite o código do Cliente: ");
                String codCliente = sc.nextLine();
                if (clienteController.clienteIsPresent(codCliente)) {
                    System.out.println("Qual a placa do veículo que será locado?");
                    String placaVeiculo = sc.nextLine();
                    if (veiculoController.veiculoIsPresent(placaVeiculo)) {
                        if(!veiculoController.veiculoIsLocado(veiculoController.findById(placaVeiculo).get())) {
                            System.out.println("Qual a matrícula do Funcionario que está realizando a locacao? ");
                            String matriculaFuncionario = sc.nextLine();
                            if (funcionarioController.funcionarioIsPresent(matriculaFuncionario)) {
                                veiculosLocacao.add(veiculoController.findById(placaVeiculo).get());
                                LocacaoModel locacaoModel = new LocacaoModel(codLocacao, clienteController.findById(codCliente).get(),
                                        nDataInicioLocacao, nDataFimLocacao, veiculosLocacao,
                                        funcionarioController.findById(matriculaFuncionario).get());
                                locacaoController.criar(locacaoModel);
                                veiculosLocados.add(veiculoController.findById(placaVeiculo).get());
                                System.out.println("----------------------------");
                                System.out.println("Locação criada com sucesso!");
                                System.out.println("----------------------------");
                            }
                        }else {
                            System.out.println("Veículo já locado para outro cliente");
                        }
                    }
                }
                //LÓGICA PARA PJ. +DE 1 VEICULO
            } else if (tipoCliente.equals("PJ")) {
                System.out.println("Digite o código do Cliente: ");
                String codCliente = sc.nextLine();
                System.out.println("Quantos veículos serão locados? ");
                int quantLocacoes = sc.nextInt();
                sc.nextLine();
                if (clienteController.clienteIsPresent(codCliente)) {
                    System.out.println("Qual o CPF do Funcionario que está realizando a locacao? ");
                    String cpfFuncionario = sc.nextLine();
                    if (funcionarioController.funcionarioIsPresent(cpfFuncionario)) {
                        for (int i = 0; i < quantLocacoes; i++) {
                            System.out.println("Qual a placa do veículo que será locado?");
                            String placaVeiculo = sc.nextLine();
                            if (veiculoController.veiculoIsPresent(placaVeiculo)) {
                                if(!veiculoController.veiculoIsLocado(veiculoController.findById(placaVeiculo).get())) {
                                    veiculosLocacao.add(veiculoController.findById(placaVeiculo).get());
                                    veiculosLocados.add(veiculoController.findById(placaVeiculo).get());
                                }else {
                                    System.out.println("Ao menos um veículo já está locado! ");
                                }
                            }
                        }
                        LocacaoModel locacaoModel = new LocacaoModel(codLocacao, clienteController.findById(codCliente).get(),
                                nDataInicioLocacao, nDataFimLocacao, veiculosLocacao, funcionarioController.findById(cpfFuncionario).get());

                        locacaoController.criar(locacaoModel);
                        System.out.println("----------------------------");
                        System.out.println("Locação criada com sucesso!");
                        System.out.println("----------------------------");
                    }
                }
            }
        }catch (DateTimeParseException e) {
            System.out.println("Erro: A data fornecida não está no formato esperado (dd/MM/yyyy).");
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
