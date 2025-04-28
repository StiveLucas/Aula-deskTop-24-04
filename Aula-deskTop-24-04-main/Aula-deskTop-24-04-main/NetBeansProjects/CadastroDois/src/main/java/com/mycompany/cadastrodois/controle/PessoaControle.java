package com.mycompany.cadastrodois.controle;

import com.mycompany.cadastrodois.dao.PessoaDao;
import com.mycompany.cadastrodois.modelo.Pessoa;
import java.util.ArrayList;

public class PessoaControle {
    private PessoaDao dao = new  PessoaDao();
    
    public void cadastrar(String nome, int idade){
        Pessoa p = new Pessoa(nome, idade, idade);
        dao.inserir(p);
    }
    
    public ArrayList<Pessoa> listar(){
        return dao.listar();
    }
    
    public void atualizar(int id, String nome, int idade){
        Pessoa p = new Pessoa(nome, id, idade);
        dao.atualizar(p);
        
    }
    
    public void remover(int id){
        dao.remover(id);
        
    }
    
    public ArrayList<Pessoa> buscarPorNome(String nome){
        return dao.buscarPorNome();
        
    }
}
