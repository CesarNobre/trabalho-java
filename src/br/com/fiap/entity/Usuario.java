package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.fiap.to.Genero;

@Entity
@Table(name="T_USUARIO")
@SequenceGenerator(name="seqUsuario", sequenceName="SEQ_T_USUARIO", allocationSize=1)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqUsuario")
	@Column(name="CD_USUARIO")
	private int codigo;
	
	@Column(name="NM_USUARIO", nullable=true)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASCIMENTO", nullable=true)
	private Calendar dataNascimento;
	
	@Column(name="CD_CPF", nullable=true)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DS_GENERO", nullable=true)
	private Genero genero;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
