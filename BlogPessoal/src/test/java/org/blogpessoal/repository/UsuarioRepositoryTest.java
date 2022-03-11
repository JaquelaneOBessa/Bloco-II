package org.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.blogpessoal.model.UsuarioModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {

		usuarioRepository.deleteAll();

		usuarioRepository.save(new UsuarioModel(0L, "Seu ze da Silva", "zezinho@email.com.br", "13465278",
				"https://i.imgur.com/FETvs2O.jpg"));

		usuarioRepository.save(new UsuarioModel(0L, "Pedrinho da Silva", "pedrinho@email.com.br", "13465278",
				"https://i.imgur.com/NtyGneo.jpg"));

		usuarioRepository.save(new UsuarioModel(0L, "Carla da Silva", "Carla@email.com.br", "13465278",
				"https://i.imgur.com/mB3VM2N.jpg"));

		usuarioRepository.save(new UsuarioModel(0L, "Paula Antunes", "paula@email.com.br", "13465278",
				"https://i.imgur.com/JR7kUFU.jpg"));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {
		Optional<UsuarioModel> usuario = usuarioRepository.findByUsuario("zezinho@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("zezinho@email.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<UsuarioModel> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());

		
		
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Seu ze da Silva"));
		
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Pedrinho da Silva"));

		assertTrue(listaDeUsuarios.get(2).getNome().equals("Carla da Silva"));

		

	}

	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}

}