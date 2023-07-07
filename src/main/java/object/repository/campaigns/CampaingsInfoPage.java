package object.repository.campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaingsInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement CampaignHeaderText;

	public CampaingsInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public String getCampaingsHeaderInfo() {
		return CampaignHeaderText.getText();
	}
}
