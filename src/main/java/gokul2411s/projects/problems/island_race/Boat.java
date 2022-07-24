package gokul2411s.projects.problems.island_race;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Boat implements Vehicle {

    @NonNull
    private final String brand;

    private final boolean hasWheels;

    @Override
    public void safeTraverse(WaterWayConnection connection) {
        simpleTraverse(this, connection);
    }

    @Override
    public boolean canTraverse(WaterWayConnection connection) {
        return true;
    }

    @Override
    public void safeTraverse(RoadWayConnection connection) {
        simpleTraverse(this, connection);
    }

    @Override
    public boolean canTraverse(RoadWayConnection connection) {
        return hasWheels;
    }

    private static void simpleTraverse(Vehicle vehicle, Connection connection) {
        System.out.println(vehicle + " going along connection " + connection);
    }
}
