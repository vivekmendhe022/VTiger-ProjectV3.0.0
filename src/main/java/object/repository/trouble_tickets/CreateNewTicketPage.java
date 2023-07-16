package object.repository.trouble_tickets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateNewTicketPage extends WebDriverUtility {

	@FindBy(xpath = "//textarea[@name='ticket_title']")
	private WebElement TitleTextarea;

	@FindBy(xpath = "//select[@name='parent_type']")
	private WebElement ParentTypeDropDownList;

	@FindBy(xpath = "//tbody/tr[3]/td[4]/img[1]")
	private WebElement ParentTypeLookUpIcon;

	@FindBy(css = "input[value='U']")
	private WebElement AssignedToUserRadioButton;

	@FindBy(css = "input[value='T']")
	private WebElement AssignedToGroupRadioButton;

	@FindBy(xpath = "(//img[@title='Select'])[2]")
	private WebElement ProductNameLookUpIcon;

	@FindBy(xpath = "//select[@name='ticketpriorities']")
	private WebElement PriorityDropDownList;

	@FindBy(xpath = "//select[@name='ticketstatus']")
	private WebElement StatusDropDownList;

	@FindBy(xpath = "//select[@name='ticketseverities']")
	private WebElement SeverityDropDownList;

	@FindBy(xpath = "//select[@name='ticketcategories']")
	private WebElement CategoryDropDownList;

	@FindBy(className = "detailedViewTextBox")
	private WebElement DescriptionTextarea;

	@FindBy(xpath = "//input[contains(@class,'crmButton small save')]")
	private WebElement SaveBtn;

	@FindBy(name = "search_text")
	private WebElement SearchTextField;

	@FindBy(name = "search")
	private WebElement SearchBtn;

	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement GroupDropDownList;

	public CreateNewTicketPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getTitleTextarea() {
		return TitleTextarea;
	}

	public WebElement getParentTypeDropDownList() {
		return ParentTypeDropDownList;
	}

	public WebElement getParentTypeLookUpIcon() {
		return ParentTypeLookUpIcon;
	}

	public WebElement getAssignedToUserRadioButton() {
		return AssignedToUserRadioButton;
	}

	public WebElement getAssignedToGroupRadioButton() {
		return AssignedToGroupRadioButton;
	}

	public WebElement getProductNameLookUpIcon() {
		return ProductNameLookUpIcon;
	}

	public WebElement getPriorityDropDownList() {
		return PriorityDropDownList;
	}

	public WebElement getStatusDropDownList() {
		return StatusDropDownList;
	}

	public WebElement getSeverityDropDownList() {
		return SeverityDropDownList;
	}

	public WebElement getCategoryDropDownList() {
		return CategoryDropDownList;
	}

	public WebElement getDescriptionTextarea() {
		return DescriptionTextarea;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getSearchTextField() {
		return SearchTextField;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getGroupDropDownList() {
		return GroupDropDownList;
	}

	public void createNewTicket(String TITLE, String ASSIGNEDTO, String STATUS) {
		TitleTextarea.sendKeys(TITLE);
		if (ASSIGNEDTO.equals("user")) {
			AssignedToUserRadioButton.click();
		} else if (ASSIGNEDTO.equals("user")) {
			AssignedToGroupRadioButton.click();
		} else {
			System.out.println("Invalid action select: 'user''group'");
		}
		handleDropDown(StatusDropDownList, STATUS);
		SaveBtn.click();
	}

	public void createNewTicketWithContact(WebDriver d, String TITLE, String LASTNAME, String ASSIGNEDTO,
			String STATUS) {
		TitleTextarea.sendKeys(TITLE);
		handleDropDown(ParentTypeDropDownList, 0);
		ParentTypeLookUpIcon.click();
		switchToWindow(d, "Contacts");
		SearchTextField.sendKeys(LASTNAME);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + LASTNAME + "']")).click();
		switchToWindow(d, "HelpDesk");
		if (ASSIGNEDTO.equals("user")) {
			AssignedToUserRadioButton.click();
		} else if (ASSIGNEDTO.equals("user")) {
			AssignedToGroupRadioButton.click();
		} else {
			System.out.println("Invalid action select: 'user''group'");
		}
		handleDropDown(StatusDropDownList, STATUS);
		SaveBtn.click();
	}

	public void createNewTicketWithOrg(WebDriver d, String TITLE, String ORGNAME, String ASSIGNEDTO, String STATUS) {
		TitleTextarea.sendKeys(TITLE);
		handleDropDown(ParentTypeDropDownList, 1);
		ParentTypeLookUpIcon.click();
		switchToWindow(d, "Accounts");
		SearchTextField.sendKeys(ORGNAME);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + ORGNAME + "']")).click();
		switchToWindow(d, "HelpDesk");
		if (ASSIGNEDTO.equals("user")) {
			AssignedToUserRadioButton.click();
		} else if (ASSIGNEDTO.equals("user")) {
			AssignedToGroupRadioButton.click();
		} else {
			System.out.println("Invalid action select: 'user''group'");
		}
		handleDropDown(StatusDropDownList, STATUS);
		SaveBtn.click();
	}

	public void createTroubleTicketUsingGroupWithTeamSellingTest(WebDriver d, String TITLE, String ORGNAME,
			String ASSIGNEDTO, String STATUS) {
		TitleTextarea.sendKeys(TITLE);
		handleDropDown(ParentTypeDropDownList, 1);
		ParentTypeLookUpIcon.click();
		switchToWindow(d, "Accounts");
		SearchTextField.sendKeys(ORGNAME);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + ORGNAME + "']")).click();
		switchToWindow(d, "HelpDesk");
		if (ASSIGNEDTO.equals("user")) {
			AssignedToUserRadioButton.click();
		} else if (ASSIGNEDTO.equals("group")) {
			AssignedToGroupRadioButton.click();
			handleDropDown(GroupDropDownList, 2);
		} else {
			System.out.println("Invalid action select: 'user''group'");
		}
		handleDropDown(StatusDropDownList, STATUS);
		SaveBtn.click();
	}

	public void createTroubleTicketWithAllCredentials(WebDriver d, String TITLE, String ORGNAME, String PRODUCT,
			String ASSIGNEDTO, String PRIORITY, String STATUS, String SEVERITY, String CATEGORY, String DESCRIPTION)
			throws InterruptedException {
		TitleTextarea.sendKeys(TITLE);
		handleDropDown(ParentTypeDropDownList, 1);
		ParentTypeLookUpIcon.click();
		switchToWindow(d, "Accounts");
		SearchTextField.sendKeys(ORGNAME);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + ORGNAME + "']")).click();
		switchToWindow(d, "HelpDesk");
		
		if (ASSIGNEDTO.equals("user")) {
			AssignedToUserRadioButton.click();
		} else if (ASSIGNEDTO.equals("group")) {
			AssignedToGroupRadioButton.click();
			handleDropDown(GroupDropDownList, 2);
		} else {
			System.out.println("Invalid action select: 'user''group'");
		}
		
		waitForElementClickable(d, ProductNameLookUpIcon);
		ProductNameLookUpIcon.click();
		switchToWindow(d, "Products");
		SearchTextField.sendKeys(PRODUCT);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + PRODUCT + "']")).click();
		switchToWindow(d, "HelpDesk");

		handleDropDown(PriorityDropDownList, PRIORITY);
		handleDropDown(StatusDropDownList, STATUS);
		handleDropDown(SeverityDropDownList, SEVERITY);
		handleDropDown(CategoryDropDownList, CATEGORY);
		DescriptionTextarea.sendKeys(DESCRIPTION);
		SaveBtn.click();
	}

	public void createNewTicketWithProduct(WebDriver d, String TITLE, String PRODUCT, String ASSIGNEDTO,
			String STATUS) {
		TitleTextarea.sendKeys(TITLE);
		if (ASSIGNEDTO.equals("user")) {
			AssignedToUserRadioButton.click();
		} else if (ASSIGNEDTO.equals("user")) {
			AssignedToGroupRadioButton.click();
		} else {
			System.out.println("Invalid action select: 'user''group'");
		}
		ProductNameLookUpIcon.click();
		switchToWindow(d, "Products");
		SearchTextField.sendKeys(PRODUCT);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + PRODUCT + "']")).click();
		switchToWindow(d, "HelpDesk");
		SaveBtn.click();
	}
}
