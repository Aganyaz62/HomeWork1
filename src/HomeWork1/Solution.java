package HomeWork1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // Verilen bir sayı dizisinde, toplamı hedef sayıya eşit olan iki sayının indekslerini bul.
    public int[] twoSum(int[] sayilar, int hedef) {
        // Sayıları ve indekslerini saklamak için bir "harita" (map) oluştur.
        // Bu harita, her sayıya karşılık gelen indeksini tutacak.
        Map<Integer, Integer> sayiIndeksleri = new HashMap<>();

        // Dizideki her bir sayıyı kontrol et.
        for (int i = 0; i < sayilar.length; i++) {
            // Hedefe ulaşmak için gerekli olan "tamamlayıcı" sayıyı hesapla.
            // Yani, hedef = sayilar[i] + tamamlayici
            int tamamlayici = hedef - sayilar[i];

            // Eğer "tamamlayıcı" sayı haritada varsa,
            // bu demektir ki hedefi elde etmek için gereken iki sayıyı bulduk.
            if (sayiIndeksleri.containsKey(tamamlayici)) {
                // İki sayının indekslerini içeren bir dizi döndür.
                // Birinci sayı: tamamlayici (haritadan indeksini al)
                // İkinci sayı: mevcut sayı (indeksi i)
                return new int[] {sayiIndeksleri.get(tamamlayici), i};
            }

            // Mevcut sayıyı ve indeksini haritaya ekle.
            // Böylece, sonraki sayılar için "tamamlayıcı" kontrolü yaparken bu sayıyı kullanabiliriz.
            sayiIndeksleri.put(sayilar[i], i);
        }

        // Eğer döngü tamamlanır ve eşleşen iki sayı bulunamazsa,
        // boş bir dizi döndür. Bu, bir çözüm bulunamadığı anlamına gelir.
        return new int[] {};
    }

    public static void main(String[] args) {
        // Örnek kullanım:
        Solution cozum = new Solution();
        int[] sayilar = {3, 3}; // Kontrol edilecek sayılar
        int hedef = 6;          // Ulaşılması gereken hedef toplam

        // Sonucu al
        int[] sonuc = cozum.twoSum(sayilar, hedef);

        // Sonucu yazdır
        if (sonuc.length == 2) {
            System.out.println("İndeksler: " + sonuc[0] + ", " + sonuc[1]);
        } else {
            System.out.println("Çözüm bulunamadı.");
        }
    }
}
