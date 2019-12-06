
package br.edu.ufabc.rankingJogos.src.core.port;

import br.edu.ufabc.rankingJogos.src.core.model.Console;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface ConsoleControllerPort {

    public void create(@RequestBody Console console);
		
    public List<Console> readAll();

    public List<Console> readByNome(@RequestParam String nome);

    public Console readById(@PathVariable int id);

    public int update(@RequestBody Console console);

    public int delete(@PathVariable int id);
}
