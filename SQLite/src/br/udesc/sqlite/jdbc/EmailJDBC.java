package br.udesc.sqlite.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.udesc.sqlite.modelo.Email;
import br.udesc.sqlite.util.SQLite;

public class EmailJDBC {
    
    public void inserir(Email email) {
        Connection c = null;
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            String sql = "INSERT INTO Email (email) "
                    + "VALUES ('" + email.getEmail() + "', " + email.getSenha() + "');";
            System.out.println(sql);
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
            return declaracao.executeUpdate("DELETE FROM email WHERE id = " + id + ";") > 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
     
    public Email encontrar(int id) {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT * FROM email WHERE id = " + id + ";");
            Email s = null;
            while (rs.next()) {
                int i = rs.getInt("id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                s = new Email();
                s.setId(id);
                s.setEmail(email);
                s.setSenha(senha);
            }
            rs.close();
            declaracao.close();
            return s;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

     
    public List<Email> listar() {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT * FROM email;");
            List<Email> emails = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                Email e = new Email();
                e.setId(id);
                e.setEmail(email);
                e.setSenha(senha);
                emails.add(e);
            }
            rs.close();
            declaracao.close();
            return emails;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
    
    public boolean atualizar(Email email) {
        Connection c = null;
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            String sql = "UPDATE SCHEDULE SET "
                    + "email = '" + email.getEmail() + "'"
                    + "WHERE id = " + email.getId() + ";";
            return declaracao.executeUpdate(sql) > 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
}
