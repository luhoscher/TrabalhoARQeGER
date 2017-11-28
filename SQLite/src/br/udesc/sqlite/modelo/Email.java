package br.udesc.sqlite.modelo;

public class Email {

    private int id;
    private String email;
    private String senha;

    public Email() {
    }

    public Email(int id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
