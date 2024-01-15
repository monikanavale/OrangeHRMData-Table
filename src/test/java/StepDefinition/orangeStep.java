package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class orangeStep extends BaseClass{
	static LoginPage loginPage;
	static String empid;

	@Given("user is on Login Page")
	public void user_is_on_login_page() {
       BaseClass.initialization();
		

	}

	@When("user enter valid credentails")
	public void user_enter_valid_credentails(DataTable dataTable) {
		List<List<String>> ls = dataTable.asLists();
		String uname = ls.get(0).get(0);
		String pass = ls.get(0).get(1);

		 loginPage = new LoginPage();
		loginPage.enterUsernameAndPassword(uname, pass);
		

	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLoginButton();

	}

	@When("user is on home page validate home page title")
	public void user_is_on_home_page_validate_home_page_title(DataTable dataTable) {
		String title = dataTable.asLists().get(0).get(0);
		String homeTitle = driver.getTitle();
		Assert.assertEquals(homeTitle, title);

	}

	@When("user validate home page url")
	public void user_validate_home_page_url() {
		String url = driver.getCurrentUrl();
		boolean abc = url.contains("orange");
		Assert.assertEquals(abc, true);
	}

	@When("user validate home page logo")
	public void user_validate_home_page_logo(DataTable dataTable) {
		String abc = dataTable.asLists().get(0).get(0);

		boolean xyz = Boolean.parseBoolean(abc);
		boolean Logo = driver.findElement(By.xpath("//div[@class='oxd-brand-banner']")).isDisplayed();
		Assert.assertEquals(Logo, xyz);

	}

	@When("user click on pim page link")
	public void user_click_on_pim_page_link() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();

	}

	@When("user validate user is on pim page by using url")
	public void user_validate_user_is_on_pim_page_by_using_url(DataTable dataTable) throws InterruptedException {
		String pim = dataTable.asLists().get(0).get(0);
		Thread.sleep(5000);
		String url = driver.getCurrentUrl();
		boolean a = url.contains(pim);
		Assert.assertEquals(a, true);

	}

	@When("user click add employee and enter firstname, lastname and click on save button")
	public void user_click_add_employee_and_enter_firstname_lastname_and_click_on_save_button(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		List<List<String>> ls = dataTable.asLists();

		for (int i = 0; i < ls.size(); i++) {
			driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
			String firstname = ls.get(i).get(0);
			String lastname = ls.get(i).get(1);
			Thread.sleep(5000);
			driver.findElement(By.name("firstName")).sendKeys(firstname);
			driver.findElement(By.name("lastName")).sendKeys(lastname);
			driver.findElement(By.xpath("//button[text()=' Save '] ")).click();
			Thread.sleep(5000);

		}

	}

	@When("user capture employee id number and user click on employeelist")
	public void user_capture_employee_id_number_and_user_click_on_employeelist() {
		empid = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]"))
				.getAttribute("value");
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();

	}

	@When("user enter employee id is employee id text  box and click on search button")
	public void user_enter_employee_id_is_employee_id_text_box_and_click_on_search_button() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]")).sendKeys(empid);
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		Thread.sleep(5000);
	}

	@When("user selected searched employee and click on delete")
	public void user_selected_searched_employee_and_click_on_delete() throws InterruptedException {
		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[2]")).click();
		
		driver.findElement(By.xpath("//button[text()=' Delete Selected ']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
			
	}

	@Then("validate employee is deleted or not")
	public void validate_employee_is_deleted_or_not() throws InterruptedException {
		driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]")).sendKeys(empid);
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		Thread.sleep(5000);
		String norecords = driver.findElement(By.xpath("//span[text()='No Records Found']")).getText();

		Assert.assertEquals(norecords, "No Records Found");

	}

	@When("user click on profile and click on logout button")
	public void user_click_on_profile_and_click_on_logout_button() {

		driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

}
