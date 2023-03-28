public class ItemParser {
    private String input;

    public ItemParser(String input) {
        this.input = input;
    }

    public Item parseItem() {
        String[] parts = input.split(" ");

        try {
            int quantity = Integer.parseInt(parts[0]);
            String name = "";
            for (int i = 1; i < parts.length - 4; i++) {
                name += parts[i] + " ";
            }
            name = name.trim();
            double price = Double.parseDouble(parts[parts.length - 3]);
            boolean isImported = Boolean.parseBoolean(parts[parts.length - 2]);
            boolean isExempted = Boolean.parseBoolean(parts[parts.length - 1]);

            return new Item(quantity, name, price, isImported, isExempted);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please try again.");
            return null;
        }
    }
}
