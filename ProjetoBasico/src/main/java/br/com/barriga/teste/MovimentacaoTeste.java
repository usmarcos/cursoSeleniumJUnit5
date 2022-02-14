package br.com.barriga.teste;

import static br.com.barriga.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.barriga.core.BaseTest;
import br.com.barriga.core.Propriedades;
import br.com.barriga.page.MenuPage;
import br.com.barriga.page.MovimentacaoPage;
import br.com.barriga.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTeste extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();

	@Test
	public void test1InserirMovimentacao() {
		menuPage.acessarTelaMovimentacao();
		movPage.setDataMovimentacao("01/08/2021");
		movPage.setDataPagamento("01/07/2021");
		movPage.setDescricao("Pagamento de aluguel");
		movPage.setInteressado("Alguma coisa");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2InserirMovimentacaoAtual() {
		menuPage.acessarTelaMovimentacao();
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Pagamento de aluguel");
		movPage.setInteressado("Alguma coisa");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());
	}

	@Test
	public void test3CamposObrigatorios() {
		menuPage.acessarTelaMovimentacao();

		movPage.salvar();
		List<String> erros = movPage.obterErros();
		// Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0));
		// Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio", "Descri��o � obrigat�rio", "Interessado � obrigat�rio",
				"Valor � obrigat�rio", "Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
	}

	@Test
	public void test4InserirMovimentacaoFutura() {
		menuPage.acessarTelaMovimentacao();

		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Pagamento de aluguel");
		movPage.setInteressado("Alguma coisa");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1, erros.size());
	}
	
	
}