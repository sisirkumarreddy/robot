package controller;

import model.Position;
import model.Room;
import service.RobotTravel;

import java.util.HashSet;
import java.util.Set;

public class MainController {

    public static void main(String[] args) throws Exception {
        String[] roomCoordinates = args[0].split(" ");
        String[] robotPosition = args[1].split(" ");
        Position position = new Position();
        position.setX(Integer.valueOf(robotPosition[0]));
        position.setY(Integer.valueOf(robotPosition[1]));
        Room room = new Room();
        room.setMaxX(Integer.valueOf(roomCoordinates[0]));
        room.setMaxY(Integer.valueOf(roomCoordinates[1]));
        Set<String> particles = new HashSet<>();
        //particles.add("X=3Y=3"); // provide particle on its way
        room.setParticle(particles);
        RobotTravel robot = new RobotTravel(room);
        System.out.println(robot.finalPosition(position, args[2].toCharArray(), getFaceIndex(robotPosition[2])));
    }

    private static int getFaceIndex(String faceAsString) {
        int i;
        for (i = 0; i < 4; i++) {
            if(RobotTravel.FACE[i].equals(faceAsString)) {
                return i;
            }
        }
        return -1;
    }
}
