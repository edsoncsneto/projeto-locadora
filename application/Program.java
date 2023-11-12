package application;

import controller.ClienteController;
import controller.FuncionarioController;
import controller.VeiculoController;
import model.ClientePFModel;
import model.FuncionarioModel;
import model.VeiculoModel;

public class Program {

	public static void main(String[] args) {

		//Testes de funcionario

//		var funcionarioModel = new FuncionarioModel("123", "Edson", "091", 40000);
//		var funcionarioModel3 = new FuncionarioModel("789", "Siqu", "982", 60000);
//		var funcionarioModel2 = new FuncionarioModel("456", "Neto", "020", 50000, funcionarioModel);
//		FuncionarioController f = new FuncionarioController();
//		f.criar(funcionarioModel);
//		f.criar(funcionarioModel2);
//		f.criar(funcionarioModel3);
//
//		f.imprimir();
//		f.imprimirUm("123");
//		f.editar(funcionarioModel2);
//		f.imprimir();
//		f.imprimirUm("789");

		//Testes de veiculo
		
//		var veiculo = new VeiculoModel("1234", "Branco", "Fiat", "SUV", "789456123", "EL1.4", null, null);
//		var veiculo1 = new VeiculoModel("4567", "Vermelho", "Citroen", "SUV", "123456789", "C4", null, null);
//
//		VeiculoController v = new VeiculoController();
//
//		v.criar(veiculo);
//		v.criar(veiculo1);
//
//		v.imprimir();
//		v.imprimirUm("4567");
//		v.editar(veiculo);
//		v.imprimir();

		//Testes de Cliente

		ClienteController c = new ClienteController();

		var cliente = new ClientePFModel("123","999999999", "Bairro Felicidade",
				"Rua Felicidade", "Garanhuns", "PE", "56800000", "71", "Edson",
				"11111111111", "999999");

		c.criar(cliente);
		System.out.println("---");
		c.imprimir();
		System.out.println("---");
		c.imprimirUm("123");
		System.out.println("---");
		c.editar(cliente);
		System.out.println("---");
		c.remover(cliente);
		System.out.println("---");
		c.imprimirUm("123");
		System.out.println("---");

	}

}
