package br.com.alura.forum.aceitacao.cadastro;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

public class FluxoDeCadastroTest {

	ChromeDriver browser;

	@Before
	public void antes() {

		browser = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver","./chromedriver");

	}

	@After
	public void depois() {
		browser.close();
	}

	@Ignore
	@Test
	public void criar_uma_conta() {
		Faker faker = new Faker();

		browser.get("http://localhost:8080/alura-forum/");

		TopicosPage paginaDeTopicos = new TopicosPage(browser);
		CadastroPage paginaDeCadastro = paginaDeTopicos.clicarNoLinkDeCadastro();

		String nome = faker.funnyName().name();
		String email = faker.internet().emailAddress();
		String senha = faker.internet().password();

		paginaDeCadastro.preencheFormulario(nome, email, senha);
		PaginaLogadaPage paginaLogadaPage = paginaDeCadastro.submeteCadastro();

		Assert.assertTrue(paginaLogadaPage.contem(nome));
	}

}
