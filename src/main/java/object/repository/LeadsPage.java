package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateLeadsLookUpImg;

	public LeadsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateLeadsLookUpImg() {
		return CreateLeadsLookUpImg;
	}

	public void clickOnCreateLeadsLookUpImg() {
		CreateLeadsLookUpImg.click();
	}

}
