package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.FuncionarioModel;
import model.LocacaoModel;

public class FuncionarioController implements IController{
	List<FuncionarioModel> funcionarios = new ArrayList<>();

	@Override
	public void criar(Object obj) {
		if(obj instanceof FuncionarioModel) {
			funcionarios.add((FuncionarioModel) obj);
		}
	}

	@Override
	public void editar(Object obj) {
		Scanner sc = new Scanner(System.in);
		if(obj instanceof FuncionarioModel) {
			System.out.println("[1] Matricula \n"+
			"[2] Nome \n" +
			"[3] CPF \n" +
			"[4] Salario \n" +
			"[5] Supervisor \n" +
			"Digite a opção");
			String opcao=sc.nextLine();

			switch(opcao){
				case "1":
					System.out.println("Digite a nova matrícula: ");
					String novaMatricula = sc.nextLine();
					((FuncionarioModel) obj).setNome(novaMatricula);
					break;
				case "2":
					System.out.println("Digite o novo nome: ");
					String novoNome = sc.nextLine();
					((FuncionarioModel) obj).setNome(novoNome);
					break;
				case "3":
					System.out.println("Digite o novo CPF: ");
					String novoCpf = sc.nextLine();
					((FuncionarioModel) obj).setCpf(novoCpf);
					break;
				case "4":
					System.out.println("Digite o novo salário: ");
					double novoSalario = sc.nextDouble();
					((FuncionarioModel) obj).setSalario(novoSalario);
					break;
				case "5":
					boolean verificacao=false;
					System.out.println("Digite matrícula do novo supervisor: ");
					String matriculaSupervisor = sc.nextLine();
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
            imprimirUm(((FuncionarioModel) obj).getMatricula());
		}
		sc.close();
	}

	@Override
	public void imprimir() {
		for(FuncionarioModel func : funcionarios) {
			imprimirUm(func.getMatricula());
		}
	}

	@Override
	public void remover(Object obj) {
		if (obj instanceof FuncionarioModel){
            ((FuncionarioModel) obj).setAtivo(false);
            }
		}

	@Override
	public void imprimirUm(String matricula) {
		for(FuncionarioModel func:funcionarios){
			if(func.getMatricula().equals(matricula)){
				System.out.println("Matrícula: "+func.getMatricula());
				System.out.println("CPF: "+func.getCpf());
				System.out.println("Nome: "+func.getNome());
				System.out.println("Quantidade de locações: "+func.getQuantidadeLocacoes());
				System.out.println("Salário: "+func.getSalario());
				if(func.getSupervisor() != null){
					System.out.println("Supervisor: "+func.getSupervisor().getNome());
				}
				if(func.isAtivo()){
					System.out.println("Status: ativo");
				}else{
					System.out.println("Status: inativo");
				}
				System.out.println("----------------");
			}
		}
	}
}
