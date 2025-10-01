package com.ifsp.projeto3bim.model;

public class Tarefa {
    private String nome;
    private String data;
    private String status;
    private String grupo;


    public Tarefa(String nome, String data, String status) {
        this(nome, data, status, "");
    }

    public Tarefa(String nome, String data, String status, String grupo) {
        this.nome = nome;
        this.data = data;
        this.status = status;
        this.grupo = grupo;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }

    public void toggleStatus() {
        if ("Completed".equalsIgnoreCase(this.status)) {
            this.status = "Pending";
        } else {
            this.status = "Completed";
        }
    }
}
