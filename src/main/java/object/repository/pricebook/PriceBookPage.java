package object.repository.pricebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceBookPage {

	@FindBy(xpath = "//img[@title='Create Price Book...']")
	private WebElement PriceBooksLookUpImg;

	public PriceBookPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void clickOnPriceBooksLookUpImg() {
		PriceBooksLookUpImg.click();
	}
}
