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
	
	public ContactFormPO enviarMensagem() {
		clicar(this.botaoContato);
		return PageFactory.initElements(
				getDriver(), ContactFormPO.class);
	}
	public void acessar() {
		clicar(this.botaoCalcularDesconto);
	}
	
	public void acessarAjuda() {
		clicar(this.botaoAjuda);
	}
	
	public ContactFormPO acessarContato() {
		clicar(this.botaoContato);
		return PageFactory.initElements(
				getDriver(), ContactFormPO.class);
	}

}
