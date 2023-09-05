package pages;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration extends env_target {

    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By passwordField = By.id("password");
    private By otpField = By.className("verification-otp");

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("User clicks masuk button")
    public void userClicksMasukButton() {
        clickButtonClass("section-splash");
        waitInvisibleClass(3, "section-splash");
        waitClickable(10, "button_signin_home");
        clickButtonId("button_signin_home");
    }

    @Then("User is being redirected to login page")
    public void userIsBeingRedirectedToLoginPage() {
        waitVisibleId(5, "email");
    }

    @When("User clicks daftar link text")
    public void userClicksDaftarLinkText() {
        waitClickable(10, "redirect_register");
        clickButtonId("redirect_register");
    }

    @Then("User is being redirected to registration page")
    public void userIsBeingRedirectedToRegistrationPage() {
        waitVisibleId(10, "name");
    }

    @When("User fills the registration form with valid data")
    public void userFillsTheRegistrationFormWithValidData() {
        clickButtonId("name");
        setName(""); //add your own name
        clickButtonId("email");
        setEmail(""); // add your own email
        clickButtonId("phone");
        setPhoneNumber(""); //add your own number
        clickButtonId("password");
        setPassword(""); //set your own password
        clickButtonId("checkbox");
    }

    @And("User clicks daftar button")
    public void userClicksDaftarButton() {
        clickButtonId("submit");
    }

    @Then("User is being redirected to verification page")
    public void userIsBeingRedirectedToVerificationPage() {
        waitVisibleId(15, "wording_verification");
    }

    @When("User fills the verification kode")
    public void userFillsTheVerificationKode() {
        setOtp(""); //add your own OTP verification
    }

    @And("User click next button")
    public void userClickNextButton() {
        clickButtonId("submit-otp");
    }

    @Then("User is being redirected to registration successful")
    public void userIsBeingRedirectedToRegistrationSuccessful() {
        waitVisibleXpath(15, "//*[contains(text(),'Selamat akun')]");
    }

    @And("User is being redirected to homepage")
    public void userIsBeingRedirectedToHomepage() {
        waitVisibleXpath(15, "//*[@id=\"product_type_0\"]");
        tearDown();
    }

    @When("User fills the registration form with invalid email")
    public void userFillsTheRegistrationFormWithInvalidEmail() {
        clickButtonId("name");
        setName("Arfandi Ahmad");
        clickButtonId("email");
        setEmail("arfandiahmad@test.com"); //using fake email
        clickButtonId("phone");
        setPhoneNumber("080000000"); //using fake phone number
        clickButtonId("password");
        setPassword("test12345");
        clickButtonId("checkbox");
    }

    @Then("User got email invalid message")
    public void userGotEmailInvalidMessage() {
        waitVisibleXpath(10, "//*[contains(text(),'Email tidak valid')]");
        tearDown();
    }

    @When("User fills the registration form with invalid phone number")
    public void userFillsTheRegistrationFormWithInvalidPhoneNumber() {
        clickButtonId("name");
        setName("Arfandi Ahmad");
        clickButtonId("email");
        setEmail("arfandi10@gmail.com"); //using real email
        clickButtonId("phone");
        setPhoneNumber("080000000000"); //using fake phone number
        clickButtonId("password");
        setPassword("test12345");
        clickButtonId("checkbox");
    }

    @Then("User got phone number invalid message")
    public void userGotPhoneNumberInvalidMessage() {
        waitVisibleXpath(10, "//*[contains(text(),'Nomor tidak valid')]");
        tearDown();
    }

    @When("User fills the registration form with password less than eight characters")
    public void userFillsTheRegistrationFormWithPasswordLessThanEightCharacters() {
        clickButtonId("name");
        setName("Arfandi Ahmad");
        clickButtonId("email");
        setEmail("arfandi10@gmail.com"); //using real email
        clickButtonId("phone");
        setPhoneNumber("081311113333"); //using real phone number
        clickButtonId("password");
        setPassword("test12"); //password less than 8 characters
        clickButtonId("checkbox");
    }

    @Then("User got password must at least eight characters message")
    public void userGotPasswordMustAtLeastEightCharactersMessage() {
        waitVisibleXpath(10, "//*[contains(text(),'at least 8 characters')]");
        tearDown();
    }

    @When("User fills the registration form with already registered email")
    public void userFillsTheRegistrationFormWithAlreadyRegisteredEmail() {
        clickButtonId("name");
        setName("Arfandi Ahmad");
        clickButtonId("email");
        setEmail("arfandiahmad2@gmail.com"); //using existing email
        clickButtonId("phone");
        setPhoneNumber("081311113333");
        clickButtonId("password");
        setPassword("test12345");
        clickButtonId("checkbox");
    }

    @Then("User got email already exists message")
    public void userGotEmailAlreadyExistsMessage() {
        waitVisibleXpath(10, "//*[contains(text(),'user with this email')]");
        tearDown();
    }

    @When("User fills the registration form with already registered phone number")
    public void userFillsTheRegistrationFormWithAlreadyRegisteredPhoneNumber() {
        clickButtonId("name");
        setName("Arfandi Ahmad");
        clickButtonId("email");
        setEmail("arfandiahmad2@gmail.com"); //using existing email
        clickButtonId("phone");
        setPhoneNumber("082311953143"); //using existing number
        clickButtonId("password");
        setPassword("test12345");
        clickButtonId("checkbox");
    }

    @Then("User got phone number already exists message")
    public void userGotPhoneNumberAlreadyExistsMessage() {
        waitVisibleXpath(10, "//*[contains(text(),'user with this email')]");
        tearDown();
    }

    private void clickButtonId(String idButton){
        WebElement button = driver.findElement(By.id(idButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();
    }

    private void clickButtonClass(String classButton){
        WebElement button = driver.findElement(By.className(classButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();
    }

    private void clickButtonXpath(String xpathButton){
        WebElement button = driver.findElement(By.xpath(xpathButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();;
    }

    private void waitClickable(int seconds, String idElement) {
        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.elementToBeClickable(By.id(idElement))
        );
    }

    private void waitVisibleId(int seconds, String idElement) {
        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(idElement))
        );
    }

    private void waitVisibleXpath(int seconds, String xpathElement) {
        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathElement))
        );
    }

    private void waitInvisibleClass(int seconds, String classElement) {
        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.className(classElement))
        );
    }

    private void setName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    private void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    private void setPhoneNumber(String phoneNumber){
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    private void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    private void setOtp(String OTP){
        driver.findElement(otpField).sendKeys(OTP);
    }

    private void tearDown(){
        driver.quit();
    }

}
