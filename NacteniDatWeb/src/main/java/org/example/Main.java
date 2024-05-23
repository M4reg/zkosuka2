package org.example;
import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Osoba> osoby = null;
        try {
            osoby = NacitacDatOsob.NactiDataOsob();
            //Ulozeni dat do souboru
            Ukladani.UkladejData(osoby, "osoby.csv");
            //Zobrazeni dialogu se zpravou
            JOptionPane.showMessageDialog(null,"Data byla úspěšně načtena a uložena do souboru 'osoby.csv'.");

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        //vypis do konzole nactenych osob z stranky
        for (Osoba osoba : osoby) {
            System.out.println(osoba);
        }
    }
}