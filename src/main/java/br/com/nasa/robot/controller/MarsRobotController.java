package br.com.nasa.robot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MarsRobotController {

    private final MarsRobot marsRobot;

    public MarsRobotController(MarsRobot marsRobot) {
        this.marsRobot = marsRobot;
    }

    /*
     * Endpoint de recebimento das coordenadas para movimentar o robô
     */
    @PostMapping("/rest/mars/{command}")
    public ResponseEntity<String> executeCommand(@PathVariable String command) {
        marsRobot.resetPosition();
        if (!isValidCommand(command)) {
            return ResponseEntity.badRequest().body("400 Bad Request");
        }

        String finalPosition = marsRobot.executeCommands(command);
        return ResponseEntity.ok(finalPosition);
    }

    /*
     * Método de validação dos dados recebidos na requisição
     */
    private boolean isValidCommand(String command) {
        if (command.length() > 10) {
            return false;
        }
        return command.matches("[LRM]+");
    }
}
