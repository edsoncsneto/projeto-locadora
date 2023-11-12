package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ClienteModel;
import model.ClientePFModel;
import model.ClientePJModel;

public class ClienteController implements IController{
	//Lista que comporta tanto clientes pf, como clientes pj. Deve-se tratar essa diferença nos métodos se necessário com o instanceOf()
	List<ClienteModel> clientes = new ArrayList<>();

	@Override
	public void criar(Object obj) {
		if(obj instanceof ClienteModel){
			clientes.add((ClienteModel) obj);
		}
	}

	@Override
	public void editar(Object obj) {
		Scanner sc = new Scanner(System.in);
		if(obj instanceof ClienteModel){
			System.out.println("[1] Código cliente");
			System.out.println("[2] Telefone");
			System.out.println("[3] Bairro");
			System.out.println("[4] Logradouro");
			System.out.println("[5] Cidade");
			System.out.println("[6] UF");
			System.out.println("[7] CEP");
			System.out.println("[8] Numero");
			if(obj instanceof ClientePFModel){
				System.out.println("[9] Nome");
				System.out.println("[10] CPF");
				System.out.println("[11] CNH");

			}else if(obj instanceof ClientePJModel){
				System.out.println("[9] CNPJ");
				System.out.println("[10] Razao social");
			}

			int opcao = sc.nextInt();
			sc.nextLine();
			if(opcao>=1 && opcao<=8){
				switch (opcao){
					case 1:
						System.out.println("Digite o novo código do cliente: ");
						String novoCodigo = sc.nextLine();
						((ClienteModel) obj).setcodCliente(novoCodigo);
						break;
					case 2:
						System.out.println("Digite o novo telefone: ");
						String novoTelefone = sc.nextLine();
						((ClienteModel) obj).setTelefone(novoTelefone);
						break;
					case 3:
						System.out.println("Digite o novo bairro: ");
						String novoBairro = sc.nextLine();
						((ClienteModel) obj).setBairro(novoBairro);
						break;
					case 4:
						System.out.println("Digite o novo logradouro: ");
						String novoLougradouro = sc.nextLine();
						((ClienteModel) obj).setLogradouro(novoLougradouro);
						break;
					case 5:
						System.out.println("Digite a nova cidade: ");
						String novaCidade = sc.nextLine();
						((ClienteModel) obj).setCidade(novaCidade);
						break;
					case 6:
						System.out.println("Digite a nova UF: ");
						String novaUF = sc.nextLine();
						((ClienteModel) obj).setUf(novaUF);
						break;
					case 7:
						System.out.println("Digite o novo CEP: ");
						String novoCEP = sc.nextLine();
						((ClienteModel) obj).setCep(novoCEP);
						break;
					case 8:
						System.out.println("Digite o novo numero: ");
						String novoNumero = sc.nextLine();
						((ClienteModel) obj).setNumero(novoNumero);
						break;
				}
			}else if(opcao>=9 && opcao<=11){
				if(obj instanceof ClientePFModel){
					switch (opcao){
						case 9:
							System.out.println("Digite o novo nome: ");
							String novoNome = sc.nextLine();
							((ClientePFModel) obj).setNome(novoNome);
							break;
						case 10:
							System.out.println("Digite o novo CPF: ");
							String novoCPF = sc.nextLine();
							((ClientePFModel) obj).setCpf(novoCPF);
							break;
						case 11:
							System.out.println("Digite a nova CNH: ");
							String novaCNH = sc.nextLine();
							((ClientePFModel) obj).setCnh(novaCNH);
							break;
					}
				}else if(obj instanceof ClientePJModel){
					switch (opcao){
						case 9:
							System.out.println("Digite o novo CNPJ: ");
							String novoCNPJ = sc.nextLine();
							((ClientePJModel) obj).setCnpj(novoCNPJ);
							break;
						case 10:
							System.out.println("Digite a nova razao social: ");
							String novaRS = sc.nextLine();
							((ClientePJModel) obj).setRazaoSocial(novaRS);
							break;
					}
				}
			}else{
				System.out.println("Opção inválida!");
			}
			imprimirUm(((ClienteModel) obj).getcodCliente());
		}
		sc.close();
	}

	@Override
	public void imprimir() {
		for(ClienteModel cli:clientes){
			if(cli instanceof ClientePFModel){
				System.out.println(cli.getcodCliente());
				System.out.println(cli.getTelefone());
				System.out.println(cli.getBairro());
				System.out.println(cli.getLogradouro());
				System.out.println(cli.getCidade());
				System.out.println(cli.getUf());
				System.out.println(cli.getCep());
				System.out.println(cli.getNumero());
				if(cli.isAtivo()){
					System.out.println("Status: ativo");
				}else{
					System.out.println("Status: inativo");
				}
				System.out.println(((ClientePFModel) cli).getNome());
				System.out.println(((ClientePFModel) cli).getCpf());
				System.out.println(((ClientePFModel) cli).getCnh());
			}else if(cli instanceof ClientePJModel){
				System.out.println(cli.getcodCliente());
				System.out.println(cli.getTelefone());
				System.out.println(cli.getBairro());
				System.out.println(cli.getLogradouro());
				System.out.println(cli.getCidade());
				System.out.println(cli.getUf());
				System.out.println(cli.getCep());
				System.out.println(cli.getNumero());
				if(cli.isAtivo()){
					System.out.println("Status: ativo");
				}else{
					System.out.println("Status: inativo");
				}
				System.out.println(((ClientePJModel) cli).getCnpj());
				System.out.println(((ClientePJModel) cli).getRazaoSocial());
			}
		}
	}

	@Override
	public void remover(Object obj) {
		if(obj instanceof ClienteModel){
			((ClienteModel) obj).setAtivo(false);
		}
	}

	@Override
	public void imprimirUm(String cod_cliente) {
		for(ClienteModel cli:clientes){
			if(cli.getcodCliente().equals(cod_cliente)){
				if(cli instanceof ClientePFModel){
					System.out.println(cli.getcodCliente());
					System.out.println(cli.getTelefone());
					System.out.println(cli.getBairro());
					System.out.println(cli.getLogradouro());
					System.out.println(cli.getCidade());
					System.out.println(cli.getUf());
					System.out.println(cli.getCep());
					System.out.println(cli.getNumero());
					if(cli.isAtivo()){
						System.out.println("Status: ativo");
					}else{
						System.out.println("Status: inativo");
					}
					System.out.println(((ClientePFModel) cli).getNome());
					System.out.println(((ClientePFModel) cli).getCpf());
					System.out.println(((ClientePFModel) cli).getCnh());
				}else if(cli instanceof ClientePJModel){
					System.out.println(cli.getcodCliente());
					System.out.println(cli.getTelefone());
					System.out.println(cli.getBairro());
					System.out.println(cli.getLogradouro());
					System.out.println(cli.getCidade());
					System.out.println(cli.getUf());
					System.out.println(cli.getCep());
					System.out.println(cli.getNumero());
					if(cli.isAtivo()){
						System.out.println("Status: ativo");
					}else{
						System.out.println("Status: inativo");
					}
					System.out.println(((ClientePJModel) cli).getCnpj());
					System.out.println(((ClientePJModel) cli).getRazaoSocial());
				}
			}
		}
	}

}
