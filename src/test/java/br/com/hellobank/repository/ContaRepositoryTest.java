package br.com.hellobank.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hellobank.model.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest

class ContaRepositoryTest {

	
		@Autowired
		private ContaRepository repository;
		@Test
	 	public void clienteCPF() {
	 		String clienteCPF = "23.456.789-00";
	 		Cliente cliente = repository.findByCpf(clienteCPF);
	 		Assert.assertNotNull(cliente);
	 		Assert.assertEquals (clienteCPF, cliente.getCpf());
	 	}
}
