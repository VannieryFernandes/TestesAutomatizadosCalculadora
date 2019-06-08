package br.pro.diegoquirino.calculadora.ux;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import br.pro.diegoquirino.calculadora.ux.pages.ContactFormPO;

import br.pro.diegoquirino.calculadora.ux.pages.PaginaInicialPO;

public class REQ003_FormularioDeContatoTests {
	 private FirefoxDriver driver;
	    private PaginaInicialPO pipo;
	    

	    @BeforeEach
	    public void setup() throws Exception {
	        this.driver = new FirefoxDriver();
	        this.driver.manage().window().maximize();
	        this.driver.get("https://calculadora.diegoquirino.net");
	        this.pipo = PageFactory.initElements(
					this.driver, PaginaInicialPO.class);
	    }

	    @AfterEach
	    public void tearDown() throws Exception {
	        this.driver.quit();
	        this.driver = null;
	        this.pipo = null;
	        
	    }
	    
	    private String getFormPageContact(String nome,String email, String tipoMensagem, String idade, String mensagem) {
	    	
	    	ContactFormPO envio= this.pipo.acessarContato();
	    	envio.setNome(nome);
	    	envio.setEmail(email);
	    	envio.setTipoMensagem(tipoMensagem);
	    	envio.setTipoIdade(idade);
	    	
	    	
	    	
	    	return envio.submit().getBody();
	    }
	    private String setTipoMensagem(String tipo) {
	    	return tipo;
	    }
	    
	    
	  

	    private void verificacao(String pagina, String resultado, String tipoMensagem) {
	    	//6.
	        assertAll("T�tulo da p�gina",
	                ()-> assertNotNull(this.driver.getTitle()),
	                ()-> assertEquals("Calcular Desconto", this.driver.getTitle())
	        );
	        assertNotNull(pagina);
	        assertTrue(pagina.contains(resultado)); //se contem a mensagem;
	        assertTrue(pagina.contains(tipoMensagem));
	    }
	    
		
	/*
	 * @Test
	 * 
	 * @DisplayName("Enviar mensagem com dados corretos, tipo de mensagem sugestao e idade Menor que 18 anos"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF003")}) public void
	 * testEnviarMensagemDuvidaMenor18() throws Exception { String pagina=
	 * getFormPageContact("Leandro",
	 * "leandro@teste.com","duvida","Menor que 18 anos","testanto o app"); String
	 * tipoMensagem = setTipoMensagem("duvida"); verificacao(pagina,
	 * "-Menor que 18 anos: Mensagem enviada com sucesso!", tipoMensagem);
	 * 
	 * }
	 */
	/*
	 * @Test
	 * 
	 * @DisplayName("Enviar mensagem com dados corretos, tipo de mensagem sugestao e idade Menor que 18 anos"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF003")}) public void
	 * testEnviarMensagemSugestaoMenor18() throws Exception { String pagina=
	 * getFormPageContact("Leandro",
	 * "leandro@teste.com","sugestao","Menor que 18 anos","testanto o app"); String
	 * tipoMensagem = setTipoMensagem("sugestao"); verificacao(pagina,
	 * "-Menor que 18 anos: Mensagem enviada com sucesso!", tipoMensagem);
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * @DisplayName("Enviar mensagem com dados corretos, tipo de mensagem sugestao e idade Menor que 18 anos"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF003")}) public void
	 * testEnviarMensagemReclamacaoMenor18() throws Exception { String pagina=
	 * getFormPageContact("Leandro",
	 * "leandro@teste.com","reclamacao","Menor que 18 anos","testanto o app");
	 * String tipoMensagem = setTipoMensagem("reclamacao"); verificacao(pagina,
	 * "-Menor que 18 anos: Mensagem enviada com sucesso!", tipoMensagem);
	 * 
	 * }
	 */
	/*
	 * @Test
	 * 
	 * @DisplayName("Enviar mensagem com dados corretos, tipo de mensagem duvida e entre 18 e 60"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF003")}) public void
	 * testEnviarMensagemDuvida18e60() throws Exception { String pagina=
	 * getFormPageContact("Leandro",
	 * "leandro@teste.com","duvida","Entre 18 e 60 anos","testanto o app"); String
	 * tipoMensagem = setTipoMensagem("duvida"); verificacao(pagina,
	 * "-Entre 18 e 60 anos: Mensagem enviada com sucesso!", tipoMensagem);
	 * 
	 * }
	 * 
	 * 
	 * @Test
	 * 
	 * @DisplayName("Enviar mensagem com dados corretos, tipo de mensagem sugestao ee entre 18 e 60"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF003")}) public void
	 * testEnviarMensagemSugestao18e60() throws Exception { String pagina=
	 * getFormPageContact("Leandro",
	 * "leandro@teste.com","sugestao","Entre 18 e 60 anos","testanto o app"); String
	 * tipoMensagem = setTipoMensagem("sugestao"); verificacao(pagina,
	 * "-Entre 18 e 60 anos: Mensagem enviada com sucesso!", tipoMensagem);
	 * 
	 * }
	 * 
	 * 
	 * @Test
	 * 
	 * @DisplayName("Enviar mensagem com dados corretos, tipo de mensagem reclamacao e entre 18 e 60"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF003")}) public void
	 * testEnviarMensagemReclamacao18e60() throws Exception { String pagina=
	 * getFormPageContact("Leandro",
	 * "leandro@teste.com","reclamacao","Entre 18 e 60 anos","testanto o app");
	 * String tipoMensagem = setTipoMensagem("reclamacao"); verificacao(pagina,
	 * "-Entre 18 e 60 anos: Mensagem enviada com sucesso!", tipoMensagem);
	 * 
	 * }
	 */
	    
	    @Test
	    @DisplayName("Enviar mensagem com dados corretos, tipo de mensagem reclamacao e depois dos 60")
	    @Tags({@Tag("Automaticos"),@Tag("RF003")})
	    public void testEnviarMensagemReclamacao60() throws Exception {
	    	String pagina= getFormPageContact("Leandro", "leandro@teste.com","reclamacao","Acima de 60 anos","testanto o app");
	    	String tipoMensagem = setTipoMensagem("reclamacao");
	    	verificacao(pagina, "-Acima de 60 anos: Mensagem enviada com sucesso!", tipoMensagem);
	    
	    }
	    
	    @Test
	    @DisplayName("Enviar mensagem com dados corretos, tipo de mensagem sugestao e depois dos 60")
	    @Tags({@Tag("Automaticos"),@Tag("RF003")})
	    public void testEnviarMensagemSugestao60() throws Exception {
	    	String pagina= getFormPageContact("Leandro", "leandro@teste.com","sugestao","Acima de 60 anos","testanto o app");
	    	String tipoMensagem = setTipoMensagem("sugestao");
	    	verificacao(pagina, "-Acima de 60 anos: Mensagem enviada com sucesso!", tipoMensagem);
	    
	    }
	    @Test
	    @DisplayName("Enviar mensagem com dados corretos, tipo de mensagem duvida e depois dos 60")
	    @Tags({@Tag("Automaticos"),@Tag("RF003")})
	    public void testEnviarMensagemDuvida60() throws Exception {
	    	String pagina= getFormPageContact("Leandro", "leandro@teste.com","duvida","Acima de 60 anos","testanto o app");
	    	String tipoMensagem = setTipoMensagem("duvida");
	    	verificacao(pagina, "-Acima de 60 anos: Mensagem enviada com sucesso!", tipoMensagem);
	    
	    }


}
