package application;

import controller.*;
import model.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//para criar um objeto Seguro precisamos receber a dataFim em String e converter para tipo Date

		//Instâncias dos controllers
		var clienteController = new ClienteController();
		var funcionarioController = new FuncionarioController();
		var manutencaoController = new ManutencaoController();
		var seguroController = new SeguroController();
		var veiculoController = new VeiculoController();

		var cliente1 = new ClientePFModel("1", "999999999", "Novo", "Nova",
				"Garanhuns", "PE", "56800000", "00", "Edson", "00000000000",
				"CNH");

		var cliente2 = new ClientePJModel("2", "888888888", "bairro", "logradouro",
				"cidade", "uf", "cep", "numero", "cnpj", "razao social");

		clienteController.criar(cliente1);
		clienteController.criar(cliente2);

		var funcionario = new FuncionarioModel("matricula", "nome", "cpf", 2000);

		funcionarioController.criar(funcionario);

		var manutencao = new ManutencaoModel("ordem serv", new Date(), "tipo");

		manutencaoController.criar(manutencao);

		var seguro = new SeguroModel("apolice", 700, new Date(), new Date(), "tipo", "historico",
				"franquia");

		seguroController.criar(seguro);

		var veiculo = new VeiculoModel("placa", "cor", "marca", "categoria", "chassi",
				"modelo", seguro, manutencao);

		veiculoController.criar(veiculo);

		funcionarioController.imprimir();
		funcionarioController.editar("matricula");
		funcionarioController.imprimirUm("matricula");
	}

}
