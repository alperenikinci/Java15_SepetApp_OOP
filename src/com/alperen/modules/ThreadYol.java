package com.alperen.modules;


import com.alperen.databases.KullaniciDB;
import com.alperen.databases.SepetDB;
import com.alperen.databases.SiparisDB;
import com.alperen.databases.UrunDB;
import com.alperen.entities.Kullanici;
import com.alperen.entities.Sepet;
import com.alperen.utility.DataInitializer;

import java.util.Locale;

public class ThreadYol {
    public static void main(String[] args) {
        Locale.setDefault(Locale.UK);
        DataInitializer.generateAllData();
        DataInitializer.kullaniciDB.findAll().forEach(System.out::println);
        DataInitializer.urunDB.findAll().forEach(System.out::println);
        startApplication();
    }

    public static void startApplication(){
        Kullanici kullanici = null;
//        Sepet sepet = null;
        int secim  = 0;
        do {
            secim = SepetModule.sepetMainMenu(kullanici);
        } while (secim!=0);
    }


}
