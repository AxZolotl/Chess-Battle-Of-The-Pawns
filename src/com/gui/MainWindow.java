package com.gui;

import com.chessBOTP.Cells;
import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
    private JLabel num[] = new JLabel[8];
    private JLabel letters[] = new JLabel[8];
    private static Cells[][] cells = new Cells[8][8];
    private JPanel grid = new JPanel();

    /**
     * Sets the color of the cells that is available to move to. references the
     * cells array, to change the colors of the cells.
     * @param moveSets   the move set to be checked
     * @param chosenCell the cell that was clicked
     */
    public static void setColAvailCells(int[][] moveSets, Cells chosenCell) {
        for (int i = 0; i < moveSets.length; i++) {
            int x = chosenCell.posX + moveSets[i][0];
            int y = chosenCell.posY + moveSets[i][1];
            if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                cells[x][y].setBackground(Color.GREEN);
            }
        }
    }

    public static Cells[][] getCells() {
        return cells;
    }

    public MainWindow (){
      setDefaultCloseOperation(EXIT_ON_CLOSE);
		  setTitle("Chess");
		  setLayout(new BorderLayout());

      //JPanel for border numbers
      JPanel brdr_num = new JPanel ();
      brdr_num.setLayout(new GridLayout(1, 8));
      for (int x = 0; x<8; x++){
        num[x] = new JLabel ("" + (x+1));
        brdr_num.add(num[x]);
      }

      //JPanel for border letters
      JPanel brdr_let = new JPanel ();
      brdr_let.setLayout(new GridLayout(8, 1));
      for (char i = 'a'; i <= 'h'; i++) {
        int x = 0;
        letters[x] = new JLabel(""+i);
        brdr_let.add(letters[x]);
        x++;
      }

      //JPanel for cells
      grid.setLayout(new GridLayout (8, 8));
      for (int x = 0; x<8; x++){
        for (int y = 0; y<8; y++){
          cells[x][y] = new Cells (x, y, 0);
          grid.add (cells[x][y]);
        }
      }

      add(brdr_num, BorderLayout.NORTH);
      add(brdr_let, BorderLayout.WEST);
      add(grid, BorderLayout.CENTER);
      setSize(500, 500);
		  setVisible(true);
    } 
}
