package tasks;

public abstract class AbstractTask {
    private final String message;
    private final long runAtTick;
    private final String taskId;
    public abstract boolean isFinished();

    public AbstractTask(String message, long runAtTick) {
        // Overenie podmienok pomocou assert
        assert message != null && !message.isEmpty() : "Správa nemôže byť prázdna alebo null"; 
        assert runAtTick >= 0 : "runAtTick nesmie byť záporný";
        
        this.message = message;
        this.runAtTick = runAtTick;
        this.taskId = TaskIdGenerator.generateTaskId(this);
    }

    public long getRunAtTick() {
        return runAtTick;
    }

    public String getId() {
        return this.taskId;
    }

    public String getMessage() {
        return message;
    }

    public abstract void run(); // Abstraktná metóda, ktorá musí byť implementovaná v podtriedach
    public boolean isScheduledAt(long currentTick) {
        return currentTick == runAtTick;
    }
}