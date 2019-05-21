class Item {

    private int value
    private int weight

    Item(int value, int weight) {
        this.value = value
        this.weight = weight
    }

    int getValue() {
        return value
    }

    int getWeight() {
        return weight
    }

    @Override
    String toString() {
        return "Item{" +
                "value=" + value +
                ", weight=" + weight +
                '}'
    }
}
