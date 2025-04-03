package tasks;

public class RecurringTask extends AbstractTask {
    private long delayBetweenRuns;
    private Integer numberOfRuns; // null znamená nekonečné opakovanie
    private long nextRunTick;

    
    public RecurringTask(String message, long runAtTick, long delayBetweenRuns, Integer numberOfRuns) {
        super(message, runAtTick);
        assert delayBetweenRuns > 0;
        assert numberOfRuns == null || numberOfRuns > 0;

        this.delayBetweenRuns = delayBetweenRuns;
        this.numberOfRuns = numberOfRuns;
        this.nextRunTick = runAtTick;
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
        RecurringTask fessSpravne = (RecurringTask) obj;
        return this.getId().equals(fessSpravne.getId());
    }
}