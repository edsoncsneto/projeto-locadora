package controller;

import java.text.ParseException;

public interface IController {

	public void criar(Object obj);
	
	public void editar(String id) throws ParseException;
	
	public void imprimir();
	
	public void remover(String id);

	public void imprimirUm(String id);
	
}
