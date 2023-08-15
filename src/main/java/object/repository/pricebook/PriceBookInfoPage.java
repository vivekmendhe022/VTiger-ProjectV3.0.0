package object.repository.pricebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceBookInfoPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement PriceBookHeaderText;

	public PriceBookInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public String priceBookHeaderInfo() {
		return PriceBookHeaderText.getText();
	}

}
