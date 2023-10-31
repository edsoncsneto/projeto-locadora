package controller;

import java.util.ArrayList;
import java.util.List;

import model.FuncionarioModel;

public class FuncionarioController implements IController{
	List<FuncionarioModel> funcionarios = new ArrayList<>();
	
	//Método apenas para ilustrar. Necessita de mais verificações
	@Override
	public void criar(Object obj) {
		if(obj instanceof FuncionarioModel) {
			funcionarios.add((FuncionarioModel) obj);
		}
	}

	@Override
	public void editar(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimir() {
		for(FuncionarioModel f : funcionarios) {
			System.out.println(f.getCpf());
			System.out.println(f.getNome());
		}
		
	}

	@Override
	public void remover(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
