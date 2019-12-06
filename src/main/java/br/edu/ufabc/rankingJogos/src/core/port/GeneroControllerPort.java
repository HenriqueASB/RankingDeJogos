
package br.edu.ufabc.rankingJogos.src.core.port;


import br.edu.ufabc.rankingJogos.src.core.model.Genero;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface GeneroControllerPort {
    public void create(@RequestBody Genero genero);
		
    public List<Genero> readAll();

    public List<Genero> readByGenero(@RequestParam String genero);

    public Genero readById(@PathVariable int id);

    public int update(@RequestBody Genero genero);

    public int delete(@PathVariable int id);
}
