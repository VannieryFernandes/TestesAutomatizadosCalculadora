package br.pro.diegoquirino.calculadora.ux;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.pro.diegoquirino.calculadora.ux.pages.DescontoInfoFormPO;
import br.pro.diegoquirino.calculadora.ux.pages.ListagemProdutoPO;
import br.pro.diegoquirino.calculadora.ux.pages.PaginaInicialPO;
import br.pro.diegoquirino.calculadora.ux.pages.ResultadoPO;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
//fazer requisito 003
//fazer projeto com cucumber
public class REQ001_CalcularDescontoTests {

    private FirefoxDriver driver;
    private PaginaInicialPO pipo;
    private Double valor;

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
        this.valor = null;
    }
    
    private String getPageComFatorDesconto(String cliente, Integer quantidade) {	
    	ListagemProdutoPO listagem = this.pipo.acessarListagemDeProduto();
    	this.valor = listagem.getValorDoProduto();
    	DescontoInfoFormPO descform = listagem.acessarDescontoInfoForm();
    	descform.setTipoCliente(cliente);
    	descform.setQuantidade(quantidade);
    	return descform.submit().getBody();
    }
    
    private String calcularValorComDesconto(double fator) {
    	Locale defaultLocale = new Locale("en", "US", "USD");
        NumberFormat nf = NumberFormat.getCurrencyInstance(defaultLocale);
    	return nf.format(new Double(this.valor*fator)).replace("$","");
    }

    private void verificacao(String pagina, String fatorDesc, String valorDesc) {
    	//6.
        assertAll("T�tulo da p�gina",
                ()-> assertNotNull(this.driver.getTitle()),
                ()-> assertEquals("Calcular Desconto", this.driver.getTitle())
        );
        assertNotNull(pagina);
        assertTrue(pagina.contains(fatorDesc)); //));
        assertTrue(pagina.contains(valorDesc));
    }
    
	
    @Test
    @DisplayName("Calcular o fator de desconto para o Cliente A, Maior que 1000 unidades")
    @Tags({@Tag("Automaticos"),@Tag("RF001")})
    public void testCalcularFatorDescontoClienteAMenorQue100() throws Exception {
    	String pageComfatorDesconto = getPageComFatorDesconto("A", 99);
    	String valorComDesconto = calcularValorComDesconto(0.9);
    	verificacao(pageComfatorDesconto, "0.9 (ou seja, 10% de desconto)", valorComDesconto);
    }
	 
	/*
	 * @Test
	 * 
	 * @DisplayName("Calcular o fator de desconto para o Cliente B, Maior que 100 unidades"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF001")}) public void
	 * testCalcularFatorDescontoClienteBMenorQue100() throws Exception { String
	 * pageComfatorDesconto = getPageComFatorDesconto("B", 99); String
	 * valorComDesconto = calcularValorComDesconto(0.85);
	 * verificacao(pageComfatorDesconto, "0.85 (ou seja, 15% de desconto)",
	 * valorComDesconto); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("Calcular o fator de desconto para o Cliente C, Maior que 100 unidades"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF001")}) public void
	 * testCalcularFatorDescontoClienteCMenorQue100() throws Exception { String
	 * pageComfatorDesconto = getPageComFatorDesconto("C", 99); String
	 * valorComDesconto = calcularValorComDesconto(0.8);
	 * verificacao(pageComfatorDesconto, "0.8 (ou seja, 20% de desconto)",
	 * valorComDesconto); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("Calcular o fator de desconto para o Cliente A, Maior que 100 unidades e menor que 1000"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF001")}) public void
	 * testCalcularFatorDescontoClienteAMaior100Menor1000() throws Exception {
	 * String pageComfatorDesconto = getPageComFatorDesconto("A", 101); String
	 * valorComDesconto = calcularValorComDesconto(0.95);
	 * verificacao(pageComfatorDesconto, "0.95 (ou seja, 5% de desconto)",
	 * valorComDesconto); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("Calcular o fator de desconto para o Cliente B, Maior que 100 unidades e menor que 1000"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF001")}) public void
	 * testCalcularFatorDescontoClienteBMaior100Menor1000() throws Exception {
	 * String pageComfatorDesconto = getPageComFatorDesconto("B", 101); String
	 * valorComDesconto = calcularValorComDesconto(0.9);
	 * verificacao(pageComfatorDesconto, "0.9 (ou seja, 10% de desconto)",
	 * valorComDesconto); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("Calcular o fator de desconto para o Cliente C, Maior que 100 unidades e menor que 1000"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF001")}) public void
	 * testCalcularFatorDescontoClienteCMaior100Menor1000() throws Exception {
	 * String pageComfatorDesconto = getPageComFatorDesconto("C", 101); String
	 * valorComDesconto = calcularValorComDesconto(0.85);
	 * verificacao(pageComfatorDesconto, "0.85 (ou seja, 15% de desconto)",
	 * valorComDesconto); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("Calcular o fator de desconto para o Cliente A, Maior que 1000 unidades"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF001")}) public void
	 * testCalcularFatorDescontoClienteAMaior1000() throws Exception { String
	 * pageComfatorDesconto = getPageComFatorDesconto("A", 1001); String
	 * valorComDesconto = calcularValorComDesconto(1.0);
	 * verificacao(pageComfatorDesconto, "1.0 (ou seja, 0% de desconto)",
	 * valorComDesconto); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("Calcular o fator de desconto para o Cliente B, Maior que 1000 unidades"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF001")}) public void
	 * testCalcularFatorDescontoClienteBMaior1000() throws Exception { String
	 * pageComfatorDesconto = getPageComFatorDesconto("B", 1001); String
	 * valorComDesconto = calcularValorComDesconto(0.95);
	 * verificacao(pageComfatorDesconto, "0.95 (ou seja, 5% de desconto)",
	 * valorComDesconto); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("Calcular o fator de desconto para o Cliente C, Maior que 1000 unidades"
	 * )
	 * 
	 * @Tags({@Tag("Automaticos"),@Tag("RF001")}) public void
	 * testCalcularFatorDescontoClienteCMaiorQue1000() throws Exception { String
	 * pageComfatorDesconto = getPageComFatorDesconto("C", 1001); String
	 * valorComDesconto = calcularValorComDesconto(0.9);
	 * verificacao(pageComfatorDesconto, "0.9 (ou seja, 10% de desconto)",
	 * valorComDesconto); }
	 */
    

}
