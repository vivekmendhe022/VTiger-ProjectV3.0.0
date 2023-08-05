package Assets;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.CreateNewOrganizationPage;
import object.repository.HomePage;
import object.repository.OrganizationInfoPage;
import object.repository.OrganizationsPage;
import object.repository.assets.AssetInfoPage;
import object.repository.assets.AssetsPage;
import object.repository.assets.CreateNewAssetsPage;
import object.repository.product.CreateNewProductPage;
import object.repository.product.ProductInfoPage;
import object.repository.product.ProductPage;

@Listeners(com.generic.utilities.ListenersImplementation.class)
public class CreateNewAssetTest extends BaseClass {

	@Test
	public void creatNewAssetTest() throws EncryptedDocumentException, IOException {

		int r = jutil.getRandom();

		String PRODUCT = "Hp SUXRT" + r;
		String HANDLER = "user";

		String expectedOrganisationPageTitle = putil.getPageTitleFromPropertyFile("expectedOrganisationTitile");

		String ORGNAME = eutil.readDataFromExcel("Organisation", 4, 2) + r;
		String INDUSTRY = eutil.readDataFromExcel("Organisation", 4, 3);

		HomePage hp = new HomePage(d);
		hp.clickOnProductLinkText();

		ProductPage pp = new ProductPage(d);
		pp.clickOnCreateTroubleTicketsLookUpIcon();

		CreateNewProductPage cnp = new CreateNewProductPage(d);
		cnp.createNewProduct(PRODUCT, HANDLER);

		ProductInfoPage pip = new ProductInfoPage(d);
		String headerInfo = pip.getProductHeaderInfo();
		Assert.assertTrue(headerInfo.contains(PRODUCT));

		// Click on Organisation link.
		hp.clickOnOrganizationLink();
		Assert.assertEquals(d.getTitle(), expectedOrganisationPageTitle, "Error");
		Reporter.log("Organisation link click successful", true);

		// Click on CreateOrgLookUpImg
		OrganizationsPage organizationsPage = new OrganizationsPage(d);
		organizationsPage.clickOnCreateOrgLookUpImg();
		Assert.assertEquals(d.getTitle(), expectedOrganisationPageTitle, "Error");
		Reporter.log("Create Organisation look up IMG link click successful", true);

		// Enter Orgnization name text field.
		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(d);

		// Enter Orgnization name text field & Select Chemical from drop down list.
		createNewOrganizationPage.createOrgWithIndustry(ORGNAME, INDUSTRY);
		Assert.assertEquals(createNewOrganizationPage.getORGNameTextField().getAttribute("value"), ORGNAME,
				"Error: Organisation  entered not successful");
		Assert.assertEquals(createNewOrganizationPage.getIndustryDropDownList().getAttribute("value"), INDUSTRY,
				"Error: Industry entered not successful");
		Reporter.log("Organisation & Industry entered successful", true);

		// Validate
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(d);
		String header = organizationInfoPage.getHeader();
		Assert.assertTrue(header.contains(ORGNAME));
		Reporter.log(ORGNAME + " create successfully...!", true);

		hp.clickOnAssetLinkText(d);

		AssetsPage ap = new AssetsPage(d);
		ap.clickOnCreateNewAssetLookUpImg();

		String SRNUM = "123" + r;
		String ASSETNAME = "Computers";

		CreateNewAssetsPage cnpp = new CreateNewAssetsPage(d);
		cnpp.createNewAsset(d, PRODUCT, SRNUM, ORGNAME, ASSETNAME);

		AssetInfoPage aip = new AssetInfoPage(d);
		String assetHeader = aip.getAssetInfo();
		Assert.assertTrue(assetHeader.contains(ASSETNAME));
	}
}
