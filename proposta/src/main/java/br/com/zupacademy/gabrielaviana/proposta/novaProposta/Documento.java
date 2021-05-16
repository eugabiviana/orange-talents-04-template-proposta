package br.com.zupacademy.gabrielaviana.proposta.novaProposta;


import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

@CPF //verifica se é um CPF válido
@ConstraintComposition(CompositionType.OR) //faz a verificação se é um CPF ou um CNPJ
@CNPJ //verifica se é um CNPJ válido
@ReportAsSingleViolation //ignora a msg de erro de cada anotação. Levará em consideração apenas a que setamos
@Constraint(validatedBy = {}) //é uma restrição para a bean validation e não precisa de validation
@Documented //documentação da classe
@Target({ElementType.FIELD}) //funciona nos atributos da classe
@Retention(RetentionPolicy.RUNTIME) //funciona em tempo de execução
public @interface Documento {

    String message() default "Documento inválido";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
