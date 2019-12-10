
package br.edu.ufabc.rankingJogos.src.core.port;

import br.edu.ufabc.rankingJogos.src.core.model.Avaliacao;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface AvaliacaoControllerPort {
    public void create(@RequestBody Avaliacao avaliacao);
		
    public List<Avaliacao> readAll();

    public List<Avaliacao> readByUser_Id(@PathVariable int user_id);

    public List<Avaliacao> readByJogo_Id(@PathVariable int jogo_id);

    public int update(@RequestBody Avaliacao avaliacao);

    public int delete(@PathVariable int id);
    
    public Double calculaNota(@PathVariable int jogo_id);
}
