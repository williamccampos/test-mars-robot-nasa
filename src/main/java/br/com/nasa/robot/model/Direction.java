package br.com.nasa.robot.model;

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public Direction left() {
        return values()[(ordinal() + 3) % 4];
    }

    public Direction right() {
        return values()[(ordinal() + 1) % 4];
    }
}
