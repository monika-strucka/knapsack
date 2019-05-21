import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrotterJohnsonAlgorithm {

private static int rank(List<Integer> permutation) {
    int size = permutation.size();

    if(size < 2)
        return 0;

    int removedNumber = getLower(permutation);
    int lowerRank = rank(permutation);

    if(lowerRank % 2 == 0) {
        return size * lowerRank + size - removedNumber;
    }
        return size * lowerRank + removedNumber - 1;

}

private static List<Integer> unrank(int index, int sizeOfPermutation) {
    if (sizeOfPermutation < 2)
        return new ArrayList<>(Collections.singletonList(1));

    if (sizeOfPermutation == 2) {
        if (index == 0) {
            return new ArrayList<>(Arrays.asList(1, 2));
        } else {
            return new ArrayList<>(Arrays.asList(2, 1));
        }
    }

    int lowerIndex = index / sizeOfPermutation;

    int indexHelper = index - sizeOfPermutation * lowerIndex;
 
    List<Integer> lowerPermutation = unrank(lowerIndex, sizeOfPermutation - 1);
    if (lowerIndex % 2 == 0)
    {
        lowerPermutation.add(sizeOfPermutation - indexHelper - 1, sizeOfPermutation);
    } else
    {
        lowerPermutation.add(indexHelper, sizeOfPermutation);
    }

    return lowerPermutation;
    
}






private static int getLower(List<Integer> permutation) {
    //the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
    //gdzie najwiekszy element
    int index = permutation.indexOf(permutation.size());

    if (!permutation.contains(permutation.size())) {
        throw new IllegalArgumentException("Permutacja nie zawiera wartości: " + permutation.size());
    }
    permutation.remove((Integer) permutation.size());
    return permutation.subList(0, index).size() +1;
}

public static void main(String[] args) {
    System.out.println("FUNKCJA RANK");
    System.out.println("---> RANK <---");
    System.out.println(rank(new ArrayList<>(Arrays.asList(1, 2))) == 0);
    System.out.println(rank(new ArrayList<>(Arrays.asList(2, 1))) == 1);
    System.out.println(rank(new ArrayList<>(Arrays.asList(1, 2, 3))) == 0);
    System.out.println(rank(new ArrayList<>(Arrays.asList(1, 3, 2))) == 1);
    System.out.println(rank(new ArrayList<>(Arrays.asList(3, 1, 2))) == 2);
    System.out.println(rank(new ArrayList<>(Arrays.asList(3, 2, 1))) == 3);
    System.out.println(rank(new ArrayList<>(Arrays.asList(2, 3, 1))) == 4);
    System.out.println(rank(new ArrayList<>(Arrays.asList(2, 1, 3))) == 5);
    System.out.println(rank(new ArrayList<>(Arrays.asList(3, 4, 2, 1))) == 13);
    System.out.println(rank(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))) == 0);




    System.out.println("FUNKCJA UNRANK");
    System.out.println(unrank(0, 2).equals(Arrays.asList(1, 2)));
    System.out.println(unrank(1, 2).equals(Arrays.asList(2, 1)));
    System.out.println(unrank(0, 3).equals(Arrays.asList(1, 2, 3)));
    System.out.println(unrank(4, 3).equals(Arrays.asList(2, 3, 1)));
    System.out.println(unrank(13, 4).equals(Arrays.asList(3, 4, 2, 1)));
    System.out.println(unrank(0, 5).equals(Arrays.asList(1, 2, 3, 4, 5)));
}

}