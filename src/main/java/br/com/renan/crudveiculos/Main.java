package br.com.renan.crudveiculos;

import br.com.renan.crudveiculos.model.Veiculo;
import br.com.renan.crudveiculos.service.VeiculoService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        VeiculoService service = new VeiculoService();

        System.out.println("=== Lista atual de veículos no banco ===");
        listar(service);

        System.out.println("=== Veiculos da marca Fiat ===");
        List<Veiculo> fiats = service.buscarPorMarca("Fiat");
        for (Veiculo v : fiats) {
            System.out.printf("%d - %s %s (%d) R$ %.2f%n",
                    v.getId(), v.getMarca(), v.getModelo(), v.getAno(), v.getPreco());
        }
     // TESTES DE ATUALIZAÇÃO E REMOÇÃO --------
    }

    private static void listar(VeiculoService service) {
        List<Veiculo> veiculos = service.listarTodos();
        for (Veiculo v : veiculos) {
            System.out.printf("%d - %s %s (%d) R$ %.2f%n",
                    v.getId(), v.getMarca(), v.getModelo(), v.getAno(), v.getPreco());
        }
        System.out.println();
    }

    // metodos de teste

    private static void atualizarPrimeiroVeiculo(VeiculoService service) {
        List<Veiculo> veiculos = service.listarTodos();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo para atualizar.");
            return;
        }

        Veiculo v = veiculos.get(0);
        v.setPreco(v.getPreco() + 1000.0);
        service.atualizarVeiculo(v);

        System.out.println("=== Atualizar o primeiro veículo ===");
    }

    private static void removerSegundoVeiculo(VeiculoService service) {
        List<Veiculo> veiculos = service.listarTodos();
        if (veiculos.size() < 2) {
            System.out.println("Não tem segundo veículo para remover.");
            return;
        }

        Long idRemover = veiculos.get(1).getId(); // segundo da lista
        service.removerVeiculo(idRemover);

        System.out.println("=== Depois de remover o segundo veículo ===");
    }
}