package application;

import controller.ClienteController;
import controller.FuncionarioController;
import controller.SeguroController;
import controller.VeiculoController;
import model.*;

import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void opcoes(){
        System.out.print("\n[1] CRUD Funcionário \n" +
                "[2] CRUD Cliente \n" +
                "[3] CRUD Veículo \n" +
                "[4] CRUD Locação \n" +
                "[5] CRUD Seguro \n" +
                "[6] CRUD Manutenção \n" +
                "[0] SAIR \n" +
                "DIGITE A OPÇÃO: ");
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        FuncionarioController fc = new FuncionarioController( );
        ClienteController clienteController = new ClienteController();
        SeguroController seguroController = new SeguroController();
        VeiculoController veiculoController = new VeiculoController();
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
                    if(opcao2==1){
                        System.out.println("Digite o nome do funcionáio: ");
                        String nomeFuncionario = sc.nextLine();
                        System.out.println("Digite a matrícula do funcionário: ");
                        String matriculaFuncionario = sc.nextLine();
                        System.out.println("Digite o CPF do funcionário: ");
                        String cpfFuncionario = sc.nextLine();
                        System.out.println("Digite o salário do funcionário: ");
                        double salarioFuncionario = sc.nextDouble();
                        System.out.println("Esse funcionário possui supervisor? [S/N]");
                        String temSupervisor = sc.nextLine().toUpperCase();
                        if(temSupervisor.equals("S")){
                            System.out.println("Digite a matrícula do supervisor: ");
                            String matSup = sc.nextLine();
                            Optional<FuncionarioModel> funcionarioO = fc.findById(matSup);
                            if(matriculaFuncionario.equals(matSup)){
                                System.out.println("O funcionário não pode ser supervisor de si mesmo!");
                            }
                            else if(!fc.funcionarioIsPresent(matSup)){
                                System.out.println("Funcionário não existe!");
                            }
                            else {
                                FuncionarioModel funcionarioModel = new FuncionarioModel(matriculaFuncionario,nomeFuncionario,
                                        cpfFuncionario,salarioFuncionario,fc.findById(matSup).get());
                                fc.criar(funcionarioModel);
                            }
                        }
                        else{
                            FuncionarioModel funcionarioModel = new FuncionarioModel(matriculaFuncionario,nomeFuncionario,
                                    cpfFuncionario,salarioFuncionario);
                            fc.criar(funcionarioModel);
                        }
                    } else if (opcao2 == 2) {
                        fc.imprimir();
                    } else if (opcao2 == 3) {
                        System.out.println("Digite a matrícula do funcionário: ");
                        String matriculaFuncionario = sc.nextLine();
                        Optional<FuncionarioModel> funcionarioO = fc.findById(matriculaFuncionario);
                        if(fc.funcionarioIsPresent(matriculaFuncionario)){
                            fc.imprimirUm(matriculaFuncionario);
                        }
                        else{
                            System.out.println("Matrícula não corresponde a um funcionário");
                        }
                    } else if (opcao2 == 4) {
                        System.out.println("Digite a matrícula do funcionário: ");
                        String matriculaFuncionario = sc.nextLine();
                        if(fc.funcionarioIsPresent(matriculaFuncionario)){
                            try {
                                fc.editar(matriculaFuncionario);
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else{
                            System.out.println("Matrícula não corresponde a um funcionário cadastrado! ");
                        }
                    } else if (opcao2 == 5) {
                        System.out.println("Digite a matrícula do funcionário a ser removido: ");
                        String matriculaFuncionario = sc.nextLine();
                        fc.remover(matriculaFuncionario);
                    }
                    opcoes();
                    opcao = sc.nextInt();
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("\n[1] Criar Cliente \n" +
                            "[2] Imprimir todos os Clientes \n" +
                            "[3] Imprimir um Cliente \n" +
                            "[4] Editar um Cliente \n" +
                            "[5] Remover um Cliente \n" +
                            "DIGITE A OPÇÃO: ");
                    opcao2 = sc.nextInt();
                    sc.nextLine();
                    if(opcao2 == 1){
                        System.out.println("Digite o código do Cliente: ");
                        String codCliente = sc.nextLine();
                        System.out.println("Digite o telefone do Cliente: ");
                        String telefoneCliente = sc.nextLine();
                        System.out.println("Digite o logradouro do Cliente: ");
                        String logCliente = sc.nextLine();
                        System.out.println("Digite o bairro do Cliente: ");
                        String bairroCliente = sc.nextLine();
                        System.out.println("Digite a cidade do Cliente: ");
                        String cidadeCliente = sc.nextLine();
                        System.out.println("Digite o UF do Cliente: ");
                        String ufCliente = sc.nextLine();
                        System.out.println("Digite o CEP do Cliente: ");
                        String cepCliente = sc.nextLine();
                        System.out.println("Digite o numero da residência do Cliente: ");
                        String numCliente = sc.nextLine();
                        System.out.println("O cliente é pessoa física ou pessoa jurídica? [PF/PJ] ");
                        String tipoCliente = sc.nextLine().toUpperCase();
                        if(tipoCliente.equals("PF")){
                            System.out.println("Digite o nome do Cliente: ");
                            String nomeCliente = sc.nextLine();
                            System.out.println("Digite o CPF do Cliente: ");
                            String cpfCliente = sc.nextLine();
                            System.out.println("Digite a CNH do Cliente: ");
                            String cnhCliente = sc.nextLine();
                            ClientePFModel clientePFModel = new ClientePFModel(codCliente,telefoneCliente,bairroCliente,logCliente,
                                    cidadeCliente,ufCliente,cepCliente,numCliente,nomeCliente,cpfCliente,cnhCliente);
                            clienteController.criar(clientePFModel);
                        } else if (tipoCliente.equals("PJ")) {
                            System.out.println("Digite a razão social do Cliente: ");
                            String razaoSocial = sc.nextLine();
                            System.out.println("Digite o CNPJ do Cliente: ");
                            String cnpjCliente = sc.nextLine();
                            ClientePJModel clientePJModel = new ClientePJModel(
                                    codCliente,telefoneCliente,bairroCliente,logCliente,cidadeCliente,
                                    ufCliente,cepCliente,numCliente,cnpjCliente, razaoSocial
                            );
                            clienteController.criar(clientePJModel);
                        }
                    } else if (opcao2 == 2) {
                        clienteController.imprimir();
                    } else if (opcao2 == 3) {
                        System.out.println("Digite o código do Cliente: ");
                        String codCliente = sc.nextLine();
                        Optional<ClienteModel> clienteO = clienteController.findById(codCliente);
                        if(clienteController.clienteIsPresent(codCliente)){
                            clienteController.imprimirUm(codCliente);
                        }
                    } else if (opcao2 == 4) {
                        System.out.println("Digite o código do Cliente a ser editado: ");
                        String codCliente = sc.nextLine();
                        if (clienteController.clienteIsPresent(codCliente)) {
                            clienteController.editar(codCliente);
                        }else {
                            System.out.println("Código não corresponde a Cliente cadastrado! ");
                        }
                    } else if (opcao2 == 5) {
                        System.out.println("Digite o código do Cliente a ser removido: ");
                        String codCliente = sc.nextLine();
                        if (clienteController.clienteIsPresent(codCliente)) {
                            clienteController.remover(codCliente);
                        }else {
                            System.out.println("Código não corresponde a Cliente cadastrado! ");
                        }
                    }
                    opcoes();
                    opcao = sc.nextInt();
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("\n[1] Criar Veículo \n" +
                            "[2] Imprimir todos os Veículos \n" +
                            "[3] Imprimir um Veículo \n" +
                            "[4] Editar um Veículo \n" +
                            "[5] Remover um Veículo \n" +
                            "DIGITE A OPÇÃO: ");
                    opcao2 = sc.nextInt();
                    sc.nextLine();
                    if(opcao2 == 1){
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
                        }
                        else{
                            System.out.println("Apolice inválida! ");
                        }
                    } else if (opcao2 == 2) {
                        veiculoController.imprimir();
                    } else if (opcao2 == 3) {
                        System.out.println("Digite a placa do veiculo: ");
                        String placaVeiculo = sc.nextLine();
                        Optional<VeiculoModel> veiculoModelO = veiculoController.findById(placaVeiculo);
                        if(veiculoController.veiculoIsPresent(placaVeiculo)){
                            clienteController.imprimirUm(placaVeiculo);
                        }
                        else {
                            System.out.println("Placa inválida! ");
                        }
                    } else if (opcao2 == 4) {
                        System.out.println("Digite a placa do veículo que será editado: ");
                        String placaVeiculo = sc.nextLine();
                        if(veiculoController.veiculoIsPresent(placaVeiculo)){
                            veiculoController.editar(placaVeiculo);
                        }
                        else {
                            System.out.println("Placa inválida!");
                        }
                    } else if (opcao2 == 5) {
                        System.out.println("Digite a placa do veículo a ser removido: ");
                        String placaVeiculo = sc.nextLine();
                        if(veiculoController.veiculoIsPresent(placaVeiculo)){
                            veiculoController.remover(placaVeiculo);
                        }
                        else {
                            System.out.println("Placa inválida!");
                        }
                    }
                    opcoes();
                    opcao = sc.nextInt();
                    sc.nextLine();
                    break;
                case 4:
            }






        }

        while (opcao!=0);

    }
}
