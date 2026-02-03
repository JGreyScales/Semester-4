// This is intentionally "bad" and mixes responsibilities (SRP violation),
// uses conditionals for types (OCP violation),
// and depends on concrete details everywhere (DIP violation).
public class OrderServiceBad {

    public void placeOrder(String customerId, String items) {
        System.out.println("Placing order for " + customerId);

        double totalArea = 0.0;
        String[] parts = items.split(",");
        for (String p : parts) {
            if (p.startsWith("square:")) {
                double s = Double.parseDouble(p.substring("square:".length()));
                totalArea += s * s;
            } else if (p.startsWith("circle:")) {
                double r = Double.parseDouble(p.substring("circle:".length()));
                totalArea += Math.PI * r * r;
            } else {
                System.out.println("Unknown item: " + p);
            }
        }

        System.out.println("TOTAL AREA=" + totalArea);
        System.out.println("Saving order to database... (pretend)");
        System.out.println("Emailing customer receipt... (pretend)");
    }
}
