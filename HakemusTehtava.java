//pääohjelma


import java.util.Scanner;
public class HakemusTehtava {
private static String vastaus = "42";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Mikä on vastaus suureen kysymykseen elämästä, maailmankaikkeudesta ja muusta sellaisesta?");
        String annettuvastaus = lukija.nextLine();
        if(!(annettuvastaus.equals(vastaus))){     // jos aloituskysymykseen ei osata vastata niin ohjelma sulkeutuu
            System.out.println("väärä vastaus, ohjelma suljetaan");
            System.exit(0);
        }
        aloita();
    }
        public static void aloita() throws Exception {
        Scanner lukija = new Scanner(System.in);
       
        System.out.println("Valitse ja anna (purku tai salaus)");    // valinnan purku/salaus toteutus
        String s = lukija.nextLine();
            if(s.equals("purku")){
                System.out.println("purku valittu");
                
                purku.puraSyote();
            }
            else if(s.equals("salaus")){
                System.out.println("salaus valittu");
                
                salaus.salaaSyote();
            }
            else{
                System.out.println("kyseinen vaihtoehto on mahdoton");  // jos valitaan jokin muu vaihtoehto kuin salaus/purku niin ilmoittaa virheestä
                aloita();
                }
        lukija.close();
    }
}
 
        
     
