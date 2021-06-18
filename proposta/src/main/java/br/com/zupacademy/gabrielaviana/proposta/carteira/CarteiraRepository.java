package br.com.zupacademy.gabrielaviana.proposta.carteira;

import br.com.zupacademy.gabrielaviana.proposta.cartoes.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, String> {

    boolean existsByCartaoAndCarteira(Cartao cartao, CarteiraTipo carteira);

}
