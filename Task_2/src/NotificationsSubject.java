import java.util.ArrayList;
import java.util.List;

public class NotificationsSubject implements Subject {

    private  List<Observer> observerList;
    private boolean changed;
    private String message;
    private final Object MUTEX = new Object();

    public NotificationsSubject() {
        this.observerList = new ArrayList<>();

    }

    @Override
    public void register(Observer obj) {
        if (obj == null) {
            throw new NullPointerException("Object is null");
        }
        synchronized (MUTEX){
            //Not ont eh list add it
            if(!observerList.contains(obj)) observerList.add(obj);
        }
    }



    @Override
    public void notifyObservers() {
        List<Observer> observersLocal ;
        //synchronization is used to make sure any observer registered
        // after message is received is not notified
        synchronized (MUTEX){
            if(!changed)
                return;

            this.changed = false;
        }
        for(Observer obj : observerList){
            obj.update();
        }

    }
    @Override
    public void unregister(Observer obj){
        synchronized (MUTEX){
            observerList.remove(obj);
        }
    }

    @Override
    public Object getUpdate(Observer obj){
        return this.message;
    }
    //method used by the currency system to notify the
    // subject of a price change
    public void postMessage(String msg){
        System.out.println("Project updates: " + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }

}
