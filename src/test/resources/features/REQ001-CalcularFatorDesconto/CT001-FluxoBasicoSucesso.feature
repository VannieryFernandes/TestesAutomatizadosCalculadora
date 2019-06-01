
#language: pt
@regressao @req001
Funcionalidade: Calcular Desconto
  

  Contexto: Sucesso na operação do cálculo
  	Dado que eu acesso a página inicial do sistema
    E seleciono um produto na lista para cálculo

  Esquema do Cenário: Cliente A Menor que 100
    Quando preencho o formulário de info. complementares
    |tipo_cliente|<TipoCliente>|
    |quantidade|<Quantidade>|
    Então o fator de desconto é exibido: 0.9 
    		E o valor com desconto é mostrado
    		E o sistema exibe mensagem de sucesso "MSG001"

    Exemplos: 
      | TipoCliente  | Quantidade |
      | "A" 				 |     0 			|
      | "A" 				 |     50			|
      | "A" 				 |     99			|
   
   
    
