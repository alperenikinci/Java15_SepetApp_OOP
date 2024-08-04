package com.alperen.modules;

import com.alperen.databases.KullaniciDB;
import com.alperen.databases.SepetDB;
import com.alperen.databases.SiparisDB;
import com.alperen.databases.UrunDB;
import com.alperen.entities.Kullanici;
import com.alperen.entities.Sepet;
import com.alperen.entities.Urun;
import com.alperen.utility.DataInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SepetModule {
    private static final KullaniciDB kullaniciDB = DataInitializer.kullaniciDB;
    private static final SiparisDB siparisDB = DataInitializer.siparisDB;
    private static final UrunDB urunDB = DataInitializer.urunDB;
    private static final SepetDB sepetDB = DataInitializer.sepetDB;
    private static final Scanner scanner = new Scanner(System.in);


    // Menu Informations
    public static int sepetMainMenu(Kullanici kullanici) {
        Sepet kullanicisizSepet = new Sepet();
        Sepet sepet;
        System.out.println("#### THREADYOL ####");
        System.out.println("1- Urunleri Incele.");
        System.out.println("2- Urun Detaylarini Goruntule");
//        System.out.println("3- Sepete Urun Ekle");
        System.out.println("3- Sepeti Goruntule");
        if (kullanici == null) {
            System.out.println("9- Giriş Yap");
        }
        System.out.println("0- Cikis");
        System.out.print("Seciminiz : ");
        int secim = scanner.nextInt();
        scanner.nextLine();
        if(kullanici== null){
           kullanicisizSepet = sepetMainMenuFunctions(secim, kullanici,kullanicisizSepet);
        } else {
            sepet = new Sepet(sepetDB);
            sepet.setUrunList(kullanicisizSepet.getUrunList());
            sepet.setKullaniciId(kullanici.getId());
            sepetDB.update(sepet);
            System.out.println(sepet);
            sepetMainMenuFunctions(secim, kullanici,sepet);
        }
        return secim;
    }

    // Case Functions
    public static Sepet sepetMainMenuFunctions(int secim, Kullanici kullanici,Sepet sepet) {
        if (kullanici != null) {
            switch (secim) {
                case 1: {
                    urunleriIncele();
                    break;
                }
                case 2: {
                    Urun urun = urunDetaylariniGoruntule();
                    sepet = sepeteUrunEkle(urun,sepet);
                    break;
                }
                case 3: {
                    sepetiGoruntule(sepet);
                    break;
                }
                case 0: {
                    System.out.println("Uygulamadan cikis yapiliyor...");
                    break;
                }
                default: {
                    System.out.println("Lutfen gecerli bir secim yapiniz...");
                    break;
                }
            }
        } else {
            switch (secim) {
                case 1: {
                    urunleriIncele();
                    break;
                }
                case 2: {
                    Urun urun = urunDetaylariniGoruntule();
                    sepet = sepeteUrunEkle(urun,sepet);
                    break;
                }
                case 3: {
                    sepetiGoruntule(sepet);
                    break;
                }
                case 9: {
                    sepetMainMenu(KullaniciModule.girisMenu());
                    break;
                }
                case 0: {
                    System.out.println("Uygulamadan cikis yapiliyor...");
                    break;
                }
                default: {
                    System.out.println("Lutfen gecerli bir secim yapiniz...");
                    break;
                }
            }
        }
        return sepet;
    }

    private static void sepetiGoruntule(Sepet sepet) {
        System.out.println(sepet);
    }

    private static Urun urunDetaylariniGoruntule() {
        System.out.print("Lutfen incelemek istediginiz urunun numarasini giriniz : ");
        Urun urun = urunDB.findByID(scanner.nextInt());
        System.out.println("\n"+urun.detayliBilgi());
        scanner.nextLine();
        return urun;
    }

    private static Sepet sepeteUrunEkle(Urun urun,Sepet sepet) {
        System.out.print("Urun Sepete eklensin mi? (E/H) : ");
        String secim = scanner.nextLine();
        secim = secim.toUpperCase();
        switch (secim){
            case "E": {
                sepet.getUrunList().add(urun);
                break;
            }
            case "H": {
                break;
            }
            default: {
                System.out.println("Gecerli bir secim yapmadiniz. Ana menuye yonlendiriliyorsunuz.");
                break;
            }
        }

        return sepet;
    }

    private static void urunleriIncele() {
//       for (Urun urun: urunDB.findAll()){
//           System.out.println(urun.ozetBilgi());
//       }
        urunDB.findAll().forEach(u -> {
            System.out.println(u.ozetBilgi());
        });
    }
}
