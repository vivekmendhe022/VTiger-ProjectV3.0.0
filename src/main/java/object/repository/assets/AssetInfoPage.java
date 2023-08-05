package object.repository.assets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssetInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement AssetHeader;

	public AssetInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getAssetHeader() {
		return AssetHeader;
	}

	public String getAssetInfo() {
		return AssetHeader.getText();
	}
}
