package object.repository.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement CreateTroubleProductLookUpIcon;

	public ProductPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void clickOnCreateTroubleTicketsLookUpIcon() {
		CreateTroubleProductLookUpIcon.click();
	}
}
