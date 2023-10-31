package application;

import controller.FuncionarioController;
import model.FuncionarioModel;

public class Program {

	public static void main(String[] args) {

		var funcionarioModel = new FuncionarioModel("123", "Edson", "091", 40000);
		FuncionarioController f = new FuncionarioController();
		f.criar(funcionarioModel);
		
		f.imprimir();
		
	}

}
