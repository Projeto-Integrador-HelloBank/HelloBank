package br.com.hellobank.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.hellobank.model.Cliente;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository sobreTeste;

    @AfterEach
    void destruir() {
        sobreTeste.deleteAll();
    }

    @Test
    public void deveriaVerificarSeExisteClienteBuscandoPorCpf() {

        // dado
        String clienteCpf = "796.881.490-12";

        Cliente cliente = new Cliente();
        cliente.setNome("Spring");
        cliente.setCpf(clienteCpf);
        cliente.setEndereco("rua 20 oloko meu ");
        cliente.setCidade("catalao");
        cliente.setEstado("GO");
        cliente.setEmail("spring@tudodebom.com");
        cliente.setTelefone("+55(00)11111-1111");

        sobreTeste.save(cliente);

        // quando
        Cliente esperado = sobreTeste.findByCpf(clienteCpf);

        // entao
        assertThat(esperado).isEqualTo(cliente);
    }

    @Test
    public void deveriaVerificarSeNaoExisteClienteBuscandoPorCpf() {

        // dado
        String clienteCpf = "171.866.330-72";

        // quando
        Cliente esperado = sobreTeste.findByCpf(clienteCpf);

        // entao
        assertThat(esperado).isNull();;
    }

    @Test
    public void deveriaVerificarSeCpfExiste() {

        // dado
        String clienteCpf = "302.830.580-13";

        Cliente cliente = new Cliente();
        cliente.setNome("outro teste");
        cliente.setCpf(clienteCpf);
        cliente.setEndereco("rua 20 outro endereco tambem ");
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");
        cliente.setEmail("outroemail@tudodebom.com");
        cliente.setTelefone("+55(00)99999-1111");

        sobreTeste.save(cliente);

        // quando
        Boolean esperado = sobreTeste.existsByCpf(clienteCpf);

        // entao
        assertThat(esperado).isTrue();
    }

    @Test
    public void deveriaVerificarSeCpfNaoExiste() {

        // dado
        String clienteCpf = "677.609.710-01";

        // quando
        Boolean esperado = sobreTeste.existsByCpf(clienteCpf);

        // entao
        assertThat(esperado).isFalse();;
    }
}
