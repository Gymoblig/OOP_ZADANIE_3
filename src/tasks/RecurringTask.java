package tasks;

public class RecurringTask extends AbstractTask {
    private final long delayBetweenRuns;
    private Integer numberOfRuns; // null znamená nekonečné opakovanie
    private long nextRunTick;

    
    public RecurringTask(String description, long startTick, long delayBetweenRuns, Integer numberOfRuns) {
        super(description, startTick);
        assert delayBetweenRuns > 0 : "Delay between runs must be positive";
        assert numberOfRuns == null || numberOfRuns > 0 : "Number of runs must be null or positive";

        this.delayBetweenRuns = delayBetweenRuns;
        this.numberOfRuns = numberOfRuns;
        this.nextRunTick = startTick;
    }

    @Override
    public boolean isScheduledAt(long tick) {
        return tick == nextRunTick && (numberOfRuns == null || numberOfRuns > 0);
    }

    @Override
    public void run() {
        if (numberOfRuns == null || numberOfRuns > 0) {
            // Vypíš správu
            System.out.println("Task " + getId() + ": " + getMessage());
            
            // Aktualizuj počet zostávajúcich spustení
            if (numberOfRuns != null) {
                numberOfRuns--;
            }
            
            // Nastav čas ďalšieho spustenia
            nextRunTick += delayBetweenRuns;
        }
    }

    @Override
    public boolean isFinished() {
        return numberOfRuns != null && numberOfRuns <= 0;
    }

    public long getDelayBetweenRuns() {
        return delayBetweenRuns;
    }

    public Integer getNumberOfRuns() {
        return numberOfRuns;
    }

    @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            RecurringTask that = (RecurringTask) obj;
            return getRunAtTick() == that.getRunAtTick() 
                && getNumberOfRuns() == that.getNumberOfRuns()
                && getDelayBetweenRuns() == that.getDelayBetweenRuns()
                && getMessage().equals(that.getMessage());
        }
}