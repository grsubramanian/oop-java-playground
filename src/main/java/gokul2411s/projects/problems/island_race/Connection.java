package gokul2411s.projects.problems.island_race;

/**
 * Represents a connection between two islands.
 *
 * <p>
 *     An implementation class `AConnection` must implement {@link #allowsTraversing(Vehicle)} and
 *     {@link #safeTraverse(Vehicle)} which respectively invoke {@link Vehicle#canTraverse(AConnection)} and
 *     {@link Vehicle#safeTraverse(AConnection)}. In addition, these implementations can encode legality of whether
 *     a vehicle can traverse a connection over and above whether the vehicle can physically traverse the connection.
 * </p>
 */
public interface Connection {

    int fromIsland();

    int toIsland();

    boolean allowsTraversing(Vehicle vehicle);

    void safeTraverse(Vehicle vehicle);
}
