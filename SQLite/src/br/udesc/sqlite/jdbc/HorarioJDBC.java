package br.udesc.sqlite.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.udesc.sqlite.modelo.Horario;
import br.udesc.sqlite.util.SQLite;

public class HorarioJDBC {

    public void inserir(Horario hora) {
        Connection c = null;
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String sql = "INSERT INTO horario (data) "
                    + "VALUES ('" + sdf.format(hora.getData()) + "');";
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
            return declaracao.executeUpdate("DELETE FROM horario WHERE id = " + id + ";") > 0;
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
            ResultSet rs = declaracao.executeQuery("SELECT * FROM horario WHERE id = " + id + ";");
            Horario s = null;
            while (rs.next()) {
                int i = rs.getInt("id");
                s = new Horario();
                DateFormat df = new SimpleDateFormat("HH:mm");
                Date data = df.parse(rs.getString("data"));
                s.setId(i);
                s.setData(data);
            }
            rs.close();
            declaracao.close();
            return s;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

     
    public List<Horario> listar() {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT * FROM horario;");
            List<Horario> horarios = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                DateFormat df = new SimpleDateFormat("HH:mm");
                Date data = df.parse(rs.getString("data"));
                Horario s = new Horario();
                s.setId(id);
                s.setData(data);
                horarios.add(s);
            }
            rs.close();
            declaracao.close();
            return horarios;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
    
    public boolean atualizar(Horario hora) {
        Connection c = null;
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String sql = "UPDATE SCHEDULE SET "
                    + "data = '" + sdf.format(hora.getData()) + "'"
                    + "WHERE id = " + hora.getId() + ";";
            return declaracao.executeUpdate(sql) > 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
}
