package com.generation.blogpessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.repository.Temporal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//transforma objetos em uma tabela no mySQL banco de dados

@Table(name="tb_postagem")
// da nome a tabela pra o banco de dados


public class Postagem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	@NotNull
	@Size(min=5,max=100, message="o campo deve ter no minimo 5 caracteres, e no maximo 100 caracteres")
	public String titulo;
	@NotNull
	public String texto;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
		}
	
	public Tema getTema() {
		return tema;
	}
	
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
