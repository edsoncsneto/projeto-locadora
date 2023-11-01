package application;

import controller.FuncionarioController;
import model.FuncionarioModel;

public class Program {

	public static void main(String[] args) {

		var funcionarioModel = new FuncionarioModel("123", "Edson", "091", 40000);
		var funcionarioModel2 = new FuncionarioModel("456", "Neto", "020", 50000, funcionarioModel);
		var funcionarioModel3 = new FuncionarioModel("789", "Marcelo", "982", 60000, funcionarioModel2);
		var funcionarioModel4 = new FuncionarioModel("101", "Carlos", "637", 60000, funcionarioModel3);

		FuncionarioController f = new FuncionarioController();
		f.criar(funcionarioModel);
		f.criar(funcionarioModel2);
		f.criar(funcionarioModel3);
		f.criar(funcionarioModel4);
		
//		f.imprimir();
//		f.imprimirUm("123");
//		System.out.println("-------");
//		f.editar(funcionarioModel2);
//		System.out.println("-------");
//		f.imprimir();
		f.remover(funcionarioModel3);
		f.imprimir();
	}

}
