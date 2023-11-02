import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Robot {

    private static final List<String> robotNames = new ArrayList<>();

    private final Random random = new Random();

    private String name;

    Robot() {
        name = createName();
        robotNames.add(name);
    }

    public String getName() {
        return name;
    }

    public void reset() {
        robotNames.remove(name);
        name = createName();
    }

    private String createName() {
        String newName;
        do {
            newName = randomName();
        } while (isInvalid(newName));
        return newName;
    }

    private boolean isInvalid(String newName) {
        return robotNames.contains(newName);
    }

    private String randomName() {
        return String.format("%s%s%s%s%s", randomLetter(), randomLetter(), randomNumber(), randomNumber(), randomNumber());
    }

    private String randomNumber() {
        return String.valueOf(random.nextInt(10));
    }

    private String randomLetter() {
        return String.valueOf((char) (random.nextInt(26) + 'A'));
    }
}