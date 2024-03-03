import java.util.ArrayList;
import java.util.List;

class Badge {
  private static final String DEFAULT_DEPT = "OWNER";

  public String print(Integer id, String name, String department) {
    List<String> badgeParts = new ArrayList<>();
    if (id != null) badgeParts.add(String.format("[%d]", id));
    badgeParts.add(name);
    badgeParts.add((department == null) ? DEFAULT_DEPT : department.toUpperCase());
    return String.join(" - ", badgeParts);
  }
}
