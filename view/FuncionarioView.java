package view;

import controller.FuncionarioController;
import model.FuncionarioModel;
import model.exceptions.OpcaoInvalidaException;
import java.util.*;

import java.util.Optional;
import java.util.Scanner;

public class FuncionarioView {
    Scanner sc = new Scanner(System.in);
    int opcao;

    public void funcionario(FuncionarioController funcionarioController) {
        try {
            menu();
            if (opcao == 1) {
                criarFuncionario(funcionarioController);
            } else if (opcao == 2) {
                funcionarioController.imprimir();
            } else if (opcao == 3) {
                imprimirUmFuncionario(funcionarioController);
            } else if (opcao == 4) {
                editarFuncionario(funcionarioController);
            } else if (opcao == 5) {
                removerFuncionario(funcionarioController);
            }
        } catch (OpcaoInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
            opcao = -1;
        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, digite um valor numérico..");
            sc.nextLine();
            opcao = -1;
        }
    }

    public void menu() throws OpcaoInvalidaException {
        System.out.println("\nMENU FUNCIONÁRIO: ");
        System.out.println("----------------------------");
        System.out.print("[1] Criar Funcionário \n" +
                "[2] Imprimir todos funcionários \n" +
                "[3] Imprimir um funcionário \n" +
                "[4] Editar um funcionário \n" +
                "[5] Remover um funcionário \n \n" +
                "DIGITE A OPÇÃO: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        if (opcao < 1 || opcao > 5) {
            throw new OpcaoInvalidaException("Opção inválida!");
        }
        this.opcao = opcao;
    }

    public void criarFuncionario(FuncionarioController funcionarioController) {
        System.out.println("\nCRIAR FUNCIONÁRIO: ");
        System.out.println("----------------------------");
        System.out.println("Digite o nome do funcionário: ");
        String nomeFuncionario = sc.nextLine();
        System.out.println("Digite a matrícula do funcionário: ");
        String matriculaFuncionario = sc.nextLine();
        System.out.println("Digite o CPF do funcionário: ");
        String cpfFuncionario = sc.nextLine();
        System.out.println("Digite o salário do funcionário: ");
        double salarioFuncionario = sc.nextDouble();
        System.out.println("Esse funcionário possui supervisor? [S/N]");
        String temSupervisor = sc.next().toUpperCase();
        sc.nextLine();

        if(temSupervisor.equals("S")){
            System.out.println("Digite a matrícula do supervisor: ");
            String matSup = sc.nextLine();
            Optional<FuncionarioModel> funcionarioO = funcionarioController.findById(matSup);
            if(matriculaFuncionario.equals(matSup)){
                System.out.println("----------------------------");
                System.out.println("O funcionário não pode ser supervisor de si mesmo!");
                System.out.println("----------------------------");
            } else if(!funcionarioController.funcionarioIsPresent(matSup)){
                System.out.println("----------------------------");
                System.out.println("Não existe funcionário com essa matrícula!");
                System.out.println("----------------------------");
            } else {
                FuncionarioModel funcionarioModel = new FuncionarioModel(matriculaFuncionario,nomeFuncionario,
                        cpfFuncionario,salarioFuncionario,funcionarioController.findById(matSup).get());
                funcionarioController.criar(funcionarioModel);
                System.out.println("----------------------------");
                System.out.println("Funcionário criado com sucesso!");
                System.out.println("----------------------------");
            }
        } else {
            FuncionarioModel funcionarioModel = new FuncionarioModel(matriculaFuncionario,nomeFuncionario,
                    cpfFuncionario,salarioFuncionario);
            funcionarioController.criar(funcionarioModel);
            System.out.println("----------------------------");
            System.out.println("Funcionário criado com sucesso!");
            System.out.println("----------------------------");
        }
    }

    public void imprimirUmFuncionario(FuncionarioController funcionarioController) {
        System.out.println("\nDigite a matrícula do funcionário: ");
        String matriculaFuncionario = sc.nextLine();
        Optional<FuncionarioModel> funcionarioO = funcionarioController.findById(matriculaFuncionario);
        if(funcionarioController.funcionarioIsPresent(matriculaFuncionario)){
            funcionarioController.imprimirUm(matriculaFuncionario);
        } else {
            System.out.println("----------------------------");
            System.out.println("Matrícula não corresponde a um funcionário");
            System.out.println("----------------------------");
        }
    }

    public void editarFuncionario(FuncionarioController funcionarioController) {
        System.out.println("\nDigite a matrícula do funcionário: ");
        String matriculaFuncionario = sc.nextLine();
        if(funcionarioController.funcionarioIsPresent(matriculaFuncionario)){
            try {
                funcionarioController.editar(matriculaFuncionario);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("----------------------------");
            System.out.println("Matrícula não corresponde a um funcionário cadastrado! ");
            System.out.println("----------------------------");
        }
    }

    public void removerFuncionario(FuncionarioController funcionarioController) {
        System.out.println("\nDigite a matrícula do funcionário a ser removido: ");
        String matriculaFuncionario = sc.nextLine();
        funcionarioController.remover(matriculaFuncionario);
    }
}
