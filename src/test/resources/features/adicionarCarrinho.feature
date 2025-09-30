Feature: Validar carrinho de compras


  Scenario: Validar
    Given que estou na página de login
    When eu digito o usuário "standard_user" e a senha "secret_sauce"
    And clico no botão de login
    Then devo ver a página inicial
    When adiciono o produto "Sauce Labs Backpack" ao carrinho
    Then o carrinho deve conter 1 item
