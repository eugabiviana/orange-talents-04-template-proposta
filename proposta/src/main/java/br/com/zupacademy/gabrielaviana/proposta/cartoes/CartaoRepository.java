package br.com.zupacademy.gabrielaviana.proposta.cartoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {


    Optional<Cartao> findById(String id);
}
