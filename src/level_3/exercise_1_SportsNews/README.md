# Exercici 1 – Redacció de notícies esportives
**Descripció**: Treballar els conceptes d’herència, atributs estàtics i finals, polimorfisme, i la gestió d’objectes relacionats entre si. També  estructures de dades i l'ús de la consola per construir una petita aplicació interactiva amb menú

##  Enunciat de l'exercici 
Estàs dissenyant un sistema per a una redacció de notícies esportives. Les notícies estan classificades segons l’esport al qual fan referència: futbol, bàsquet, tenis, F1 i motociclisme.

A la redacció hi poden treballar diversos redactors. De cada redactor cal guardar el nom, el DNI i el sou. Tingues en compte:

    El DNI no pot canviar un cop assignat (ha de ser immutable).
    Tots els redactors tenen el mateix sou, que actualment és de 1500 €. Si l’empresa decideix apujar-lo, ho farà per a tots a la vegada (atribut comú).

Cada redactor pot escriure múltiples notícies. Tota notícia ha de tenir un titular, un text (que estarà buit quan es crea), una puntuació i un preu.

Cada tipus de notícia conté informació específica segons l’esport:

    Futbol: competició, club i jugador.
    Bàsquet: competició i club.
    Tenis: competició i tenistes.
    F1: escuderia.
    Motociclisme: equip.


Càlcul del preu de la notícia

Implementa un mètode calcularPreuNoticia() a cada tipus de notícia, tenint en compte les regles següents:

Futbol

    Preu base: 300 €
    +100 € si és “Lliga de Campions”
    +100 € si parla de Barça o Madrid
    +50 € si esmenta Ferran Torres o Benzema

Bàsquet

    Preu base: 250 €
    +75 € si és Eurolliga
    +75 € si parla de Barça o Madrid

Tenis

    Preu base: 150 €
    +100 € si apareix Federer, Nadal o Djokovic

F1

    Preu base: 100 €
    +50 € si l’escuderia és Ferrari o Mercedes

Motociclisme

    Preu base: 100 €
    +50 € si l’equip és Honda o Yamaha


Càlcul de la puntuació

Crea un mètode calcularPuntuacio() per calcular la puntuació de cada notícia segons:

Futbol

    5 punts base
    +3 punts si és “Lliga de Campions”
    +2 punts si és “Lliga”
    +1 punt si és Barça o Madrid
    +1 punt si esmenta Ferran Torres o Benzema

Bàsquet

    4 punts base
    +3 punts si és Eurolliga
    +2 punts si és ACB
    +1 punt si és Barça o Madrid

Tenis

    4 punts base
    +3 punts si apareix Federer, Nadal o Djokovic

F1

    4 punts base
    +2 punts si és Ferrari o Mercedes

Motociclisme

    3 punts base
    +3 punts si és Honda o Yamaha


Aplicació amb menú

A la classe principal del teu programa implementa un menú per consola amb les següents opcions:

    Introduir redactor
    Eliminar redactor
    Introduir notícia a un redactor
    Eliminar notícia (cal demanar el redactor i el titular de la notícia)
    Mostrar totes les notícies d’un redactor
    Calcular puntuació d’una notícia
    Calcular preu d’una notícia

## 🛠 Tecnologies
- Backend: Java

##  Instal·lació i Execució
1. Clonar el repositori: `git clone ...`
2. Execució de l'aplicació.
3. Proves: Executar el `Main()`.
