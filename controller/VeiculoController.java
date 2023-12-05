package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import model.VeiculoModel;
import view.VeiculoView;

public class VeiculoController implements IController {
    VeiculoModel veiculoModel;
    VeiculoView veiculoView;

    public VeiculoController(VeiculoModel veiculoModel, VeiculoView veiculoView) {
        this.veiculoModel = veiculoModel;
        this.veiculoView = veiculoView;
    }

    List<VeiculoModel> veiculos = new ArrayList<>();

    @Override
    public void criar(Object obj) {
        veiculos.add((VeiculoModel) obj);
    }

    @Override
    public void editar(String id) {
        for(VeiculoModel veiculo:veiculos){
            if(veiculo.getPlaca().equals(id)){
                Scanner sc = new Scanner(System.in);

                System.out.println("\nEDITAR VEÍCULO ");
                System.out.println("----------------------------");
                System.out.println("[1] Placa \n" +
                        "[2] Cor \n" +
                        "[3] Marca \n" +
                        "[4] Categoria \n" +
                        "[5] Modelo \n \n");
                System.out.print("DIGITE A OPÇÃO: ");

                String opcao = sc.nextLine();

                switch (opcao) {
                    case "1":
                        System.out.println("Digite a nova placa: ");
                        String novaPlaca = sc.nextLine();
                        veiculo.setPlaca(novaPlaca);
                        break;
                    case "2":
                        System.out.println("Digite a nova cor: ");
                        String novaCor = sc.nextLine();
                        veiculo.setCor(novaCor);
                        break;
                    case "3":
                        System.out.println("Digite a nova Marca: ");
                        String novaMarca = sc.nextLine();
                        veiculo.setMarca(novaMarca);
                        break;
                    case "4":
                        System.out.println("Digite a nova categoria: ");
                        String novaCategoria = sc.nextLine();
                        veiculo.setCategoria(novaCategoria);
                        break;
                    case "5":
                        System.out.println("Digite o novo modelo: ");
                        String novoModelo = sc.nextLine();
                        veiculo.setModelo(novoModelo);
                        break;
                }
                imprimirUm(veiculo.getPlaca());
            }
        }
    }

    @Override
    public void imprimir() {
        for (VeiculoModel veic : veiculos) {
            imprimirUm(veic.getPlaca());
        }
    }

    @Override
    public void remover(String id) {
        for(VeiculoModel veiculo:veiculos){
            if(veiculo.getPlaca().equals(id)){
                veiculo.setAtivo(false);
                veiculo.getManutencao().setAtivo(false);
                veiculo.getSeguro().setAtivo(false);
                //inativando a manutenção e o seguro desse veículo
            }
        }
    }

    @Override
    public void imprimirUm(String placa) {
        System.out.println("\nDADOS DO VEÍCULO ");
        System.out.println("----------------------------");
        for (VeiculoModel veic : veiculos) {
            if (placa.equals(veic.getPlaca())) {
                System.out.println("Placa: " + veic.getPlaca());
                System.out.println("Modelo: " + veic.getModelo());
                System.out.println("Marca: " + veic.getMarca());
                System.out.println("Cor: " + veic.getCor());
                if (veic.getManutencao() == null) {
                    System.out.println("Manutenção nula");
                } else {
                    System.out.println("Ordem de serviço da manutenção: " + veic.getManutencao().getOrdemServico());
                }

                if (veic.getSeguro() == null) {
                    System.out.println("Seguro nulo");
                } else {
                    System.out.println("Apólice do veículo: " + veic.getSeguro().getApolice());
                }

                if (veic.isAtivo()) {
                    System.out.println("Status: ativo");
                } else {
                    System.out.println("Status: inativo");
                }
            }
        }
    }

    public Optional<VeiculoModel> findById(String placa){
        for(VeiculoModel veiculo:veiculos){
            if(veiculo.getPlaca().equals(placa)){
                return Optional.of(veiculo);
            }
        }
        return  Optional.empty();
    }
    public boolean veiculoIsPresent(String placa){
        Optional<VeiculoModel> veiculoModelO = findById(placa);
        return veiculoModelO.isPresent();
    }
}
