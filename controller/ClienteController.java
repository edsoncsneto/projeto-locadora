package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import model.ClienteModel;
import model.ClientePFModel;
import model.ClientePJModel;
import view.ClienteView;
import java.util.Iterator;


public class ClienteController implements IController {
    //Lista que comporta tanto clientes pf, como clientes pj. Deve-se tratar essa diferença nos métodos se necessário com o instanceOf()
    ClienteModel clienteModel;
    ClienteView clienteView;

    public ClienteController(ClienteModel clienteModel, ClienteView clienteView) {
        this.clienteModel = clienteModel;
        this.clienteView = clienteView;
    }

    List<ClienteModel> clientes = new ArrayList<>();

    @Override
    public void criar(Object obj) {
        clientes.add((ClienteModel) obj);
    }

    @Override
    public void editar(String id) {
        for(ClienteModel cliente:clientes){
            if(cliente.getcodCliente().equals(id)){
                Scanner sc = new Scanner(System.in);

                System.out.println("\nEDITAR CLIENTE ");
                System.out.println("----------------------------");
                System.out.println("[1] Código cliente");
                System.out.println("[2] Telefone");
                System.out.println("[3] Bairro");
                System.out.println("[4] Logradouro");
                System.out.println("[5] Cidade");
                System.out.println("[6] UF");
                System.out.println("[7] CEP");
                System.out.println("[8] Numero");
                if (cliente instanceof ClientePFModel) {
                    System.out.println("[9] Nome");
                    System.out.println("[10] CPF");
                    System.out.println("[11] CNH");

                } else if (cliente instanceof ClientePJModel) {
                    System.out.println("[9] CNPJ");
                    System.out.println("[10] Razao social");
                }
                System.out.print("DIGITE A OPÇÃO: ");
                int opcao = sc.nextInt();
                sc.nextLine();
                if (opcao >= 1 && opcao <= 8) {
                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o novo código do cliente: ");
                            String novoCodigo = sc.nextLine();
                            cliente.setcodCliente(novoCodigo);
                            break;
                        case 2:
                            System.out.println("Digite o novo telefone: ");
                            String novoTelefone = sc.nextLine();
                            cliente.setTelefone(novoTelefone);
                            break;
                        case 3:
                            System.out.println("Digite o novo bairro: ");
                            String novoBairro = sc.nextLine();
                            cliente.setBairro(novoBairro);
                            break;
                        case 4:
                            System.out.println("Digite o novo logradouro: ");
                            String novoLougradouro = sc.nextLine();
                            cliente.setLogradouro(novoLougradouro);
                            break;
                        case 5:
                            System.out.println("Digite a nova cidade: ");
                            String novaCidade = sc.nextLine();
                            cliente.setCidade(novaCidade);
                            break;
                        case 6:
                            System.out.println("Digite a nova UF: ");
                            String novaUF = sc.nextLine();
                            cliente.setUf(novaUF);
                            break;
                        case 7:
                            System.out.println("Digite o novo CEP: ");
                            String novoCEP = sc.nextLine();
                            cliente.setCep(novoCEP);
                            break;
                        case 8:
                            System.out.println("Digite o novo numero: ");
                            String novoNumero = sc.nextLine();
                            cliente.setNumero(novoNumero);
                            break;
                    }
                } else if (opcao >= 9 && opcao <= 11) {
                    if (cliente instanceof ClientePFModel) {
                        switch (opcao) {
                            case 9:
                                System.out.println("Digite o novo nome: ");
                                String novoNome = sc.nextLine();
                                ((ClientePFModel) cliente).setNome(novoNome);
                                break;
                            case 10:
                                System.out.println("Digite o novo CPF: ");
                                String novoCPF = sc.nextLine();
                                ((ClientePFModel) cliente).setCpf(novoCPF);
                                break;
                            case 11:
                                System.out.println("Digite a nova CNH: ");
                                String novaCNH = sc.nextLine();
                                ((ClientePFModel) cliente).setCnh(novaCNH);
                                break;
                        }
                    } else if (cliente instanceof ClientePJModel) {
                        switch (opcao) {
                            case 9:
                                System.out.println("Digite o novo CNPJ: ");
                                String novoCNPJ = sc.nextLine();
                                ((ClientePJModel) cliente).setCnpj(novoCNPJ);
                                break;
                            case 10:
                                System.out.println("Digite a nova razao social: ");
                                String novaRS = sc.nextLine();
                                ((ClientePJModel) cliente).setRazaoSocial(novaRS);
                                break;
                        }
                    }
                } else {
                    System.out.println("----------------------------");
                    System.out.println("Opção inválida!");
                    System.out.println("----------------------------");
                }
                imprimirUm(cliente.getcodCliente());
            }
        }

    }

    @Override
    public void imprimir() {
        for (ClienteModel cli : clientes) {
            imprimirUm(cli.getcodCliente());
        }
    }

    @Override
    public void remover(String id) {
        Iterator<ClienteModel> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            ClienteModel cliente = iterator.next();
            if (cliente.getcodCliente().equals(id)) {
                iterator.remove();
                System.out.println("Cliente removido com sucesso.");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }


    @Override
    public void imprimirUm(String cod_cliente) {
        System.out.println("\nDADOS DO CLIENTE ");
        System.out.println("----------------------------");
        for (ClienteModel cli : clientes) {
            if (cli.getcodCliente().equals(cod_cliente)) {
                if (cli instanceof ClientePFModel) {
                    System.out.println("Código: " + cli.getcodCliente());
                    System.out.println("Nome: " + ((ClientePFModel) cli).getNome());
                    System.out.println("CPF: " + ((ClientePFModel) cli).getCpf());
                    System.out.println("CNH: " + ((ClientePFModel) cli).getCnh());
                    System.out.println("Telefone: " + cli.getTelefone());
                    System.out.println("Logradouro: " + cli.getLogradouro() + ", " + cli.getNumero());
                    System.out.println("Bairro: " + cli.getBairro());
                    System.out.println("Cidade: " + cli.getCidade() + "-" + cli.getUf());
                    System.out.println("CEP: " + cli.getCep());
                    if (cli.isAtivo()) {
                        System.out.println("Status: ativo");
                    } else {
                        System.out.println("Status: inativo");
                    }
                } else if (cli instanceof ClientePJModel) {
                    System.out.println("Código: " + cli.getcodCliente());
                    System.out.println("CNPJ: " + ((ClientePJModel) cli).getCnpj());
                    System.out.println("Razão social: " + ((ClientePJModel) cli).getRazaoSocial());
                    System.out.println("Telefone: " + cli.getTelefone());
                    System.out.println("Logradouro: " + cli.getLogradouro() + ", " + cli.getNumero());
                    System.out.println("Bairro: " + cli.getBairro());
                    System.out.println("Cidade: " + cli.getCidade() + "-" + cli.getUf());
                    System.out.println("CEP: " + cli.getCep());
                    if (cli.isAtivo()) {
                        System.out.println("Status: ativo");
                    } else {
                        System.out.println("Status: inativo");
                    }
                }
            }
        }
    }

    public Optional<ClienteModel> findById(String codCliente){
        for(ClienteModel cliente:clientes){
            if(cliente.getcodCliente().equals(codCliente)){
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }
    public boolean clienteIsPresent(String codCliente){
        Optional<ClienteModel> clienteO = findById(codCliente);
        return clienteO.isPresent();
    }


}
