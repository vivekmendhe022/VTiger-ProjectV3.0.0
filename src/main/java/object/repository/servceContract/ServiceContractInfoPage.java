package object.repository.servceContract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceContractInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ServiceContractHederText;

	public ServiceContractInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public String getServiceContractHeaderInfo() {
		return ServiceContractHederText.getText();
	}
}
