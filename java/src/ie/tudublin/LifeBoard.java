package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;
    private int size;
    private PApplet p;
    float cellwidth;

    public boolean getcell(int row, int col)
    {
        if (row >= 0 && row <= size -1 )
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
        for (int i = -1; i <= 1; i++)
        {
            if (! (i == 0) && (j == 0))
            {
                if(getcell)
            }
        }
    }

    public void applyRules()
    {
        for(int row = 0; row < size; row ++)
        {
            for (int col = 0; col <size; col ++)
            {
                int count = countCells(row,col);
                // < 2 > 3 dies
                // 2-3 survives 
                // dead with 3 neighbours come to life

            }
        }
}

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
