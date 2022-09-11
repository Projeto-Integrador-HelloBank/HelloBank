package br.com.hellobank;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.hellobank.controller.ClienteController;
import br.com.hellobank.model.Cliente;
import br.com.hellobank.repository.ClienteRepository;
import br.com.hellobank.service.ClienteServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

	
	
	@Autowired
	private ClienteRepository repository;
	@Test
 	public void clienteCPF() {
 		String clienteCPF = "23.456.789-00";
 		Cliente cliente = repository.findByCpf(clienteCPF);
 		Assert.assertNotNull(cliente);
 		Assert.assertEquals (clienteCPF, cliente.getCpf());
 	}

}
