package object.repository.campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {

	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement CreateCampaignsLookUpIcon;

	public CampaignsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateCampaignsLookUpIcon() {
		return CreateCampaignsLookUpIcon;
	}

	public void clickOnCreateCampaignsLookUpIcon() {
		CreateCampaignsLookUpIcon.click();
	}

}
