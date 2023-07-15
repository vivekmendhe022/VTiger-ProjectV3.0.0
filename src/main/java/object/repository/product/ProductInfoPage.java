package object.repository.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ProductHeaderText;

	public ProductInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public String getProductHeaderInfo() {
		return ProductHeaderText.getText();
	}
}
