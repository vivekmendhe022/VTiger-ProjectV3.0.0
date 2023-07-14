package object.repository.documents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateNewDocumentPage extends WebDriverUtility{

	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement TitleTextField;

	@FindBy(xpath = "//input[@value='U']")
	private WebElement AssignedToUserRadioButton;

	@FindBy(xpath = "//input[@value='T']")
	private WebElement AssignedToGroupRadioButton;

	@FindBy(xpath = "//body[@class='cke_show_borders']")
	private WebElement NoteTextArea;

	@FindBy(xpath = "//select[@name='filelocationtype']")
	private WebElement DownloadTypeDropDownList;

	@FindBy(xpath = "//input[@id='filename_I__']")
	private WebElement UploadFileButton;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreateNewDocumentPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public void createNewDocument(String TITLE, String AssignedTo) {
		TitleTextField.sendKeys(TITLE);
		if(AssignedTo.equalsIgnoreCase("user")) {
			AssignedToUserRadioButton.click();
		}else if(AssignedTo.equalsIgnoreCase("group")){
			AssignedToGroupRadioButton.click();
		}else {
			System.out.println("Give valid data: 'user' or 'group'");
		}
		SaveBtn.click();
	}
	
	public void createNewDocumentUsingDescription(WebDriver d, String TITLE, String AssignedTo) {
		TitleTextField.sendKeys(TITLE);
		if(AssignedTo.equalsIgnoreCase("user")) {
			AssignedToUserRadioButton.click();
		}else if(AssignedTo.equalsIgnoreCase("group")){
			AssignedToGroupRadioButton.click();
		}else {
			System.out.println("Give valid data: 'user' or 'group'");
		}
		switchToFrame(d, 0);
		NoteTextArea.click();
		NoteTextArea.sendKeys("Hello Every one.......!");
		switchToParentFrame(d);
		SaveBtn.click();
	}
	
	public void createNewDocumentUsingDownloadType(WebDriver d, String TITLE, String AssignedTo) {
		TitleTextField.sendKeys(TITLE);
		if(AssignedTo.equalsIgnoreCase("user")) {
			AssignedToUserRadioButton.click();
		}else if(AssignedTo.equalsIgnoreCase("group")){
			AssignedToGroupRadioButton.click();
		}else {
			System.out.println("Give valid data: 'user' or 'group'");
		}
		switchToFrame(d, 0);
		NoteTextArea.click();
		NoteTextArea.sendKeys("Hello Every one.......!");
		switchToParentFrame(d);
		handleDropDown(DownloadTypeDropDownList, 1);
		SaveBtn.click();		
	}
	
	public void createNewDocumentUsingUploadFile(WebDriver d, String TITLE, String AssignedTo) {
		String filePath = "D:\\elon-musk-resume.webp";
		TitleTextField.sendKeys(TITLE);
		if(AssignedTo.equalsIgnoreCase("user")) {
			AssignedToUserRadioButton.click();
		}else if(AssignedTo.equalsIgnoreCase("group")){
			AssignedToGroupRadioButton.click();
		}else {
			System.out.println("Give valid data: 'user' or 'group'");
		}
		switchToFrame(d, 0);
		NoteTextArea.click();
		NoteTextArea.sendKeys("Hello Every one.......!");
		switchToParentFrame(d);
		UploadFileButton.sendKeys(filePath);
		SaveBtn.click();	
	}
}
