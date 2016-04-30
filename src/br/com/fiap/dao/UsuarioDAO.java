package br.com.fiap.dao;

import br.com.fiap.entity.Usuario;

public interface UsuarioDAO extends DAO<Usuario,Integer>{
	
	public void inserir(Usuario usuario);
	
	public Usuario buscarUsuario(String nome);
}
