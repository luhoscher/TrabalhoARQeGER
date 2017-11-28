package br.udesc.sqlite.modelo;

public class Termo {

    private int id;
    private String termo;

    public Termo() {
    }

    public Termo(int id, String termo) {
        this.id = id;
        this.termo = termo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }
    
    

}
