package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {

	@FindBy(xpath = "//span[contains(text(),'Lead Information')]")
	private WebElement LeadsHeaderText;

	public LeadsInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getLeadsHeaderText() {
		return LeadsHeaderText;
	}

	public String getLeadsHeader() {
		return LeadsHeaderText.getText();
	}

}
