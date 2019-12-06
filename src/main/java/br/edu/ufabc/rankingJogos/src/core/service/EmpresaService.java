
package br.edu.ufabc.rankingJogos.src.core.service;

import br.edu.ufabc.rankingJogos.src.core.model.Empresa;
import br.edu.ufabc.rankingJogos.src.core.port.repository.EmpresaRepositoryPort;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    
    @Autowired
	EmpresaRepositoryPort empresaRepository;

    public int create(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> readAll() {
        return empresaRepository.findAll();
    }

    public List<Empresa> readByNome(String nome) {
        return empresaRepository.findByNome(nome);
    }

    public Empresa readById(int id) {
        return empresaRepository.findById(id);
    }

    public int update(Empresa empresa) {
        return empresaRepository.update(empresa);
    }

    public int delete(int id) {
        return empresaRepository.deleteById(id);
    }
    
}
