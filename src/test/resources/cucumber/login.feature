#language: es
Feature: iniciar sesion
	
	Scenario: agente tipo persona inicia sesion
		Given: el agente con email 'guille@uniovi.es'
			And: y contraseña 'Contra'
			And: y tipo 'Persona'
		When el agente presiona el botón de iniciar sesión
		Then: se inicia sesión