package org.example;

import javax.swing.text.DateFormatter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NacitacDatOsob {
    //Ulozeni adresy pro pristup k datum
    private static final String stranka = "https://lide.uhk.cz/fim/ucitel/kozelto1/prog/people.txt";

    public static List<Osoba> NactiDataOsob() throws Exception {
        URL url = new URL(stranka);
        BufferedReader vstup = new BufferedReader(new InputStreamReader(url.openStream()));

        //vytvoreni mapy pro nactena data
        Map<String, String[]> mapaDat = new HashMap<>();
        String radek;

        //nacitani ze vstupu
        while ((radek = vstup.readLine()) != null) {
            //rozdeleni po :
            String[] casti = radek.split(":");

            //Kontrola poctu atributu
            if (casti.length == 2){
                //vlozeni co bude pred hodnotou jmeno,prijmeni..
                String klic = casti[0].trim();
                //ukladani hodnot do promenne rozdeleni podle ,
                String[] hodnoty = casti[1].split(",");
                for (int i = 0; i < hodnoty.length; i++) {
                    hodnoty[i] = hodnoty[i].trim();
                }

                //ukladani hodnot do mapy
                mapaDat.put(klic,hodnoty);
            }
        }
    vstup.close();
        //pole jednotlivych atributu
        String[] jmena = mapaDat.get("firstnames");
        String[] prijmeni = mapaDat.get("lastnames");
        String[] narozeniny = mapaDat.get("bithdays");

        //Overeni zda jsou data kompletni
        if (jmena == null || prijmeni == null || narozeniny == null )
        {
            throw new IllegalStateException("Chybí vstupní data");
        }

        List<Osoba> osoby = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //prochazeni vsech polí
        for (int i = 0; i < jmena.length; i++) {
            String jm = jmena[i];
            String pr = prijmeni[i];
            LocalDate na = LocalDate.parse(narozeniny[i], formatter);

            osoby.add(new Osoba(jm, pr, na));
        }
        return osoby;
    }

}
