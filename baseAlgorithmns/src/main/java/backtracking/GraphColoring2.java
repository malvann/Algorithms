package backtracking;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphColoring2 {
    private final char name;
    private Set<GraphColoring2> connections;
    private Color color = null;

    public GraphColoring2(char name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setConnections(Set<GraphColoring2> connections) {
        this.connections = connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphColoring2 that)) return false;
        return name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void colour(GraphColoring2 root) throws NoSuchElementException {
        Set<Color> forbiddenColors = root.connections.stream().map(GraphColoring2::getColor).distinct()
                .filter(Objects::nonNull).collect(Collectors.toSet());
        if (root.color == null)
            root.color = Stream.of(Color.values())
                    .filter(c -> !forbiddenColors.contains(c)).findFirst().orElseThrow(ColoringIsUnavailable::new);
        root.connections.stream().filter(graph -> graph.color == null).forEach(GraphColoring2::colour);
    }

    public static void main(String[] args) {
        GraphColoring2 a = new GraphColoring2('a');
        GraphColoring2 b = new GraphColoring2('b');
        GraphColoring2 c = new GraphColoring2('c');
        GraphColoring2 d = new GraphColoring2('d');
        GraphColoring2 e = new GraphColoring2('e');
        GraphColoring2 f = new GraphColoring2('f');
        a.setConnections(Set.of(b, c, d));
        b.setConnections(Set.of(a, c, e, f));
        c.setConnections(Set.of(a, b, f, d));
        d.setConnections(Set.of(a, c, f));
        e.setConnections(Set.of(b, f));
        f.setConnections(Set.of(b, c, d, e));
        try {
            GraphColoring2.colour(a);
        } catch (ColoringIsUnavailable ex) {
            System.out.println("Graph can't be colored");
        }
        System.out.println("a-" + a.color);
        System.out.println("b-" + b.color);
        System.out.println("c-" + c.color);
        System.out.println("d-" + d.color);
        System.out.println("e-" + e.color);
        System.out.println("f-" + f.color);
    }
}

class ColoringIsUnavailable extends RuntimeException {
}

enum Color {
    YELLOW,
    BLUE,
    GREEN,
    RED
}
