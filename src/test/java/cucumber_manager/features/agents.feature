#language: es

Feature: Utilizar el modulo agents

	Escenario: Obtener los datos de un agente
		Dado: el email del agente es 'alvaro@uniovi.es'
			Y: su contraseña es 'Contra'
			Y: su tipo es 'Persona'
		Cuando: el agente los introduce en el formulario
			Y: presiona el boton
		Entonces: se envia la peticion
			Y: se obtienen los datos del agente