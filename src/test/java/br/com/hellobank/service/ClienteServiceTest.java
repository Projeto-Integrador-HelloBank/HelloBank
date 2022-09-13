package br.com.hellobank.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.hellobank.model.Cliente;
import br.com.hellobank.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
    
    @Mock private ClienteRepository clienteRepository;
    private IClienteService sobreTeste;

    @BeforeEach
    void configurar() {
        clienteRepository.deleteAll();
        sobreTeste = new ClienteServiceImpl(clienteRepository);
    }

    @Test
    void podeSalvarCliente() {
        // dado
        Cliente cliente = new Cliente();
        cliente.setNome("Spring");
        cliente.setCpf("796.881.490-12");
        cliente.setEndereco("rua 20 oloko meu ");
        cliente.setCidade("catalao");
        cliente.setEstado("GO");
        cliente.setEmail("spring@tudodebom.com");
        cliente.setTelefone("+55(00)11111-1111");

        // quando
        sobreTeste.salvar(cliente);

        // entao
        ArgumentCaptor<Cliente> clienteArgumentCaptor = ArgumentCaptor.forClass(Cliente.class);

        verify(clienteRepository).save(clienteArgumentCaptor.capture());

        Cliente clienteCapturado = clienteArgumentCaptor.getValue();

        assertThat(clienteCapturado).isEqualTo(cliente);
    }

    @Test
	void podeListarTodosClientes() {
        // quando
        sobreTeste.listarTodos();

        // entao
        verify(clienteRepository).findAll();
    }

    @Test
	void podeBuscarPorIdCliente() {

        // dado
        Cliente cliente = new Cliente();
        cliente.setNome("Spring");
        cliente.setCpf("796.881.490-12");
        cliente.setEndereco("rua 20 oloko meu ");
        cliente.setCidade("catalao");
        cliente.setEstado("GO");
        cliente.setEmail("spring@tudodebom.com");
        cliente.setTelefone("+55(00)11111-1111");

        // quando
        sobreTeste.buscarPorId(cliente.getId());

        // entao
        verify(clienteRepository).findById(cliente.getId());
    }

    @Test
	void podeBuscarPorCpf() {

        String clienteCpf = "796.881.490-12";
        // dado
        Cliente cliente = new Cliente();
        cliente.setNome("Spring");
        cliente.setCpf(clienteCpf);
        cliente.setEndereco("rua 20 oloko meu ");
        cliente.setCidade("catalao");
        cliente.setEstado("GO");
        cliente.setEmail("spring@tudodebom.com");
        cliente.setTelefone("+55(00)11111-1111");

        // quando
        sobreTeste.buscarPorCpf(clienteCpf);

        // entao
        verify(clienteRepository).findByCpf(clienteCpf);

    }

    @Test
    void podeDeletar() {

        // dado
        Cliente cliente = new Cliente();
        cliente.setNome("Spring");
        cliente.setCpf("796.881.490-12");
        cliente.setEndereco("rua 20 oloko meu ");
        cliente.setCidade("catalao");
        cliente.setEstado("GO");
        cliente.setEmail("spring@tudodebom.com");
        cliente.setTelefone("+55(00)11111-1111");

        // quando
        sobreTeste.deletar(cliente.getId());

        // entao
        verify(clienteRepository).deleteById(cliente.getId());
    }
	
    @Test
	void podeExisteCpf() {

        // dado
        Cliente cliente = new Cliente();
        cliente.setNome("Spring");
        cliente.setCpf("796.881.490-12");
        cliente.setEndereco("rua 20 oloko meu ");
        cliente.setCidade("catalao");
        cliente.setEstado("GO");
        cliente.setEmail("spring@tudodebom.com");
        cliente.setTelefone("+55(00)11111-1111");

        // quando
        sobreTeste.existeCpf(cliente.getCpf());

        // entao
        verify(clienteRepository).existsByCpf(cliente.getCpf());
    }
	
    @Test
	void podeExisteId() {

        // dado
        Cliente cliente = new Cliente();
        cliente.setNome("Spring");
        cliente.setCpf("796.881.490-12");
        cliente.setEndereco("rua 20 oloko meu ");
        cliente.setCidade("catalao");
        cliente.setEstado("GO");
        cliente.setEmail("spring@tudodebom.com");
        cliente.setTelefone("+55(00)11111-1111");

        // quando
        sobreTeste.existeId(cliente.getId());

        // entao
        verify(clienteRepository).existsById(cliente.getId());
    }

}
