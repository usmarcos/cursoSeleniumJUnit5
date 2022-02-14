package br.com.barriga.teste;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.barriga.core.BaseTest;
import br.com.barriga.core.Propriedades;
import br.com.barriga.page.ContasPage;
import br.com.barriga.page.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RemoverMovimentacaoContaTest extends BaseTest {
	
	private ContasPage contasPage = new ContasPage();
	private MenuPage menuPage = new MenuPage();

	@Test
	public void test1ExcluirContaComMovimentacao() {
		menuPage.acessarListarConta();
		contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}

}
