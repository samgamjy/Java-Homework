package added.lab4;

import java.util.Random;

/**
 * Created by Sam on 21.02.2015.
 * На вход программе поступает трёхзначное число (от 100 до 999), которое
 * генерируется случайным образом либо вводиться из консоли (на своё
 * усмотрение). Необходимо определить является ли число счастливым.
 * Счастливое число, это число у которого все цифры совпадают (например
 * 777), либо число у которого каждая последующая цифра на 1 больше
 * предыдущей (123 или 456), а также счастливыми являются числа 781, 302,
 * 409 и 941 (такие числа будет называть “Магическими”).
 * Программа должна вывести на экран входное число ( только в случае если
 * оно было сгенерировано) и результат какое число попалось: “Счастливое”,
 * “Несчастливое” или “Магическое”.
 */
public class CheckNumbers {

    private static int magicVals[] = {781, 302, 409, 941};

    private static boolean checkMagicNums(int checkVal) {
        for (int i = 0; i < magicVals.length; i++) {
            if (checkVal == magicVals[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int val = Math.abs(rand.nextInt(900)) + 100;

        if (checkMagicNums(val)) {
            System.out.println("Число " + val + " -  магическое");
        } else {
            int count = 3;
            int tmpVal = val;
            int mod = 10;
            int valArr[] = new int[count];
            for (int i = 0; i < count; i++) {
                valArr[count - i - 1] = (tmpVal % (int) Math.pow(mod, i + 1));
                tmpVal -= valArr[count - i - 1];
                valArr[count - i - 1] /= (int) Math.pow(mod, i);
            }

            boolean resLuckEqual = true, resLuckGrow = true;
            for (int i = 0; i < count - 1; i++) {
                if ((valArr[i] + 1) != valArr[i + 1]) {
                    resLuckGrow = false;
                }

                if (valArr[i] != (valArr[i + 1])) {
                    resLuckEqual = false;
                }

                if (!resLuckEqual && !resLuckGrow) {
                    break;
                }
            }
            if (resLuckEqual) {
                System.out.println("Число " + val + " -  cчастливое (все цифры совпадают)");
            } else {
                if (resLuckGrow) {
                    System.out.println("Число " + val + " -  cчастливое (цифры возрастают)");
                } else {
                    System.out.println("Число " + val + " -  несчастливое (не поддается классификации)");
                }
            }
        }

    }
}
