class Knapsack {

    private int capacity = 50
    private List<Item> items = new LinkedList<>()

    Knapsack(int capacity) {
        this.capacity = capacity
    }

    int checkValue() {
        return this.items.stream()
                .mapToInt { it.getValue() }
                .sum()
    }

    int checkWeight() {
        return this.items.stream()
                .mapToInt { it.getWeight() }
                .sum()
    }

    double checkValueDividedByWeight() { //strategia, która wybiera rzeczy najcenniejsze w stosunku do swojej wagi,
        return checkValue() / checkWeight()
    }

    boolean willExceedSize(Item item) {
        return this.checkWeight() + item.getWeight() > capacity
    }

    void put(Item item) {
        items.add(item)
    }

    boolean isFull() {
        return this.checkWeight() == capacity
    }

    Knapsack copyWithItem(Item item) { //return knapsack full with all items and selected item
        Knapsack knapsack = new Knapsack(this.capacity)

        List<Item> newItems = this.items.collect { new Item(it.getValue(), it.getWeight()) }
        newItems.forEach { knapsack.put(it) }
        knapsack.put(item)
        return knapsack
    }

    boolean canAdd(List<Item> items) {
        return items.stream().anyMatch { !willExceedSize(it) }
    }

    List<Item> getItems() {
        return items
    }

    void display() {
        System.out.println("Knapsack has capacity " + capacity + " and items: ")
        for (Item item : items) {
            System.out.println(item)
        }
    }

    int getCapacity() {
        return capacity
    }

    @Override
    String toString() {
        return "Knapsack{" +
                ", items=" + items +
                "capacity=" + capacity +
                '}'
    }
}
