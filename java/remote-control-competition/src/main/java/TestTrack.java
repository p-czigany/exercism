import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(ProductionRemoteControlCar prc1,
                                                                 ProductionRemoteControlCar prc2) {
        List<ProductionRemoteControlCar> list = new ArrayList<>(List.of(prc1, prc2));
        list.sort(Comparator.comparing(ProductionRemoteControlCar::getNumberOfVictories));
        return list;
    }
}
