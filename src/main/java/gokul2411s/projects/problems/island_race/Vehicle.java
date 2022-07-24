package gokul2411s.projects.problems.island_race;

/**
 * Represents a vehicle that can traverse supported connections.
 *
 * <p>
 *     Implementations must implement {@link #canTraverse} and {@link #safeTraverse} for each concrete type of
 *     {@link Connection}. These implementations respectively determine if the vehicle can physically traverse
 *     the connection and how it will do so.
 * </p>
 */
public interface Vehicle {

    void safeTraverse(WaterWayConnection connection);

    boolean canTraverse(WaterWayConnection connection);

    void safeTraverse(RoadWayConnection connection);

    boolean canTraverse(RoadWayConnection connection);

    default void traverse(Connection connection) {

        if (!canTraverse(connection)) {
            throw new RuntimeException(this + "cannot traverse " + connection);
        }
        safeTraverse(connection);
    }

    default boolean canTraverse(Connection connection) {
        return connection.allowsTraversing(this);
    }

    default void safeTraverse(Connection connection) {
        connection.safeTraverse(this);
    }
}
