package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class OrtakKarakterleriBulHashMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan iki metin girişi al
        System.out.println("Birinci metni girin: ");
        String metin1 = scanner.nextLine();

        System.out.println("İkinci metni girin: ");
        String metin2 = scanner.nextLine();

        // Ortak karakterleri bul ve yazdır
        System.out.println("Ortak Karakterler: " + findOrtakKarakterler(metin1, metin2));
    }

    private static String findOrtakKarakterler(String metin1, String metin2) {
        HashMap<Character, Boolean> karakterHaritasi = new HashMap<>();
        StringBuilder ortakKarakterler = new StringBuilder();

        // İlk metindeki karakterleri HashMap'e ekle
        for (char c : metin1.toCharArray()) {
            karakterHaritasi.put(c, false); // Başlangıçta her karakter için "false" değeri ata
        }

        // İkinci metindeki karakterleri kontrol et
        for (char c : metin2.toCharArray()) {
            // Eğer karakter ilk metinde varsa ve daha önce "true" olarak işaretlenmemişse
            if (karakterHaritasi.containsKey(c) && !karakterHaritasi.get(c)) {
                ortakKarakterler.append(c);
                karakterHaritasi.put(c, true); // Karakteri işaretle, böylece tekrar eklenmez
            }
        }

        return ortakKarakterler.toString();
    }
}
