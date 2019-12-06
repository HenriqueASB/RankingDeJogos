
package br.edu.ufabc.rankingJogos.src.core.port.repository;

import br.edu.ufabc.rankingJogos.src.core.model.Empresa;

import java.util.List;


public interface EmpresaRepositoryPort {
    int count();

    int save(Empresa empresa);

    int update(Empresa empresa);

    int deleteById(Long id);

    List<Empresa> findAll();

    Empresa findById(Long id);
    
    List<Empresa> findByEmpresa(String empresa);
}
