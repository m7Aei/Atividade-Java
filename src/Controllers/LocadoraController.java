package Controllers;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import Database.ConnectionFactory;
import Models.Locadora;

public class LocadoraController {
    public void store (Locadora locarCarro) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = connect.prepareStatement("INSERT INTO carros (marca, modelo, ano, cor , motorização, quilometragem, valorVeículo, qtdPortas, donoAtual, placa)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, locarCarro.getMarca());
            stmt.setString(2, locarCarro.getModelo());
            stmt.setInt(3, locarCarro.getAno());
            stmt.setString(4, locarCarro.getCor());
            stmt.setDouble(5, locarCarro.getMotorizacao());
            stmt.setDouble(6, locarCarro.getQuilometragem());
            stmt.setDouble(7, locarCarro.getValorVeiculo());
            stmt.setInt(8, locarCarro.getQtdPortas());
            stmt.setString(9, locarCarro.getDonoAtual());
            stmt.setString(10, locarCarro.getPlaca());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "As informações do carro foram salvas com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Desculpe, houve um erro ao cadastrar as informações!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }

    public List<Locadora> index () {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet results = null;

        List<Locadora> listarCarros = new ArrayList<>();

        try {
            stmt = connect.prepareStatement("SELECT * FROM carros");
            results = stmt.executeQuery();

            while (results.next()) {
                Locadora carrosCadastrados = new Locadora();

                carrosCadastrados.setId(results.getInt("id"));
                carrosCadastrados.setMarca(results.getString("marca"));
                carrosCadastrados.setModelo(results.getString("modelo"));
                carrosCadastrados.setAno(results.getInt("ano"));
                carrosCadastrados.setCor(results.getString("cor"));
                carrosCadastrados.setMotorizacao(results.getDouble("motorização"));
                carrosCadastrados.setQuilometragem(results.getDouble("quilometragem"));
                carrosCadastrados.setValorVeiculo(results.getDouble("valorVeículo"));
                carrosCadastrados.setQtdPortas(results.getInt("qtdPortas"));
                carrosCadastrados.setDonoAtual(results.getString("donoAtual"));
                carrosCadastrados.setPlaca(results.getString("placa"));

                listarCarros.add(carrosCadastrados);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a listagem!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt, results);
        }

        return listarCarros;
    }

    public List<Locadora> show () {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet results = null;

        List<Locadora> listarCarro = new ArrayList<>();

        try {
            stmt = connect.prepareStatement("SELECT * FROM carros WHERE placa LIKE ?");
            stmt.setString(1, "%" + placa + "%");
            results = stmt.executeQuery();

            while (results.next()) {
                Locadora buscarCarro = new Locadora();

                buscarCarro.setId(results.getInt("id"));
                buscarCarro.setMarca(results.getString("marca"));
                buscarCarro.setModelo(results.getString("modelo"));
                buscarCarro.setAno(results.getInt("ano"));
                buscarCarro.setCor(results.getString("cor"));
                buscarCarro.setMotorizacao(results.getDouble("motorização"));
                buscarCarro.setQuilometragem(results.getDouble("quilometragem"));
                buscarCarro.setValorVeiculo(results.getDouble("valorVeículo"));
                buscarCarro.setQtdPortas(results.getInt("qtdPortas"));
                buscarCarro.setDonoAtual(results.getString("donoAtual"));
                buscarCarro.setPlaca(results.getString("placa"));

                listarCarro.add(buscarCarro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o carro!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt, results);
        }

        return listarCarro;
    }

    public void update (Locadora updateCarro) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = connect.prepareStatement("UPDATE carros SET marca = ?, modelo = ?, cor = ?, donoAtual = ? WHERE id = ?");

            stmt.setString(1, updateCarro.getMarca());
            stmt.setString(2, updateCarro.getModelo());
            stmt.setString(3, updateCarro.getCor());
            stmt.setString(4, updateCarro.getDonoAtual());
            stmt.setInt(5, updateCarro.getId());

            stmt.executeQuery();

            JOptionPane.showMessageDialog(null, "As informações foram atualizadas com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Desculpe, houve um erro ao atualizar as informações!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
    }

    public void delete (Locadora deletarCarro) {}
}
