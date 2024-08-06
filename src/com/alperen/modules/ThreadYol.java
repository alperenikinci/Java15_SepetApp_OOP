package com.alperen.modules;


import com.alperen.databases.SepetDB;
import com.alperen.entities.Kullanici;
import com.alperen.entities.Sepet;
import com.alperen.entities.Urun;
import com.alperen.utility.DataInitializer;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ThreadYol {

    private static Kullanici kullanici = null;
    private static Sepet sepet = new Sepet();

    public static void main(String[] args) {
        Locale.setDefault(Locale.UK);
        DataInitializer.generateAllData();
        startApplication();
    }

    public static void startApplication() {
        int secim = 0;
        do {
            secim = SepetModule.sepetMainMenu(sepet, kullanici);
            assignSepetToKullanici(secim);

        } while (secim != 0);
    }

    private static void assignSepetToKullanici(int secim) {
        if (secim == 9 && kullanici == null) {
            kullanici = KullaniciModule.girisMenu();

            if (kullanici != null) {
                if (SepetModule.isUserHasSepet(kullanici)) {
                    sepet = SepetModule.findActiveSepetByUserId(kullanici.getId());
                } else if (sepet.getKullaniciId() == -1) {
                    List<Urun> tempUrunList = sepet.getUrunList();
                    sepet = new Sepet(DataInitializer.sepetDB);
                    sepet.sepeteUrunEkle(tempUrunList);
                    sepet.setKullaniciId(kullanici.getId());
                }
            }
        } else if (secim == 9 && kullanici != null) {
            sepet = new Sepet();
            kullanici = null;
        }
    }
}

