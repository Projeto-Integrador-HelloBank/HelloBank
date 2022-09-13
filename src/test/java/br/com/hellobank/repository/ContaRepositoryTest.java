package br.com.hellobank.repository;

// import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.hellobank.model.Conta;

@DataJpaTest
class ContaRepositoryTest {

	@Autowired
    private ContaRepository sobreTeste;

    @Test
    void deveriaVerificarSeContaExitePeloNumeroConta() {
        
        // dado
        String numeroConta = "123456789";
        Conta conta = new Conta();

        conta.setTipoConta("Poupança");
        conta.setNumeroConta(numeroConta);
        conta.setAgencia("4567");
        conta.setSaldo(new BigDecimal(1500.00));

        sobreTeste.save(conta);

        // quando
        Conta esperado = sobreTeste.findByNumeroConta(numeroConta);

        // entao
        assertThat(esperado).isEqualTo(conta);
    }

    @Test
    void deveriaVerificarSeContaNaoExitePeloNumeroConta() {
        
        // dado
        String numeroConta = "123456789";

        // quando
        Conta esperado = sobreTeste.findByNumeroConta(numeroConta);

        // entao
        assertThat(esperado).isNull();
    }
	
}
