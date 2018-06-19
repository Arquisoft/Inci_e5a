package pageobjects;

import org.openqa.selenium.*;

public class PO_RegisterView extends PO_NavView
{
	static public void fillForm(WebDriver driver,  String namep, String emailp, String passwordp, String passwordconfp) 
	{ 
		WebElement email = driver.findElement(By.name("email")); 
		email.click(); 
		email.clear(); 
		email.sendKeys(emailp); 
		WebElement nombre = driver.findElement(By.name("nombre")); 
		nombre.click();
		nombre.clear();
		nombre.sendKeys(namep);
		WebElement password = driver.findElement(By.name("password")); 
		password.click(); 
		password.clear(); 
		password.sendKeys(passwordp); 
		WebElement repPassword = driver.findElement(By.name("repPassword")); 
		repPassword.click(); 
		repPassword.clear(); 
		repPassword.sendKeys(passwordconfp); 
		//Pulsar el boton de Alta. 
		By boton = By.className("btn"); 
		driver.findElement(boton).click(); 
	}
	
}
