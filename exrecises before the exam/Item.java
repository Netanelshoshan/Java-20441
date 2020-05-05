public class Item {
    private int weight;
    private int value;

    public Item(int w, int v) {
        weight = w;
        value = v;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }


    public static int knapsack(Item[] items, int w) {
        return knapsack(items, w, 0, 0, 0, 0);
    }

    private static int knapsack(Item[] items, int maxW, int i, int currV, int currW, int prevValue) {
        if (currW > maxW)
            return (currV - prevValue);
        if (i >= items.length)
            return currV;

        return Math.max(
                knapsack(items, maxW, i + 1, currV, currW, prevValue),
                knapsack(items, maxW, i + 1, currV + items[i].getValue(),
                        currW + items[i].getWeight(), items[i].getValue())
        );
    }

}
