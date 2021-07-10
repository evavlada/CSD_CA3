public class MainClass {
    public static void main(String[] event) {

        //create subject
        NotificationsSubject projectPlan = new NotificationsSubject();

        //create observers
        Observer obs1 = new NotificationsObserver("Donna",5);
        Observer obs2=new NotificationsObserver("Johnny",3);
        Observer obs3=new NotificationsObserver("Dana",1);

        Events event1= new Events("repository pushed", 1);
        Events event2= new Events("changes made", 3);
        Events event3=new Events("new branch", 4);

        //register observers to the event alert subject
        projectPlan.register(obs1);
        projectPlan.register(obs2);
        projectPlan.register(obs3);

        //attach observer to subject
        obs1.setEvents(projectPlan);
        obs2.setEvents(projectPlan);
        obs3.setEvents(projectPlan);

        //check if any update is available
        obs1.update();
        obs2.update();
        obs3.update();

        //now send message to the subjects notifying all the changes
        projectPlan.postMessage("Project started");
        event1.getEvents();
        projectPlan.postMessage(event1.getEvents());
        event1.getPriority();
        projectPlan.postMessage(String.valueOf(event1.getPriority()));


    }
}