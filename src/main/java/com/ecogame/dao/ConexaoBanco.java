package com.ecogame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {

    private static final String URL_BANCO = "jdbc:sqlite:ranking.db";

    public static Connection obterConexao() throws SQLException {
        Connection conexao = DriverManager.getConnection(URL_BANCO);
        criarTabelaSeNaoExistir(conexao);
        return conexao;
    }

    private static void criarTabelaSeNaoExistir(Connection conexao) throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS ranking (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                jogador TEXT NOT NULL,
                pontos INTEGER NOT NULL,
                data_hora TEXT DEFAULT CURRENT_TIMESTAMP
            )
        """;
        try (Statement stmt = conexao.createStatement()) {
            stmt.execute(sql);
        }
    }
}