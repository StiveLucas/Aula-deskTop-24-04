package com.mycompany.cadastrodois.modelo;

public class Pessoa {
    private String nome;
    private int id;
    private int idade;

    public Pessoa() {
        
    }

    public Pessoa(String nome, int id, int idade) {
        this.nome = nome;
        this.id = id;
        this.idade = idade;
    }
    
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    
}
