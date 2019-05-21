class ItemWithValue {

    private Item item
    double valueToWeightRatio

    ItemWithValue(Item item, Double valueToWeightRatio) {
        this.item = item
        this.valueToWeightRatio = valueToWeightRatio
    }

    Item getItem() {
        return item
    }

    double getValueToWeightRatio() {
        return valueToWeightRatio
    }

    @Override
    String toString() {
        return "Item" + item.toString() + "Value: " + valueToWeightRatio;
    }
}
