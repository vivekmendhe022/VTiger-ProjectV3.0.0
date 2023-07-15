package object.repository.trouble_tickets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement TroubleTicketHeaderText;

	public TroubleTicketInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public String getTroubleTicketHeaderInfo() {
		return TroubleTicketHeaderText.getText();
	}
}
