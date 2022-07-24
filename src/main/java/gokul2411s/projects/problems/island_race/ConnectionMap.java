package gokul2411s.projects.problems.island_race;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a collection of connections among islands.
 */
public class ConnectionMap {

    /**
     * An optimized way to store connections between islands (adjacency list representation of a graph).
     */
    private final Map<Integer, List<Connection>> connections;

    private ConnectionMap(Map<Integer, List<Connection>> connections) {
        this.connections = connections;
    }

    public List<Connection> islandConnections(int island) {
        return connections.getOrDefault(island, new ArrayList<>());
    }

    public static ConnectionMapBuilder builder() {
        return new ConnectionMapBuilder();
    }

    public static class ConnectionMapBuilder {

        private Map<Integer, List<Connection>> connections = new HashMap<>();

        public ConnectionMapBuilder withConnection(Connection connection) {
            Preconditions.checkNotNull(connection);

            int fromIsland = connection.fromIsland();
            List<Connection> existingConnectionsFromIsland = connections.get(fromIsland);
            if (existingConnectionsFromIsland == null) {
                existingConnectionsFromIsland = new ArrayList<>();
                connections.put(fromIsland, existingConnectionsFromIsland);
            }
            existingConnectionsFromIsland.add(connection);
            return this;
        }


        public ConnectionMap build() {
            return new ConnectionMap(connections);
        }
    }
}
