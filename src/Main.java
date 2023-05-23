import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
        int[] prices = {50, 14, 80};
        int[] quantityForSelectedProduct = new int[3];
        int sumProducts = 0;

        for (int i = 0; i < products.length; i++) {
            System.out.println(i+1 + ". " + products[i] + " " + prices[i] + " руб/шт");
        }

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            int productNo = Integer.parseInt(parts[0]) - 1;
            int quantity = Integer.parseInt(parts[1]);
            quantityForSelectedProduct[productNo] += quantity;
        }

        System.out.println("Ваша корзина:");

        for (int i = 0; i < products.length; i++) {
            if (quantityForSelectedProduct[i] != 0) { // Молоко 10 шт 50 руб/шт 500 руб в сумме
                System.out.println(products[i] + " " + quantityForSelectedProduct[i] + " шт " + prices[i] + " руб/шт "
                        + (quantityForSelectedProduct[i] * prices[i]) + " руб в сумме");
            }
            sumProducts += (quantityForSelectedProduct[i] * prices[i]);
        }

        System.out.println("Итого " + sumProducts);
    }
}