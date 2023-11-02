public class Seance {
    private Cinema cinema;
    private String title;
    private Hall hall;
    private String start;
    private String end;

    public Seance(Cinema cinema, String title, Hall hall, String start, String end){
        this.cinema = cinema;
        this.title = title;
        this.hall = new Hall(hall.getHallId(), hall.getRow(), hall.getSeat());
        this.start = start;
        this.end = end;
    }

    public Cinema getCinema() {return cinema;}
    public String getTitle() {return title;}
    public Hall getHall() {return hall;}
    public String getStart() {return start;}
    public String getEnd() {return end;}
}
