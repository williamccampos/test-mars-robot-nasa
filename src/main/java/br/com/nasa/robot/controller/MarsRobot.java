package br.com.nasa.robot.controller;

import org.springframework.stereotype.Component;

import br.com.nasa.robot.model.Direction;
import br.com.nasa.robot.model.Position;

@Component
public class MarsRobot {
    private Position position;
    private Direction direction;

    public MarsRobot() {
        this.position = new Position(0, 0);
        this.direction = Direction.NORTH;
    }

    public String executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'M') {
                move();
            } else if (command == 'L') {
                turnLeft();
            } else if (command == 'R') {
                turnRight();
            }
        }
        return getCurrentPosition();
    }

    private void move() {
        switch (direction) {
            case NORTH:
                position.setY(position.getY() + 1);
                break;
            case SOUTH:
                position.setY(position.getY() - 1);
                break;
            case EAST:
                position.setX(position.getX() + 1);
                break;
            case WEST:
                position.setX(position.getX() - 1);
                break;
        }
    }

    private void turnLeft() {
        direction = direction.left();
    }

    private void turnRight() {
        direction = direction.right();
    }

    private String getCurrentPosition() {
        return "(" + position.getX() + ", " + position.getY() + ", " + direction + ")";
    }
}
