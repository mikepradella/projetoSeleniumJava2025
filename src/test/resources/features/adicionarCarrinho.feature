Feature: Validar carrinho de compras

  Background:
    Given que estou na página de login
    When eu digito o usuário "standard_user" e a senha "secret_sauce"
    And clico no botão de login

  Scenario: Validar inclusao de um produto no carrinho
    Then devo ver a página inicial
    When adiciono o produto "Sauce Labs Backpack" ao carrinho
    Then o carrinho deve conter 1 item

  Scenario: Validar conteudo do carrinho
    When adiciono o produto "Sauce Labs Backpack" ao carrinho
    And clico no ícone do carrinho
    Then devo ver o produto "Sauce Labs Backpack" no carrinho
