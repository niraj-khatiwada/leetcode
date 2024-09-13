import java.util.*;

public class Main {
        public static void main(String[] args) {
                var n = 0;
                n ^= 2;
                n ^= 3;
                n ^= 5;
                System.out.println(n);
                System.out.println(1 ^ 1 ^ 2 ^ 3);
        }
}
