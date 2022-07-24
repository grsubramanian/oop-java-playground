package gokul2411s.projects.problems.island_race;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoadWayConnection implements Connection {

    private final int fromIsland;
    private final int toIsland;
    private final int maxWeight;

    @Override
    public int fromIsland() {
        return fromIsland;
    }

    @Override
    public int toIsland() {
        return toIsland;
    }

    @Override
    public boolean allowsTraversing(Vehicle vehicle) {
        return vehicle.canTraverse(this);
    }

    @Override
    public void safeTraverse(Vehicle vehicle) {
        vehicle.safeTraverse(this);
    }
}
