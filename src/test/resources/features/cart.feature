Feature: Carrito de compras
  Como usuario autenticado
  Quiero agregar productos al carrito
  Para poder realizar una compra

  Scenario: Agregar un producto al carrito
    Given el usuario ha iniciado sesion con las credenciales validas
    When agrega el primer producto en el carrito
    Then el contador del carrito debe mostrar 1