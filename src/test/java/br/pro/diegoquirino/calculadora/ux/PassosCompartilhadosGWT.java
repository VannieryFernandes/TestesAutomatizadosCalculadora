package br.pro.diegoquirino.calculadora.ux;

import cucumber.api.java.pt.Dado;
import net.thucydides.core.annotations.Step;

public class PassosCompartilhadosGWT {
	//Dado que eu acesso a página inicial do sistema
    //E seleciono um produto na lista para cálculo
	
	@Step
	PassosCompartilhadosSteps steps;
	
	@Dado("^que eu acesso a página inicial do sistema")
	public void acesso_pagina_inicial() {
		steps.getPaginaInicial();
		
	}
	

}
