package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginAdminView extends PO_View
{
	static public void fillForm(WebDriver driver, String emailp, String passwordp) 
	{ 
		WebElement email = driver.findElement(By.name("email")); 
		email.click(); 
		email.clear(); 
		email.sendKeys(emailp); 
		WebElement password = driver.findElement(By.name("password")); 
		password.click(); 
		password.clear(); 
		password.sendKeys(passwordp); 
		//Pulsar el boton de Alta. 
		By boton = By.className("btn"); 
		driver.findElement(boton).click(); 
	}
}
