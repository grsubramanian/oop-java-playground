package gokul2411s.projects.problems.island_race.app;

import gokul2411s.projects.problems.island_race.*;

public final class Example {

    public static void main(String[] args) {

        ConnectionMap connectionMap =
                ConnectionMap.builder()
                        .withConnection(
                                WaterWayConnection.builder()
                                        .fromIsland(1)
                                        .toIsland(2)
                                        .build())
                        .withConnection(
                                WaterWayConnection.builder()
                                        .fromIsland(2)
                                        .toIsland(3)
                                        .build())
                        .withConnection(
                                RoadWayConnection.builder()
                                        .fromIsland(0)
                                        .toIsland(1)
                                        .maxWeight(1000)
                                        .build())
                        .withConnection(
                                RoadWayConnection.builder()
                                        .fromIsland(0)
                                        .toIsland(2)
                                        .maxWeight(2000)
                                        .build())
                        .withConnection(
                                RoadWayConnection.builder()
                                        .fromIsland(2)
                                        .toIsland(3)
                                        .maxWeight(2500)
                                        .build())
                        .build();

        // TODO: Make this multi-threaded.

        Simulation<Car> carSimulation =
                Simulation.<Car>builder()
                        .withVehicle(Car.builder().brand("Audi").weight(1500).build())
                        .withStartIsland(0)
                        .withEndIsland(3)
                        .withConnectionMap(connectionMap)
                        .withTraversionStrategy(new RandomTraversingStrategy())
                        .build();

        while (carSimulation.hasNext()) {
            carSimulation.next();
        }

        Simulation<Boat> boatSimulation =
                Simulation.<Boat>builder()
                        .withVehicle(Boat.builder().brand("Sea Ray").hasWheels(true).build())
                        .withStartIsland(0)
                        .withEndIsland(3)
                        .withConnectionMap(connectionMap)
                        .withTraversionStrategy(new RandomTraversingStrategy())
                        .build();

        while (boatSimulation.hasNext()) {
            boatSimulation.next();
        }
    }

    private Example() { }
}
