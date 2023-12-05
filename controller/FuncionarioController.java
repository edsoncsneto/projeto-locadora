package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

                System.out.println("\nEDITAR FUNCIONÁRIO ");
                System.out.println("----------------------------");
                System.out.print("[1] Editar matricula \n" +
                        "[2] Editar nome \n" +
                        "[3] Editar CPF \n" +
                        "[4] Editar salario \n" +
                        "[5] Editar supervisor \n \n");
                System.out.print("DIGITE A OPÇÃO: ");
                String opcao = sc.nextLine();

                switch (opcao) {
                    case "1":
                        System.out.print("Digite a nova matrícula: ");
                        String novaMatricula = sc.nextLine();
                        func.setMatricula(novaMatricula);
                        break;
                    case "2":
                        System.out.print("Digite o novo nome: ");
                        String novoNome = sc.nextLine();
                        func.setNome(novoNome);
                        break;
                    case "3":
                        System.out.print("Digite o novo CPF: ");
                        String novoCpf = sc.nextLine();
                        func.setCpf(novoCpf);
                        break;
                    case "4":
                        System.out.print("Digite o novo salário: ");
                        double novoSalario = sc.nextDouble();
                        sc.nextLine();
                        func.setSalario(novoSalario);
                        break;
                    case "5":
                        boolean verificacao = false;
                        System.out.print("Digite matrícula do novo supervisor: ");
                        String matriculaSupervisor = sc.nextLine();
                        for (FuncionarioModel supervisor : funcionarios) {
                            if (supervisor.getMatricula().equals(matriculaSupervisor)) {
                                func.setSupervisor(supervisor);
                                verificacao = true;
                            }
                        }
                        if (!verificacao) {
                            System.out.println("----------------------------");
                            System.out.println("Não foi possível alterar o supervisor. Verifique a matrícula.");
                            System.out.println("----------------------------");
                        }
                        break;
                }
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
            if(func.getMatricula().equals(id) && !isSupervisor(func.getMatricula())){
                    func.setAtivo(false);
            } else if(func.getMatricula().equals(id) && isSupervisor(func.getMatricula())){
                System.out.println("----------------------------");
                System.out.println("Não foi possível inativar o funcionário. Verifique se ele supervisiona alguém!");
                System.out.println("----------------------------");
            }
        }
    }

    public boolean isSupervisor(String matricula){
        for(FuncionarioModel funcionario:funcionarios){
            if(funcionario.getSupervisor()!=null){
                if(funcionario.getSupervisor().getMatricula().equals(matricula)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void imprimirUm(String matricula) {
        for (FuncionarioModel func : funcionarios) {
            if (func.getMatricula().equals(matricula)) {
                System.out.println("\nDADOS DO FUNCIONÁRIO ");
                System.out.println("----------------------------");
                System.out.println("Matrícula: " + func.getMatricula());
                System.out.println("Nome: " + func.getNome());
                System.out.println("CPF: " + func.getCpf());
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
            }
        }
    }

    public Optional<FuncionarioModel> findById(String matricula){
        for(FuncionarioModel funcionario:funcionarios){
            if(funcionario.getMatricula().equals(matricula)){
                return Optional.of(funcionario);
            }
        }
        return Optional.empty();
    }

    public boolean funcionarioIsPresent(String matricula){
        Optional<FuncionarioModel> funcionarioO = findById(matricula);
        if(funcionarioO.isPresent()){
            return true;
        } else{
            return false;
        }
    }
}
