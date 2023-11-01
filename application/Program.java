package application;

import controller.FuncionarioController;
import model.FuncionarioModel;

public class Program {

	public static void main(String[] args) {

		var funcionarioModel = new FuncionarioModel("123", "Edson", "091", 40000);
		var funcionarioModel3 = new FuncionarioModel("789", "Siqu", "982", 60000);
		var funcionarioModel2 = new FuncionarioModel("456", "Neto", "020", 50000, funcionarioModel);
		FuncionarioController f = new FuncionarioController();
		f.criar(funcionarioModel);
		f.criar(funcionarioModel2);
		f.criar(funcionarioModel3);
		
		f.imprimir();
		f.imprimirUm("123");
		f.editar(funcionarioModel2);
		f.imprimir();
	}

}
