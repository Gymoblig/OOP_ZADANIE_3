package handler;
import java.util.Arrays;
import tasks.AbstractTask;


public class TaskHandler {
    private static final int MAXIMUM_TASKS = 5;
    private AbstractTask[] tasks = new AbstractTask[MAXIMUM_TASKS];
    private int tasksIndex = 0;

    public void addTask(AbstractTask task) {
        if (tasksIndex < MAXIMUM_TASKS) {
            tasks[tasksIndex] = task;
            tasksIndex++;
        } else {
            throw new IllegalStateException("Uz nie je volne miesto na pridanie Tasku");
        }
    }
    
    public void removeTask(AbstractTask task){
        for(int i = 0; i < tasksIndex; i++){
            if(tasks[i] == task){
                for(int j = i; j < tasksIndex - 1; j++){
                    tasks[j] = tasks[j + 1];
                }
                tasks[tasksIndex - 1] = null;
                tasksIndex--;
                break;
            }
        }
    }

    public void tickLoop(long durationInNumberOfTicks) {
        for (long tick = 0; tick < durationInNumberOfTicks; tick++) {
            System.out.println("Current tick: " + tick);
    
            for (int i = 0; i < tasksIndex; i++) {
                AbstractTask task = tasks[i];
                if (task.isScheduledAt(tick)) {
                    task.run();
                    if (task.isFinished()) {
                        removeTask(task);
                        i-=1; 
                    }
                }
            }
    
            System.out.println("===");
        }
    }

    public AbstractTask[] getTasks() {
        return Arrays.copyOf(tasks, tasksIndex);
    }
    public int getTaskIndex(AbstractTask task) {
        for (int i = 0; i < tasksIndex; i++) {
            if (tasks[i].equals(task)) {
                return i;
            }
        }
        return -1; // ak sa úloha nenašla
    }
}
