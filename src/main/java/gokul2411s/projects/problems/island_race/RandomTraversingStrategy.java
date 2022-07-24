package gokul2411s.projects.problems.island_race;

import java.util.List;
import java.util.Random;

public class RandomTraversingStrategy implements TraversingStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public Connection pick(List<Connection> connections) {
        return connections.get(RANDOM.nextInt(connections.size()));
    }
}
