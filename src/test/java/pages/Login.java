package pages;

import config.env_target;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends env_target {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");

    @When("User fills the valid phone number and password")
    public void userFillsValidPhoneNumberAndPassword(){
        clickButtonId("email");
        setEmail(""); //add your own email
        clickButtonId("password");
        setPassword(""); //add your own password
    }

    @When("User fills the valid email and password")
    public void userFillsValidEmailAndPassword(){
        clickButtonId("email");
        setEmail(""); //add your own email
        clickButtonId("password");
        setPassword(""); //add your own password
    }

    @When("User fills with invalid credentials")
    public void userFillsInvalidCredentials(){
        clickButtonId("email");
        setEmail("arfandi@test.com"); //add your own email
        clickButtonId("password");
        setPassword("test12345"); //add your own password
    }

    @Then("User got login error message")
    public void userGotLoginErrorMessage(){
        waitVisibleId(10, "alert_description");
        tearDown();
    }

    private void waitVisibleId(int seconds, String idElement) {
        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(idElement))
        );
    }
    private void clickButtonId(String idButton){
        WebElement button = driver.findElement(By.id(idButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();
    }
    private void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    private void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    private void tearDown(){
        driver.quit();
    }
}
