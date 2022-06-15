import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Deque<Integer> source = new LinkedList<>(List.of(0, 1, 2));
        move(source, new LinkedList<>(), new LinkedList<>());
    }

    public static void move(Deque<Integer> source, Deque<Integer> mid, Deque<Integer> dest) {
        if (source.isEmpty() && mid.isEmpty()) {
            System.out.println(dest);
            return;
        }
        if (!source.isEmpty()) {
            if (dest.isEmpty() || source.peek() < dest.peek()) {
                dest.add(source.pop());
                move(source, mid, dest);
            } else if (mid.isEmpty() || source.peek() < mid.peek()) {
                mid.add(source.pop());
                move(source, mid, dest);
            } else if (dest.peek() < mid.peek()) {
                mid.add(dest.pop());
                move(source, mid, dest);
            } else {
                source.add(dest.pop());
                dest.add(mid.pop());
                move(source, mid, dest);
            }
        } else move(mid, source, dest);
    }
}
