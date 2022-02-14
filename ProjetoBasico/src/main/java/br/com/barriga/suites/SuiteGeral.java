package br.com.barriga.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.barriga.teste.ContaTest;
import br.com.barriga.teste.MovimentacaoTeste;
import br.com.barriga.teste.RemoverMovimentacaoContaTest;
import br.com.barriga.teste.ResumoTest;
import br.com.barriga.teste.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({ ContaTest.class, 
	MovimentacaoTeste.class, 
	RemoverMovimentacaoContaTest.class, 
	SaldoTest.class,
	ResumoTest.class })
public class SuiteGeral {
	
	/* Como cada um estará em uma instancia, cada um terá seu login
	private static LoginPage page = new LoginPage();

	@BeforeClass
	public static void inicializa() {
		page.acessarPagina();
		page.setEmail();
		page.setSenha();
		page.entrar();
	}*/

	/*Como o initDriver vai estar finalizando sempre não será preciso matar o driver
	  na suite
	 
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
	*/
}
