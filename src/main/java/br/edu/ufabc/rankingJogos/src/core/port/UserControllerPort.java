package br.edu.ufabc.rankingJogos.src.core.port;

import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ufabc.rankingJogos.src.core.model.UserToken;
import br.edu.ufabc.rankingJogos.src.core.model.Usuario;
import java.util.List;

public interface UserControllerPort {
	
	public Usuario create(@RequestBody Usuario request);
	
	public UserToken login(@RequestBody Usuario request);
        
        public int update(@RequestBody Usuario usuario);
        
        public int delete(Long id);
        
        public List<Usuario> readAll();
                
        public Usuario readById(Long id);
        
        public List<Usuario> readByEmail(String email);
}
