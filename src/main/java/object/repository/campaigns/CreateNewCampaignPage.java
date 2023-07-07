package object.repository.campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {

	@FindBy(name = "campaignname")
	private WebElement CampaignNameTextField;

	@FindBy(xpath = "//input[@value='U']")
	private WebElement AssignedToUserRadioButton;

	@FindBy(xpath = "//input[@value='T']")
	private WebElement AssignedToGroupRadioButton;

	@FindBy(xpath = "//input[contains(@class,'crmButton small save')]")
	private WebElement SaveBtn;

	public CreateNewCampaignPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createNewCampaignPage(String CAMPNAME, String ASSIGNTO) {
		CampaignNameTextField.sendKeys(CAMPNAME);
		if (ASSIGNTO.equalsIgnoreCase("user")) {
			AssignedToUserRadioButton.click();
		} else if (ASSIGNTO.equalsIgnoreCase("group")) {
			AssignedToGroupRadioButton.click();
		} else {
			System.out.println("Enter valid credential: user or group.");
		}
		SaveBtn.click();
	}

}
