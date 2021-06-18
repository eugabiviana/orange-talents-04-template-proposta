package br.com.zupacademy.gabrielaviana.proposta.carteira;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarteiraRequest {
    @NotBlank
    private String email;
    @NotNull
    private CarteiraTipo carteira;

    public CarteiraRequest(@NotBlank String email, @NotNull CarteiraTipo carteira) {

        this.email = email;
        this.carteira = carteira;
    }

    public String getEmail() {
        return email;
    }

    public CarteiraTipo getCarteira() {
        return carteira;
    }


}
