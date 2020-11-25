package week2.GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class GUI extends JFrame {
    public JPanel[][] cells = new JPanel[100][100];
    public int[][] alivenessCells = new int[100][100];
    public boolean finished = false;


    public GUI() {
        this.setSize(500, 500);
        this.setTitle("Game of Life");
        this.createGUI();
        this.setVisible(true);
        initialiseArray();
        play();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new GridLayout(100, 100));
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new JPanel();
                window.add(cells[i][j]);
            }
        }
    }

    private void initialiseArray() {
        Random random = new Random();
        for (int i = 0; i < alivenessCells.length; i++) {
            Arrays.fill(alivenessCells[i], 0);
            for (int j = 0; j < alivenessCells[i].length; j++) {
                alivenessCells[i][j] = random.nextInt(2);
            }
        }
    }

    private void play() {
        while (!finished) {
            colourCells();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            playingGod();
            check();
        }
        colourCells();
    }

    private void colourCells() {
        for (int i = 0; i < alivenessCells.length; i++) {
            for (int j = 0; j < alivenessCells[i].length; j++) {
                if (alivenessCells[i][j] == 1) {
                    cells[i][j].setBackground(Color.black);
                } else {
                    cells[i][j].setBackground(Color.white);
                }
            }
        }
    }

    private void playingGod() {
        int[][] temp = new int[100][100];
        for (int row = 0; row < temp.length; row++) {
            for (int column = 0; column < temp[row].length; column++) {
                int liveNeighbours = 0;
                for (int horizontal = -1; horizontal <= 1; horizontal++) {
                    for (int vertical = -1; vertical <= 1; vertical++) {
                        try {
                            if (row + horizontal == row && column + vertical == column) {

                            } else if (alivenessCells[row + horizontal][column + vertical] == 1) {
                                liveNeighbours++;
                            }
                        } catch (IndexOutOfBoundsException ignored) {
                        }
                    }
                }
                if (alivenessCells[row][column] == 0) {
                    if (liveNeighbours == 3) {
                        temp[row][column] = 1;
                    }
                } else if (alivenessCells[row][column] == 1) {
                    if (liveNeighbours == 3 || liveNeighbours == 2) {
                        temp[row][column] = 1;
                    }
                } else {
                    temp[row][column] = 0;
                }
            }
        }
        alivenessCells = temp.clone();
    }

    private void check() {
        int count = 0;
        for (int[] ints : alivenessCells) {
            for (int i : ints) {
                if (i == 0) {
                    count++;
                }
            }
        }
        if (count == 100) {
            finished = true;
        }
    }

}
