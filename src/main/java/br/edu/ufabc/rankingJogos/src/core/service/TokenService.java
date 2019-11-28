package br.edu.ufabc.rankingJogos.src.core.service;

import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.edu.ufabc.rankingJogos.src.core.model.Usuario;

@Service
public class TokenService {
	
	public String geraToken(Usuario usuario) {
		Date now = new Date();
		String info = usuario.getNome()+"|"+now.getTime()+"|"+usuario.getSenha();
		byte[] encode = Base64.getEncoder().encode(info.getBytes());
		String token = new String(encode);
		byte[] decode = Base64.getDecoder().decode(token.getBytes());
		String teste = new String(decode);
		System.out.println("info   "+info);
		System.out.println("toke   "+token);
		System.out.println("teste   "+teste);
		
		return token;
		
	}

}
