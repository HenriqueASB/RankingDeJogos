package br.edu.ufabc.rankingJogos.src.core.model;

import java.util.Arrays;
import java.util.Objects;

public class Game {

	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Game(int id, String titulo, Empresa empresa,Genero[] genero,Console[] console, String sinopse, String urlFoto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.empresa = empresa;
		this.genero = Arrays.stream(genero).filter(Objects::nonNull).toArray(Genero[]::new);
		this.console =Arrays.stream(console).filter(Objects::nonNull).toArray(Console[]::new);
		this.sinopse = sinopse;
		this.urlFoto = urlFoto;
	}
	private int id;
	private String titulo;
	private Empresa empresa;
	private Genero genero[];
    private Console console[];
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Genero[] getGenero() {
		return genero;
	}
	public void setGenero(Genero genero[]) {
		this.genero = genero;
	}
    public Console[] getConsole() {
		return console;
	}
	public void setConsole_id(Console console[]) {
		this.console = console;
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
