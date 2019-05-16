import java.util.stream.Collectors

public class GreedyKnapsackAlgorithm {

    public Knapsack packKnapsack(List<Item> items, Knapsack knapsack) {
        Integer itemsSize = items.size()
        List<ItemWithValue> itemsWithValue = new ArrayList<>();

        for (Item item : items) {
            itemsWithValue.add(createItemWithValue(item))
        }

//        TODO nie widzi getValueToWeightRatio() jak posortowac po double?
//       itemsWithValue.sort(Comparator.comparingDouble( {it -> it.getValueToWeightRatio()})

        itemsWithValue.sort{it.getValueToWeightRatio()}
        itemsWithValue = itemsWithValue.reverse()
        System.out.println("SORTED: " + itemsWithValue + "\n")

        items = new ArrayList<>(itemsSize)
        for (ItemWithValue itemWithValue : itemsWithValue){
            items.add(createItem(itemWithValue))
        }
//jeśli nie jest pełny - waga wszystkich spakowanych przedmiotów nie równa jest pojemności plecaka
//canAdd - czy można jeszcze dodać jakikolwiek element z listy
        while (!knapsack.isFull() && knapsack.canAdd(items)) {
            for (int i = 0; i < items.size(); i++) {
                if (checkFreeSpace(knapsack) >= items.get(i).weight) {
                    knapsack.put(items.get(i))
                    items.remove(items.get(i))
                    break
                }
            }
        }
        return knapsack
    }

    ItemWithValue createItemWithValue(Item item) {
        return new ItemWithValue(item, item.getValue().toDouble() / item.getWeight().toDouble())
    }

    Item createItem(ItemWithValue itemWithValue) {
        return new Item( itemWithValue.getItem().getValue(), itemWithValue.getItem().getWeight())
    }

    Integer checkFreeSpace(Knapsack knapsack) {
        Integer usedCapacity = 0;
        List<Item> knapsackItems = knapsack.getItems()
        for (Item item : knapsackItems){
            usedCapacity = usedCapacity + item.getWeight()
        }

        return knapsack.getCapacity() - usedCapacity
    }


}