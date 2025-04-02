import java.util.Random;
import java.util.Scanner;

public class Aleatorio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NumberRandom = new Random().nextInt(100000) + 1;
        int chute = scanner.nextInt();
        while (chute != NumberRandom) {
            if (NumberRandom < chute) {
                System.out.println("DIgite numero menor: ");
                chute = scanner.nextInt();
            } else {
                System.out.println("DIgite numero MAIOR: ");
                chute = scanner.nextInt();
            }
        }
        System.out.println("Parabéns!");
    }
}
