import java.util.LinkedList;



public class NotificationsObserver implements Observer {
    private LinkedList<Observer> observers = new LinkedList<Observer>();
    private String name;
    private  String message;
    private Subject events;

    public NotificationsObserver(String name, int priority) {

        this.name=name;

    }



    // The update method updates the corresponding observers about the triggered event
    @Override
    public void update(){
        String message = (String) events.getUpdate(this);
        if(message == null){
            System.out.println(name + ":: No Change.");
        }else
            System.out.println(name + ":: Projects changes :: " + message);
    }
    @Override
    public void setEvents(Subject events) {
        this.events =events;
    }
}



