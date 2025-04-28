package com.mycompany.cadastrodois.dao;

import com.mycompany.cadastrodois.conexao.ConexaoMySQL;
import com.mycompany.cadastrodois.modelo.Pessoa;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PessoaDao {

    public void inserir(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, idade) VALUES (?, ?)";
        
        try {Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareCall(sql);
             stmt.setString(1, pessoa.getNome());
             stmt.setInt(2, pessoa.getIdade());
             stmt.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    public ArrayList<Pessoa> listar(){
        ArrayList<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        
        try {Connection conn = ConexaoMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             
             while (rs.next()) {
                Pessoa p = new Pessoa(
                        
                        rs.getString("nome"),
                        rs.getInt("id"),
                        rs.getInt("idade")
                );
                lista.add(p);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return lista;
        
    }
    
    public ArrayList<Pessoa> buscarPorNome(String nome){
        ArrayList<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
        
        try {Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pessoa p = new Pessoa(
                    rs.getString("nome"),
                    rs.getInt("id"),
                    rs.getInt("idade")
                
                );
                lista.add(p);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
        
    }
    
    public void atualizar(Pessoa pessoa){
        String sql = "UPDATE pessoas SET nome = ?, idade = ? WHERE id = ?";
        try {Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setInt(3, pessoa.getId());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        
    }
    
    public void remover(int id){
        String sql = "DELETE FROM pessoa WHERE id = ?";
        
        try {Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    
    }

    public ArrayList<Pessoa> buscarPorNome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    System;
    
    
}
