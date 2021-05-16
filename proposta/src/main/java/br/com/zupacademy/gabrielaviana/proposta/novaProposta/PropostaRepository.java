package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    boolean existsByDocumento(String documento);
}
