package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginStepDefinitions {
    private WebDriver driver;

    @Given("Użytkownik znajduje się na stronie logowania")
    public void użytkownik_znajduje_się_na_stronie_logowania() {
        // Używa WebDriverManager do automatycznego zarządzania sterownikiem ChromeDriver.
        // clearResolutionCache() czyści pamięć podręczną rozdzielczości sterowników. bez tego miałem problem z wersjia webdriver
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        // Inicjalizuje instancję przeglądarki Chrome.
        driver = new ChromeDriver();
        // Otwiera stronę logowania pod podanym adresem URL.
        driver.get("https://demo.guru99.com/V4/");
    }

    @When("Wprowadza nazwę użytkownika {string}")
    public void wprowadza_nazwę_użytkownika(String username) {
        // Znajduje pole tekstowe dla nazwy użytkownika na stronie za pomocą jego atrybutu 'name'.
        WebElement userIdField = driver.findElement(By.name("uid"));
        // Wprowadza podaną nazwę użytkownika do znalezionego pola tekstowego.
        userIdField.sendKeys(username);
    }

    @When("Wprowadza hasło {string}")
    public void wprowadza_hasło(String password) {
        // Znajduje pole tekstowe dla hasła na stronie za pomocą jego atrybutu 'name'.
        WebElement passwordField = driver.findElement(By.name("password"));
        // Wprowadza podane hasło do znalezionego pola tekstowego.
        passwordField.sendKeys(password);
    }

    @When("Naciska przycisk \"Zaloguj\"")
    public void naciska_przycisk_zaloguj() {
        // Znajduje przycisk "Zaloguj" na stronie za pomocą jego atrybutu 'name'.
        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        // Kliknięcie znalezionego przycisku "Zaloguj".
        loginButton.click();
    }

    @Then("Zostaje przekierowany na stronę główną")
    public void zostaje_przekierowany_na_stronę_główną() {
        // Asercja sprawdzająca, czy tytuł aktualnej strony jest zgodny z oczekiwanym tytułem strony głównej.
        Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
    }

    @Then("Widzi napis {string}")
    public void widzi_napis(String expectedText) {
        // Znajduje element <td> wewnątrz elementu <tr> z klasą 'heading3' na stronie głównej.
        WebElement welcomeText = driver.findElement(By.xpath("//tr[@class='heading3']/td"));
        // Asercja sprawdzająca, czy tekst znaleziony w elemencie zawiera oczekiwany napis powitania.
        Assert.assertTrue(welcomeText.getText().contains(expectedText), "Nie znaleziono tekstu: " + expectedText);
        // Zamyka przeglądarkę po pomyślnym zalogowaniu i sprawdzeniu napisu.
        driver.quit();
    }

    @Then("Widzi komunikat o błędzie {string}")
    public void widzi_komunikat_o_błędzie(String expectedErrorMessage) {
        try {
            // Przełącza kontekst WebDrivera na otwarty alert przeglądarki.
            Alert alert = driver.switchTo().alert();
            // Pobiera tekst z otwartego alertu.
            String actualErrorMessage = alert.getText();
            // Asercja sprawdzająca, czy tekst alertu jest zgodny z oczekiwanym komunikatem o błędzie.
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Tekst alertu nie zgadza się.");
            // Akceptuje (kliknięcie "OK") otwarty alert.
            alert.accept();
        } catch (NoAlertPresentException e) {
            // Obsługuje wyjątek, gdy alert nie jest obecny, a był oczekiwany.
            Assert.fail("Oczekiwano alertu, ale go nie znaleziono.");
        } finally {
            // Zamyka przeglądarkę w bloku 'finally', aby zapewnić jej zamknięcie niezależnie od wyniku testu.
            if (driver != null) {
                driver.quit();
            }
        }
    }
}