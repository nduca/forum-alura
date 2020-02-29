package br.com.alura.forum.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TopicoTest {

	@Test
	public void marcar_estado_como_solucionado() {

		// Dado

		Usuario autor = new Usuario("Nathan", "nathan@duca.com", "123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Devops", categoria);
		Topico topico = new Topico("Primeiros Passos", "Conhecendo Devops", autor, curso);

		// Entao
		
		topico.marcarComoSolucionado();

		assertEquals(StatusTopico.SOLUCIONADO, topico.getStatus());

	}

}
