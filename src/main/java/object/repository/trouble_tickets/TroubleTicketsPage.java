package object.repository.trouble_tickets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketsPage {
	
	@FindBy(xpath = "//img[@title='Create Ticket...']")
	private WebElement CreateTroubleTicketsLookUpIcon;
	
	public TroubleTicketsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public void clickOnCreateTroubleTicketsLookUpIcon() {
		CreateTroubleTicketsLookUpIcon.click();
	}

}
