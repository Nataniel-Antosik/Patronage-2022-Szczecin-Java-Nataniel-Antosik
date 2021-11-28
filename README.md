# Patronage-2022-Szczecin-Java-Nataniel-Antosik
## Opis
Jest to Rest Api do bardzo uproszczonego systemu rezerwacji miejsc parkingowych w budynku.

## Funkcjonalności
W ramach tego programu jest dostępne 4 główne Endpoint'y oraz 1 dodatkowy:
* POST - dodanie rezerwacji
* DELETE - usunięcie rezerwacji
* GET - otrzymanie wszystkich rezerwacji dla podmiotu
* GET - otrzymanie listy wszystkich wolnych miejsc

## Technologia
* Język: Java wersja 11
* IDE: IntelliJ 2021.1
* Framework: Spring Boot 2.6.0
* Narzędzie do budowy: Maven

## Jak zbudować aplikację?
1. Należy wykonać klon repozytorium swój komputer gh repo clone Nataniel-Antosik/Patronage-2022-Szczecin-Java-Nataniel-Antosik
2. Odpalić projekt w IntelliJ
3. W plikach znaleźć plik Application nacisnąć przycisk Run 

![image](https://user-images.githubusercontent.com/57491794/143784839-8321fe06-ea7a-4fd6-85fe-864336417349.png)

4.Wybrać opcję run application(1) 

![image](https://user-images.githubusercontent.com/57491794/143784816-825dd27f-55c6-406a-8b9f-bf0688a67528.png)

Potem już można korzystać z Api testować w aplikacji Postman lub z narzędzia Curl


## Korzystanie z narzędzia Curl 

### 
Dodawanie rezerwacji
```
curl -X POST http://localhost:8080/api/booking/add/reservation
   -H "Content-Type: application/json"
   -d '{"id":1, "name": "Jan", "parkingSpaceId":9}' 
```
### 
Usuwanie rezerwacji
```
curl -X DELETE http://localhost:8080/api/booking/deleTe/reservation?index=1
	-H "Content-Type: application/json" 
```
### 
Wypisać wszystkie rezerwacje dla podmiotu
```
curl -X GET http://localhost:8080/api/booking/all/reservation/for/person?name=Jan
	-H "Content-Type: application/json" 
```
### 
Wypisać listę wolnych miejsc
```
curl -X GET http://localhost:8080/api/booking/all/parking/free/space
	-H "Content-Type: application/json" 
```
