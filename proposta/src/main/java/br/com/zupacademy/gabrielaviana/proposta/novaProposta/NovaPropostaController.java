package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/propostas")
public class NovaPropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @PostMapping
    public ResponseEntity<NovaPropostaDto> cadastrar(@RequestBody @Valid NovaPropostaForm form,
                                                     UriComponentsBuilder uriComponentsBuilder){
        Proposta novaProposta = form.paraProposta();

        //salvar a proposta
        propostaRepository.save(novaProposta);
        URI location = uriComponentsBuilder.path("/propostas/{id}")
                                           .buildAndExpand(novaProposta.getId())
                                           .toUri();
        return ResponseEntity.created(location).build();
    }
}
