package br.com.barriga.teste;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.barriga.core.BaseTest;
import br.com.barriga.core.Propriedades;
import br.com.barriga.page.HomePage;
import br.com.barriga.page.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaldoTest extends BaseTest {
	HomePage homePage = new HomePage();
	MenuPage menu = new MenuPage();
	@Test
	public void test1Saldo() {
		menu.acessarTelaPrincipal();
		Assert.assertEquals("1000.00", homePage.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}
}
