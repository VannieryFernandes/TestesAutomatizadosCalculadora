package br.pro.diegoquirino.calculadora.ux.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;

public class ResultadoPO extends PageObject {

	@FindBy(xpath = "//body")
	private WebElement body;
	
	public ResultadoPO(WebDriver driver) {
		super(driver);
	}
	
	public String getBody() {
		return this.body.getText();
	}

}
