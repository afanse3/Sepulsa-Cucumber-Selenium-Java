package pages;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Payment extends env_target {

    private By emailField = By.id("guest_email");


    @When("User fills email")
    public void userFillsEmail(){
        setEmail("arfandiahmad2@gmail.com"); //set your real email
    }
    @And("User selects Gopay payment method")
    public void userSelectsGopayPaymentMethod(){
        clickButtonId("checkbox Gopay");
    }
    @And("User clicks Bayar Sekarang button")
    public void userClicksBayarSekarangButton(){
        clickButtonId("submit_payment");
    }
    @Then("User is being redirected to Pay with Gopay page")
    public void userIsBeingRedirectedToPayWithGopayPage(){
        waitVisibleClass(10, "gopay-qrcode");
        tearDown();
    }

    @When("User fills with invalid email")
    public void userFillsWithInvalidEmail(){
        setEmail("arfandi@test.com"); //using fake email
    }

    @When("User fills with valid email and invalid phone number")
    public void userFillsWithValidEmailAndInvalidPhoneNumber(){
        setEmail("arfandiahmad2@gmail.com"); //use your real email
        clickButtonId("");
    }

    @Then("User got guest email invalid message")
    public void userGotGuestEmailInvalidMessage(){
        waitVisibleXpath(5, "//*[contains(text(),'Tolong isi dengan email')]");
        tearDown();
    }

    @Then("User got guest phone number invalid message")
    public void userGotGuestPhoneNumberInvalidMessage(){
        waitVisibleXpath(5, "//*[contains(text(),'Tolong isi dengan nomor')]");
        tearDown();
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    private void clickButtonId(String idButton){
        WebElement button = driver.findElement(By.id(idButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();
    }

    private void waitVisibleClass(int seconds, String classElement) {
        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className(classElement))
        );
    }

    private void waitVisibleXpath(int seconds, String xpathElement) {
        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathElement))
        );
    }

    private void tearDown(){
        driver.quit();
    }

}
