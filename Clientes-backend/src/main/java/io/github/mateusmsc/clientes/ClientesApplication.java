package io.github.mateusmsc.clientes;

import io.github.mateusmsc.clientes.model.entity.Cliente;
import io.github.mateusmsc.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {

    // Testar db conection
    /*@Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository){
        return args -> {
            Cliente cliente = Cliente.builder().cpf("06585669925").nome("Teste de build").build();
            repository.save(cliente);
        };
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
    }
}
