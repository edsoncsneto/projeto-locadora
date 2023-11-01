package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.FuncionarioModel;
import model.LocacaoModel;

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
		if(obj instanceof FuncionarioModel) {
			Scanner sc = new Scanner(System.in);
			System.out.println("[1] Matricula \n"+
			"[2] Nome \n" +
			"[3] CPF \n" +
			"[4] Salario \n" +
			"[5] Supervisor \n" +
			"Digite a opção");
			String opcao=sc.nextLine();

			switch(opcao){
				case "1":
					String novaMatricula = sc.next();
					((FuncionarioModel) obj).setNome(novaMatricula);
					break;
				case "2":
					String novoNome = sc.next();
					((FuncionarioModel) obj).setNome(novoNome);
					break;
				case "3":
					String novoCpf = sc.next();
					((FuncionarioModel) obj).setCpf(novoCpf);
					break;
				case "4":
					double novoSalario = sc.nextDouble();
					((FuncionarioModel) obj).setSalario(novoSalario);
					break;
				case "5":
					boolean verificacao=false;
					String matriculaSupervisor = sc.next();
					for(FuncionarioModel supervisor:funcionarios){
						if(supervisor.getMatricula().equals(matriculaSupervisor)){
							((FuncionarioModel) obj).setSupervisor(supervisor);
							verificacao=true;
						}
					}
					if(!verificacao){
						System.out.println("Não foi possível alterar o supervisor. Verifique a matrícula.");
					}
					break;
			}

		}
	}

	@Override
	public void imprimir() {
		for(FuncionarioModel func : funcionarios) {
			System.out.println(func.getMatricula());
			System.out.println(func.getCpf());
			System.out.println(func.getNome());
			System.out.println(func.getQuantidadeLocacoes());
			System.out.println(func.getSalario());
			if(func.getSupervisor() != null){
				System.out.println(func.getSupervisor().getNome());
			}
			System.out.println("-------");
		}
	}

	@Override
	public void remover(Object obj) {
		if (obj instanceof FuncionarioModel){
			for(FuncionarioModel func:funcionarios){
				if(func.getQuantidadeLocacoes()!=0){
					System.out.println("Não é possível remover. Há registro desse funcinário em locações.");
				}else{
					funcionarios.remove(func);
				}
			}
		}
	}

	@Override
	public void imprimirUm(String matricula) {
		for(FuncionarioModel func:funcionarios){
			if(func.getMatricula().equals(matricula)){
				System.out.println(func.getMatricula());
				System.out.println(func.getCpf());
				System.out.println(func.getNome());
				System.out.println(func.getQuantidadeLocacoes());
				System.out.println(func.getSalario());
				if(func.getSupervisor() != null){
					System.out.println(func.getSupervisor());
				}
				System.out.println("-------");
			}
		}
	}

}
