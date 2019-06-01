package br.pro.diegoquirino.calculadora.ux.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DescontoInfoFormPO extends PageObject {

	@FindBy(id = "tipoCliente")
	private WebElement tipoCliente; //select
	@FindBy(id = "quantidade")
	private WebElement quantidade; //textbox
	@FindBy(id = "calculardesconto.button.calcular")
	private WebElement botaoCalcularDesconto;
	
	public DescontoInfoFormPO(WebDriver driver) {
		super(driver);
	}
	
	public void setTipoCliente(String tipo) {
		selecionar(this.tipoCliente, tipo);
	}
	public void setQuantidade(Integer quant) {
		preencher(this.quantidade, quant.toString());
	}
	public ResultadoPO acessarResultado() {
		clicar(this.botaoCalcularDesconto);
		return PageFactory.initElements(
				getDriver(), ResultadoPO.class);
	}

	public ResultadoPO submit() {
		return acessarResultado();
	}

}
