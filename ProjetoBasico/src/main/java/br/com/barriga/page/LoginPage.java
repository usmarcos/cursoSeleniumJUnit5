package br.com.barriga.page;

import static br.com.barriga.core.DriverFactory.getDriver;


import br.com.barriga.core.BasePage;

public class LoginPage extends BasePage {
	
	public void acessarPagina() {
		getDriver().get("https://seubarriga.wcaquino.me");
	}

	public void setEmail() {
		escrever("email", "usmarcos@yahoo.com");
	}

	public void setSenha() {
		escrever("senha", "776801");
	}

	public void entrar() {
		clicarBotaoPorTexto("Entrar");
	}
}
