package br.pro.diegoquirino.calculadora.ux.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.pro.diegoquirino.calculadora.ux.pages.PageObject;

public class ResultadoContactPO extends PageObject{
	
	@FindBy(xpath = "//body")
	private WebElement body;
	
	public ResultadoContactPO(WebDriver driver) {
		super(driver);
	}
	
	public String getBody() {
		return this.body.getText();
	}


}
