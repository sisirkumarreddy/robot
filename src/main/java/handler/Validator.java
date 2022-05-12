package handler;

import model.Position;
import model.Room;

public class Validator {

    public static void validation(Room room, int faceIndex, Position position) throws Exception {
        if(room.getMaxX() < 0 || room.getMaxY() < 0) {
            throw new Exception("Invalid room");
        }
        if(room.getMaxY() < position.getY() || room.getMaxX() < position.getX()) {
            throw new Exception("Robot is out side the room");
        }
        if(faceIndex == -1) {
            throw new Exception("Invalid Facing");
        }
    }
}
