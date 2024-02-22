package br.com.codandosimples.dao;

import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;
import infra.ConnectionFactory;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DespesaDAO implements IDespesaDAO {

    @Override
    public Despesa save(Despesa despesa) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO Despesas (descricao, valor, data, categoria) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, despesa.getDescricao());
            preparedStatement.setDouble(2, despesa.getValor());
            preparedStatement.setDate(3, Date.valueOf(despesa.getData()));
            preparedStatement.setString(4, despesa.getCategoria().toString());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Integer generatedId = resultSet.getInt(1);

            despesa.setId(generatedId);

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }

        return despesa;
    }

    @Override
    public Despesa update(Despesa despesa) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE Despesas SET descricao = ?, valor = ?, data = ?, categoria = ? WHERE id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, despesa.getDescricao());
            preparedStatement.setDouble(2, despesa.getValor());
            preparedStatement.setDate(3, Date.valueOf(despesa.getData()));
            preparedStatement.setString(4, despesa.getCategoria().toString());
            preparedStatement.setInt(5, despesa.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }

        return despesa;
    }

    @Override
    public void delete(int id) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM Despesas WHERE id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
    }

    @Override
    public List<Despesa> findAll() {

        String sql = "SELECT id, descricao, data, valor, categoria FROM Despesas;";

            List<Despesa> listDespesas = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer pKey = rs.getInt("id");
                String descricao = rs.getString("descricao");
                LocalDate data = rs.getDate("data").toLocalDate();
                double valor = rs.getDouble("valor");
                Categoria categoria = Categoria.valueOf(rs.getString("categoria"));

                Despesa despesa = new Despesa();

                despesa.setId(pKey);
                despesa.setDescricao(descricao);
                despesa.setData(data);
                despesa.setValor(valor);
                despesa.setCategoria(categoria);

                listDespesas.add(despesa);

            }
        }

        catch (SQLException ex) {

            throw new RuntimeException(ex);
        }

        System.out.println(listDespesas.size());

        return listDespesas;
    }

    @Override
    public Optional<Despesa> findById(int id) {

        String sql = "SELECT id, descricao, data, valor, categoria FROM Despesas WHERE id = ?";

        Despesa despesa = new Despesa();

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            Integer pKey = rs.getInt("id");
            String descricao = rs.getString("descricao");
            LocalDate data = rs.getDate("data").toLocalDate();
            double valor = rs.getDouble("valor");
            Categoria categoria = Categoria.valueOf(rs.getString("categoria"));

            despesa.setId(pKey);
            despesa.setDescricao(descricao);
            despesa.setData(data);
            despesa.setValor(valor);
            despesa.setCategoria(categoria);
        }

        catch (SQLException ex) {

            throw new RuntimeException(ex);
        }

      return Optional.ofNullable(despesa);
    }

    @Override
    public List<Despesa> findByCategoria(Categoria categoria) {

        String sql = "SELECT id, descricao, data, valor, categoria FROM Despesas WHERE categoria = ? ";

        List<Despesa> despesas = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoria.toString());

            ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                Integer id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                LocalDate data = rs.getDate("data").toLocalDate();
                double valor = rs.getDouble("valor");
                Categoria cat = Categoria.valueOf(rs.getString("categoria"));

                Despesa despesa = new Despesa();

                    despesa.setId(id);
                    despesa.setDescricao(descricao);
                    despesa.setData(data);
                    despesa.setValor(valor);
                    despesa.setCategoria(categoria);

                despesas.add(despesa);

            }
        }

        catch (SQLException ex) {

            throw new RuntimeException(ex);
        }

        return despesas;
    }

}