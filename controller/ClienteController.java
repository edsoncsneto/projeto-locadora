package controller;

import java.util.ArrayList;
import java.util.List;
import model.ClienteModel;

public class ClienteController implements IController{
	
	//Lista que comporta tanto clientes pf, como clientes pj. Deve-se tratar essa diferença nos métodos se necessário com o instanceOf()
	List<ClienteModel> clientes = new ArrayList<>();

	@Override
	public void criar(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirUm(String cod_cliente) {

	}

}
