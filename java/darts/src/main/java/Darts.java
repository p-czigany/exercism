import java.util.function.DoublePredicate;

class Darts {
    int score(double xOfDart, double yOfDart) {
        double distanceFromMiddle = Math.sqrt(Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2));
        DoublePredicate thrownInside = ring -> distanceFromMiddle <= ring;

        if (thrownInside.test(1)) return 10;
        if (thrownInside.test(5)) return 5;
        if (thrownInside.test(10)) return 1;
        return 0;
    }
}
