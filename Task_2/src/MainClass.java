public class MainClass {
    public static void main(String[] event) {

        //create subject
        NotificationsSubject projectPlan = new NotificationsSubject();

        //create observers
        Observer obs1 = new NotificationsObserver("Donna",5);
        Observer obs2=new NotificationsObserver("Johnny",3);
        Observer obs3=new NotificationsObserver("Dana",1);

        //register observers to the event alert subject
        projectPlan.register(obs1);
        projectPlan.register(obs2);
        projectPlan.register(obs3);

        //attach observer to subject
        obs1.setEvents(projectPlan);
        obs2.setEvents(projectPlan);
        obs3.setEvents(projectPlan);


        obs1.update();
        obs2.update();
        obs3.update();

        projectPlan.postMessage("Project started");


    }
}