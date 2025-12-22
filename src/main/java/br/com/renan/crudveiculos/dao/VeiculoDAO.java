package br.com.renan.crudveiculos.dao;

import br.com.renan.crudveiculos.model.Veiculo;

import java.util.List;

public interface VeiculoDAO {

    void inserir(Veiculo veiculo);

    void atualizar(Veiculo veiculo);

    void deletar(Long id);

    Veiculo buscarPorId(Long id);

    List<Veiculo> buscarPorMarca(String marca);

    List<Veiculo> listarTodos();

}