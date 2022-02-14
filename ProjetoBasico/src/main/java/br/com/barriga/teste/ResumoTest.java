package br.com.barriga.teste;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.barriga.core.BaseTest;
import br.com.barriga.core.Propriedades;
import br.com.barriga.page.MenuPage;
import br.com.barriga.page.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();

	/*
	@Test
	 
	public void test1ResumoMensal() {
		menuPage.acessarTelaResumoMensal();
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());

		List<WebElement> elementosEncontrados = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
		}catch (JUnitException e) {
			// TODO: handle exception
		}
	}*/

	@Test
	public void test2RemoverMovimentacaoAtual() {
		menuPage.acessarTelaResumoMensal();
		resumoPage.clicarExcluirResumoAtual();
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}

	@Test
	public void test3RemoverMovimentacao() {
		menuPage.acessarTelaResumoMensal();
		resumoPage.selecionarMes("Agosto");
		resumoPage.selecionarAno("2021");
		resumoPage.clicarBuscar();
		resumoPage.clicarExcluirResumo(Propriedades.NOME_CONTA_ALTERADA);
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}

}
