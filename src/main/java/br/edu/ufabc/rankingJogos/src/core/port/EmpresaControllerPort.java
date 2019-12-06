
package br.edu.ufabc.rankingJogos.src.core.port;

import br.edu.ufabc.rankingJogos.src.core.model.Empresa;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface EmpresaControllerPort {
    
    public void create(@RequestBody Empresa empresa);
		
    public List<Empresa> readAll();

    public List<Empresa> readByNome(@RequestParam String nome);

    public Empresa readById(@PathVariable int id);

    public int update(@RequestBody Empresa empresa);

    public int delete(@PathVariable int id);
}
