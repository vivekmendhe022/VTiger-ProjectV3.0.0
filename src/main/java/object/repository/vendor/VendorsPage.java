package object.repository.vendor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {

	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement CreateNewVendorsLookUpImg;

	public VendorsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateNewVendorsLookUpImg() {
		return CreateNewVendorsLookUpImg;
	}

	public void clickOnCreateNewVendorsLookUpImg() {
		CreateNewVendorsLookUpImg.click();
	}

}
