package br.com.zupacademy.gabrielaviana.proposta.bloqueio;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueioRepository extends JpaRepository<Cartao, Long> {

}
