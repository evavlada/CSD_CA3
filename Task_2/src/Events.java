public class Events {
    //initialise events and priority
    private String events;
    private int priority;

    public Events(String events, int priority) {
        this.events=events;
        this.priority = priority;
    }
    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }



}
