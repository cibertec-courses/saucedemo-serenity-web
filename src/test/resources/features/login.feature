Feature: Login en SauceDemo

  Como usuario de SauceDemo
  Quiero iniciar sesion en la aplicacion
  Para acceder al catalogo de productos

  Scenario: Login existoso con credenciales validas
    Given el usuario esta en la pagina de login
    When ingresa el usuario "standard_user"
    And ingresar la contraseña "secret_sauce"
    And hace clic en el boton login
    Then debe ver la pagina de productos

  Scenario: Login fallido con credenciales invalidas
    Given el usuario esta en la pagina de login
    When ingresa el usuario "invalid_user"
    And ingresar la contraseña "worng_password"
    And hace clic en el boton login
    Then debe ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"