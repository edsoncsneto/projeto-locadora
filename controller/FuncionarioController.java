package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.FuncionarioModel;
import model.LocacaoModel;

public class FuncionarioController implements IController {
    List<FuncionarioModel> funcionarios = new ArrayList<>();

    @Override
    public void criar(Object obj) {
        funcionarios.add((FuncionarioModel) obj);
    }

    @Override
    public void editar(String id) {
        for(FuncionarioModel func:funcionarios){
            if(func.getMatricula().equals(id)){
                Scanner sc = new Scanner(System.in);
                System.out.println("[1] Matricula \n" +
                        "[2] Nome \n" +
                        "[3] CPF \n" +
                        "[4] Salario \n" +
                        "[5] Supervisor \n");
                System.out.print("Digite a opção: ");
                String opcao = sc.nextLine();

                switch (opcao) {
                    case "1":
                        System.out.println("Digite a nova matrícula: ");
                        String novaMatricula = sc.nextLine();
                        func.setMatricula(novaMatricula);
                        break;
                    case "2":
                        System.out.println("Digite o novo nome: ");
                        String novoNome = sc.nextLine();
                        func.setNome(novoNome);
                        break;
                    case "3":
                        System.out.println("Digite o novo CPF: ");
                        String novoCpf = sc.nextLine();
                        func.setCpf(novoCpf);
                        break;
                    case "4":
                        System.out.println("Digite o novo salário: ");
                        double novoSalario = sc.nextDouble();
                        func.setSalario(novoSalario);
                        break;
                    case "5":
                        boolean verificacao = false;
                        System.out.println("Digite matrícula do novo supervisor: ");
                        String matriculaSupervisor = sc.nextLine();
                        for (FuncionarioModel supervisor : funcionarios) {
                            if (supervisor.getMatricula().equals(matriculaSupervisor)) {
                                func.setSupervisor(supervisor);
                                verificacao = true;
                            }
                        }
                        if (!verificacao) {
                            System.out.println("Não foi possível alterar o supervisor. Verifique a matrícula.");
                        }
                        break;
                }
                //imprimindo usuário que foi editado
                imprimirUm(func.getMatricula());
                sc.close();
            }
        }
    }

    @Override
    public void imprimir() {
        for (FuncionarioModel func : funcionarios) {
            imprimirUm(func.getMatricula());
        }
    }

    @Override
    public void remover(String id) {
        for(FuncionarioModel func : funcionarios){
            if(func.getMatricula().equals(id)){
                funcionarios.remove(func);
            }
        }
    }

    @Override
    public void imprimirUm(String matricula) {
        for (FuncionarioModel func : funcionarios) {
            if (func.getMatricula().equals(matricula)) {
                System.out.println("-----------------------------");
                System.out.println("Matrícula: " + func.getMatricula());
                System.out.println("CPF: " + func.getCpf());
                System.out.println("Nome: " + func.getNome());
                System.out.println("Quantidade de locações: " + func.getQuantidadeLocacoes());
                System.out.println("Salário: " + func.getSalario());
                if (func.getSupervisor() != null) {
                    System.out.println("Supervisor: " + func.getSupervisor().getNome());
                }
                if (func.isAtivo()) {
                    System.out.println("Status: ativo");
                } else {
                    System.out.println("Status: inativo");
                }
                System.out.println("-----------------------------");
            }
        }
    }
}
