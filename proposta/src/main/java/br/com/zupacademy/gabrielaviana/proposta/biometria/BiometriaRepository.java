package br.com.zupacademy.gabrielaviana.proposta.biometria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiometriaRepository extends JpaRepository<BiometriaModel,Long> {
}
