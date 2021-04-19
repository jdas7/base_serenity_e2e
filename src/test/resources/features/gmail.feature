# language: es

Característica: Gmail

  @test
  Escenario: Contraseña incorrecta gmail
    Dado Juan es un usuario de gmail
    Cuando intenta iniciar sesion
    Entonces visualiza un error indicando que la contrasena es incorrecta