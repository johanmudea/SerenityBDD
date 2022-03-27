Feature: eliminacion de usuario
    Como administrador
    Quiero elliminar existencia de usuario
    Para validar inexistencia en plataforma.

    Scenario: eliminacion de usuario
        Given me encuentro en el servicio
        When realizo una peticion de eliminacion de usuario
        Then Se obtendra un status de no contenido.