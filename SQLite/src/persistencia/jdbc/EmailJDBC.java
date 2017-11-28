package persistencia.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.modelo.Email;
import persistencia.modelo.Horario;
import persistencia.util.SQLite;

public class EmailJDBC {
    
    public void inserir(Email email) {
        Connection c = null;
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            String sql = "INSERT INTO Email (email) "
                    + "VALUES ('" + email.getEmail() + "');";
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
     
    public Horario encontrar(int id) {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT * FROM email WHERE id = " + id + ";");
            Horario s = null;
            while (rs.next()) {
                int i = rs.getInt("id");
                String email = rs.getString("email");
                Email e = new Email();
                e.setId(id);
                e.setEmail(email);
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
                Email e = new Email();
                e.setId(id);
                e.setEmail(email);
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
                    + "data = '" + email.getEmail() + "'"
                    + "WHERE id = " + email.getId() + ";";
            return declaracao.executeUpdate(sql) > 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
}
