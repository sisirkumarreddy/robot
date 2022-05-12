package service;

import model.Position;
import model.Room;
import handler.Validator;

import java.util.HashSet;
import java.util.Set;

public class RobotTravel {
    public static final String[] FACE = {"N", "E", "S", "W"};
    private Set<String> travelled = new HashSet<>();
    private Room room;

    public RobotTravel(Room room) {
       this.room = room;
    }

    public  String finalPosition(Position position, char[] directions, int faceIndex) throws Exception {
        Validator.validation(room,faceIndex,position);
        travelled.add("X=" + position.getX() + "Y=" + position.getY());
        for (char direction : directions) {
            if (direction == 'M') {
                int currentX = position.getX();
                int currentY = position.getY();
                nextPosition(faceIndex, position);
                String nextPosition = "X=" + position.getX() + "Y=" + position.getY();
                if (isMoveNotPossible(nextPosition, position.getX(), position.getY()))
                    return (currentX + " " + currentY + " " + FACE[faceIndex]);
                travelled.add(nextPosition);
            } else if (direction == 'L') {
                faceIndex--;
                if (faceIndex < 0)
                    faceIndex = 3;
            } else if (direction == 'R') {
                faceIndex++;
                if (faceIndex > 3)
                    faceIndex = 0;
            } else {
                throw new Exception ("Invalid Input");
            }
        }
        return (position.getX() + " " + position.getY() + " " + FACE[faceIndex]);
    }

    private void nextPosition(int faceIndex, Position position) {
        if (faceIndex == 0) {
            position.setY(position.getY() + 1);
        } else if (faceIndex == 1) {
            position.setX(position.getX() + 1);
        } else if (faceIndex == 2) {
            position.setY(position.getY() - 1);
        } else if (faceIndex == 3) {
            position.setX(position.getX() - 1);
        }
    }

    private boolean isMoveNotPossible(String nextPosition, int tempX, int tempY) {
        return (travelled.contains(nextPosition)
                || room.getParticle().contains(nextPosition)
                || tempX > room.getMaxX() || tempY > room.getMaxY() || tempY < room.getMinX() || tempX < room.getMinY());
    }
}
