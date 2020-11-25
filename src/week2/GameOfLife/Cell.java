package week2.GameOfLife;

import javax.swing.*;

public class Cell extends JPanel {
    private boolean alive;

    public Cell() {
        super();
        this.alive = false;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public void setAlive(boolean status) {
        this.alive = status;
    }
}
