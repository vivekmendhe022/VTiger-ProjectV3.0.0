package object.repository.servceContract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceContractPage {

	@FindBy(xpath = "//img[@title='Create Service Contract...']")
	private WebElement ServiceContractLookUpImg;

	public ServiceContractPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getServiceContractLookUpImg() {
		return ServiceContractLookUpImg;
	}

	public void clickOnServiceContractLookUpImg() {
		ServiceContractLookUpImg.click();
	}
}
