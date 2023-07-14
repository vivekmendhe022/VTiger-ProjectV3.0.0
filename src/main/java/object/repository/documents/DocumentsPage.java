package object.repository.documents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {
	
	@FindBy(xpath = "//img[@title='Create Document...']")
	private WebElement CreateDocumnetsLookUpIcon;
	
	public DocumentsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateDocumnetsLookUpIcon() {
		return CreateDocumnetsLookUpIcon;
	}

	public void clickOnCreateDocumnetsLookUpIcon() {
		CreateDocumnetsLookUpIcon.click();
	}
}
