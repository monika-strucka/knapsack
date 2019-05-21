class BruteForceKnapsackAlgorithm {
    Integer currentBest = 0
    Integer countOfItems = 0
    List<Boolean> solution
    List<Boolean> current

    public Knapsack packKnapsack(List<Item> items, Knapsack knapsack) {
        countOfItems = items.size()
        //true - przemdioty dające najlepszą wartość , dla current przedmioty w obecnie rozważanym wyniku
        solution = new ArrayList<>(countOfItems)
        current = new ArrayList<>(countOfItems)
        findSolution(items, knapsack, countOfItems - 1)

        for (int k = 0; k < solution.size(); k++) {
            if (solution.get(k)) {
                knapsack.put(items.get(k))
            }
        }
        return knapsack
    }

    private void findSolution(List<Item> items, Knapsack knapsack, Integer i) {
        //Podstawowy przypadek: wszystkie przedmioty zostały uwzględnione
        if (i < 0) {
            //Znajdź całkowitą wagę i wartość
            int totalWeight = 0
            int totalValue = 0
            for (int j = 0; j < countOfItems; j++) {
                if (current[j]) {
                    totalWeight += items[j].weight
                    totalValue += items[j].value
                }
            }
            //Sprawdź czy istnieje lepsze rozwiązanie
            if (totalWeight <= knapsack.capacity && totalValue > currentBest) {
                currentBest = totalValue
                copySolution()
            }
            return

        }

        //rekurencja - 2 możliwości dla danego przemdiotu - albo wybieramy albo nie
        current[i] = true
        findSolution(items, knapsack, i-1)

        current[i] = false
        findSolution(items, knapsack, i-1)
    }

    private copySolution() {
        for(int i = 0; i < countOfItems; i++){
            solution[i] = current[i]
        }

    }
}
