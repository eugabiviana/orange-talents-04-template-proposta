package br.com.zupacademy.gabrielaviana.proposta.compartilhado;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class ExecutorTransacao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public <T> T salvaEComita(T objeto){
        manager.persist(objeto);
        return objeto;
    }
}
