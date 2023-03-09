import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void findMinMax(Stream<Objects> stream, Comparator<Objects> order, BiConsumer<Objects, Objects> minMaxConsumer){
        LinkedList<Objects> newList = stream.sorted(order)
                .collect(Collectors.toCollection(LinkedList::new));
        if (newList.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(newList.getFirst(), newList.getLast());
        }
    }
}