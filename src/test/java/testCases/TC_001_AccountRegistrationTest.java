package testCases;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.AccountRegistrationPage;
import testBase.BaseClass;
public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups= {"Regression","Master"})
	void test_account_Registration()
	{
		logger.debug("applocation logs......"); //captures client server communication
		logger.info("*****Staring TC_001_AccountRegistrationTest*****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account link");
		
		hp.clickRegister();
		logger.info("clicked on register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("providing customer data");
		
        regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		//regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		
		regpage.setSubscribeYes();
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("clicked on continue button");
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","not getting expected message");
		}
		
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		
		logger.info("finished TC_001_AccountRegistrationTest");
	}
	
	

}
