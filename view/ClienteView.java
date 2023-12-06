package view;

import controller.ClienteController;
import model.ClienteModel;
import model.ClientePFModel;
import model.ClientePJModel;

import java.util.Optional;
import java.util.Scanner;

public class ClienteView {
    Scanner sc = new Scanner(System.in);

    public void cliente(ClienteController clienteController) {
        menu();
        int opcao = sc.nextInt();
        sc.nextLine();

        if(opcao == 1){
            criarCliente(clienteController);
        } else if (opcao == 2) {
            clienteController.imprimir();
        } else if (opcao == 3) {
           imprimirUmCliente(clienteController);
        } else if (opcao == 4) {
            editarCliente(clienteController);
        } else if (opcao == 5) {
            removerCliente(clienteController);
        }
    }

    public void menu() {
        System.out.println("\nMENU CLIENTE: ");
        System.out.println("----------------------------");
        System.out.print("[1] Criar Cliente \n" +
                "[2] Imprimir todos os Clientes \n" +
                "[3] Imprimir um Cliente \n" +
                "[4] Editar um Cliente \n" +
                "[5] Remover um Cliente \n \n" +
                "DIGITE A OPÇÃO: ");
    }

    public void criarCliente(ClienteController clienteController) {
        System.out.println("Digite o código do Cliente: ");
        String codCliente = sc.nextLine();
        System.out.println("Digite o telefone do Cliente: ");
        String telefoneCliente = sc.nextLine();
        System.out.println("Digite o logradouro do Cliente: ");
        String logCliente = sc.nextLine();
        System.out.println("Digite o numero da residência do Cliente: ");
        String numCliente = sc.nextLine();
        System.out.println("Digite o bairro do Cliente: ");
        String bairroCliente = sc.nextLine();
        System.out.println("Digite a cidade do Cliente: ");
        String cidadeCliente = sc.nextLine();
        System.out.println("Digite o UF do Cliente: ");
        String ufCliente = sc.nextLine();
        System.out.println("Digite o CEP do Cliente: ");
        String cepCliente = sc.nextLine();
        System.out.println("O cliente é pessoa física ou pessoa jurídica? [PF/PJ] ");
        String tipoCliente = sc.nextLine().toUpperCase();
        if(tipoCliente.equals("PF")){
            System.out.println("Digite o nome do Cliente: ");
            String nomeCliente = sc.nextLine();
            System.out.println("Digite o CPF do Cliente: ");
            String cpfCliente = sc.nextLine();
            System.out.println("Digite a CNH do Cliente: ");
            String cnhCliente = sc.nextLine();
            ClientePFModel clientePFModel = new ClientePFModel(codCliente,telefoneCliente,bairroCliente,logCliente,
                    cidadeCliente,ufCliente,cepCliente,numCliente,nomeCliente,cpfCliente,cnhCliente);
            clienteController.criar(clientePFModel);
        } else if (tipoCliente.equals("PJ")) {
            System.out.println("Digite a razão social do Cliente: ");
            String razaoSocial = sc.nextLine();
            System.out.println("Digite o CNPJ do Cliente: ");
            String cnpjCliente = sc.nextLine();
            ClientePJModel clientePJModel = new ClientePJModel(
                    codCliente,telefoneCliente,bairroCliente,logCliente,cidadeCliente,
                    ufCliente,cepCliente,numCliente,cnpjCliente, razaoSocial
            );
            clienteController.criar(clientePJModel);
            System.out.println("----------------------------");
            System.out.println("Cliente criado com sucesso!");
            System.out.println("----------------------------");
        }
    }

    public void imprimirUmCliente(ClienteController clienteController) {
        System.out.println("\nDigite o código do Cliente: ");
        String codCliente = sc.nextLine();
        Optional<ClienteModel> clienteO = clienteController.findById(codCliente);
        if(clienteController.clienteIsPresent(codCliente)){
            clienteController.imprimirUm(codCliente);
        }
    }

    public void editarCliente(ClienteController clienteController) {
        System.out.println("\nDigite o código do Cliente a ser editado: ");
        String codCliente = sc.nextLine();
        if (clienteController.clienteIsPresent(codCliente)) {
            clienteController.editar(codCliente);
        } else {
            System.out.println("----------------------------");
            System.out.println("Código não corresponde a Cliente cadastrado! ");
            System.out.println("----------------------------");
        }
    }

    public void removerCliente(ClienteController clienteController) {
        System.out.println("\nDigite o código do Cliente a ser removido: ");
        String codCliente = sc.nextLine();
        if (clienteController.clienteIsPresent(codCliente)) {
            clienteController.remover(codCliente);
        }else {
            System.out.println("----------------------------");
            System.out.println("Código não corresponde a Cliente cadastrado! ");
            System.out.println("----------------------------");
        }
    }
}
