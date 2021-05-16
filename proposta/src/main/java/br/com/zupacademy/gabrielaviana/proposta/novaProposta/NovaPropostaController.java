package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/propostas")
public class NovaPropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private AnaliseSolicitacaoClient analiseClient;


    @PostMapping
    public ResponseEntity<NovaPropostaDto> cadastrar(@RequestBody @Valid NovaPropostaForm form,
                                                     UriComponentsBuilder uriComponentsBuilder){

        //usar o exist, retorna apenas o id do objeto enquanto o findBy retorna o objeto completo
        //método para não criar duas propostas com documentos iguais
        if(propostaRepository.existsByDocumento(form.getDocumento())){
            return ResponseEntity.unprocessableEntity().build();
        }
        Proposta novaProposta = form.paraProposta();

        //salvar a proposta mostrando o endereço de onde os dados foram salvos
        propostaRepository.save(novaProposta);

        //consultar dados da proposta

        try{
            AnaliseDePropostaRequest analiseRequest = new AnaliseDePropostaRequest(novaProposta.getDocumento(),
                                                                                    novaProposta.getNome(),
                                                                                    novaProposta.getId());
            AnaliseDePropostaResponse resultadoDaConsulta = analiseClient.consulta(analiseRequest);
            Status status = resultadoDaConsulta.status();

            novaProposta.setStatus(status);
        } catch (FeignException.FeignClientException.UnprocessableEntity unprocessableEntity){
            
            novaProposta.setStatus(Status.NAO_ELEGIVEL);
        }

        propostaRepository.save(novaProposta);
        URI location = uriComponentsBuilder.path("/propostas/{id}")
                                           .buildAndExpand(novaProposta.getId())
                                           .toUri();
        return ResponseEntity.created(location).build();
    }
}
