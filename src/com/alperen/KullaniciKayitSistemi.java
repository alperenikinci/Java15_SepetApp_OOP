//package com.alperen;
//
//
//import com.alperen.databases.KullaniciDB;
//import com.alperen.entities.Kullanici;
//
//
//import java.time.LocalDate;
//import java.time.Period;
//import java.util.List;
//import java.util.Scanner;
//
//public class KullaniciKayitSistemi {
//
//    static Scanner scanner = new Scanner(System.in);
//    static KullaniciDB kullaniciDB = new KullaniciDB();
//
//
//    public static void main(String[] args) {
//        menu();
//    }
//
//    public static void menu() {
//        int secim = -1;
//        do {
//            System.out.println("### KULLANICI KAYIT SISTEMI ###");
//            System.out.println("1- Kayit Ol");
//            System.out.println("2- Giris Yap");
//            System.out.println("3- Sifremi Unuttum");
//            System.out.println("8- Demo veri olustur");
//            System.out.println("9- Kullanicilari Goruntule");
//            System.out.println("0- Cikis");
//            System.out.print("Lutfen bir secim yapiniz : ");
//            try {
//                secim = scanner.nextInt();
//            } catch (Exception e) {
//                System.out.println("Gecerli bir secim yapiniz.");
//            } finally {
//                scanner.nextLine();
//            }
//            menuFunctions(secim);
//        } while (secim != 0);
//    }
//
//    private static void menuFunctions(int secim) {
//        switch (secim) {
//            case 1: {
//                Kullanici kullanici = kullaniciKaydi();
//                break;
//            }
//            case 2: {
////                Kullanici kullanici = girisYap();
////                if (kullanici != null) {
////                    kullaniciArayuzu(kullanici);
////                }
//                break;
//            }
//            case 3: {
//                sifremiUnuttum();
//                break;
//            }
//            case 8: {
//                generateData();
//                break;
//            }
//            case 9: {
//                kullanicilariGoruntule();
//                break;
//            }
//            case 0: {
//                System.out.println("Program Sonlandirildi...");
//                break;
//            }
//        }
//    }
//
//    private static void kullaniciArayuzu(Kullanici kullanici) {
//        int secim = -1;
//        do {
//            System.out.println("### KULLANICI ARAYUZU ###");
//            System.out.println("1- Bilgilerimi Goruntule");
//            System.out.println("7- TelNo Degistir");
//            System.out.println("8- Email Degistir");
//            System.out.println("9- Sifre Degistir");
//            System.out.println("0- Oturumu Sonlandir");
//            System.out.print("Lutfen bir secim yapiniz : ");
//            try {
//                secim = scanner.nextInt();
//            } catch (Exception e) {
//                System.out.println("Gecerli bir secim yapiniz.");
//            } finally {
//                scanner.nextLine();
//            }
//            secim = userMenuFunctions(secim, kullanici);
//        } while (secim != 0);
//
//    }
//
//    private static int userMenuFunctions(int secim, Kullanici kullanici) {
//        switch (secim) {
//            case 1: {
//                kullaniciyiGoruntule(kullanici.getId());
//                break;
//            }
//
//            case 7: {
//                telNoDegistir(kullanici);
//                break;
//            }
//            case 8: {
//                emailDegistir(kullanici);
//                break;
//            }
//            case 9: {
//                if (sifreDegistir(kullanici)) {
//                    System.out.println("Sifrenizi basariyla degistirdiniz. Lutfen tekrar giris yapiniz... ");
//                    return 0;
//                }
//                break;
//            }
//            case 0: {
//                System.out.println("Ana Menuye Donuluyor...");
//                break;
//            }
//        }
//        return secim;
//    }
//
//
//    private static void telNoDegistir(Kullanici kullanici) {
//        //TODO Potansiyel iptal islemleri icin case yapisi kurulabilir.
//        System.out.println("### Telefon Numarasi Degistirme ###");
//        kullanici.setTelNo(telNoAl());
//        kullaniciDB.update(kullanici);
//    }
//
//    private static void emailDegistir(Kullanici kullanici) {
//        //TODO Potansiyel iptal islemleri icin case yapisi kurulabilir.
//        System.out.println("### Email Degistirme ###");
//        kullanici.setEmail(emailAl());
//        kullaniciDB.update(kullanici);
//    }
//
//    private static boolean sifreDegistir(Kullanici kullanici) {
//        //TODO Potansiyel iptal islemleri icin case yapisi kurulabilir.
//        boolean isPasswordChanged = false;
//        System.out.println("### Sifre Degistirme ###");
//        System.out.print("Lutfen eski sifrenizi giriniz : ");
//        String eskiSifre = scanner.nextLine();
//        if (kullanici.getSifre().equals(eskiSifre)) {
//            kullanici.setSifre(sifreAl());
//            kullaniciDB.update(kullanici);
//            isPasswordChanged = true;
//        } else {
//            System.out.println("Eski sifrenizi yanlis girdiniz !! ");
//        }
//        return isPasswordChanged;
//    }
//
//    private static Kullanici kullaniciyiGoruntule(int id) {
//        Kullanici kullanici = kullaniciDB.findByID(id);
//        if (kullanici != null) {
//            System.out.println(kullanici);
//            return kullanici;
//        } else {
//            System.out.println("Beklenmedik bir hata ile karsilasildi... ");
//            return null;
//        }
//    }
//
//    private static List<Kullanici> kullanicilariGoruntule() {
//        List<Kullanici> kullaniciList = kullaniciDB.findAll();
//        if (kullaniciList.isEmpty()) {
//            System.out.println("Hic kullanici bulunamadi...\n");
//        } else {
//            kullaniciList.forEach(System.out::println);
//        }
//        return kullaniciList;
//    }
//
//    private static Kullanici sifremiUnuttum() {
//        System.out.print("Lutfen TC Kimlik No giriniz : ");
//        String tcKimlik = scanner.nextLine();
//        System.out.print("Lutfen mail adresinizi giriniz : ");
//        String email = scanner.nextLine();
//        System.out.print("Lutfen telefon no giriniz : ");
//        String telNo = scanner.nextLine();
//
//        Kullanici kullanici = kullaniciDB.findByTcEmailPhoneNo(tcKimlik, email, telNo);
//
//        if (kullanici != null) {
//            kullanici.setSifre(sifreAl());
//            if (kullaniciDB.update(kullanici) != null) {
//                return kullanici;
//            } else {
//                System.out.println("Beklenmedik bir sorun ile karsilasildi.");
//                return null;
//            }
//        } else {
//            System.out.println("Girdiginiz bilgilerde eslesmeyen alanlar var. ");
//            return null;
//        }
//    }
//
//
//
//    private static Kullanici kullaniciKaydi() {
//        LocalDate dogumTarihi;
//        Kullanici kullanici;
////        dogumTarihi = dogumTarihiAl();
//       dogumTarihi = LocalDate.of(1996,8,7);
//        if (dogumTarihKontrol(dogumTarihi)) {
//            //Dogum tarihini kontrolunu gectik, o zaman kullanici olusturabiliriz.
//            kullanici = new Kullanici(kullaniciDB);
//            kullanici.setDogumTarihi(dogumTarihi);
//
//            String[] isimSoyisim = isimSoyisimAl();
//            kullanici.setIsim(isimSoyisim[0]);
//            kullanici.setSoyisim(isimSoyisim[1]);
//            kullanici.setEmail(emailAl());
//            kullanici.setTelNo(telNoAl());
//            kullanici.setTcKimlik(tcKimlikAl());
//            kullanici.setKullaniciAdi(kullaniciAdiAl());
//            kullanici.setSifre(sifreAl());
//
//            return kullanici;
//        } else {
//            System.out.println("18 Yasindan kucukler kayit islemi gerceklestiremez.");
//        }
//        return null;
//    }
//
//
//

//}
