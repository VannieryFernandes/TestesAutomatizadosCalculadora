package br.pro.diegoquirino.calculadora.ux.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.pro.diegoquirino.calculadora.ux.pages.PageObject;


public class ContactFormPO extends PageObject{
	


	String texto;

	@FindBy(id = "nome")
	private WebElement nome; 
	
	@FindBy(id = "email")
	private WebElement email; 
	
	
	
	@FindBy(css = "input[value='duvida']")    //"input[value='sugestao']"
	private WebElement tipMensagem; 
	
	@FindBy(id = "idade")
	private WebElement idade; 
	
	
	@FindBy(id = "mensagem")
	private WebElement mensagem;
	
	
	@FindBy(id = "contato.button.enviarMensagem")
	private WebElement botaoEnviarMensagem;

	public ContactFormPO(WebDriver driver) {
		super(driver);
	
	}
	
	
	public void setNome(String nome) {
		preencher(this.nome, nome);
	}
	
	public void setEmail(String email) {
		preencher(this.email, email);
	}
	
	
	
	public void setTipoMensagem(String tipoMensagem) {
		

		switch (tipoMensagem) {
		case "duvida":
			escolher(this.tipMensagem, "duvida");
			break;
		case "sugestao":
			escolher(this.tipMensagem, "sugestao");
			break;
		case "reclamacao":
			escolher(this.tipMensagem, "reclamacao");
			break;
		default:
			escolher(this.tipMensagem, "duvida");
			break;
		}
		
	}
	
	public void setTipoIdade(String idade) {
		selecionar(this.idade, idade);
	}
	
	
	public ResultadoContactPO enviarMensagem() {
		clicar(this.botaoEnviarMensagem);
		return PageFactory.initElements(
				getDriver(), ResultadoContactPO.class);
	}

	public ResultadoContactPO submit() {
		return enviarMensagem();
	}


}
