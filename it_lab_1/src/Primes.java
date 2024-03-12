//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Primes {
    public Primes() {
    }

    public static void main(String[] args) {
        for(int i = 2; i <= 100; ++i) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

    }

    public static boolean isPrime(int n) {
        for(int i = 2; i < n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        if (n % 10 == 9) {
            return true;
        } else {
            return false;
        }
    }
}
