package br.com.zupacademy.gabrielaviana.proposta.novaProposta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    boolean existsByDocumento(String documento);

    @Query ("select p from Proposta p where p.status = :status and p.cartao is null")
    Set<Proposta> findByStatusWhereCartaoIsNull(Status status);
}
