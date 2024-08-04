package com.alperen.modules;

import com.alperen.databases.KullaniciDB;
import com.alperen.databases.SepetDB;
import com.alperen.databases.SiparisDB;
import com.alperen.databases.UrunDB;
import com.alperen.entities.Kullanici;
import com.alperen.utility.DataInitializer;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class KullaniciModule {
    private static final KullaniciDB kullaniciDB = DataInitializer.kullaniciDB;
    private static final SiparisDB siparisDB = DataInitializer.siparisDB;
    private static final UrunDB urunDB = DataInitializer.urunDB;
    private static final SepetDB sepetDB = DataInitializer.sepetDB;
    private static final Scanner scanner = new Scanner(System.in);


    public static Kullanici girisMenu(){
        int secim = 0;
        do {
            System.out.println("### Giris Menusu ###");
            System.out.println("1- Giris Yap");
            System.out.println("2- Kayit Ol");
            System.out.println("0- Ana Menuye Don");
            System.out.print("Seciminiz : ");
            secim = scanner.nextInt();
            scanner.nextLine();
            Kullanici kullanici = kullaniciGirisMenuFunctions(secim);
            if(kullanici!=null){
                System.out.println("\nGiris basarili, ana menuye yonlendiriliyorsunuz...");
            }
            return  kullanici;
        } while (true);
    }

    private static Kullanici kullaniciGirisMenuFunctions(int secim) {
        Kullanici kullanici = null;
            switch (secim){
                case 1:{
                    kullanici = girisYap();
                    if(kullanici == null){
                      kullanici= girisMenu();
                    }
                    break;
                }
                case 2:{
                    kullanici = kullaniciKaydi();
                    break;
                }
                case 0:{
                    System.out.println("Ana menuye donuyorsunuz.");
                    break;
                } //TODO Buradaki yapiyi yonet, donguye alinip, mutlaka gecerli bir secim alinmasi lazim.
                default:{
                    System.out.println("Lutfen gecerli bir secim yapiniz... Ana menuye donuyorsunuz. yonlendiriliyorsunuz...");
                    break;
                }
            }
        return kullanici;
    }

    private static Kullanici girisYap() {
        System.out.print("Lutfen kullanici adinizi giriniz : ");
        String username = scanner.nextLine();
        System.out.print("Lutfen sifrenizi giriniz : ");
        String password = scanner.nextLine();
        Kullanici kullanici = kullaniciDB.findByUsernameAndPassword(username, password);
        if (kullanici != null) {
            return kullanici;
        } else {
            System.out.println("Kullanici adi veya sifre hatali.\nGiris menusune yonlendiriliyorsunuz... ");
            return null;
        }
    }

    private static Kullanici kullaniciKaydi() {
        LocalDate dogumTarihi;
        Kullanici kullanici;
//        dogumTarihi = dogumTarihiAl();
        dogumTarihi = LocalDate.of(1996,8,7);
        if (dogumTarihKontrol(dogumTarihi)) {
            //Dogum tarihini kontrolunu gectik, o zaman kullanici olusturabiliriz.
            kullanici = new Kullanici(kullaniciDB);
            kullanici.setDogumTarihi(dogumTarihi);

            String[] isimSoyisim = isimSoyisimAl();
            kullanici.setIsim(isimSoyisim[0]);
            kullanici.setSoyisim(isimSoyisim[1]);
            kullanici.setEmail(emailAl());
            kullanici.setTelNo(telNoAl());
            kullanici.setTcKimlik(tcKimlikAl());
            kullanici.setKullaniciAdi(kullaniciAdiAl());
            kullanici.setSifre(sifreAl());

            return kullanici;
        } else {
            System.out.println("18 Yasindan kucukler kayit islemi gerceklestiremez.");
        }
        return null;
    }

    private static String kullaniciAdiAl() {
        String kullaniciAdi;
        while (true) {
            System.out.print("Lutfen bir kullanici adi giriniz min 4 - max 16 karakter : ");
            kullaniciAdi = scanner.nextLine();
            if (kullaniciAdi.length() < 4) {
                System.out.println("Kullanici adi 4 karakterden kisa olamaz.");
                continue;
            } else if (kullaniciAdi.length() > 16) {
                System.out.println("Kullanici adi 16 karakterden uzun olamaz.");
                continue;
            }
            if (!kullaniciDB.existsByUsername(kullaniciAdi)) {
                return kullaniciAdi;
            } else {
                System.out.println("Kullanici adi sistemde bulunmaktadir.");
            }
        }
    }

    private static String tcKimlikAl() {
        String tcKimlik;
        while (true) {
            System.out.print("Lutfen TC kimlik numaranizi giriniz : ");
            tcKimlik = scanner.nextLine();
            if (tcKimlik.length() != 11) {
                System.out.println("TC Kimlik No 11 haneli olmalidir.");
                continue;
            } else if (!numerikDegerKontrol(tcKimlik)) {
                System.out.println("TC Kimlik No sadece numerik karakterler barindirabilir. ");
                continue;
            }
            if (!kullaniciDB.existsByTcKimlik(tcKimlik)) {
                return tcKimlik;
            } else {
                System.out.println("TC kimlik sistemde bulunmaktadir.");
            }
        }
    }

    private static String emailAl() {
        while (true) {
            System.out.print("Lutfen mailinizi giriniz : ");
            String email = scanner.nextLine();
            if (!kullaniciDB.existsByEmail(email)) {
                return email;
            } else {
                System.out.println("Girdiginiz email kullanilmaktadir.");
            }
        }


    }

    private static boolean numerikDegerKontrol(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static String sifreAl() {
        String sifre;
        String sifreYeniden;
        while (true) {
            System.out.print("Lutfen bir sifre giriniz min 8 - max 32 karakter : ");
            sifre = scanner.nextLine();
            if (sifre.length() < 8) {
                System.out.println("Sifre 8 karakterden kisa olamaz.");
                continue;
            } else if (sifre.length() > 32) {
                System.out.println("Sifre 32 karakterden uzun olamaz.");
                continue;
            } else {
                System.out.print("Lutfen sifreninizi tekrar giriniz : ");
                sifreYeniden = scanner.nextLine();
                if (sifre.equals(sifreYeniden)) {
                    return sifre;
                } else {
                    System.out.println("Girdiginiz sifreler eslesmiyor! ");
                }
            }
        }

    }

    private static String telNoAl() {
        System.out.print("Lutfen telefon numaranizi giriniz : +90 ");
        String telNo = scanner.nextLine();
        return telNo;
    }

    private static String[] isimSoyisimAl() {
        String[] isimSoyisim = new String[2];
        System.out.print("Lutfen adinizi giriniz : ");
        isimSoyisim[0] = scanner.nextLine();
        System.out.print("Lutfen soyadinizi giriniz : ");
        isimSoyisim[1] = scanner.nextLine();
        return isimSoyisim;
    }

    private static LocalDate dogumTarihiAl() {
        while (true) {
            System.out.print("Lutfen dogum tarihinizi giriniz (yyyy-MM-dd) : ");
            String date = scanner.nextLine();
            try {
                LocalDate localDate = LocalDate.parse(date);
                return localDate;
            } catch (Exception e) {
                System.out.println("Lutfen dogum tarihinizi yil-ay-gun formatinda giriniz!!!\n");
            }
        }
    }

    private static boolean dogumTarihKontrol(LocalDate date) {
        int yas = Period.between(date, LocalDate.now()).getYears();
        boolean resitMi = (yas < 18) ? false : true;
        return resitMi;
    }
}
