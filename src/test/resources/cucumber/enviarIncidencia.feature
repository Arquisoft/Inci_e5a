#language: es
Feature: Enviamos una incidencia
	
	Escenario: Enviamos una nueva incidencia rellenando una serie de campos
		Dado: la incidencia recogida por un agente loggrado
			Y: y con nombre 'Averia1'
			Y: y descripcion 'Perdida de agua de la labadora'
			Y: y etiquetas 'averia, agua'
		Cuando introduzco los datos en el formulario
			Y: presiono el boton de enviar incidencia
		Entonces: se envia la incidencia correctamente 