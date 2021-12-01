import java.util.Scanner;
import java.util.InputMismatchException;
 
public class Streichholzspiel {
    public static void main(String[] args) {
    	
        int rest = 0; //Rest der Streichh�lzer, die noch im Spiel sind
        Scanner eingabe = new Scanner(System.in);
        
        try {
           do {
        	   System.out.println("Mit wie vielen Streichh�lzern wird gespielt?");
        	   rest = eingabe.nextInt();
        	   if (rest <= 0) {
        		   System.out.println("Fehler: Es muss mindestens 1 Streichholz da sein.");
        	   }
           } while (rest <= 0);
                  
           boolean cpuIstDran = true;
           
         //Startspieler wird so bestimmt, dass der Computer immer gewinnt
           if (rest % 4 == 0) { 
        	   cpuIstDran = false;
        	   System.out.println("Der Spieler f�ngt an!");
           } else {
        	   System.out.println("Der Computer f�ngt an!");
           }
        	   
           //Spiel beginnt
           do {
        		if (cpuIstDran) {
        			rest = CPUZug(rest);
        			cpuIstDran = false;
        		} else {
        			rest = SpielerZug(rest);
        			cpuIstDran = true;
        		}
        		System.out.println("Noch �brige Streichh�lzer: " + rest);
        	} while (rest > 0);

           eingabe.close(); 
           
           //Ergebnis
           if (cpuIstDran) {
        	 //Existiert um Absturz bei Fehler zu verhindern
        	   System.out.println("Der Spieler hat gewonnen! Da ist etwas schiefgelaufen..."); 
           } else {
        	   System.out.println("Der Computer hat gewonnen! Spiel ist beendet."); 
           }
        }
        catch (InputMismatchException e) {
        	System.out.println("Fehler: Bitte nur Zahlen eingeben. Spiel wird beendet."); 
        } 
    }
   
static int CPUZug(int strAnzahl) {
	
	int abziehAnzahl = strAnzahl % 4;
	
	if (abziehAnzahl == 0) {
		//Existiert um Absturz bei Fehler zu verhindern
		System.out.println("Fehler: Unm�gliche Situation ist aufgetreten. Bitte erneut versuchen.");
		System.exit(0); 
	}
	
	System.out.println("Computerzug: Vom Computer entfernte Streichh�lzer: " + abziehAnzahl);
	
	return strAnzahl - abziehAnzahl;
    }

static int SpielerZug(int strAnzahl) {
	
    int abziehAnzahl = 0;
    
    Scanner eingabe = new Scanner(System.in);
    while (4 <= abziehAnzahl || abziehAnzahl <= 0) {
 	   System.out.println("Spielerzug: Wie viele Streichh�lzer sollen entfernt werden?");
 	   abziehAnzahl = eingabe.nextInt();
 	   System.out.println(abziehAnzahl);
 	   
 	   if (4 <= abziehAnzahl || abziehAnzahl <= 0) {
 		   System.out.println("Fehler: Es m�ssen 1-3 Streichh�lzer entfernt werden.");
 	   }
    } 
    
	if (strAnzahl == 4) {
		eingabe.close(); 
	}
	
	return strAnzahl - abziehAnzahl;
    }
}


