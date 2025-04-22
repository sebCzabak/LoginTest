Feature: Logowanie użytkownika

  Scenario: Pomyślne logowanie użytkownika
    Given Użytkownik znajduje się na stronie logowania
    When Wprowadza nazwę użytkownika "mngr620372"
    And Wprowadza hasło "venegyg"
    And Naciska przycisk "Zaloguj"
    Then Zostaje przekierowany na stronę główną
    And Widzi napis "Manger Id : mngr620372"

  Scenario: Logowanie z nieprawidłowym hasłem
    Given Użytkownik znajduje się na stronie logowania
    When Wprowadza nazwę użytkownika "mngr620372"
    And Wprowadza hasło "zle_haslo"
    And Naciska przycisk "Zaloguj"
    Then Widzi komunikat o błędzie "User or Password is not valid"