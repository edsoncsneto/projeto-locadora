package application;

import controller.FuncionarioController;
import model.FuncionarioModel;

import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        FuncionarioController fc = new FuncionarioController( );
        Locale.setDefault(Locale.US);
        int opcao=0;

        do{
            System.out.print("\n[1] CRUD Funcionário \n" +
                    "[2] CRUD Cliente \n" +
                    "[3] CRUD Veículo \n" +
                    "[4] CRUD Locação \n" +
                    "[5] RUD Seguro \n" +
                    "[6] RUD Manutenção \n" +
                    "[0] SAIR \n" +
                    "DIGITE A OPÇÃO: ");

            opcao = sc.nextInt();
            sc.nextLine();

            if(opcao==1){

                System.out.print("\n[1] Criar Funcionário \n" +
                        "[2] Imprimir todos funcionários \n" +
                        "[3] Imprimir um funcionário \n" +
                        "[4] Editar um funcionário \n" +
                        "[5] Remover um funcionário \n" +
                        "DIGITE A OPÇÃO: ");
                int opcao2 = sc.nextInt();
                sc.nextLine();

                if (opcao2==1){
                    System.out.print("Digite a matrícula do funcionário: ");
                    String matricula = sc.nextLine();
                    System.out.print("Digite o nome do funcionário: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o CPF do funcionário: ");
                    String cpf = sc.nextLine();
                    System.out.print("Digite o salário do funcionário: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Esse funcionário tem supervisor? (s/n): ");
                    String temSupervisor = sc.nextLine();

                    if(temSupervisor.equals("s")){
                        System.out.print("Digite a matrícula do supervisor: ");
                        String matriculaSupervisor = sc.nextLine();
                        Optional<FuncionarioModel> funcionarioO = fc.findById(matriculaSupervisor);
                        if(matricula.equals(matriculaSupervisor)){
                            System.out.print("Um funcionário não pode ser supervidor de si mesmo!");
                        } else if (!fc.funcionarioIsPresent(matriculaSupervisor)){
                            System.out.print("Não existe esse funcionário!");
                        } else {
                            FuncionarioModel funcionarioModel = new FuncionarioModel(matricula, nome, cpf, salario, fc.findById(matriculaSupervisor).get());
                            fc.criar(funcionarioModel);
                        }
                    } else{
                        FuncionarioModel funcionarioModel = new FuncionarioModel(matricula, nome, cpf, salario);
                        fc.criar(funcionarioModel);
                    }
                } else if (opcao2==2) {
                    fc.imprimir();
                } else if (opcao2==3) {
                    System.out.print("Digite a matrícula do funcionário para ser listado: ");
                    String matricula = sc.nextLine();
                    Optional<FuncionarioModel> funcionarioO = fc.findById(matricula);
                    if(fc.funcionarioIsPresent(matricula)){
                        fc.imprimirUm(matricula);
                    } else{
                        System.out.println("Essa matrícula não corresponde a de um funcionário cadastrado!");
                    }
                } else if (opcao2==4) {
                    System.out.print("Digite a matrícula do funcionário para ser editado: ");
                    String matricula = sc.nextLine();
                    if(fc.funcionarioIsPresent(matricula)){
                        try{
                        fc.editar(matricula);
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    } else{
                        System.out.println("Essa matrícula não corresponde a de um funcionário cadastrado!");
                    }
                } else{
                    System.out.print("Digite a matrícula do funcionário a ser removido: ");
                    String matricula = sc.nextLine();
                    fc.remover(matricula);
                }
            }
        }

        while (opcao!=0);

    }
}
