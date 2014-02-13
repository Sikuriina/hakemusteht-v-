//salauksen purkaminen

import java.util.Scanner;


public class purku {      //purku luokka
     public static void puraSyote(){
     Scanner purunlukija = new Scanner(System.in);
        System.out.println("anna purettava syöte");    
        String syote = purunlukija.nextLine();
        char[] aakkoset = {'a', 'b','c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q','r', 's', 't', 'u', 'v', 'w', 'x','y','z'};
        String ratkaisu = "";
        try{ 
        
    for(int i = 0; i < syote.length(); i++){   // syötteen läpikäyminen
     char eka = syote.charAt(i);                // heksat ovat kahden merkin pituisia, joten yhden heksaluvun purkuun otetaan syötteestä kaksi peräkkäistä merkkiä
     char toka = syote.charAt(i+1);
     i=i+1;
     String hexNumber = "";
     boolean kirjain = true;
     hexNumber = hexNumber + eka + toka;    // muodostetaan purettava heksanumero
     int decimal = Integer.parseInt(hexNumber, 16);
     //System.out.println(decimal); 
     if(hexNumber.equals("01")){                // tutkitaan erikoismerkit
         ratkaisu = ratkaisu + ",";
         kirjain = false;
     }
     if(hexNumber.equals("05")){
         ratkaisu = ratkaisu + ".";
         kirjain = false;
     }
     if(hexNumber.equals("09")){
         ratkaisu = ratkaisu + "!";
         kirjain = false;
     }
     if(hexNumber.equals("13")){
         ratkaisu = ratkaisu + "?";
         kirjain = false;
     }
     if(hexNumber.equals("00")){
         ratkaisu = ratkaisu + " ";
         kirjain = false;
     }
     
     
     if(decimal % 2 == 0 && kirjain){               // tutkitaan saadun desimaalin parillisuus/parittomuus
         int jarjestysluku = decimal/2;
         ratkaisu = ratkaisu + aakkoset[jarjestysluku-1];
         
     }
     if(!(decimal % 2 == 0) && kirjain){
         int jarjestysluku = 32-((decimal+1)/4);
         ratkaisu = ratkaisu + aakkoset[jarjestysluku-1];
     }      
               
           }
    System.out.println(ratkaisu);
}
      catch(Exception e){                           // otetaan poikkeus kiinni ja ilmoitetaan virheestä ja kutsutaan metodia uudelleen.
          System.out.println("Virhe syötteessä, tarkista syöte");
          puraSyote();
      }  
     }
}
