package ServiceContracts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.servceContract.CreateNewSericeContractPage;
import object.repository.servceContract.ServiceContractInfoPage;
import object.repository.servceContract.ServiceContractPage;

public class CreateNewServiceContractsTest extends BaseClass {

	@Test
	public void createNewServiceContractsTest() {

		String Subject = "Hp Driver";
		String Status = "In Planning";
		String Priority = "Normal";

		HomePage hp = new HomePage(d);
		hp.clickOnServiceContractsLinkText(d);

		ServiceContractPage scp = new ServiceContractPage(d);
		scp.clickOnServiceContractLookUpImg();

		CreateNewSericeContractPage cnscp = new CreateNewSericeContractPage(d);
		cnscp.createNewSericeContract(Subject, Status, Priority);

		ServiceContractInfoPage scip = new ServiceContractInfoPage(d);
		String header = scip.getServiceContractHeaderInfo();
		Assert.assertTrue(header.contains(Subject));

	}
}
