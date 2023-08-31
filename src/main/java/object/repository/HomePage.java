package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorLookUpImg;

	@FindBy(linkText = "Sign Out")
	private WebElement LogoutLink;

	@FindBy(linkText = "Organizations")
	private WebElement Organizations;

	@FindBy(linkText = "Contacts")
	private WebElement ContactLink;

	@FindBy(linkText = "Leads")
	private WebElement LeadsLink;

	@FindBy(linkText = "Opportunities")
	private WebElement Opportunities;

	@FindBy(xpath = "//a[@href='javascript:;'][normalize-space()='More']")
	private WebElement More;

	@FindBy(linkText = "Campaigns")
	private WebElement CampaingsLinkText;

	@FindBy(linkText = "Documents")
	private WebElement DocumentsLinkText;

	@FindBy(linkText = "Trouble Tickets")
	private WebElement TroubleTicketsLinkText;

	@FindBy(linkText = "Products")
	private WebElement ProductLinkText;

	@FindBy(linkText = "Invoice")
	private WebElement InvoiceLinkText;

	@FindBy(linkText = "Sales Order")
	private WebElement SalesOrderLinkText;

	@FindBy(linkText = "Services")
	private WebElement ServicesLinkText;

	@FindBy(linkText = "Assets")
	private WebElement AssetLinkText;

	@FindBy(linkText = "Purchase Order")
	private WebElement PurchaseOrderLinkText;

	@FindBy(linkText = "Price Books")
	private WebElement PriceBooksLinkText;

	@FindBy(linkText = "Vendors")
	private WebElement VendorsLinkText;

	@FindBy(linkText = "Service Contracts")
	private WebElement ServiceContractsLinkText;

	@FindBy(linkText = "Project Milestones")
	private WebElement ProjectMilestonesLinkText;

	@FindBy(linkText = "Project Tasks")
	private WebElement ProjectTaskLinkText;

	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getOrganizations() {
		return Organizations;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getAdministratorLookUpImg() {
		return AdministratorLookUpImg;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getOpportunities() {
		return Opportunities;
	}

	public WebElement getMore() {
		return More;
	}

	public WebElement getCampaingsLinkText() {
		return CampaingsLinkText;
	}

	public WebElement getDocumentsLinkText() {
		return DocumentsLinkText;
	}

	public WebElement getTroubleTicketsLinkText() {
		return TroubleTicketsLinkText;
	}

	public WebElement getProductLinkText() {
		return ProductLinkText;
	}

	public WebElement getInvoiceLinkText() {
		return InvoiceLinkText;
	}

	public WebElement getSalesOrderLinkText() {
		return SalesOrderLinkText;
	}

	public WebElement getVendorsLinkText() {
		return VendorsLinkText;
	}

	public WebElement getServiceContractsLinkText() {
		return ServiceContractsLinkText;
	}

	public WebElement getProjectMilestonesLinkText() {
		return ProjectMilestonesLinkText;
	}

	public WebElement getProjectTaskLinkText() {
		return ProjectTaskLinkText;
	}

	public void clickOnOrganizationLink() {
		Organizations.click();
	}

	public void clickOnContactLink() {
		ContactLink.click();
	}

	public void logoutToApplication(WebDriver d) {
		mouseHoverAction(d, AdministratorLookUpImg);
	}

	public void clickOnLeadsLink() {
		LeadsLink.click();
	}

	public void clickOnOpportunitiesLink() {
		Opportunities.click();
	}

	public void hoverOnMore(WebDriver d) {
		mouseHoverAction(d, More);
	}

	public WebElement getServicesLinkText() {
		return ServicesLinkText;
	}

	public WebElement getAssetLinkText() {
		return AssetLinkText;
	}

	public WebElement getPurchaseOrderLinkText() {
		return PurchaseOrderLinkText;
	}

	public WebElement getPriceBooksLinkText() {
		return PriceBooksLinkText;
	}

	public void clickOnCampaingsLinkText() {
		CampaingsLinkText.click();
	}

	public void clickOnDocumentsLinkText() {
		DocumentsLinkText.click();
	}

	public void clickOnTroubleTicketsLinkText() {
		TroubleTicketsLinkText.click();
	}

	public void clickOnProductLinkText() {
		ProductLinkText.click();
	}

	public void clickOnInvoiceLinkText(WebDriver d) {
		hoverOnMore(d);
		InvoiceLinkText.click();
	}

	public void clickOnSalesOrderLinkText(WebDriver d) {
		hoverOnMore(d);
		SalesOrderLinkText.click();
	}

	public void clickOnServicesLinkText(WebDriver d) {
		hoverOnMore(d);
		ServicesLinkText.click();
	}

	public void clickOnAssetLinkText(WebDriver d) {
		hoverOnMore(d);
		AssetLinkText.click();
	}

	public void clickOnPurchaseOrderLinkText(WebDriver d) {
		hoverOnMore(d);
		PurchaseOrderLinkText.click();
	}

	public void clickOnPriceBooksLinkText(WebDriver d) {
		hoverOnMore(d);
		PriceBooksLinkText.click();
	}

	public void clickOnVendorsLinkText(WebDriver d) {
		hoverOnMore(d);
		VendorsLinkText.click();
	}

	public void clickOnServiceContractsLinkText(WebDriver d) {
		hoverOnMore(d);
		ServiceContractsLinkText.click();
	}

	public void clickOnProjectMilestonesLinkText(WebDriver d) {
		hoverOnMore(d);
		ProjectMilestonesLinkText.click();
	}

	public void clickOnProjectTaskLinkText(WebDriver d) {
		hoverOnMore(d);
		ProjectTaskLinkText.click();
	}

}
