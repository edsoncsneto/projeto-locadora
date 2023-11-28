package application;

import controller.FuncionarioController;
import model.FuncionarioModel;

import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void opcoes(){
        System.out.print("\n[1] CRUD Funcionário \n" +
                "[2] CRUD Cliente \n" +
                "[3] CRUD Veículo \n" +
                "[4] CRUD Locação \n" +
                "[5] RUD Seguro \n" +
                "[6] RUD Manutenção \n" +
                "[0] SAIR \n" +
                "DIGITE A OPÇÃO: ");
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        FuncionarioController fc = new FuncionarioController( );
        Locale.setDefault(Locale.US);
        int opcao;

        do{
            opcoes();

            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1:
                    System.out.print("\n[1] Criar Funcionário \n" +
                            "[2] Imprimir todos funcionários \n" +
                            "[3] Imprimir um funcionário \n" +
                            "[4] Editar um funcionário \n" +
                            "[5] Remover um funcionário \n" +
                            "DIGITE A OPÇÃO: ");
                    int opcao2 = sc.nextInt();
                    sc.nextLine();

                    opcoes();
                    opcao = sc.nextInt();
                    sc.nextLine();
            }






        }

        while (opcao!=0);

    }
}
