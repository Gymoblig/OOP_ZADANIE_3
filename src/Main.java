import handler.TaskHandler;
import tasks.SimpleTask;
import tasks.RecurringTask;

public class Main {
    public static void main(String[] args) {
        SimpleTask t1 = new SimpleTask("Vyvenčiť Dunča", 2);
        SimpleTask t2 = new SimpleTask("Vystreliť si mozog z hlavy", 1);
        RecurringTask t3 = new RecurringTask("Umyť si chrup", 2, 2, 2);
        TaskHandler taskHandler = new TaskHandler();
        taskHandler.addTask(t1);
        taskHandler.addTask(t2);
        taskHandler.addTask(t3);
        taskHandler.removeTask(t2);
        System.out.println(taskHandler.getTaskIndex(t1)+": "+t1.getId());
        System.out.println(taskHandler.getTaskIndex(t2)+": "+t2.getId());
        System.out.println(taskHandler.getTaskIndex(t3)+": "+t3.getId());
        taskHandler.tickLoop(6);
        
    }
}