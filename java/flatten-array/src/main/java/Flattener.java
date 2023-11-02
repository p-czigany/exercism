import java.util.ArrayList;
import java.util.List;

public class Flattener {

    public List<Object> flatten(Object object) {
        List<Object> l = new ArrayList<>();
        if (object == null) {
            return l;
        }
        if (object instanceof List) {
            for (Object element : (List<?>) object) {
                l.addAll(flatten(element));
            }
        } else {
            l.add(object);
        }
        return l;
    }
}
