package br.com.hellobank.controller;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.hellobank.model.Cliente;
import br.com.hellobank.repository.ClienteRepository;
import br.com.hellobank.service.IClienteService;


@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ClienteRepository clienteRepository;

	@MockBean
	IClienteService clienteService;

	@Test
	public void deveriaVerificarSeListaClientes() throws Exception {

		Cliente clienteA = new Cliente();
		clienteA.setNome("Spring");
		clienteA.setCpf("059.797.120-03");
		clienteA.setEndereco("rua 20 casa 99 esquina do vento que corta");
		clienteA.setCidade("catalao");
		clienteA.setEstado("GO");
		clienteA.setEmail("spring@tudodebom.com");
		clienteA.setTelefone("+55(00)11111-1111");

		Cliente clienteB = new Cliente();
		clienteB.setNome("Spring Doidao");
		clienteB.setCpf("431.155.630-60");
		clienteB.setEndereco("rua 20 casa 50 lote 10");
		clienteB.setCidade("Salvador");
		clienteB.setEstado("BA");
		clienteB.setEmail("springDoidao@tudodebom.com");
		clienteB.setTelefone("+55(00)12222-2222");

		Cliente clienteC = new Cliente();
		clienteC.setNome("Alguem muito bom");
		clienteC.setCpf("985.744.030-40");
		clienteC.setEndereco("rua 20 casa 50 lote 100");
		clienteC.setCidade("Belo Horizonte");
		clienteC.setEstado("MG");
		clienteC.setEmail("alguem@tudodebom.com");
		clienteC.setTelefone("+55(00)13333-3333");


		// dado
		List<Cliente> testantoListaCliente = new ArrayList<>(Arrays.asList(clienteA, clienteB, clienteC));

		// quando
		Mockito.when(clienteService.listarTodos()).thenReturn(testantoListaCliente);
		
		// entao
		mockMvc.perform(MockMvcRequestBuilders.get("/cliente")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[1].nome", is("Spring Doidao")))
				.andExpect(jsonPath("$[1].cpf", is("431.155.630-60")))
				.andExpect(jsonPath("$[1].email", is("springDoidao@tudodebom.com")));
	}

	@Test
	public void deveriaVerificarSeListaClientesVazia() throws Exception {

		// dado
		List<Cliente> testantoListaCliente = new ArrayList<>(Arrays.asList());

		// quando
		Mockito.when(clienteService.listarTodos()).thenReturn(testantoListaCliente);
		
		// entao
		mockMvc.perform(MockMvcRequestBuilders.get("/cliente")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(0)));
	}

	@Test
	public void deveriaVerificarSeListaClientePorId() throws Exception {
		
		// dado
		Cliente clienteC = new Cliente();
		clienteC.setId(3L);
		clienteC.setNome("Alguem muito bom");
		clienteC.setCpf("985.744.030-40");
		clienteC.setEndereco("rua 20 casa 50 lote 100");
		clienteC.setCidade("Belo Horizonte");
		clienteC.setEstado("MG");
		clienteC.setEmail("alguem@tudodebom.com");
		clienteC.setTelefone("+55(00)13333-3333");

		// quando
		Mockito.when(clienteService.existeId(clienteC.getId())).thenReturn(true);
		Mockito.when(clienteService.buscarPorId(clienteC.getId())).thenReturn(clienteC);
		
		// entao
		mockMvc.perform(MockMvcRequestBuilders.get("/cliente/{id}", clienteC.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nome", is("Alguem muito bom")))
				.andExpect(jsonPath("$.cpf", is("985.744.030-40")))
				.andExpect(jsonPath("$.email", is("alguem@tudodebom.com")));
	}

	@Test
	public void deveriaVerificarSeNaoListaClientePorId() throws Exception {
		
		// dado
		Cliente clienteC = new Cliente();
		clienteC.setId(3L);
		clienteC.setNome("Alguem muito bom");
		clienteC.setCpf("985.744.030-40");
		clienteC.setEndereco("rua 20 casa 50 lote 100");
		clienteC.setCidade("Belo Horizonte");
		clienteC.setEstado("MG");
		clienteC.setEmail("alguem@tudodebom.com");
		clienteC.setTelefone("+55(00)13333-3333");

		// quando
		Mockito.when(clienteService.existeId(clienteC.getId())).thenReturn(false);
		
		// entao
		mockMvc.perform(MockMvcRequestBuilders.get("/cliente/{id}", clienteC.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	

}
