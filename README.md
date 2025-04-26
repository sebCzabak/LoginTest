# Automatyczne Testy Logowania dla Internet Banking Project

Ten projekt zawiera automatyczne testy logowania dla demonstracyjnej aplikacji bankowości internetowej dostępnej pod adresem [https://demo.guru99.com/V4/](https://demo.guru99.com/V4/). Testy zostały napisane przy użyciu języka Gherkin, frameworka TestNG oraz biblioteki Selenium WebDriver.

## Technologie Użyte

* **Język:** Java
* **Framework Testowy:** TestNG
* **Biblioteka do Automatyzacji Przeglądarki:** Selenium WebDriver
* **Język Opisu Testów:** Gherkin
* **Integracja Gherkin z Javą:** Cucumber
* **Zarządzanie Zależnościami:** Maven
* **Zarządzanie Sterownikami Przeglądarek:** WebDriverManager


* `src/test/resources/features/login.feature`: Zawiera scenariusze testowe logowania opisane w języku Gherkin.
* `src/test/java/steps/LoginStepDefinitions.java`: Zawiera implementację kroków testowych w języku Java z wykorzystaniem Selenium WebDriver.
* `src/test/java/runner/TestRunner.java`: Konfiguruje Cucumbera i TestNG do uruchamiania testów.
* `pom.xml`: Plik konfiguracyjny Maven zawierający zależności projektu.

## Scenariusze Testowe

Projekt zawiera następujące scenariusze testowe:

1.  **Pomyślne logowanie użytkownika:**
    * Sprawdza, czy użytkownik po wprowadzeniu prawidłowych danych logowania jest przekierowywany na stronę główną i widzi odpowiedni napis powitania.
2.  **Nieudane logowanie:**
    * Sprawdza, czy użytkownik po wprowadzeniu poprawnej nazwy użytkownika i niepoprawnego hasła otrzymuje komunikat o błędzie.

## Jak Uruchomić Testy

1.  **Wymagania:**
    * Zainstalowane JDK (Java Development Kit)
    * Zainstalowany Maven
    * Przeglądarka Google Chrome (sterownik ChromeDriver jest zarządzany automatycznie przez WebDriverManager)

2.  **Klonowanie Repozytorium:**
    ```bash
    git clone [https://github.com/sebCzabak/LoginTest]
    cd LoginTest
    ```

3.  **Uruchomienie Testów:**
    Testy można uruchomić bezpośrednio z IDE (np. IntelliJ IDEA, uruchamiając klasę `TestRunner.java`) lub za pomocą polecenia Maven w terminalu:
    ```bash
    mvn test
    ```

4.  **Raporty z Testów:**
    Po uruchomieniu testów raport HTML zostanie wygenerowany w folderze `target/cucumber-reports/report.html`. Otwórz ten plik w przeglądarce, aby zobaczyć szczegółowe wyniki testów.

## Dodatkowe Informacje

* Dane do logowania użyte w testach (User ID: `mngr620372`, Password: `venegyg`) są danymi demonstracyjnymi dostarczonymi przez serwis i mogą ulec zmianie. W razie potrzeby należy skorzystać z opcji "Generate Access" na stronie głównej aplikacji, aby uzyskać aktualne dane.
* Kod został napisany z dbałością o czytelność i zawiera komentarze wyjaśniające każdy krok implementacji.


