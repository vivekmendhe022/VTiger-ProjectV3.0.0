package object.repository.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceInfoPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ServiceInfoHeader;

	public ServiceInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public String serviceInfoHeader() {
		return ServiceInfoHeader.getText();
	}
}
