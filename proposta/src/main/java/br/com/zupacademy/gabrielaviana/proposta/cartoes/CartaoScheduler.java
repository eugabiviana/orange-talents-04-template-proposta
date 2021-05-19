package br.com.zupacademy.gabrielaviana.proposta.cartoes;

import br.com.zupacademy.gabrielaviana.proposta.novaProposta.Proposta;
import br.com.zupacademy.gabrielaviana.proposta.novaProposta.PropostaRepository;
import br.com.zupacademy.gabrielaviana.proposta.novaProposta.Status;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class CartaoScheduler {

    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private PropostaRepository propostaRepository;
    @Autowired
    private CartaoClientFeign cartaoClientFeign;

    @Scheduled(fixedDelay = 60 * 1000)
    public void associaCartaoAProposta(){

        //buscar todas as propostas sem cartao
        Set<Proposta> propostas = propostaRepository.findByStatusWhereCartaoIsNull(Status.ELEGIVEL);

        for (Proposta proposta : propostas) {
            //faça alguma coisa
            try{
                CartaoResponse cartaoResponse = cartaoClientFeign.cadastroCartao(proposta.getId());

                Cartao cartao = cartaoResponse.paraCartao(propostaRepository);
                cartaoRepository.save(cartao);
                proposta.setCartao(cartao);
                propostaRepository.save(proposta);
            } catch (FeignException e) {
                e.printStackTrace(); // se ocorrer a exceção, mostra o que e onde está acontecendo
            }
        }
    }

}
