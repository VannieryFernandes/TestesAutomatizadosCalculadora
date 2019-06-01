package br.pro.diegoquirino.calculadora.ux;

import br.pro.diegoquirino.calculadora.ux.pages.PaginaInicialPO;
import net.thucydides.core.annotations.Step;

public class PassosCompartilhadosSteps {
	
	PaginaInicialPO page;
	
	@Step
	public void getPaginaInicial() {
		page.acessar();
		
	}

}
