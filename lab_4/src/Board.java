import Figures.Bishop;
import Figures.Figure;
import Figures.King;
import Figures.Knight;
import Figures.Pawn;
import Figures.Queen;
import Figures.Rook;

import java.util.ArrayList;

public class Board {
    private Figure  fields[][] = new Figure[8][8];
    private ArrayList<String> takeWhite = new ArrayList(16);
    private ArrayList<String> takeBlack = new ArrayList(16);

    public char getColorGaming() {return colorGaming;}

    public void setColorGaming(char colorGaming) {this.colorGaming = colorGaming;}

    private char colorGaming;

    public void init(){
        this.fields[0] = new Figure[]{
                new Rook("R", 'w'), new Knight("N", 'w'),
                new Bishop("B", 'w'), new Queen("Q", 'w'),
                new King("K", 'w'), new Bishop("B", 'w'),
                new Knight("N", 'w'),new Rook("R", 'w')
        };
        this.fields[1] = new Figure[]{
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
        };

        this.fields[7] = new Figure[]{
                new Rook("R", 'b'), new Knight("N", 'b'),
                new Bishop("B", 'b'), new Queen("Q", 'b'),
                new King("K", 'b'), new Bishop("B", 'b'),
                new Knight("N", 'b'),new Rook("R", 'b')
        };
        this.fields[6] = new Figure[]{
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
        };
    }

    public String getCell(int row, int col){
        Figure figure = this.fields[row][col];
        if (figure == null){
            return "    ";
        }
        return " "+figure.getColor()+figure.getName()+" ";
    }

    public ArrayList<String> getTakeWhite() {return takeWhite;}

    public ArrayList<String> getTakeBlack() {return takeBlack;}

    public boolean move_figure(int row1, int col1, int row2, int col2) {
        Figure figure = fields[row1][col1];
        if (figure != null && figure.canMove(row1, col1, row2, col2)) {
            if (fields[row2][col2] == null || fields[row2][col2].getColor() != figure.getColor()) {
                fields[row2][col2] = figure;
                fields[row1][col1] = null;
                return true;
            }
        } else if (figure.canAttack(row1, col1, row2, col2) && fields[row2][col2] != null && fields[row2][col2].getColor() != figure.getColor()) {
            if (!existsObstacle(row1, col1, row2, col2)) {
                if (!(fields[row2][col2] instanceof King)) {
                    switch (fields[row2][col2].getColor()) {
                        case 'w' -> takeWhite.add(fields[row2][col2].getColor() + fields[row2][col2].getName());
                        case 'b' -> takeBlack.add(fields[row2][col2].getColor() + fields[row2][col2].getName());
                    }
                    fields[row2][col2] = figure;
                    fields[row1][col1] = null;
                    return true;
                }
            }
        }
        return false;
    }
    public void print_board(){
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for(int row = 7; row > -1; row--){
            System.out.print(row);
            for(int col = 0; col< 8; col++){
                System.out.print("|"+getCell(row, col));
            }
            System.out.println("|");
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }
        for(int col = 0; col < 8; col++){
            System.out.print("    "+col);
        }

    }
    private int getRowOfKing(char color) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (fields[row][col] instanceof King && fields[row][col].getColor() == color) {
                    return row;
                }
            }
        }
        return -1;
    }
    private int getColOfKing(char color) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (fields[row][col] instanceof King && fields[row][col].getColor() == color) {
                    return col;
                }
            }
        }
        return -1;
    }
    private boolean existsObstacle(int row1, int col1, int row2, int col2) {
        int curRow = row1 + Integer.signum(row2 - row1);
        int curCol = col1 + Integer.signum(col2 - col1);
        while (curRow != row2 || curCol != col2) {
            if (fields[curRow][curCol]!= null) {
                return true;
            }
            curRow += Integer.signum(row2 - row1);
            curCol += Integer.signum(col2 - col1);
        }
        return false;
    }
    public boolean shahCheck(char color) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (fields[row][col] != null && fields[row][col].getColor() != color) {
                    if (fields[row][col].canAttack(row, col, getRowOfKing(color), getColOfKing(color))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean checkKing(int row1, int col1, int row2, int col2, char color) {
        Figure tmp = fields[row2][col2];
        fields[row2][col2] = fields[row1][col1];
        fields[row1][col1] = null;
        boolean result = shahCheck(color);
        fields[row1][col1] = fields[row2][col2];
        fields[row2][col2] = tmp;
        return !result;
    }

    public boolean mat() {
        if (shahCheck('b')) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (fields[row][col] != null && fields[row][col].getColor() == 'b' && fields[row][col].canMove(row, col, getRowOfKing('b'), getColOfKing('b'))) {
                        if (checkKing(row, col, getRowOfKing('b'), getColOfKing('b'), 'b')) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else if (shahCheck('w')) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (fields[row][col] != null && fields[row][col].getColor() == 'w' && fields[row][col].canMove(row, col, getRowOfKing('w'), getColOfKing('w'))) {
                        if (checkKing(row, col, getRowOfKing('w'), getColOfKing('w'), 'w')) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }
}