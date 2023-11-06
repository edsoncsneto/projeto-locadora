package application;

import controller.FuncionarioController;
import controller.VeiculoController;
import model.FuncionarioModel;
import model.VeiculoModel;

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
		f.imprimirUm("789");
		
		var veiculo = new VeiculoModel("1234", "Branco", "Fiat", "SUV", "789456123", "EL1.4", null, null);
		var veiculo1 = new VeiculoModel("4567", "Vermelho", "Citroen", "SUV", "123456789", "C4", null, null);
		
		VeiculoController v = new VeiculoController();
		
		v.criar(veiculo);
		v.criar(veiculo1);
		
		v.imprimir();
		v.imprimirUm("4567");
		v.editar(veiculo);
		v.imprimir();
//		f.imprimirUm("789");
	}

}
