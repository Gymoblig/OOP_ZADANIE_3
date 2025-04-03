package tasks;

public abstract class AbstractTask {
    protected String message;
    protected long runAtTick;
    private String id;
    public abstract boolean isFinished();

    public AbstractTask(String message, long runAtTick) {
        // Overenie podmienok pomocou assert
        assert message != null && !message.isEmpty(); 
        assert runAtTick >= 0;
        
        this.message = message;
        this.runAtTick = runAtTick;
        this.id = TaskIdGenerator.generateTaskId(this);
    }

    public long getRunAtTick() {
        return runAtTick;
    }

    public String getId() {
        return this.id;
    }

    public String getMessage() {
        return message;
    }

    
    public abstract void run(); // Abstraktná metóda, ktorá musí byť implementovaná v podtriedach
    public boolean isScheduledAt(long currentTick) {
        return currentTick == runAtTick;
    }
}