#language: es
Feature: iniciar sesion
	
	Escenario: agente tipo persona inicia sesion
		Dado: el agente con email 'guille@uniovi.es'
			Y: y contraseña 'Contra'
			Y: y tipo 'Persona'
		Cuando introduzco los datos en el formulario
			Y: presiono el boton de iniciar sesion
		Entonces: se inicia sesión