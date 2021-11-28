# Patronage-2022-Szczecin-Java-Nataniel-Antosik
## Opis
Jest to Rest Api do bardzo uproszczonego systemu rezerwacji miejsc parkingowych w budynku.

## Funkcjonalności
W ramach tego programu jest dostępne 4 główne Endpoint'y:
* POST - dodanie rezerwacji
* DELETE - usunięcie rezerwacji
* GET - otrzymanie wszystkich rezerwacji dla podmiotu
* GET - otrzymanie listy wszystkich wolnych miejsc

## Technologia
* Język: Java wersja 11
* IDE: IntelliJ 2021.1
* Framework: Spring Boot 2.6.0
* Narzędzie do budowy: Maven

## Endpoint
### GET - tutaj otrzymujemy wszystkie wolne miejsca
```
http://localhost:8080/api/booking/all/parking/free/space
```
### GET - tutaj otrzymujemy wszystkie rezerwacje dla podmiotu (np. dla podmiotu 'Krzysiek')
```
http://localhost:8080/api/booking/all/reservation/for/person?name=Krzysiek
```
### POST - tutaj dodajemy rezerwację wysyłamy dane w postacji JSON
```
http://localhost:8080/api/booking/add/reservation
```
#### Body w wersji JSON:
```
{
        "id": 2,
        "name": "Jan",
        "parkingSpaceId": 3
}
```
### DELETE - usuwamy daną rezerwację za pomocą odpowiedniego indeksu 
```
http://localhost:8080/api/booking/deleTe/reservation?index=1
```

## Jak zbudować aplikację?
1. Należy wykonać klon repozytorium do lokalnego urządzenia
```
 gh repo clone Nataniel-Antosik/Patronage-2022-Szczecin-Java-Nataniel-Antosik
```
2. Odpalić projekt w IntelliJ
3. W plikach znaleźć plik Application nacisnąć przycisk Run 

![image](https://user-images.githubusercontent.com/57491794/143784839-8321fe06-ea7a-4fd6-85fe-864336417349.png)

4.Wybrać opcję run application(1) 

![image](https://user-images.githubusercontent.com/57491794/143784816-825dd27f-55c6-406a-8b9f-bf0688a67528.png)
###
W tym przypadku tylko uruchamiamy aplikację, możemy ją zbudować za pomocą Maven:
1. Należy wykonać klon repozytorium do lokalnego urządzenia
```
 gh repo clone Nataniel-Antosik/Patronage-2022-Szczecin-Java-Nataniel-Antosik
```
2. W linii poleceń wchodzimy do głównego katalogu
3. Wpisujemy

```
mvn compile
mvn package
```
3. Jak skończą się już wykonywać powyższe polecenia utworzy nam się folder "Target" tam są wszystkie nowo utworzone pliki po budowaniu aplikacji.
4. Aby uruchomić program należy wpisać

```
java -jar "Ścieżka do pliku z rozszerzeniem .jar"
```
Przykład:
```
java -jar "C:\Users\Nataniel Antosik\IdeaProjects\Patronage-2022-Szczecin-Java-Nataniel-Antosik\target\parking-0.0.1-SNAPSHOT.jar"
```
Kiedy uruchomi się już nasz program wszystkie dane będą wypisywane w konsoli
![image](https://user-images.githubusercontent.com/57491794/143786276-91acf542-4b8b-4ac7-b6ca-55ece377a194.png)


Potem już można korzystać z Api, testować w aplikacji Postman lub z narzędzia Curl

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
