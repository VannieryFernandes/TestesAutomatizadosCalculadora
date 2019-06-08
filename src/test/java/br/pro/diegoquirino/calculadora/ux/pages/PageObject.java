package br.pro.diegoquirino.calculadora.ux.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;

public class PageObject {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public PageObject(WebDriver driver) {
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 15000);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void clicar(WebElement e) {
		e.click();
	}
	
	public void preencher(WebElement e, String text) {
		e.clear();
		e.sendKeys(text);
	}
	
	public void selecionar(WebElement e, String visibleText) {
		(new Select(e)).selectByVisibleText(visibleText);
	}
	
	public void escolher(WebElement e, String text) {
		
		e.click();
		
		
		
		
		
	}
	
}