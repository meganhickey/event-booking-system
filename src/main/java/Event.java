import java.util.ArrayList;

public class Event {

    private String name;
    private int capacity;
    private ArrayList<String> attendees;

    public Event(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.attendees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAttendeeCount() {
        return attendees.size();
    }

    public boolean registerAttendee(String attendeeName) {

        if (attendees.contains(attendeeName)) {
            return false;
        }

        if (attendees.size() >= capacity) {
            return false;
        }

        attendees.add(attendeeName);
        return true;
    }

    public boolean cancelRegistration(String attendeeName) {
        return attendees.remove(attendeeName);
    }

    public boolean isFull() {
        return attendees.size() >= capacity;
    }

    public int getAvailableSpots() {
        return capacity - attendees.size();
    }
}