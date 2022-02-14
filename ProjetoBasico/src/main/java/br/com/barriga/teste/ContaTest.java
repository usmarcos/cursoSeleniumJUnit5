package br.com.barriga.teste;

import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.Assert;
import org.junit.FixMethodOrder;

import br.com.barriga.core.BaseTest;
import br.com.barriga.core.Propriedades;
import br.com.barriga.page.ContasPage;
import br.com.barriga.page.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();

	@Test
	public void test1InserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta de Teste");
		contasPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void test2AlterarContas() {
		menuPage.acessarListarConta();
		contasPage.clicarAlterarConta("Conta de Teste");
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void test3InserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}	
}
