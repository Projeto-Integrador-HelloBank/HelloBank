package br.com.hellobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.hellobank.model.Cliente;

@SpringBootApplication
public class HelloBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloBankApplication.class, args);
		
		
	}

	public void run (String[] args) {
		
		Cliente clienteA = new Cliente();
		clienteA.setNome("Spring");
		clienteA.setCpf("123.456.789-00");
		clienteA.setEndereco("rua 20");
		clienteA.setCidade("catalao");
		clienteA.setEstado("GO");
		clienteA.setEmail("spring@tudodebom.com");
		clienteA.setTelefone("+55(00)11111-1111");
	
	}
}
