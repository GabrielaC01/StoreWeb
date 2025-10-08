Feature: Product-Store
  @testProduct
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<Usuario>" y clave "<Password>"
    When navego a la categoria "<Categoria>" y subcategoria "<Subcategoria>"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
    Examples:
    |Usuario                   |Password  |Categoria|Subcategoria|
    |gabrielafeber07@gmail.com |PruebaWeb |Clothes  |Men         |
    |gabrielafeber07@gmail.com |PruebaW   |Clothes  |Men         |
    |gabrielafeber07@gmail.com |PruebaWeb |Autos    |Men         |

