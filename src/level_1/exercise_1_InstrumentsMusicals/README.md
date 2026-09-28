# Exercici 1 – Instruments musicals
**Descripció**: Treballar l'herència, polimorfisme, blocs estàtics i no estàtics.

##  Enunciat de l'exercici 
Estem dissenyant un programa per gestionar instruments musicals d’un grup de música. En aquest grup, hi ha tres tipus d’instruments:

    Instruments de vent
    Instruments de corda
    Instruments de percussió

Tots aquests instruments tenen dues característiques en comú: un nom i un preu. A més, tots poden tocar-se, però ho fan de maneres diferents.

## 🛠 Tecnologies
- Backend: Java

##  Instal·lació i Execució
1. Clonar el repositori: `git clone ...`
2. Execució de l'aplicació.
3. Proves: Executar el `Main()`.
## 📌 Anotacions
- Els atributs "static" i "final" SI es poden inicialitzar en el constructor.

- Els atributs "static" o de clase comparteixen la mateixa adreça de memòria per totes les instàncies. Els "final" tenen la funcionalitat del fet que el valor no es pot canviar una vegada assignat.

- El cas especial de "static" "final" és que s'inicialitza amb la primera instància de la classe i a més no es pot canviar la seva assignació una vegada assignat. Tampoc s'hi pot inicialitzar en el constructor. Per tant, cal fer-ho en els fields de la declaració de la variable "static" "final".

```java
public class SampleBlockClass {
    // - Static Initialization Blocks
    // - Static Initialization Methods
    // - Non-Static Initialization Blocks
    // - Non-Static Initialization Methods (Preferably final methods)

    public static String myVarA;
    public String myVarB = myVarNonStaticInitialization();

    @Override
    public String toString() {
        return "SampleBlockClass{" +
                "myVarA='" + myVarA + '\'' +
                "myVarB='" + myVarB + '\'' +
                '}';
    }

    // Can have any number of static initialization blocks, and they can appear anywhere in the class body
    static {
        myVarA = "myStaticVarA";
    }

    // This is especially useful if subclasses might want to reuse the initialization method.
    // The method is final because calling non-final methods during instance initialization can cause problems.
    protected final String myVarNonStaticInitialization(){
        return "myNonStaticVar";
    }
}