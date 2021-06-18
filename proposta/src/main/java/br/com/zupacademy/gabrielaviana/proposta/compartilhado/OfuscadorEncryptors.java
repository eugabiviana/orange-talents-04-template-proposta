package br.com.zupacademy.gabrielaviana.proposta.compartilhado;

import org.springframework.security.crypto.encrypt.Encryptors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OfuscadorEncryptors implements AttributeConverter<String, String>{


//@param atributo será ofuscado (banco de dados)
//@return documento criptografado (banco de dados)

    @SuppressWarnings("deprecation")
    @Override
    public String convertToDatabaseColumn(String documento) {
        try {
            return Encryptors.queryableText("${proposta.ofuscar.dados}", "senha").encrypt(documento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


// @param atributo será descompilado do banco de dados
// @return retorna ofuscado - astericos ( Exemplo nota do pix)

    @SuppressWarnings("deprecation")
    @Override
    public String convertToEntityAttribute(String documento) {
        try {
            return Encryptors.queryableText("${proposta.ofuscar.dados}", "senha").decrypt(documento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
//classe criada para que os dados dos clientes sejam parcialmente ofuscados.