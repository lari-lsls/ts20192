@ts20192 @seleniumEasy @tableSortSearch
Feature:
  As a user
  I want to filter the employees list
  So that I can see only the employees which interests me

  @automated @filter
  Scenario: Filter the employees list by word and see the results in one page
	Given the user access the table sort and search page
	And there are 30 employees in the company
	When the user search for a employees using the word "London"
	Then 7 employees are shown in the list

  @automated @filter @especialAfter
  Scenario: Filter the employees list by word and see the results in one page
	Given the user access the table sort and search page
	And there are 30 employees in the company
	When the user search for a employees using the word "London"
	Then 7 employees are shown in the list

#  @automated @filter
#  Scenario: Filtrar a lista de colaboradores por palavras e ver os resultados em uma página
#	Given o usuário acessou a página table sort and search
#	And existem 30 colaboradores na empresa
#	When o usuário procura por um colaborador usando a palabra "London"
#	Then são mostrados 9 colaboradores na lista