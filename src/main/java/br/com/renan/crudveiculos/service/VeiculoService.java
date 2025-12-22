package br.com.renan.crudveiculos.service;

import br.com.renan.crudveiculos.dao.VeiculoDAO;
import br.com.renan.crudveiculos.dao.VeiculoDAOImpl;
import br.com.renan.crudveiculos.model.Veiculo;

import java.util.List;

public class VeiculoService {

    private final VeiculoDAO veiculoDAO = new VeiculoDAOImpl();

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculoDAO.inserir(veiculo);
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        veiculoDAO.atualizar(veiculo);
    }

    public void removerVeiculo(Long id) {
        veiculoDAO.deletar(id);
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoDAO.buscarPorId(id);
    }

    public List<Veiculo> listarTodos() {
        return veiculoDAO.listarTodos();
    }
    public List<Veiculo> buscarPorMarca(String marca) {
        return veiculoDAO.buscarPorMarca(marca);
    }
}