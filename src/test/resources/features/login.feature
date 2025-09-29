Feature: Login

  Scenario: Login com sucesso
    Given que estou na página de login
    When eu digito o usuário "standard_user" e a senha "secret_sauce"
    And clico no botão de login
    Then devo ver a página inicial


  Scenario: Login com falha
    Given que estou na página de login
    When eu digito o usuário "locked_out_user" e a senha "secret"
    And clico no botão de login
    Then valido mensagem de erro "Epic sadface: Username and password do not match any user in this service"
