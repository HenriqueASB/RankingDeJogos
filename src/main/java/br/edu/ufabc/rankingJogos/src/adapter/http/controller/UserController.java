package br.edu.ufabc.rankingJogos.src.adapter.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufabc.rankingJogos.src.core.model.UserToken;
import br.edu.ufabc.rankingJogos.src.core.model.Usuario;
import br.edu.ufabc.rankingJogos.src.core.port.UserControllerPort;
import br.edu.ufabc.rankingJogos.src.core.service.UsuarioService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerPort {
	
	@Autowired
	UsuarioService service;

	@Override
	@PostMapping("/create")
	public Usuario create(Usuario usuario) {
		service.create(usuario);
		return service.readByEmail(usuario.getEmail()).get(0); 
	}

	@Override
	@PostMapping("/login")
	public UserToken login(Usuario usuario) {
		UserToken token = service.login(usuario);
		return token;
	}
        
        @Override
        @PutMapping
        public int update(Usuario usuario) {
    	System.out.println("userController"+usuario.getNome());
            return service.update(usuario);
        }
        
        @Override
        @DeleteMapping
        public int delete(Long id) {
            return service.delete(id);
        }
        
        @Override
        @GetMapping
        public List<Usuario> readAll() {
            return service.readAll();
        }
        
        @Override
        @GetMapping("/{id}")
        public Usuario readById(Long id) {
            return service.readById(id);
        }
        
        @Override
        @GetMapping("/email")
        public List<Usuario> readByEmail(String email) {
            return service.readByEmail(email);
        }
}
