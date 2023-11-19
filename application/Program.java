package application;

import controller.*;
import model.*;

import java.util.Date;

public class Program {

	public static void main(String[] args) {

		//Instâncias dos controllers
		var clienteController = new ClienteController();
		var funcionarioController = new FuncionarioController();
		var manutencaoController = new ManutencaoController();
		var seguroController = new SeguroController();
		var veiculoController = new VeiculoController();

	}

}
