package object.repository.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewServicePage {

	@FindBy(name = "servicename")
	private WebElement ServiceNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewServicePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public void createNewService(String SERVICENAME) {
		ServiceNameTextField.sendKeys(SERVICENAME);
		SaveBtn.click();
	}
}
