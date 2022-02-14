package br.com.barriga.page;

import br.com.barriga.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}

	public void acessarListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");
	}

	public void acessarTelaMovimentacao() {
		clicarLink("Criar Movimentação");
	}
	
	public void acessarTelaResumoMensal() {
		clicarLink("Resumo Mensal");
	}
	public void acessarTelaPrincipal() {
		clicarLink("Home");
	}
}
