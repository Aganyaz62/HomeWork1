package HomeWork1;

import java.util.HashMap;
import java.util.Map;

class SolutionForJava {

    public int[] twoSum(int[] sayilar, int hedef) {
        Map<Integer, Integer> sayiIndeksleri = new HashMap<>();

        for (int i = 0; i < sayilar.length; i++) {
            int tamamlayici = hedef - sayilar[i];
            if (sayiIndeksleri.containsKey(tamamlayici)) {
                return new int[] {sayiIndeksleri.get(tamamlayici), i};
            }

            sayiIndeksleri.put(sayilar[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        SolutionForJava cozum = new SolutionForJava();
        int[] sayilar = {3, 3};
        int hedef = 6;

        int[] sonuc = cozum.twoSum(sayilar, hedef);

       if (sonuc.length == 2) {
            System.out.println("İndeksler: " + sonuc[0] + ", " + sonuc[1]);
        } else {
            System.out.println("Çözüm bulunamadı.");
        }
    }
}
