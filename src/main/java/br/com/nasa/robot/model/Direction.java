package br.com.nasa.robot.model;

public enum Direction {
    N,
    S,
    E,
    W;

    public Direction left() {
        return values()[(ordinal() + 3) % 4];
    }

    public Direction right() {
        return values()[(ordinal() + 1) % 4];
    }
}
