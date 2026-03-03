import java.util.ArrayList;

abstract class PlanItem {
    String name;
    int minutesRemaining; // Estimated time
    boolean isCompleted = false;

    public PlanItem(String name, int minutesRemaining) {
        this.name = name;
        this.minutesRemaining = minutesRemaining;
    }

    // Abstract methods to be overridden (Specific Behavior)
    public abstract String getUrgency();
    public abstract void displayDetails();

    public void markAsComplete() {
        this.isCompleted = true;
    }
}

class Assignment extends PlanItem {
    public Assignment(String name, int mins) { super(name, mins); }

    @Override
    public String getUrgency() {
        return isCompleted ? "None" : (minutesRemaining < 60 ? "CRITICAL" : "High");
    }

    @Override
    public void displayDetails() {
        System.out.println("[Assignment] " + name + " | Status: " + (isCompleted ? "Done" : "Pending") + " | Urgency: " + getUrgency());
    }
}

class ClubEvent extends PlanItem {
    public ClubEvent(String name, int mins) { super(name, mins); }

    @Override
    public String getUrgency() {
        return "Medium (Social)";
    }

    @Override
    public void displayDetails() {
        System.out.println("[Social] " + name + " | Prep Time: " + minutesRemaining + " mins");
    }
}

public class Main2 {
    public static void main(String[] args) {
        ArrayList<PlanItem> schedule = new ArrayList<>();

        schedule.add(new Assignment("Java Lab 4", 45));
        schedule.add(new ClubEvent("Chess Club Meet", 20));
        schedule.add(new Assignment("History Essay", 300));

        // 1 Print all using overridden behavior
        System.out.println(" Current Schedule");
        for (PlanItem item : schedule) {
            item.displayDetails();
        }

        // 2 Mark one as completed and show update
        System.out.println("\nUpdating Status");
        schedule.get(0).markAsComplete();
        schedule.get(0).displayDetails();

        // 3 Summarizing tasks
        int totalTime = 0;
        for (PlanItem item : schedule) {
            if (!item.isCompleted) totalTime += item.minutesRemaining;
        }
        System.out.println("\nSummary: Total remaining work time: " + totalTime + " minutes.");
    }
}