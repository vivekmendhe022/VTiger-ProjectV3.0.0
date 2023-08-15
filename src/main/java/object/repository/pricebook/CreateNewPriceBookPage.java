package object.repository.pricebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPriceBookPage {

	@FindBy(name = "bookname")
	private WebElement PriceBookNameTextField;

	@FindBy(name = "description")
	private WebElement DescriptionTextarea;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	public CreateNewPriceBookPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createNewPriceBook(String PriceBookName, String Description) {
		PriceBookNameTextField.sendKeys(PriceBookName);
		DescriptionTextarea.sendKeys(Description);
		SaveButton.click();
	}
}
