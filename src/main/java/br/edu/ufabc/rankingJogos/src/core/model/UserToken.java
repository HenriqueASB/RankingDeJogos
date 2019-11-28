package br.edu.ufabc.rankingJogos.src.core.model;

public class UserToken {
	
	private String token;
	private String refreshToken;
	private int validTime;
	
	public UserToken() {
		super();
	}
	public UserToken(String token, String refreshToken, int validTime) {
		super();
		this.token = token;
		this.refreshToken = refreshToken;
		this.validTime = validTime;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public int getValidTime() {
		return validTime;
	}
	public void setValidTime(int validTime) {
		this.validTime = validTime;
	}
	

}
