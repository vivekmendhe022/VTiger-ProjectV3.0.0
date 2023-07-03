package object.repository.opportunities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement CreateOpportunitiesLookUpIcon;

	public OpportunitiesPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateOpportunitiesLookUpIcon() {
		return CreateOpportunitiesLookUpIcon;
	}

	public void clickOnCreateOpportunitiesLookUpIcon() {
		CreateOpportunitiesLookUpIcon.click();
	}

}
