package br.edu.ufabc.rankingJogos.src.core.port.repository;

import java.util.List;

import br.edu.ufabc.rankingJogos.src.core.model.Usuario;

public interface UsuarioRepositoryPort {
	int count();

    int save(Usuario usuario);

    int update(Usuario usuario);

    int deleteById(Long id);

    List<Usuario> findAll();

    Usuario findById(Long id);
    
    List<Usuario> findByEmail(String email);
}
