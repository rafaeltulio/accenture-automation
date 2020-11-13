#language: pt
Funcionalidade: Preencher formulário de cadastro
	Para validar o formulário
	Como um usuário logado no sistema
	Quero validar as ações da cadastrar com sucesso
	
	@teste
	Cenário: Cadastrar dados com sucesso
		Dado que acesse a url do site
		Quando preencho o formulário de veiculos, aba "Enter Vehicle Data" e pressiono o botão next
		Quando preencho o formulário de seguradora, aba "Enter Insurant Data" e pressiono o botão next
	  Quando preencho o formulário de produto, aba "Enter Product Data" e pressiono o botão next
	  Quando preencho o formulário de preço, aba "Select Price Option" e pressiono o botão next
	  Quando preencho o formulário de cotação, aba "Send Quote" e pressiono o botão next
	 	Então devo receber a mensagem de sucesso "Sending e-mail success!"