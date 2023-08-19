package Vendors;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.vendor.CreateNewVendorPage;
import object.repository.vendor.VendorInfoPage;
import object.repository.vendor.VendorsPage;

public class CreateNewVendorsTest extends BaseClass {

	@Test
	public void createNewVendorsTest() {

		String vendorName = "TestVendor123";
		String email = "testvendor123@example.com";
		String phone = "123-456-7890";
		String glAccount = "304-Sales-Software-Support";
		String website = "www.testvendor123.com";
		String category = "Software";
		String street = "123 Test St";
		String poBox = "PO Box 123";
		String city = "TestCity";
		String state = "TestState";
		String postalCode = "12345";
		String country = "Testland";
		String description = "This is a test vendor for automation testing.";

		HomePage hp = new HomePage(d);
		hp.clickOnVendorsLinkText(d);

		VendorsPage vp = new VendorsPage(d);
		vp.clickOnCreateNewVendorsLookUpImg();

		CreateNewVendorPage cnvp = new CreateNewVendorPage(d);
		cnvp.createNewVendor(vendorName, email, phone, glAccount, website, category, street, poBox, city, state,
				postalCode, country, description);

		VendorInfoPage vip = new VendorInfoPage(d);
		String vheader = vip.getVendorHeaderInfo();
		Assert.assertTrue(vheader.contains(vendorName));
	}
}
