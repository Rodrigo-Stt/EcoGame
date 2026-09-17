package com.ecogame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RankingDAO {

    public void salvarPontuacao(String jogador, int pontos) {
        String sql = "INSERT INTO ranking (jogador, pontos) VALUES (?, ?)";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, jogador);
            stmt.setInt(2, pontos);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar pontuacao: " + e.getMessage());
        }
    }

    public List<String> buscarMelhoresPontuacoes(int limite) {
        List<String> resultado = new ArrayList<>();
        String sql = "SELECT jogador, pontos FROM ranking ORDER BY pontos DESC LIMIT ?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, limite);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    resultado.add(rs.getString("jogador") + " - " + rs.getInt("pontos") + " pts");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar ranking: " + e.getMessage());
        }
        return resultado;
    }
}