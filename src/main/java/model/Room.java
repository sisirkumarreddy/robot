package model;

import java.util.HashSet;
import java.util.Set;

public class Room {

    private int maxX;

    private int maxY;

    private int minX;

    private int minY;

    private Set<String> particle;

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public Set<String> getParticle() {
        return particle;
    }

    public void setParticle(Set<String> particle) {
        this.particle = particle;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }
}
