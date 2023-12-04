package application;

import controller.*;
import model.*;
import model.exceptions.OpcaoInvalidaException;
import view.*;

import java.text.ParseException;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        SeguroModel seguroModel = null;
        SeguroView seguroView = new SeguroView();
        SeguroController seguroController = new SeguroController(seguroModel, seguroView);

        FuncionarioModel funcionarioModel = null;
        FuncionarioView funcionarioView = new FuncionarioView();
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioModel, funcionarioView);

        ClienteModel clienteModel = null;
        ClienteView clienteView = new ClienteView();
        ClienteController clienteController = new ClienteController(clienteModel, clienteView);

        VeiculoModel veiculoModel = null;
        VeiculoView veiculoView = new VeiculoView();
        VeiculoController veiculoController = new VeiculoController(veiculoModel, veiculoView);

        LocacaoModel locacaoModel = null;
        LocacaoView locacaoView = new LocacaoView();
        LocacaoController locacaoController = new LocacaoController(locacaoModel, locacaoView);

        ManutencaoModel manutencaoModel = null;
        ManutencaoView manutencaoView = new ManutencaoView();
        ManutencaoController manutencaoController = new ManutencaoController(manutencaoModel, manutencaoView);

        int opcao = 0;

        do {
            try {
                opcoes();
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        funcionarioView.funcionario(funcionarioController);
                        break;
                    case 2:
                        clienteView.cliente(clienteController);
                        break;
                    case 3:
                        veiculoView.veiculo(veiculoController, seguroController, clienteController);
                        break;
                    case 4:
                        locacaoView.locacao(locacaoController, clienteController, veiculoController, funcionarioController);
                        break;
                    case 5:
                        seguroView.seguro(seguroController);
                        break;
                    case 6:
                        manutencaoView.manutencao(manutencaoController, veiculoController, seguroController);
                        break;

                    default:
                        throw new OpcaoInvalidaException("Opção inválida!");
                }
            } catch (OpcaoInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número inteiro.");
                sc.nextLine();
                opcao = -1;
            }
        }
        while (opcao != 0);
    }

    public static void opcoes(){
        System.out.println("\nMENU PRINCIPAL: ");
        System.out.println("----------------------------");
        System.out.print("[1] CRUD Funcionário \n" +
                "[2] CRUD Cliente \n" +
                "[3] CRUD Veículo \n" +
                "[4] CRUD Locação \n" +
                "[5] CRUD Seguro \n" +
                "[6] CRUD Manutenção \n" +
                "[0] SAIR \n \n" +
                "DIGITE A OPÇÃO: ");
    }
}