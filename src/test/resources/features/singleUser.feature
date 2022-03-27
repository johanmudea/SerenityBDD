Feature: Consulta de usuario
    Como administrador
    Quiero validar existencia de usuario
    Para validar existencia en plataforma.

    Scenario: Consulta de usuario
        Given me encuentro en el servicio
        When realizo una peticion de consulta de usuario
        Then Se obtendra un status de OK en http.