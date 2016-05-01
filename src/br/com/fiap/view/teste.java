package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.services.UsuarioBO;
import br.com.fiap.to.UsuarioTO;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioBO usuarioBO = new UsuarioBO();
		
		UsuarioTO usuarioTO = new UsuarioTO();
		
		usuarioTO.setCpf("123");
		//usuarioTO.setGenero('M');
		//usuarioTO.setDataNascimento(new GregorianCalendar(1,1,89));
		usuarioTO.setNome("Cesar2");
		
		UsuarioTO cesar = new UsuarioTO();
		cesar = usuarioBO.buscarUsuario("Cesar");
		System.out.println(cesar.getNome());
	}

}
