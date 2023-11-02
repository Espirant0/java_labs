public class Cinema {
    protected String name;
    protected Hall[] halls;
    public Cinema(String name, Hall[] halls){
        this.name = name;
        this.halls = halls;
    }
    public String getName() {return name;}
    public Hall[] getHalls() {return halls;}

}

