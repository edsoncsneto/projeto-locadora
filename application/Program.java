package application;

import controller.*;
import model.*;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Program {

	public static void menuPrincipal() {
		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Cadastrar Funcionário ");
		System.out.println("2 - Cadastrar Cliente ");
		System.out.println("3 - Cadastrar Seguro ");
		System.out.println("4 - Cadastrar Manutenção ");
		System.out.println("5 - Cadastrar Veículo ");
		System.out.println("6 - Realizar locação ");
		System.out.println("7 - Mais opções...");
		System.out.println("0 - SAIR");
	}
	public static void menuAlternativo(){
		System.out.println("Escolha uma opção: ");
		System.out.println("8 - Editar Funcionários ");
		System.out.println("9 - Editar Clientes ");
		System.out.println("10 - Editar Veículos ");
		System.out.println("11 - Editar Seguros ");
		System.out.println("12 - Editar Manutenções ");
		System.out.println("0 - SAIR");
	}
	public static void main(String[] args) {

		menuPrincipal();
		int opcP = sc.nextInt();
		FuncionarioModel funcionarioModel = null;
		FuncionarioModel supervisorModel = null;
		FuncionarioController funcionarioController = null;
		ClienteModel ClientePF = null;
		ClienteModel ClientePJ = null;
		ClienteController clienteController = null;
		SeguroModel seguroModel = null;
		SeguroController seguroController = null;


		while(opcP!=0){
			switch (opcP){
				case 1:
					System.out.println("Digite o nome do funcionário: ");
					String nomeFuncionario = sc.nextLine();
					System.out.println("Digite a matrícula do funcionário: ");
					String matriculaFuncionario = sc.nextLine();
					System.out.println("Digite o CPF do funcionário: ");
					String cpfFuncionario = sc.nextLine();
					System.out.println("Digite o salário do funcionário: ");
					double salarioFuncionario = sc.nextDouble();
					System.out.println("O funcionário possui supervisor? S/N");
					String validaSupervisor = sc.nextLine().toUppercase();
					if(validaSupervisor.equals("S")){
						System.out.println("Forneça os dados do Funcionário Supervisor: ");
						System.out.println("Digite o nome do supervisor: ");
						String nomeSupervisor = sc.nextLine();
						System.out.println("Digite a matrícula do supervisor: ");
						String matriculaSupervisor = sc.nextLine();
						System.out.println("Digite o CPF do supervisor: ");
						String cpfSupervisor = sc.nextLine();
						supervisorModel = new FuncionarioModel(matriculaSupervisor, nomeSupervisor, cpfSupervisor);
						funcionarioModel = new FuncionarioModel(matriculaFuncionario, nomeFuncionario, cpfFuncionario, salarioFuncionario,supervisorModel);
                        assert false;
                        funcionarioController.criar(funcionarioModel);
					} else if (validaSupervisor.equals("N")) {
						funcionarioModel = new FuncionarioModel(matriculaFuncionario,nomeFuncionario, cpfFuncionario,salarioFuncionario);
                        assert false;
                        funcionarioController.criar(funcionarioModel);
					}
					menuPrincipal();
					opcP = sc.nextInt();
					break;
				case 2:
					System.out.println("Digite o código do Cliente: ");
					String codCliente = sc.nextLine();
					System.out.println("Digite o telefone do Cliente: ");
					String telefoneCliente = sc.nextLine();
					System.out.println("Digite o logradouro do Cliente: ");
					String logradouroCliente = sc.nextLine();
					System.out.println("Digite o bairro do Cliente: ");
					String bairroCliente = sc.nextLine();
					System.out.println("Digite a cidade do Cliente: ");
					String cidadeCliente = sc.nextLine();
					System.out.println("Digite o UF do Cliente: ");
					String ufCliente = sc.nextLine();
					System.out.println("Digite o CEP do Cliente: ");
					String cepCliente = sc.nextLine();
					System.out.println("Digite o número da casa do Cliente: ");
					String numeroCliente = sc.nextLine();
					System.out.println("O Cliente será pessoa física ou jurídica? PF/PJ");
					String validaTipoCliente = sc.nextLine().toUppercase();
					if(validaTipoCliente.equals("PF")){
						System.out.println("Digite o nome do Cliente: ");
						String nomeCliente = sc.nextLine();
						System.out.println("Digite o CPF do Cliente: ");
						String cpfCliente = sc.nextLine();
						System.out.println("Digite a CNH do Cliente: ");
						String cnhCliente = sc.nextLine();
						ClientePF = new ClientePFModel(codCliente, telefoneCliente,bairroCliente,logradouroCliente,cidadeCliente,ufCliente,cepCliente,numeroCliente,nomeCliente,cpfCliente,cnhCliente);
                        assert false;
                        clienteController.criar(ClientePF);
					} else if (validaTipoCliente.equals("PJ")) {
						System.out.println("Digite o CNPJ do Cliente: ");
						String cnpjCliente = sc.nextLine();
						System.out.println("Digite a razão social do Cliente: ");
						String razaoSocialCliente = sc.nextLine();
						ClientePJ = new ClientePJModel(codCliente, telefoneCliente, bairroCliente, logradouroCliente, cidadeCliente, ufCliente, cepCliente, numeroCliente, cnpjCliente, razaoSocialCliente);
						assert false;
						clienteController.criar(ClientePJ);
					}
					menuPrincipal();
					opcP = sc.nextInt();
					break;
				case 3:
					String partner = "dd-MM-yyyy";
					System.out.println("Digite o número da apolice do Seguro: ");
					String apoliceSeguro = sc.nextLine();
					System.out.println("Digite o valor do Seguro: ");
					double valorSeguro = sc.nextDouble();
					System.out.println("Digite a data de início do Seguro: ");
					String dataInicio = sc.nextLine();
					SimpleDateFormat sdt = new SimpleDateFormat(partner);
					dataInicio = sdt.format(new Date());
					System.out.println("Digite a data de término do Seguro: ");
					String dataFim = sc.nextLine();
					dataFim = sdt.format(new Date());
					System.out.println("Qual o tipo de cobertura do Seguro? ");
					String tipoCobertura = sc.nextLine();
					System.out.println("Histórico de Sinistro: ");
					String historicoSinistro = sc.nextLine();
					System.out.println("Qual é a franquia? ");
					String franquiaSeguro = sc.nextLine();
					seguroModel = new SeguroModel(apoliceSeguro,valorSeguro,dataInicio.,dataFim,tipoCobertura,historicoSinistro,franquiaSeguro);
					assert false;
					seguroController.criar(seguroModel);
					menuPrincipal();
					opcP = sc.nextInt();
					break;
				case 4:

					menuPrincipal();
					opcP = sc.nextInt();
					break;
			}
		}



//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		//para criar um objeto Seguro precisamos receber a dataFim em String e converter para tipo Date
//
//		//Instâncias dos controllers
//		var clienteController = new ClienteController();
//		var funcionarioController = new FuncionarioController();
//		var manutencaoController = new ManutencaoController();
//		var seguroController = new SeguroController();
//		var veiculoController = new VeiculoController();
//
//		var cliente1 = new ClientePFModel("1", "999999999", "Novo", "Nova",
//				"Garanhuns", "PE", "56800000", "00", "Edson", "00000000000",
//				"CNH");
//
//		var cliente2 = new ClientePJModel("2", "888888888", "bairro", "logradouro",
//				"cidade", "uf", "cep", "numero", "cnpj", "razao social");
//
//		clienteController.criar(cliente1);
//		clienteController.criar(cliente2);
//
//		var funcionario = new FuncionarioModel("matricula", "nome", "cpf", 2000);
//
//		funcionarioController.criar(funcionario);
//
//		var manutencao = new ManutencaoModel("ordem serv", new Date(), "tipo");
//
//		manutencaoController.criar(manutencao);
//
//		var seguro = new SeguroModel("apolice", 700, new Date(), new Date(), "tipo", "historico",
//				"franquia");
//
//		seguroController.criar(seguro);
//
//		var veiculo = new VeiculoModel("placa", "cor", "marca", "categoria", "chassi",
//				"modelo", seguro, manutencao);
//
//		veiculoController.criar(veiculo);
//
//		funcionarioController.imprimir();
//		funcionarioController.editar("matricula");
//		funcionarioController.imprimirUm("matricula");
	}
}
