package br.com.renan.crudveiculos.dao;

import br.com.renan.crudveiculos.model.Veiculo;
import br.com.renan.crudveiculos.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAOImpl implements VeiculoDAO {

    @Override
    public void inserir(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (marca, modelo, ano, preco) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getAno());
            stmt.setDouble(4, veiculo.getPreco());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    veiculo.setId(rs.getLong(1));
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir veículo", e);
        }
    }

    @Override
    public void atualizar(Veiculo veiculo) {
        String sql = "UPDATE veiculo SET marca = ?, modelo = ?, ano = ?, preco = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getAno());
            stmt.setDouble(4, veiculo.getPreco());
            stmt.setLong(5, veiculo.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar veículo", e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM veiculo WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar veículo", e);
        }
    }

    @Override
    public Veiculo buscarPorId(Long id) {
        String sql = "SELECT id, marca, modelo, ano, preco FROM veiculo WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Veiculo v = new Veiculo();
                    v.setId(rs.getLong("id"));
                    v.setMarca(rs.getString("marca"));
                    v.setModelo(rs.getString("modelo"));
                    v.setAno(rs.getInt("ano"));
                    v.setPreco(rs.getDouble("preco"));
                    return v;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar veículo por id", e);
        }

        return null;
    }

    @Override
    public List<Veiculo> listarTodos() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT id, marca, modelo, ano, preco FROM veiculo ORDER BY id ASC";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setId(rs.getLong("id"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setAno(rs.getInt("ano"));
                v.setPreco(rs.getDouble("preco"));
                veiculos.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar veículos", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return veiculos;
    };

    public List<Veiculo> buscarPorMarca(String marca) {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT id, marca, modelo, ano, preco FROM veiculo WHERE marca = ? ORDER BY id ASC";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, marca);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Veiculo v = new Veiculo();
                    v.setId(rs.getLong("id"));
                    v.setMarca(rs.getString("marca"));
                    v.setModelo(rs.getString("modelo"));
                    v.setAno(rs.getInt("ano"));
                    v.setPreco(rs.getDouble("preco"));
                    veiculos.add(v);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar veículos por marca", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return veiculos;
    }
}