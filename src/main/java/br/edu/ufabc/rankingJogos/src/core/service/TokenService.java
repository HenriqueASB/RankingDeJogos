package br.edu.ufabc.rankingJogos.src.core.service;

import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.edu.ufabc.rankingJogos.src.core.model.UserToken;
import br.edu.ufabc.rankingJogos.src.core.model.Usuario;

@Service
public class TokenService {
	
	public UserToken geraToken(Usuario usuario) {
		Date now = new Date();
		String info = usuario.getNome()+"|"+now.getTime()+"|"+usuario.getSenha();
		byte[] encode = Base64.getEncoder().encode(info.getBytes());
		String token = new String(encode);
		String refreshInfo = usuario.getNome()+"|refresh|"+usuario.getSenha();
		byte[] refreshEncode = Base64.getEncoder().encode(refreshInfo.getBytes());
		String refreshToken = new String(refreshEncode);
		UserToken t = new UserToken(token,refreshToken,1000);
		return t;
		
	}
	
	

}
