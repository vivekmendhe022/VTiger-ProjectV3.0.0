package object.repository.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class EditOpportunityPage extends WebDriverUtility {

	@FindBy(xpath = "//input[@name='campaignname']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement CampaignSourceLookUpIcon;

	@FindBy(name = "search_text")
	private WebElement SearchTextField;

	@FindBy(name = "search")
	private WebElement SearchBtn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public EditOpportunityPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createCampaignsForOpportunity(WebDriver d, String CAMPNAME) throws InterruptedException {
		CampaignSourceLookUpIcon.click();
		switchToWindow(d, "Campaigns");
		SearchTextField.sendKeys(CAMPNAME);
		SearchBtn.click();
		d.findElement(By.xpath("//a[.='" + CAMPNAME + "']")).click();
		switchToWindow(d, "Potentials");
		Thread.sleep(5000);
		SaveBtn.click();
	}

}
