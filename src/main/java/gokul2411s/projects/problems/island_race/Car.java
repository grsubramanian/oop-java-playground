package gokul2411s.projects.problems.island_race;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Car implements Vehicle {

    @NonNull
    private final String brand;

    private final int weight;

    @Override
    public void safeTraverse(WaterWayConnection connection) { }

    @Override
    public boolean canTraverse(WaterWayConnection connection) {
        return false;
    }

    @Override
    public void safeTraverse(RoadWayConnection connection) {
        System.out.println(this + " going along connection " + connection);
    }

    @Override
    public boolean canTraverse(RoadWayConnection connection) {
        return weight <= connection.getMaxWeight();
    }
}
