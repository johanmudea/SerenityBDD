
Feature: actualizacion de datos
  como  administrador  de sistema
  deseo validar la actualizacion de los datos
  para poder ofrecerlo en el sitio

  Scenario: actualizacion exitosa
    Given el usuario esta en la pagina  con name "morpheus" y el job "zion_resident"
    When  cuando el usuario hace una solicitud de actualizacion
    Then  se debera ver un codigo de respuesta exitoso status.

    
