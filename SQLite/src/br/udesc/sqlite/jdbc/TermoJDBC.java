package br.udesc.sqlite.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.udesc.sqlite.modelo.Termo;
import br.udesc.sqlite.util.SQLite;

public class TermoJDBC {

    public void inserir(Termo ter) {
        Connection c = null;
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            String sql = "INSERT INTO SUBJECT (termo) "
                    + "VALUES ('" + ter.getTermo() + "');";
            declaracao.executeUpdate(sql);
            declaracao.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Criado com sucesso");
    }

    public boolean deletar(int id) {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            return declaracao.executeUpdate("DELETE FROM termo WHERE id = " + id + ";") > 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    public Termo encontrar(int id) {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT * FROM termo WHERE id = " + id + ";");
            Termo s = null;
            while (rs.next()) {
                int i = rs.getInt("id");
                String termo = rs.getString("termo");
                s = new Termo();
                s.setId(i);
                s.setTermo(termo);
            }
            rs.close();
            declaracao.close();
            return s;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    public List<Termo> listar() {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT * FROM termo;");
            List<Termo> termos = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String termo = rs.getString("termo");
                Termo s = new Termo();
                s.setId(id);
                s.setTermo(termo);
                termos.add(s);
            }
            rs.close();
            declaracao.close();
            return termos;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
    
    public boolean atualizar(Termo ter) {
        Connection c = null;
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            String sql = "UPDATE SUBJECT SET "
                    + "termo = '" + ter.getTermo() + "'"
                    + "WHERE id = " + ter.getId() + ";";
            return declaracao.executeUpdate(sql) > 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
}
