package application;

import controller.*;
import model.*;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Program {

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
    public static void main(String[] args) throws ParseException {


        Scanner sc = new Scanner(System.in);
        FuncionarioController fc = new FuncionarioController( );
        ClienteController clienteController = new ClienteController();
        SeguroController seguroController = new SeguroController();
        VeiculoController veiculoController = new VeiculoController();
        LocacaoController locacaoController = new LocacaoController();
        Locale.setDefault(Locale.US);
        DateTimeFormatter ftd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ManutencaoController manutencaoController = new ManutencaoController();
        int opcao;

        do{
            opcoes();

            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("\nMENU FUNCIONÁRIO: ");
                    System.out.println("----------------------------");
                    System.out.print("[1] Criar Funcionário \n" +
                            "[2] Imprimir todos funcionários \n" +
                            "[3] Imprimir um funcionário \n" +
                            "[4] Editar um funcionário \n" +
                            "[5] Remover um funcionário \n \n" +
                            "DIGITE A OPÇÃO: ");
                    int opcao2 = sc.nextInt();
                    sc.nextLine();

                    if(opcao2==1){
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
                            Optional<FuncionarioModel> funcionarioO = fc.findById(matSup);
                            if(matriculaFuncionario.equals(matSup)){
                                System.out.println("----------------------------");
                                System.out.println("O funcionário não pode ser supervisor de si mesmo!");
                                System.out.println("----------------------------");
                                break;
                            }
                            else if(!fc.funcionarioIsPresent(matSup)){
                                System.out.println("----------------------------");
                                System.out.println("Não existe funcionário com essa matrícula!");
                                System.out.println("----------------------------");
                                break;
                            }
                            else {
                                FuncionarioModel funcionarioModel = new FuncionarioModel(matriculaFuncionario,nomeFuncionario,
                                        cpfFuncionario,salarioFuncionario,fc.findById(matSup).get());
                                fc.criar(funcionarioModel);
                                System.out.println("----------------------------");
                                System.out.println("Funcionário criado com sucesso!");
                                System.out.println("----------------------------");
                                break;
                            }
                        }
                        else{
                            FuncionarioModel funcionarioModel = new FuncionarioModel(matriculaFuncionario,nomeFuncionario,
                                    cpfFuncionario,salarioFuncionario);
                            fc.criar(funcionarioModel);
                            System.out.println("----------------------------");
                            System.out.println("Funcionário criado com sucesso!");
                            System.out.println("----------------------------");
                            break;
                        }
                    } else if (opcao2 == 2) {
                        fc.imprimir();
                    } else if (opcao2 == 3) {
                        System.out.println("\nDigite a matrícula do funcionário: ");
                        String matriculaFuncionario = sc.nextLine();
                        Optional<FuncionarioModel> funcionarioO = fc.findById(matriculaFuncionario);
                        if(fc.funcionarioIsPresent(matriculaFuncionario)){
                            fc.imprimirUm(matriculaFuncionario);
                        }
                        else{
                            System.out.println("----------------------------");
                            System.out.println("Matrícula não corresponde a um funcionário");
                            System.out.println("----------------------------");
                        }
                    } else if (opcao2 == 4) {
                        System.out.println("\nDigite a matrícula do funcionário: ");
                        String matriculaFuncionario = sc.nextLine();
                        if(fc.funcionarioIsPresent(matriculaFuncionario)){
                            try {
                                fc.editar(matriculaFuncionario);
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else{
                            System.out.println("----------------------------");
                            System.out.println("Matrícula não corresponde a um funcionário cadastrado! ");
                            System.out.println("----------------------------");
                        }
                    } else if (opcao2 == 5) {
                        System.out.println("\nDigite a matrícula do funcionário a ser removido: ");
                        String matriculaFuncionario = sc.nextLine();
                        fc.remover(matriculaFuncionario);
                    }
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("\nMENU CLIENTE: ");
                    System.out.println("----------------------------");
                    System.out.print("[1] Criar Cliente \n" +
                            "[2] Imprimir todos os Clientes \n" +
                            "[3] Imprimir um Cliente \n" +
                            "[4] Editar um Cliente \n" +
                            "[5] Remover um Cliente \n \n" +
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
                        System.out.println("Digite o numero da residência do Cliente: ");
                        String numCliente = sc.nextLine();
                        System.out.println("Digite o bairro do Cliente: ");
                        String bairroCliente = sc.nextLine();
                        System.out.println("Digite a cidade do Cliente: ");
                        String cidadeCliente = sc.nextLine();
                        System.out.println("Digite o UF do Cliente: ");
                        String ufCliente = sc.nextLine();
                        System.out.println("Digite o CEP do Cliente: ");
                        String cepCliente = sc.nextLine();
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
                            System.out.println("----------------------------");
                            System.out.println("Cliente criado com sucesso!");
                            System.out.println("----------------------------");
                            break;
                        }
                    } else if (opcao2 == 2) {
                        clienteController.imprimir();
                    } else if (opcao2 == 3) {
                        System.out.println("\nDigite o código do Cliente: ");
                        String codCliente = sc.nextLine();
                        Optional<ClienteModel> clienteO = clienteController.findById(codCliente);
                        if(clienteController.clienteIsPresent(codCliente)){
                            clienteController.imprimirUm(codCliente);
                        }
                    } else if (opcao2 == 4) {
                        System.out.println("\nDigite o código do Cliente a ser editado: ");
                        String codCliente = sc.nextLine();
                        if (clienteController.clienteIsPresent(codCliente)) {
                            clienteController.editar(codCliente);
                        }else {
                            System.out.println("----------------------------");
                            System.out.println("Código não corresponde a Cliente cadastrado! ");
                            System.out.println("----------------------------");
                        }
                    } else if (opcao2 == 5) {
                        System.out.println("\nDigite o código do Cliente a ser removido: ");
                        String codCliente = sc.nextLine();
                        if (clienteController.clienteIsPresent(codCliente)) {
                            clienteController.remover(codCliente);
                        }else {
                            System.out.println("----------------------------");
                            System.out.println("Código não corresponde a Cliente cadastrado! ");
                            System.out.println("----------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nMENU VEÍCULO: ");
                    System.out.println("----------------------------");
                    System.out.print("[1] Criar Veículo \n" +
                            "[2] Imprimir todos os Veículos \n" +
                            "[3] Imprimir um Veículo \n" +
                            "[4] Editar um Veículo \n" +
                            "[5] Remover um Veículo \n \n" +
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
                            System.out.println("----------------------------");
                            System.out.println("Veículo criado com sucesso!");
                            System.out.println("----------------------------");
                            break;
                        }
                        else{
                            System.out.println("----------------------------");
                            System.out.println("Apolice inválida! ");
                            System.out.println("----------------------------");
                        }
                    } else if (opcao2 == 2) {
                        veiculoController.imprimir();
                    } else if (opcao2 == 3) {
                        System.out.println("\nDigite a placa do veiculo: ");
                        String placaVeiculo = sc.nextLine();
                        Optional<VeiculoModel> veiculoModelO = veiculoController.findById(placaVeiculo);
                        if(veiculoController.veiculoIsPresent(placaVeiculo)){
                            clienteController.imprimirUm(placaVeiculo);
                        }
                        else {
                            System.out.println("----------------------------");
                            System.out.println("Placa inválida! ");
                            System.out.println("----------------------------");
                        }
                    } else if (opcao2 == 4) {
                        System.out.println("\nDigite a placa do veículo que será editado: ");
                        String placaVeiculo = sc.nextLine();
                        if(veiculoController.veiculoIsPresent(placaVeiculo)){
                            veiculoController.editar(placaVeiculo);
                        }
                        else {
                            System.out.println("Placa inválida!");
                        }
                    } else if (opcao2 == 5) {
                        System.out.println("\nDigite a placa do veículo a ser removido: ");
                        String placaVeiculo = sc.nextLine();
                        if(veiculoController.veiculoIsPresent(placaVeiculo)){
                            veiculoController.remover(placaVeiculo);
                        }
                        else {
                            System.out.println("----------------------------");
                            System.out.println("Placa inválida!");
                            System.out.println("----------------------------");
                        }
                    }
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("\nMENU LOCAÇÃO: ");
                    System.out.println("----------------------------");
                    System.out.print("[1] Criar Locaçao \n" +
                            "[2] Imprimir todas as Locações \n" +
                            "[3] Imprimir uma Locação \n" +
                            "[4] Editar uma Locação \n" +
                            "[5] Remover uma Locação \n \n" +
                            "DIGITE A OPÇÃO: ");
                    opcao2 = sc.nextInt();
                    sc.nextLine();
                    if(opcao2 == 1){
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
                                   if(fc.funcionarioIsPresent(cpfFuncionario)){
                                       veiculosLocacao.add(veiculoController.findById(placaVeiculo).get());
                                       LocacaoModel locacaoModel = new LocacaoModel(codLocacao,clienteController.findById(cpfCliente).get(),
                                               nDataInicioLocacao,nDataFimLocacao,veiculosLocacao,
                                               fc.findById(cpfFuncionario).get());
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
                                if(fc.funcionarioIsPresent(cpfFuncionario)){
                                for(int i=0; i<quantLocacoes; i++){
                                    System.out.println("Qual a placa do veículo que será locado?");
                                    String placaVeiculo = sc.nextLine();
                                    if(veiculoController.veiculoIsPresent(placaVeiculo)){
                                        veiculosLocacao.add(veiculoController.findById(placaVeiculo).get());
                                        }
                                    }
                                LocacaoModel locacaoModel = new LocacaoModel(codLocacao,clienteController.findById(cnpjCliente).get(),
                                        nDataInicioLocacao,nDataFimLocacao,veiculosLocacao, fc.findById(cpfFuncionario).get());
                                }
                            }
                        }
                    } else if (opcao2 == 2) {
                        locacaoController.imprimir();
                    } else if (opcao2 == 3) {
                        System.out.println("Digite o Código da Locação: ");
                        String codLocacao = sc.nextLine();
                        if(locacaoController.LocacaoIsPresent(codLocacao)){
                            locacaoController.imprimirUm(codLocacao);
                        }
                        else {
                            System.out.println("Código de Locação inválido! ");
                        }
                    } else if (opcao2 == 4) {
                        System.out.println("Digite o Código da Locação que será editado:");
                        String codLocacao = sc.nextLine();
                        if(locacaoController.LocacaoIsPresent(codLocacao)){
                            locacaoController.editar(codLocacao);
                        }
                        else {
                            System.out.println("Código de locação inválido! ");
                        }
                    } else if (opcao2 == 5) {
                        System.out.println("Digite o código da locação que será removida: ");
                        String codLocacao = sc.nextLine();
                        if (locacaoController.LocacaoIsPresent(codLocacao)) {
                            locacaoController.remover(codLocacao);
                        }else{
                            System.out.println("Código de Locação inválido! ");
                        }
                    }
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("\nMENU SEGURO: ");
                    System.out.println("----------------------------");
                    System.out.print("[1] Criar Seguro \n" +
                            "[2] Imprimir todos os Seguro \n" +
                            "[3] Imprimir um Seguro \n" +
                            "[4] Editar um Seguro \n" +
                            "[5] Remover um Seguro \n \n" +
                            "DIGITE A OPÇÃO: ");
                    opcao2 = sc.nextInt();
                    sc.nextLine();
                    if(opcao2 == 1){
                        System.out.println("Digite a apólice do Seguro: ");
                        String apoliceSeguro = sc.nextLine();
                        System.out.println("Digite o valor do Seguro: ");
                        Double valorSeguro = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Digite a data inicial do Seguro: ");
                        String dataInicialSeguro = sc.nextLine();
                        System.out.println("Digite a data final do Seguro: ");
                        String dataFinalSeguro = sc.nextLine();
                        System.out.println("Digite o tipo de cobertura do Seguro: ");
                        String tipoCoberturaSeguro = sc.nextLine();
                        System.out.println("Digite o histórico do Seguro: ");
                        String historicoSeguro = sc.nextLine();
                        System.out.println("Digite a franquia do seguro: ");
                        String franquiaSeguro = sc.nextLine();

                        LocalDate novaDI = LocalDate.parse(dataInicialSeguro, ftd);
                        LocalDate novaDF = LocalDate.parse(dataFinalSeguro,ftd);

                       SeguroModel seguroModel = new SeguroModel(apoliceSeguro,valorSeguro,novaDI,
                               novaDF, tipoCoberturaSeguro, historicoSeguro, franquiaSeguro);
                       seguroController.criar(seguroModel);
                        System.out.println("----------------------------");
                        System.out.println("Seguro criado com sucesso!");
                        System.out.println("----------------------------");
                        break;

                    } else if (opcao2 == 2) {
                        seguroController.imprimir();
                    } else if (opcao2 == 3) {
                        System.out.println("\nDigite a apolice do seguro: ");
                        String apoliceSeguro = sc.nextLine();
                        Optional<SeguroModel> seguroModelO = seguroController.findById(apoliceSeguro);
                        if(seguroController.seguroIsPresent(apoliceSeguro)){
                            seguroController.imprimirUm(apoliceSeguro);
                        }
                        else {
                            System.out.println("----------------------------");
                            System.out.println("Apolice inválida! ");
                            System.out.println("----------------------------");
                        }
                    } else if (opcao2 == 4) {
                        System.out.println("\nDigite a apolice do seguro que será editado: ");
                        String apoliceSeguro = sc.nextLine();
                        if(seguroController.seguroIsPresent(apoliceSeguro)){
                            seguroController.editar(apoliceSeguro);
                        }
                        else {
                            System.out.println("----------------------------");
                            System.out.println("Apolice inválida!");
                            System.out.println("----------------------------");
                        }
                    } else if (opcao2 == 5) {
                        System.out.println("\nDigite a apolice do seguro a ser removido: ");
                        String apoliceSeguro = sc.nextLine();
                        if(seguroController.seguroIsPresent(apoliceSeguro)){
                            seguroController.remover(apoliceSeguro);
                        }
                        else {
                            System.out.println("----------------------------");
                            System.out.println("Apolice inválida!");
                            System.out.println("----------------------------");
                        }
                    }
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("\nMENU MANUTENÇÃO: ");
                    System.out.println("----------------------------");
                    System.out.print("\n[1] Criar Manutenção \n" +
                            "[2] Imprimir todas as Manutençoes \n" +
                            "[3] Imprimir uma Manutenção \n" +
                            "[4] Editar uma Manutenção \n" +
                            "[5] Remover uma Manutenção \n \n" +
                            "DIGITE A OPÇÃO: ");
                    opcao2 = sc.nextInt();
                    sc.nextLine();
                    if(opcao2 == 1){
                        System.out.println("Digite a ordem de serviço da manutenção: ");
                        String ordemServicoManutencao = sc.nextLine();
                        System.out.println("Digite a data da manutenção: ");
                        String dataManutencao = sc.nextLine();
                        LocalDate nDataManutencao = LocalDate.parse(dataManutencao,ftd);
                        System.out.println("Digite o tipo da manutenção: ");
                        String tipoManutencao = sc.nextLine();
                        System.out.println("Digite a placa do veículo que será atribuido a manutenção: ");
                        String placaVeiculo = sc.nextLine();
                        Optional<VeiculoModel> veiculoModelO = veiculoController.findById(placaVeiculo);
                        if(veiculoController.veiculoIsPresent(placaVeiculo)){
                        ManutencaoModel manutencaoModel = new ManutencaoModel(ordemServicoManutencao,nDataManutencao,
                                tipoManutencao, veiculoController.findById(placaVeiculo).get());
                        manutencaoController.criar(manutencaoModel);
                        }
                        else{
                            System.out.println("Veículo inexistente! ");
                        }
                    } else if (opcao2 == 2) {
                        manutencaoController.imprimir();
                    } else if (opcao2 == 3) {
                        System.out.println("Digite a ordem de serviço da manutenção: ");
                        String ordemServico = sc.nextLine();
                        Optional<ManutencaoModel> manutencaoModelO = manutencaoController.findById(ordemServico);
                        if(manutencaoController.manutencaoIsPresent(ordemServico)){
                            seguroController.imprimirUm(ordemServico);
                        }
                        else {
                            System.out.println("Ordem de serviço inválida! ");
                        }
                    } else if (opcao2 == 4) {
                        System.out.println("Digite a ordem de serviço que será editado: ");
                        String ordemServico = sc.nextLine();
                        if(seguroController.seguroIsPresent(ordemServico)){
                            seguroController.editar(ordemServico);
                        }
                        else {
                            System.out.println("Ordem de serviço inválida!");
                        }
                    } else if (opcao2 == 5) {
                        System.out.println("Digite a Ordem de serviço a ser removido: ");
                        String ordemServico = sc.nextLine();
                        if(seguroController.seguroIsPresent(ordemServico)){
                            seguroController.remover(ordemServico);
                        }
                        else {
                            System.out.println("Ordem de serviço inválida!");
                        }
                    }
                    opcoes();
                    opcao = sc.nextInt();
                    sc.nextLine();
                    break;
            }
        }
        while (opcao!=0);
    }
}