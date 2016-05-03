package br.com.fiap.services;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.UsuarioDAOImpl;
import br.com.fiap.entity.Usuario;
import br.com.fiap.singleton.EMSingleton;
import br.com.fiap.to.Genero;
import br.com.fiap.to.UsuarioTO;

public class UsuarioBO {
	
	private UsuarioDAOImpl usuarioDao;
	
	public UsuarioBO(){
		
	}
	
	public UsuarioTO buscarUsuario(String nome){
		EntityManager em = EMSingleton.getInstance().createEntityManager();
		this.usuarioDao = new UsuarioDAOImpl(em);
		
		UsuarioTO usuarioTO = new UsuarioTO();
		Usuario usuario = this.usuarioDao.buscarUsuario(nome);
		
		usuarioTO.setCodigo(usuario.getCodigo());
		usuarioTO.setCpf(usuario.getCpf());
		if(usuario.getGenero() == Genero.MASCULINO){
			usuarioTO.setNome("Sr. " + usuario.getNome());
			usuarioTO.setGenero("Masculino");
		}
		else{
			usuarioTO.setNome("Sra. " + usuario.getNome());
			usuarioTO.setGenero("Feminino");
		}
		
		
		return usuarioTO;
	}
	
	public int inserirUsuario(UsuarioTO usuarioTO){
		EntityManager em = EMSingleton.getInstance().createEntityManager();
		this.usuarioDao = new UsuarioDAOImpl(em);
		
		Usuario usuario = new Usuario();
		
		usuario.setCpf(usuarioTO.getCpf());
		if(usuarioTO.getGenero().equals("M")){
			usuario.setGenero(Genero.MASCULINO);
		} else{
			usuario.setGenero(Genero.FEMININO);
		}
		usuario.setNome(usuarioTO.getNome());
		
		
		this.usuarioDao.inserir(usuario);
		
		return 200;
	}
	
}
