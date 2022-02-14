package br.com.barriga.page;

import org.openqa.selenium.By;

import br.com.barriga.core.BasePage;

public class ResumoPage extends BasePage {

	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

	public void selecionarMes(String mes) {
		selecionarCombo("mes", mes);
	}

	public void selecionarAno(String ano) {
		selecionarCombo("ano", ano);
	}

	public void clicarBuscar() {
		clicarBotao(By.xpath(".//input[@class='btn btn-primary']"));
	}

	public void clicarExcluirResumoAtual() {
		clicarBotao(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']"));
	}

	public void clicarExcluirResumo(String string) {
		obterCelula("Conta", string, "Ações", "tabelaExtrato")
				.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
}
