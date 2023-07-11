package object.repository.opportunities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OpportunityHeaderText;

	public OpportunityInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public String getOpportunityHeaderInfo() {
		return OpportunityHeaderText.getText();
	}
}
