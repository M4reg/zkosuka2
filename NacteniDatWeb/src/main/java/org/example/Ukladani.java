package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class Ukladani {
    public static void UkladejData(List<Osoba> osoby, String filePath) throws IOException{

        //vytvoreni zapisovace
        try (BufferedWriter zapisovac = new BufferedWriter(new FileWriter(filePath))) {
            //Vytvoreni porovnavace

            Comparator<Osoba> porovnavac = new Comparator<Osoba>() {
                @Override
                public int compare(Osoba o1, Osoba o2) {
                    //Pri shode vrati nula
                    int vysledek = o1.getLastname().compareTo(o2.getLastname());
                    if (vysledek == 0) {
                        //razeni podle datumu
                        return o1.getBirthday().compareTo(o2.getBirthday());
                    }
                    return vysledek;
                }
            };
            //Pruchod seznamem osob
            for (Osoba osoba : osoby) {
                try {
                    // Formátování na požadovaný formát dta
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    // Zapíše atributy do souboru a přidá středník
                    zapisovac.write(osoba.getFirstname() + ";" +
                            osoba.getLastname() + ";" +
                            osoba.getBirthday().format(formatter) + "\n");
                } catch (IOException e) {
                    // V případě chyby při zápisu, výps chybové zprávy
                    e.printStackTrace();
                }
            }
        }
    }
}
