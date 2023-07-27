package object.repository.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicePage {

	@FindBy(xpath = "//img[@title='Create Service...']")
	private WebElement ServiceImgLookUpIcon;

	public ServicePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getServiceImgLookUpIcon() {
		return ServiceImgLookUpIcon;
	}
	
	public void clickOnServiceImgLookUpIcon() {
		ServiceImgLookUpIcon.click();
	}
}
