package br.com.hellobank.repository;

import br.com.hellobank.model.Cliente;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class ClienteRepositoryTest {

  @Autowired
  private ClienteRepository sobreTeste;

  @Test
  public void clienteCPF() {
    String clienteCpf = "796.881.490-12";

    Cliente clienteA = new Cliente();
    clienteA.setNome("Spring");
    clienteA.setCpf(clienteCpf);
    clienteA.setEndereco("rua 20 oloko meu ");
    clienteA.setCidade("catalao");
    clienteA.setEstado("GO");
    clienteA.setEmail("spring@tudodebom.com");
    clienteA.setTelefone("+55(00)11111-1111");

    sobreTeste.save(clienteA);

    Cliente cliente = sobreTeste.findByCpf(clienteCpf);
    Assert.assertNotNull(cliente);
    Assert.assertEquals(clienteCpf, cliente.getCpf());
  }

  @Test
  public void clienteCPFErrado() {
    String clienteCPF = "23.555.789-00";

    Cliente cliente = sobreTeste.findByCpf(clienteCPF);
    Assert.assertNull(cliente);
  }
}
