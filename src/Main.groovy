static void main(String[] args) {

    def items = createItems()
    KnapsackAlgorithm knapsackAlgorithm = new KnapsackAlgorithm()
    def result = knapsackAlgorithm.packKnapsack(items, new Knapsack(40))

    println("Hill climbng Algorithm: ")
    println("Value =" + result.checkValue())
    println("Weight =" + result.checkWeight())
    println("Number of items: " + result.items.size())
    result.display()
    println "\n"

    def itemsGreedy = createItems()
    GreedyKnapsackAlgorithm greedyKnapsackAlgorithm = new GreedyKnapsackAlgorithm()
    def greedyResult = greedyKnapsackAlgorithm.packKnapsack(itemsGreedy, new Knapsack(40))

    println("Greedy Algorithm: ")
    println("Value =" + greedyResult.checkValue())
    println("Weight =" + greedyResult.checkWeight())
    println("Number of items: " + greedyResult.items.size())
    greedyResult.display()
    println "\n"

    def bruteForce = createItems()
    BruteForceKnapsackAlgorithm bruteForceKnapsackAlgorithm = new BruteForceKnapsackAlgorithm()
    def bruteForceResult = bruteForceKnapsackAlgorithm.packKnapsack(bruteForce, new Knapsack(40))

    println("Brute force Algorithm: ")
    println("Value =" + bruteForceResult.checkValue())
    println("Weight =" + bruteForceResult.checkWeight())
    println("Number of items: " + bruteForceResult.items.size())
    bruteForceResult.display()
    println "\n"
    }

private static List<Item> createItems() {
    return [
            new Item(18, 9),
            new Item(50, 5),
            new Item(100, 25),
            new Item(11, 1),
            new Item(27, 9),
            new Item(12, 3),
            new Item(25, 5),
            new Item(9, 9),
            new Item(49, 7),
            new Item(15, 3),
            new Item(1, 1),
            new Item(4, 2),
    ]
}

