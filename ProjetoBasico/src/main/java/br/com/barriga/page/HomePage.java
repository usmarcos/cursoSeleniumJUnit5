package br.com.barriga.page;


import br.com.barriga.core.BasePage;

public class HomePage extends BasePage {

	public String obterSaldoConta(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}

}
