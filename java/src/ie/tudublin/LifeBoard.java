
package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;
    boolean[][] next;
    private int size;
    private PApplet p;
    float cellwidth;

    public boolean getcell(int row, int col)
    {
        if (row >= 0 && row <= size -1 && col >= 0 && col <=size - 1)
        {
            return board[row][col];
        }
        else
        {
            return false;
        }
    }

    public LifeBoard(int size, PApplet p)
    {
        this.size = size;
        board = new boolean[size][size];
        this.p = p;
        cellwidth = p.width / (float) size;
    }

    public void randomise()
    {
        for(int row = 0; row < size; row ++)
        {
            for (int col = 0; col <size; col ++)
            {
                float dice = p.random(0, 1);
                board[row][col] = (dice <= 0.5f);
            }
        }
    }

    public int countCells(int row, int col)
    {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0) && row + i >= 0 && row + i < size && col + j >= 0 && col + j < size) {
                    if (board[row + i][col + j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

       
                
    public void applyRules(){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int count = countCells(row, col);
                if (board[row][col]) {
                    if (count < 2 || count > 3) {
                        next[row][col] = false; // cell dies
                    } else {
                        next[row][col] = true; // cell survives
                    }
                } else {
                    if (count == 3) {
                        next[row][col] = true; // cell comes to life
                    } else {
                        next[row][col] = false; // cell remains dead
                    }
                }
            }
        }
        boolean[][] temp = board;
        board = next;
        next = temp;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
    