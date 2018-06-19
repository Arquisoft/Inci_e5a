package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;

public class PO_PrivateView extends PO_NavView 
{
	static List<WebElement> peticionesEnviadas=new ArrayList<WebElement>();
	
	static public void buscarUsuario(WebDriver driver, String busquedaP) 
	{ 
		
		WebElement busqueda = driver.findElement(By.name("searchText")); 
		busqueda.clear(); 
		busqueda.sendKeys(busquedaP);
		By boton = By.className("btn"); driver.findElement(boton).click(); 
		
	}
	
	static public boolean checkPeticion(WebDriver driver, WebElement element) 
	{ 
		for (WebElement webElement : peticionesEnviadas) 
		{
			if(peticionesEnviadas.contains(webElement))
				return true;
		}
		return false;
	}

	public static void addPeticion(WebElement webElement) 
	{
		peticionesEnviadas.add(webElement);
	}
	
	static public void rellenarDatosPublicacion(WebDriver driver, String texto, String titulo) 
	{ 
		WebElement text = driver.findElement(By.name("titulo")); 
		text.click(); 
		text.clear(); 
		text.sendKeys(texto); 
		WebElement title = driver.findElement(By.name("texto")); 
		title.click(); 
		title.clear(); 
		title.sendKeys(titulo); 
		
		//Pulsar el boton de Alta. 
		By boton = By.name("subida");
		driver.findElement(boton).click(); 
	}
	
	static public void rellenarDatosPublicacionConFoto(WebDriver driver, String texto, String titulo) 
	{ 
		WebElement text = driver.findElement(By.name("titulo")); 
		text.click(); 
		text.clear(); 
		text.sendKeys(texto); 
		WebElement title = driver.findElement(By.name("texto")); 
		title.click(); 
		title.clear(); 
		title.sendKeys(titulo); 
		
		By boton=By.name("img");
		//Pulsar el boton de Alta. 
		//By boton = By.name("subida");
		driver.findElement(boton).click(); 
	}
}
