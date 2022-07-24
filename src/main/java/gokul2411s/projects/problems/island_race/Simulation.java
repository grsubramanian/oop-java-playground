package gokul2411s.projects.problems.island_race;

import com.google.common.base.Preconditions;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Simulation<T extends Vehicle> implements Iterator<Integer> {

    private final T vehicle;
    private final int startIsland;
    private final int endIsland;
    private final ConnectionMap connectionMap;
    private final TraversingStrategy traversingStrategy;

    private int currentIsland;

    private Simulation(
            T vehicle,
            int startIsland,
            int endIsland,
            ConnectionMap connectionMap,
            TraversingStrategy traversingStrategy) {
        Preconditions.checkNotNull(vehicle);
        Preconditions.checkNotNull(connectionMap);
        Preconditions.checkNotNull(traversingStrategy);

        this.vehicle = vehicle;
        this.startIsland = startIsland;
        this.endIsland = endIsland;
        this.connectionMap = connectionMap;
        this.traversingStrategy = traversingStrategy;

        this.currentIsland = this.startIsland;
    }

    public static <T extends Vehicle> SimulationBuilder<T> builder() {
        return new SimulationBuilder<>();
    }

    @Override
    public boolean hasNext() {
        return currentIsland != endIsland && !possibleConnections().isEmpty();
    }

    @Override
    public Integer next() {
        Connection chosenConnection = traversingStrategy.pick(possibleConnections());
        vehicle.traverse(chosenConnection);
        currentIsland = chosenConnection.toIsland();
        return currentIsland;
    }

    private List<Connection> possibleConnections() {
        return connectionMap.islandConnections(currentIsland).stream()
                .filter(ic -> vehicle.canTraverse(ic))
                .collect(Collectors.toList());
    }

    public static class SimulationBuilder<T extends Vehicle> {

        private T vehicle;
        private int startIsland;
        private int endIsland;
        private ConnectionMap connectionMap;
        private TraversingStrategy traversingStrategy;

        public SimulationBuilder<T> withVehicle(T vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public SimulationBuilder<T> withStartIsland(int startIsland) {
            this.startIsland = startIsland;
            return this;
        }

        public SimulationBuilder<T> withEndIsland(int endIsland) {
            this.endIsland = endIsland;
            return this;
        }

        public SimulationBuilder<T> withConnectionMap(ConnectionMap connectionMap) {
            this.connectionMap = connectionMap;
            return this;
        }

        public SimulationBuilder<T> withTraversionStrategy(TraversingStrategy traversionStrategy) {
            this.traversingStrategy = traversionStrategy;
            return this;
        }

        public Simulation<T> build() {
            return new Simulation<>(vehicle, startIsland, endIsland, connectionMap, traversingStrategy);
        }
    }
}
