package br.pro.diegoquirino.calculadora.ux.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicialPO extends PageObject {

	@FindBy(id="welcome.button.calculardesconto")
	private WebElement botaoCalcularDesconto;
	
	@FindBy(id="welcome.button.ajuda")
	private WebElement botaoAjuda;
	
	@FindBy(id="welcome.button.contato")
	private WebElement botaoContato;
	
	public PaginaInicialPO(WebDriver driver) {
		super(driver);
	}
	
	public ListagemProdutoPO acessarListagemDeProduto() {
		clicar(this.botaoCalcularDesconto);
		return PageFactory.initElements(
				getDriver(), ListagemProdutoPO.class);
	}
	
	public void acessarAjuda() {
		clicar(this.botaoAjuda);
	}
	public void acessar() {
		clicar(this.botaoCalcularDesconto);
	}
	
	public void acessarContato() {
		clicar(this.botaoContato);
	}

}
