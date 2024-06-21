import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class WardrobeApp {
    private List<WardrobeItem> wardrobe;

    public WardrobeApp() {
        this.wardrobe = new ArrayList<>();
    }

    public void addItem(String type, String color, String material) {
        WardrobeItem item = new WardrobeItem(type, color, material);
        wardrobe.add(item);
    }

    public void displayWardrobe() {
        System.out.println("Your Wardrobe:");
        for (WardrobeItem item : wardrobe) {
            System.out.println(item);
        }
    }

    public void suggestOutfit(String weather) {
        System.out.println("Suggested Outfit for " + weather + ":");
        boolean outfitFound = false;
        HashSet<String> suggestedTypes = new HashSet<>();

        for (WardrobeItem item : wardrobe) {
            if (suggestedTypes.contains(item.getType())) {
                continue;
            }

            if (weather.equalsIgnoreCase("hot") && !item.getMaterial().equalsIgnoreCase("wool")) {
                System.out.println(item);
                suggestedTypes.add(item.getType());
                outfitFound = true;
            } else if (weather.equalsIgnoreCase("cold") && item.getMaterial().equalsIgnoreCase("wool")) {
                System.out.println(item);
                suggestedTypes.add(item.getType());
                outfitFound = true;
            }
        }

        if (!outfitFound) {
            System.out.println("No suitable outfits found for " + weather + " weather.");
        }
    }

    public static void main(String[] args) {
        WardrobeApp app = new WardrobeApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (add/display/suggest/exit):");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("add")) {
                System.out.println("Enter type:");
                String type = scanner.nextLine();
                System.out.println("Enter color:");
                String color = scanner.nextLine();
                System.out.println("Enter material:");
                String material = scanner.nextLine();
                app.addItem(type, color, material);
            } else if (command.equalsIgnoreCase("display")) {
                app.displayWardrobe();
            } else if (command.equalsIgnoreCase("suggest")) {
                System.out.println("Enter weather (hot/cold):");
                String weather = scanner.nextLine();
                app.suggestOutfit(weather);
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Unknown command. Try again.");
            }
        }

        scanner.close();
    }
}
