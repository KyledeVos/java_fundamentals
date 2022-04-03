package mysql.labs;

public class Flight {

    private int id;
    private int start_id;
    private int end_id;
    private int airline_id;
    private String date;

    public Flight(){

    }

    public Flight(int id, int start_id, int end_id, int airline_id, String date) {
        this.id = id;
        this.start_id = start_id;
        this.end_id = end_id;
        this.airline_id = airline_id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart_id() {
        return start_id;
    }

    public void setStart_id(int start_id) {
        this.start_id = start_id;
    }

    public int getEnd_id() {
        return end_id;
    }

    public void setEnd_id(int end_id) {
        this.end_id = end_id;
    }

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id = airline_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", start_id=" + start_id +
                ", end_id=" + end_id +
                ", airline_id=" + airline_id +
                ", date='" + date + '\'' +
                '}';
    }
}
