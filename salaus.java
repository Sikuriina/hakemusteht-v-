//salauksen suorittava luokka

import java.util.Scanner;

public class salaus {
    public static void salaaSyote(){
     Scanner purunlukija = new Scanner(System.in);
        System.out.println("anna salattava syöte");    
        String syote = purunlukija.nextLine();
        char[] aakkoset = {'a', 'b','c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q','r', 's', 't', 'u', 'v', 'w', 'x','y','z'};
        String salaisuus = "";
    int jarjestysluku = 0;    
    char merkki = 0;
    try{
        for(int i = 0; i < syote.length(); i++){
        boolean kirjain = true;
        
        for(int j = 0; j < aakkoset.length; j++){  // käydään läpi aakkoset-taulukko
            merkki = syote.charAt(i);
            char aakkonen = aakkoset[j];
            if(merkki == aakkonen){                 // jos merkkijonon merkki ja aakkoston merkki täsmäävät, niin silloin järjestysluku on indeksipaikka + 1.
                jarjestysluku = j+1;
            }
            
        }
            if(merkki == (',')){                // käydään läpi erikoismerkit
            salaisuus = salaisuus + "01";
            kirjain = false;
     }
            if(merkki == ('.')){
            salaisuus = salaisuus + "05";
            kirjain = false;
     }
            if(merkki == ('!')){
            salaisuus = salaisuus + "09";
            kirjain = false;
     }
            if(merkki == ('?')){
            salaisuus = salaisuus + "13";
            kirjain = false;
     }
            if(merkki == (' ')){
            salaisuus = salaisuus + "00";
            kirjain = false;
     }
            

        if(jarjestysluku % 2 == 0 && kirjain){          // tutkitaan onko järjestysluku parillinen vai pariton, jotta tiedetään miten se tulee salata.
            int koodattavaJarjestysluku = ((32 - jarjestysluku)*4)-1;
            String koodattuMerkki = Integer.toHexString(koodattavaJarjestysluku);
            if(koodattuMerkki.length() == 1){           //koska Integer.toHexString muuttaa integerit hexoiksi vähimmällä mahdollisella määrällä merkkejä
                salaisuus = salaisuus + "0" + koodattuMerkki;               // ja salauksen onnistumiseksi tulee lisätä nolla.
            }else{
                salaisuus = salaisuus + koodattuMerkki;
            }
           
         
        }
        if(!(jarjestysluku % 2 == 0) && kirjain){
            int koodattavaJarjestysluku = jarjestysluku * 2;
            String koodattuMerkki = Integer.toHexString(koodattavaJarjestysluku);
             if(koodattuMerkki.length() == 1){                  
                salaisuus = salaisuus + "0" + koodattuMerkki;
            }else{
            salaisuus = salaisuus + koodattuMerkki;
        }
        
    }
        
}
        System.out.println(salaisuus);
}
    catch(Exception e){
        System.out.println("Virhe syötteessä, tarkista syöte"); // otetaan poikkeus kiinni ja ilmoitetaan virheestä ja kutsutaan metodia uudelleen.
        salaaSyote();
    }
    }
}
