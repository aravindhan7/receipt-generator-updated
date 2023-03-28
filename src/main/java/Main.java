import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();

        while (true) {
            System.out.println("Enter item details in the following format: <quantity> <name> at <price> <imported> <exempted>");
            System.out.println("Example: 1 book at 12.49 true true");
            System.out.println("Enter 'done' to finish entering items");

            String input = scanner.nextLine();

            if (input.equals("done")) {
                break;
            }

            ItemParser parser = new ItemParser(input);
            Item item = parser.parseItem();

            if (item != null) {
                items.add(item);
            }
        }

        Receipt receipt = new Receipt(items);
        ReceiptFormatter formatter = new ReceiptFormatter();
        String receiptText = formatter.format(receipt);

        System.out.println(receiptText);
        scanner.close();
    }
}
