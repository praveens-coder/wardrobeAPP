public class WardrobeItem {
    private String type; // e.g., "shirt", "pants"
    private String color;
    private String material; // e.g., "cotton", "wool"

    public WardrobeItem(String type, String color, String material) {
        this.type = type;
        this.color = color;
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return type + ": " + color + " (" + material + ")";
    }
}
