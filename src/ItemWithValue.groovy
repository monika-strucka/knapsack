public class ItemWithValue {
    private Item item
    public double valueToWeightRatio

    public ItemWithValue(Item item, Double valueToWeightRatio) {
        this.item = item
        this.valueToWeightRatio = valueToWeightRatio
    }

    public Item getItem(){
        return item
    }

    public double getValueToWeightRatio(){
        return valueToWeightRatio
    }

    @Override
    public String toString(){
        return "Item" + item.toString() + "Value: " + valueToWeightRatio;
    }

//    @Override
//    public int compareTo(ItemWithValue it1, ItemWithValue it2) {
//        return Double.compare(it1.valueToWeightRatio, it2.valueToWeightRatio)
//    }



}
