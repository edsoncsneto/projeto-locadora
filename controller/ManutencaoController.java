package controller;

import java.util.ArrayList;
import java.util.List;

import model.ManutencaoModel;

public class ManutencaoController implements IController{
	List<ManutencaoModel> manutencoes = new ArrayList<>();
	
	@Override
	public void criar(Object obj) {}
	
	@Override
	public void editar(Object obj){}
	
	@Override
	public void imprimir() {}
	
	@Override
	public void remover(Object obj) {}

}
