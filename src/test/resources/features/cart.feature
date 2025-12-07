Feature: Carrito de compras
  Como usuario autenticado
  Quiero agregar productos al carrito
  Para poder realizar una compra

  Scenario: Agregar un producto al carrito
    Given el usuario ha iniciado sesion con las credenciales validas
    When agrega el primer producto en el carrito
    Then el contador del carrito debe mostrar 1

  Scenario: Ver producto en el carrito
    Given el usuario ha iniciado sesion con las credenciales validas
    And agrega el primer producto en el carrito
    When accede al carrito
    Then debe ver el producto agregado en el carrito

  Scenario: Completar proceso de checkout
    Given el usuario ha iniciado sesion con las credenciales validas
    And agrega el primer producto en el carrito
    And accede al carrito
    When procede al checkout
    And completa el formulario con nombre "Pedro" apellido "Perez" y codigo postal "12345"
    And finaliza la compra
    Then debe ver el mensaje de confirmacion "Thank you for your order!"

    Scenario: Cerrar Sesion desde el menu
      Given el usuario ha iniciado sesion con las credenciales validas
      When abre el menu lateral
      And hace click en logout
      Then debe ver la pagina de login


