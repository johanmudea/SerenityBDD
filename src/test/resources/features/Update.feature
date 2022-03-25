# new feature
# Tags: optional

    Feature: actualizacion de dato

      como un usuario  del sistema
      deseo validar la actualizacion
      para poder ofrecer personalizacion al perfil de usuario

      Scenario: actualizacion exitosa

        Given el usuario esta en la pagina de actualizacion con name "morpheus" y el job "zion_resident"
        When  cuando el usuario hace una peticion para actualizar el job
        Then  el usuario debera ver un codigo de respuesta exitoso y un token de respuesta.