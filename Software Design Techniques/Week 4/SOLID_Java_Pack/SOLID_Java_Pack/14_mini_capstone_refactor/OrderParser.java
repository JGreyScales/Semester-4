import java.util.ArrayList;
import java.util.List;

public class OrderParser {

    public Shape[] parse(String items) {
        // TODO (exercise): remove the if/else by introducing a registry/factory (OCP).
        List<Shape> out = new ArrayList<>();
        String[] parts = items.split(",");
        for (String p : parts) {
            if (p.startsWith("square:")) {
                out.add(new Square(Double.parseDouble(p.substring("square:".length()))));
            } else if (p.startsWith("circle:")) {
                out.add(new Circle(Double.parseDouble(p.substring("circle:".length()))));
            }
        }
        return out.toArray(new Shape[0]);
    }
}
