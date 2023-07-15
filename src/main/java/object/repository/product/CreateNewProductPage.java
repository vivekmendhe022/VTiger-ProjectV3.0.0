package object.repository.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {

	@FindBy(name = "productname")
	private WebElement ProductNameTextField;

	@FindBy(xpath = "//input[@value='U']")
	private WebElement HandlerUsingUserRadioButton;

	@FindBy(xpath = "//input[@value='T']")
	private WebElement HandlerUsingGroupRadioButton;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	public CreateNewProductPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createNewProduct(String PRODUCT, String HANDLER) {
		ProductNameTextField.sendKeys(PRODUCT);
		if (HANDLER.equals("user")) {
			HandlerUsingUserRadioButton.click();
		} else if (HANDLER.equals("group")) {
			HandlerUsingGroupRadioButton.click();
		} else {
			System.out.println("Invalid handler click on: 'user' 'group'");
		}
		SaveButton.click();
	}
}
