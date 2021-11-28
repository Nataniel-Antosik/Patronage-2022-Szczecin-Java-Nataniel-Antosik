# Patronage-2022-Szczecin-Java-Nataniel-Antosik
## Opis
Jest to Rest Api do bardzo uproszczonego systemu rezerwacji miejsc parkingowych w budynku.

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
