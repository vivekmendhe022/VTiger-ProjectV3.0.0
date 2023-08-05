package object.repository.assets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssetsPage {

	@FindBy(xpath = "//img[@title='Create Asset...']")
	private WebElement CreateNewAssetLookUpImg;

	public AssetsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateNewAssetLookUpImg() {
		return CreateNewAssetLookUpImg;
	}

	public void clickOnCreateNewAssetLookUpImg() {
		CreateNewAssetLookUpImg.click();
	}

}
