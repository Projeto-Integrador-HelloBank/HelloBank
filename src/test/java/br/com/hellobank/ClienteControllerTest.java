package br.com.hellobank;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.hellobank.controller.ClienteController;
import br.com.hellobank.model.Cliente;
import br.com.hellobank.repository.ClienteRepository;
import br.com.hellobank.service.ClienteServiceImpl;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ClienteRepository clienteRepository;
	@MockBean
	ClienteServiceImpl clienteService;

	// Cliente clienteA = new Cliente("spring@tudodebom.com", "+55(00)11111-1111");

	// Cliente b = new Cliente("Spring Doidao", "098.765.432-00",
	// "springDoidao@tudodebom.com", "+55(00)12222-2222");
	// Cliente c = new Cliente("Alexandre", "123.456.789-00",
	// "alexandre@tudodebom.com", "+55(00)13333-3333");

	@Test
	public void testGetClientes() throws Exception {

		Cliente clienteA = new Cliente();
		clienteA.setNome("Spring");
		clienteA.setCpf("123.456.789-00");
		clienteA.setEndereco("rua 20");
		clienteA.setCidade("catalao");
		clienteA.setEstado("GO");
		clienteA.setEmail("spring@tudodebom.com");
		clienteA.setTelefone("+55(00)11111-1111");
		// dado
		List<Cliente> testantoListaCliente = new ArrayList<>(Arrays.asList(clienteA));

		Mockito.when(clienteService.listarTodos()).thenReturn(testantoListaCliente);
		// quando

		mockMvc.perform(MockMvcRequestBuilders.get("/cliente").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].nome", is("Spring"))).andExpect(jsonPath("$[0].cpf", is("123.456.789-00")));
	}

}
