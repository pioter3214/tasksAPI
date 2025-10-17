# tasksAPI - Prosta aplikacja REST API w Spring Boot
# Opis projektu
tasksAPI to prosty projekt backendowy stworzony w Javie 17 z użyciem Spring Boot, który umożliwia zarządzanie zadaniami (CRUD) poprzez REST API. Aplikacja obsługuje podstawowe operacje na zadaniach takie jak dodawanie, usuwanie, aktualizacja oraz filtrowanie po statusie i terminie wykonania.

# Technologie
Java 17

Spring Boot 3

Spring Data JPA (Hibernate)

MySQL jako baza danych

RESTful API

Mockito i Spring Boot Test do testów jednostkowych

OpenAPI (Swagger) do dokumentacji API

# Funkcjonalności
Lista wszystkich zadań

Pobieranie zadania po ID

Dodawanie nowych zadań

Aktualizacja istniejących zadań

Usuwanie zadań

Filtrowanie zadań po statusie (TODO, IN_PROGRESS, DONE)

Filtrowanie zadań po dacie wykonania

# Uruchomienie lokalne
1. Skonfiguruj bazę danych MySQL i ustaw dane połączenia w application.properties (np. URL, użytkownik, hasło).
2. Sklonuj repozytorium.
3. Uruchom aplikację przy pomocy Mavena:

bash:
```mvn spring-boot:run```

4. API będzie dostępne pod adresem http://localhost:8080/tasks

# Testy
Projekt zawiera podstawowe testy jednostkowe serwisu z wykorzystaniem Mockito.
Aby uruchomić testy:

bash:
```mvn test```

# Kolekcja postman
https://piotr-michalak312-6301147.postman.co/workspace/Piotr-Michalak's-Workspace~422a8320-14ac-4da2-8d96-2f2b8e8a6a2b/collection/49349310-b51e7866-8f3d-40ac-a4b1-cabd72c1cd44?action=share&source=copy-link&creator=49349310

# Dokumentacja API
Interaktywną dokumentację API można znaleźć pod adresem:
http://localhost:8080/swagger-ui.html

# Możliwe rozszerzenia
Rozbudowanie testów jednostkowych i integracyjnych

Dodanie autoryzacji i uwierzytelniania

Obsługa bardziej zaawansowanych zapytań i paginacji

Dodanie frontendowej warstwy UI
