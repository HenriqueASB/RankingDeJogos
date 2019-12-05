package br.edu.ufabc.rankingJogos.src.core.model;

public class Game {
	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Game(int id, String titulo, int empresa_id, int genero_id, String sinopse, String urlFoto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.empresa_id = empresa_id;
		this.genero_id = genero_id;
		this.sinopse = sinopse;
		this.urlFoto = urlFoto;
	}
	private int id;
	private String titulo;
	private int empresa_id;
	private int genero_id ;
	private String sinopse;
	private String urlFoto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getEmpresa_id() {
		return empresa_id;
	}
	public void setEmpresa_id(int empresa_id) {
		this.empresa_id = empresa_id;
	}
	public int getGenero_id() {
		return genero_id;
	}
	public void setGenero_id(int genero_id) {
		this.genero_id = genero_id;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	

}
