public class Hall {
    private int hall_id;
    private int row;
    private int seat;
    private String [][] seats;

    public Hall(int hall_id, int row, int seat){
        this.hall_id = hall_id;
        this.row = row;
        this.seat = seat;
        this.seats = new String[this.row][this.seat];
        Hall.this.defaultSeats();
    }
    public int getHallId() {return hall_id;}
    public int getRow() {return row;}
    public int getSeat() {return seat;}


    public void printSeats()
    {
        System.out.println("---------------------ЭКРАН-----------------------");
        System.out.print("     ");
        for (int i = 0; i < seat; i++){
            if (i < 9)
                System.out.print((i + 1)+"   ");
            else if(i==9)
                System.out.print((i + 1));
            else
                System.out.print("  " + (i + 1));
        }
        System.out.println();
        for (int row = 0; row < this.row; row++){
            if(row<9)
                System.out.print((row+1) +  " | ");
            else
                System.out.print((row+1) +  "| ");
            for (int place = 0; place < seat; place++){
                System.out.print(seats[row][place] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void defaultSeats(){
        for(int i=0; i<this.row; i++){
            for(int j=0; j<this.seat; j++){
                seats[i][j] = "[ ]";
            }
        }
    }
    public boolean setSeat(int row, int seat) {
        boolean is_free = true;
        if (seats[row][seat].equals("[ ]")) {
            seats[row][seat] = "[X]";
            is_free = false;
        }
        else{
            System.out.println("Это место уже занято! Выберите другое место.");
        }
        return is_free;
    }
}
