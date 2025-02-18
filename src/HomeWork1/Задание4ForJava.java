package HomeWork1;

 class Задание4ForJava {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Задание4ForJava solution = new Задание4ForJava();
        int[] digits = {1, 2, 7};
        int[] result = solution.plusOne(digits);


        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}


