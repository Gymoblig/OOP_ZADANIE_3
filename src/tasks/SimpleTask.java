package tasks;

public class SimpleTask extends AbstractTask {
    private boolean finished = false;

    public SimpleTask(String description, long scheduledTick) {
        super(description, scheduledTick); // Volanie konštruktora nadradenej triedy
    }

    @Override
    public boolean isScheduledAt(long tick) {
        return tick == getRunAtTick(); // Použitie metódy z AbstractTask
    }

    @Override
    public void run() {
        System.out.println("Task "+getId()+": " + getMessage());
        finished = true; // Po spustení je úloha dokončená
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SimpleTask that = (SimpleTask) obj;
        return getRunAtTick() == that.getRunAtTick() && getMessage().equals(that.getMessage());
    }
}