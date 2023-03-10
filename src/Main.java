import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer){
        LinkedList<? extends T> newList = stream.sorted(order)
                .collect(Collectors.toCollection(LinkedList::new));
        if (newList.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(newList.getFirst(), newList.getLast());
        }
    }

    public static void countEventNumbers(List<Integer> list){
        List<Integer> newList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(newList.size());
    }
}