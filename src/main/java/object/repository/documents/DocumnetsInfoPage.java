package object.repository.documents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumnetsInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement DocumentHeaderText;

	public DocumnetsInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getDocumentHeaderText() {
		return DocumentHeaderText;
	}

	public String getDocumentsHeaderInfo() {
		return DocumentHeaderText.getText();
	}

}
