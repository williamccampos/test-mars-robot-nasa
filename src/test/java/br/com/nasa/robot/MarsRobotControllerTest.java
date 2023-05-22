package br.com.nasa.robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.nasa.robot.controller.MarsRobot;
import br.com.nasa.robot.controller.MarsRobotController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MarsRobotControllerTest {

    @Mock
    private MarsRobot marsRobot;

    @InjectMocks
    private MarsRobotController marsRobotController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        configureInitialPosition(); // Configurar posição inicial antes de cada teste
    }

    private void configureInitialPosition() {
        when(marsRobot.executeCommands("")).thenReturn("(0, 0, N)");
    }

    @Test
    void testExecuteCommand_ValidCommand() {
        String command = "MML";
        String expectedFinalPosition = "(0, 2, W)";

        when(marsRobot.executeCommands(command)).thenReturn(expectedFinalPosition);

        ResponseEntity<String> responseEntity = marsRobotController.executeCommand(command);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedFinalPosition, responseEntity.getBody());

        verify(marsRobot, times(1)).executeCommands(command);
        verifyNoMoreInteractions(marsRobot);
    }

    @Test
    void testExecuteCommand_InvalidCommand() {
        String invalidCommand = "AAA";

        ResponseEntity<String> responseEntity = marsRobotController.executeCommand(invalidCommand);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("400 Bad Request", responseEntity.getBody());

        verifyNoInteractions(marsRobot);
    }
}
