package br.com.nasa.robot.controller;

import org.springframework.stereotype.Component;

import br.com.nasa.robot.model.Direction;
import br.com.nasa.robot.model.Position;

/*
 * Classe responsável por receber os comandos do controller
 * para alterar o direção do robô
 */
@Component
public class MarsRobot {
    private Position position;
    private Direction direction;

    public MarsRobot() {
        this.position = new Position(0, 0);
        this.direction = Direction.N;
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

    public void resetPosition() {
        this.position = new Position(0, 0);
        this.direction = Direction.N;
    }

    private void move() {
        switch (direction) {
            case N:
                position.setY(position.getY() + 1);
                break;
            case S:
                position.setY(position.getY() - 1);
                break;
            case E:
                position.setX(position.getX() + 1);
                break;
            case W:
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
