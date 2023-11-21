package application;

import controller.*;
import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Program {

	public static void menuPrincipal() {
		System.out.println("MENU PRINCIPAL: ");
		System.out.println("1 - Cadastrar Funcionário ");
		System.out.println("2 - Cadastrar Cliente ");
		System.out.println("3 - Cadastrar Seguro ");
		System.out.println("4 - Cadastrar Manutenção ");
		System.out.println("5 - Cadastrar Veículo ");
		System.out.println("6 - Realizar locação ");
		System.out.println("7 - Mais opções...");
		System.out.println("0 - SAIR");

		System.out.println("");
		System.out.println("Escolha uma das opção acima:");
	}
	public static void menuAlternativo(){
		System.out.println("EDITAR DADOS: ");
		System.out.println("8 - Editar Funcionários ");
		System.out.println("9 - Editar Clientes ");
		System.out.println("10 - Editar Veículos ");
		System.out.println("11 - Editar Seguros ");
		System.out.println("12 - Editar Manutenções ");
		System.out.println("0 - SAIR");

		System.out.println("");
		System.out.println("Escolha uma das opção acima:");
	}
	public static void main(String[] args) {
		FuncionarioModel funcionarioModel = null;
		FuncionarioModel supervisorModel = null;
		ClienteModel ClientePF = null;
		ClienteModel ClientePJ = null;
		SeguroModel seguroModel = null;
		ManutencaoModel manutencaoModel = null;

		ClienteController clienteController = new ClienteController();
		FuncionarioController funcionarioController = new FuncionarioController();
		SeguroController seguroController = new SeguroController();
		ManutencaoController manutencaoController = new ManutencaoController();

		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		int opcP = -1;

		while(opcP != 0){
			menuPrincipal();
			opcP = sc.nextInt();

			switch (opcP){
				case 1:
					System.out.println("Digite o nome do funcionário: ");
					String nomeFuncionario = sc.next();
					System.out.println("Digite a matrícula do funcionário: ");
					String matriculaFuncionario = sc.next();
					System.out.println("Digite o CPF do funcionário: ");
					String cpfFuncionario = sc.next();
					System.out.println("Digite o salário do funcionário: ");
					double salarioFuncionario = sc.nextDouble();
					System.out.println("O funcionário possui supervisor? S/N");
					String validaSupervisor = sc.next().toUpperCase();

					if(validaSupervisor.equals("S")){
						System.out.println("DADOS DO SUPERVISOR");
						System.out.println("Digite o nome do supervisor: ");
						String nomeSupervisor = sc.next();
						System.out.println("Digite a matrícula do supervisor: ");
						String matriculaSupervisor = sc.next();
						System.out.println("Digite o CPF do supervisor: ");
						String cpfSupervisor = sc.next();

						supervisorModel = new FuncionarioModel(matriculaSupervisor, nomeSupervisor, cpfSupervisor);
						funcionarioModel = new FuncionarioModel(matriculaFuncionario, nomeFuncionario, cpfFuncionario, salarioFuncionario, supervisorModel);
                        assert false;
                        funcionarioController.criar(funcionarioModel);

						//TESTE
						funcionarioController.imprimir();
						break;
					} else if (validaSupervisor.equals("N")) {
						funcionarioModel = new FuncionarioModel(matriculaFuncionario,nomeFuncionario, cpfFuncionario,salarioFuncionario);
                        assert false;
                        funcionarioController.criar(funcionarioModel);

						//TESTE
						funcionarioController.imprimir();
						break;
					}
				case 2:
					System.out.println("Digite o código do Cliente: ");
					String codCliente = sc.next();
					System.out.println("Digite o telefone do Cliente: ");
					String telefoneCliente = sc.next();
					System.out.println("Digite o logradouro do Cliente: ");
					String logradouroCliente = sc.next();
					System.out.println("Digite o bairro do Cliente: ");
					String bairroCliente = sc.next();
					System.out.println("Digite a cidade do Cliente: ");
					String cidadeCliente = sc.next();
					System.out.println("Digite o UF do Cliente: ");
					String ufCliente = sc.next();
					System.out.println("Digite o CEP do Cliente: ");
					String cepCliente = sc.next();
					System.out.println("Digite o número da casa do Cliente: ");
					String numeroCliente = sc.next();
					System.out.println("O Cliente será pessoa física ou jurídica? PF/PJ");
					String validaTipoCliente = sc.next().toUpperCase();

					if(validaTipoCliente.equals("PF")){
						System.out.println("Digite o nome do Cliente: ");
						String nomeCliente = sc.next();
						System.out.println("Digite o CPF do Cliente: ");
						String cpfCliente = sc.next();
						System.out.println("Digite a CNH do Cliente: ");
						String cnhCliente = sc.next();

						ClientePF = new ClientePFModel(codCliente, telefoneCliente, bairroCliente, logradouroCliente, cidadeCliente, ufCliente, cepCliente, numeroCliente, nomeCliente, cpfCliente, cnhCliente);
                        assert false;
                        clienteController.criar(ClientePF);
						clienteController.imprimir();
						break;
					} else if (validaTipoCliente.equals("PJ")) {
						System.out.println("Digite o CNPJ do Cliente: ");
						String cnpjCliente = sc.next();
						System.out.println("Digite a razão social do Cliente: ");
						String razaoSocialCliente = sc.nextLine(); sc.nextLine();
						ClientePJ = new ClientePJModel(codCliente, telefoneCliente, bairroCliente, logradouroCliente, cidadeCliente, ufCliente, cepCliente, numeroCliente, cnpjCliente, razaoSocialCliente);
						assert false;
						clienteController.criar(ClientePJ);
						clienteController.imprimir();
						break;
					}

				case 3:
					System.out.println("Digite o número da apolice do Seguro: ");
					String apoliceSeguro = sc.next();
					System.out.println("Digite o valor do Seguro: ");
					double valorSeguro = sc.nextDouble();
					System.out.println("Digite a data de início do Seguro: ");
					String dataInicio = sc.next();
					System.out.println("Digite a data de término do Seguro: ");
					String dataFim = sc.next();
					System.out.println("Qual o tipo de cobertura do Seguro? ");
					String tipoCobertura = sc.next();
					System.out.println("Histórico de Sinistro: ");
					String historicoSinistro = sc.next();
					System.out.println("Qual é a franquia? ");
					String franquiaSeguro = sc.next();

					// Convertendo a data para LocalDate
					LocalDate dataInicial = LocalDate.parse(dataInicio, formataData);
					LocalDate dataFinal = LocalDate.parse(dataFim, formataData);

//					String partner = "dd-MM-yyyy";
//					SimpleDateFormat sdt = new SimpleDateFormat(partner);
//					dataInicio = sdt.format(new Date());
//					dataFim = sdt.format(new Date());

					seguroModel = new SeguroModel(apoliceSeguro, valorSeguro, dataInicial, dataFinal, tipoCobertura, historicoSinistro, franquiaSeguro);
					assert false;
					seguroController.criar(seguroModel);
					seguroController.imprimir();
					break;
				case 4:
					System.out.println("Digite a ordem de serviço: ");
					String ordemServico = sc.next();
					System.out.println("Digite a data da manutenção: ");
					String dataManutencao = sc.next();
					System.out.println("Digite o tipo da manutenção: ");
					String tipoManutencao = sc.next();

					LocalDate dataRealizado = LocalDate.parse(dataManutencao, formataData);

					manutencaoModel = new ManutencaoModel(ordemServico, dataRealizado, tipoManutencao);
					assert false;
					manutencaoController.criar(manutencaoModel);
					manutencaoController.imprimir();
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
