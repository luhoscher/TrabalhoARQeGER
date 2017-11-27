/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.util;

import java.sql.*;

public class SQLite {

    private static Connection c;

    public static Connection iniciarConexao() {
        try {
            Class.forName("org.sqlite.JDBC");
            if (c == null) {
                c = DriverManager.getConnection("jdbc:sqlite:rssfeed.db");
                System.out.println("Banco de dados iniciado com sucesso");
                criar();
            }
            return c;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    public static void criar() {
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = ""
                    + "CREATE TABLE IF NOT EXISTS noticias ( \n"
                    + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + "	url varchar(50),\n"
                    + "	title varchar(50),\n"
                    + "	data text\n"
                    + ");\n"
                    + "CREATE TABLE IF NOT EXISTS horario ( \n"
                    + "	id integer PRIMARY KEY AUTOINCREMENT\n"
                    + "	data text,\n"
                    + ");\n"
                    + "CREATE TABLE IF NOT EXISTS termo ( \n"
                    + "	termo varchar(50),\n"
                    + "	id integer PRIMARY KEY AUTOINCREMENT\n"
                    + ");\n";
            stmt.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        ;
    }

}
