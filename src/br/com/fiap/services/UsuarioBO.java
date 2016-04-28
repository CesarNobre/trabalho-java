package br.com.fiap.services;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.UsuarioDAOImpl;
import br.com.fiap.entity.Usuario;
import br.com.fiap.singleton.EMSingleton;
import br.com.fiap.to.UsuarioTO;

public class UsuarioBO {
	
	private UsuarioDAOImpl usuarioDao;
	
	public UsuarioBO(){
		
	}
	
	public UsuarioTO buscarUsuario(int codigo){
		EntityManager em = EMSingleton.getInstance().createEntityManager();
		this.usuarioDao = new UsuarioDAOImpl(em);
		
		UsuarioTO usuarioTO = new UsuarioTO();
		Usuario usuario = this.usuarioDao.buscarUsuario(codigo);
		
		usuarioTO.setCodigo(usuario.getCodigo());
		usuarioTO.setCpf(usuario.getCpf());
		usuarioTO.setDataNascimento(usuario.getDataNascimento());
		usuarioTO.setGenero(usuario.getGenero());
		usuarioTO.setNome(usuario.getNome());
		
		return usuarioTO;
	}
	
	public int inserirUsuario(UsuarioTO usuarioTO){
		EntityManager em = EMSingleton.getInstance().createEntityManager();
		this.usuarioDao = new UsuarioDAOImpl(em);
		
		Usuario usuario = new Usuario();
		
		usuario.setCodigo(usuarioTO.getCodigo());
		usuario.setCpf(usuarioTO.getCpf());
		usuario.setDataNascimento(usuarioTO.getDataNascimento());
		usuario.setGenero(usuarioTO.getGenero());
		usuario.setNome(usuarioTO.getNome());
		
		
		this.usuarioDao.inserir(usuario);
		
		return 200;
	}
	
}
