package view;

import controller.SeguroController;
import model.SeguroModel;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class SeguroView {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter ftd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public void seguro(SeguroController seguroController) throws ParseException {
        menu();
        int opcao = sc.nextInt();
        sc.nextLine();

        if(opcao == 1){
            criarSeguro(seguroController);
        } else if (opcao == 2) {
            seguroController.imprimir();
        } else if (opcao == 3) {
            imprimirUmSeguro(seguroController);
        } else if (opcao == 4) {
            editarSeguro(seguroController);
        } else if (opcao == 5) {
            removerSeguro(seguroController);
        }
    }

    public void menu() {
        System.out.println("\nMENU SEGURO: ");
        System.out.println("----------------------------");
        System.out.print("[1] Criar Seguro \n" +
                "[2] Imprimir todos os Seguro \n" +
                "[3] Imprimir um Seguro \n" +
                "[4] Editar um Seguro \n" +
                "[5] Remover um Seguro \n \n" +
                "DIGITE A OPÇÃO: ");
    }

    public void criarSeguro(SeguroController seguroController) {
        System.out.println("Digite a apólice do Seguro: ");
        String apoliceSeguro = sc.nextLine();
        System.out.println("Digite o valor do Seguro: ");
        Double valorSeguro = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite a data inicial do Seguro: ");
        String dataInicialSeguro = sc.nextLine();
        System.out.println("Digite a data final do Seguro: ");
        String dataFinalSeguro = sc.nextLine();
        System.out.println("Digite o tipo de cobertura do Seguro: ");
        String tipoCoberturaSeguro = sc.nextLine();
        System.out.println("Digite o histórico do Seguro: ");
        String historicoSeguro = sc.nextLine();
        System.out.println("Digite a franquia do seguro: ");
        String franquiaSeguro = sc.nextLine();

        LocalDate novaDI = LocalDate.parse(dataInicialSeguro, ftd);
        LocalDate novaDF = LocalDate.parse(dataFinalSeguro,ftd);

        SeguroModel seguroModel = new SeguroModel(apoliceSeguro,valorSeguro,novaDI,
                novaDF, tipoCoberturaSeguro, historicoSeguro, franquiaSeguro);
        seguroController.criar(seguroModel);
        System.out.println("----------------------------");
        System.out.println("Seguro criado com sucesso!");
        System.out.println("----------------------------");
    }

    public void imprimirUmSeguro(SeguroController seguroController) {
        System.out.println("\nDigite a apolice do seguro: ");
        String apoliceSeguro = sc.nextLine();
        Optional<SeguroModel> seguroModelO = seguroController.findById(apoliceSeguro);
        if(seguroController.seguroIsPresent(apoliceSeguro)){
            seguroController.imprimirUm(apoliceSeguro);
        }
        else {
            System.out.println("----------------------------");
            System.out.println("Apolice inválida! ");
            System.out.println("----------------------------");
        }
    }

    public void editarSeguro(SeguroController seguroController) throws ParseException {
        System.out.println("\nDigite a apolice do seguro que será editado: ");
        String apoliceSeguro = sc.nextLine();
        if(seguroController.seguroIsPresent(apoliceSeguro)) {
            try {
                seguroController.editar(apoliceSeguro);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("----------------------------");
            System.out.println("Apolice inválida!");
            System.out.println("----------------------------");
        }
    }

    public void removerSeguro(SeguroController seguroController) {
        System.out.println("\nDigite a apolice do seguro a ser removido: ");
        String apoliceSeguro = sc.nextLine();
        if(seguroController.seguroIsPresent(apoliceSeguro)){
            seguroController.remover(apoliceSeguro);
        }
        else {
            System.out.println("----------------------------");
            System.out.println("Apolice inválida!");
            System.out.println("----------------------------");
        }
    }
}
