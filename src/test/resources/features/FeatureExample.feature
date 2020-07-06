#language: en

@ts2020 @listaCompras @alerta
Feature: Como usuário do aplicativo
  Eu quero ser alertado sobre o valor total da minha lista de compras
  Para que eu saber quando o limite do valor que eu havia planejado for alcançado

  @automated @stepData
  Scenario: Alertar sobre o limite de valor da lista de
  compras quando itens avulsos são adicionados
	Given o limite de valor definido pelo usuário é 50.0
	And o usuário criou uma lista de compras de 42.91
	When o usuário adiciona 1 item avulso que custa 11.99
	Then o valor da lista de compras atual é 54.90
	And o usuário visualiza o alerta "A lista de compras ultrapassou o valor limite!"


  @automated @examples @expressions
  Scenario Outline: Visualizar a quantidade de itens de uma
  lista enquanto itens avulsos são adicionados
	Given a lista de compras contém "<quantidade inicial>" itens
	When o usuário adiciona <quantidade adicoes> itens avulsos
	Then a quantidades de itens da lista é atualizado para <quantidade final>
	And a seguinte mensagem é mostrada "<mensagem>"
	Examples:
	  | quantidade inicial | quantidade adicoes | quantidade final | mensagem  |
	  |         2          |         1          |         3        | Foram 3!  |
	  |         10         |         5          |        15        | Foram 10! |



