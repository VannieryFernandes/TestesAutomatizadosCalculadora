package br.pro.diegoquirino.calculadora.ux.pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListagemProdutoPO extends PageObject {

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement valorDoProduto;
	
	@FindBy(xpath = "//a[contains(@href,'pid')][1]")
	private WebElement botaoDescontoInfoForm;
	
	public ListagemProdutoPO(WebDriver driver) {
		super(driver);
	}
	
	public DescontoInfoFormPO acessarDescontoInfoForm() {
		clicar(this.botaoDescontoInfoForm);
		return PageFactory.initElements(
				getDriver(), DescontoInfoFormPO.class);
	}
	
	public Double getValorDoProduto() {
		Locale defaultLocale = new Locale("en", "US", "USD");
        NumberFormat nf = NumberFormat.getCurrencyInstance(defaultLocale);
        try {
        	return new Double(nf.parse("$"+
        			this.valorDoProduto.getText()).doubleValue());
        } catch (ParseException e) {
            e.printStackTrace();
            return new Double(0);
        }
	}
	
}
