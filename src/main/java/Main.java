public class Main {

    public static void main(String[] args) {

        Event event = new Event("Java Workshop", 3);

        System.out.println("Event: " + event.getName());
        System.out.println("Capacity: " + event.getCapacity());

        event.registerAttendee("Megan");
        event.registerAttendee("Victoria");

        System.out.println("Registered attendees: " + event.getAttendeeCount());
        System.out.println("Available spots: " + event.getAvailableSpots());

        event.cancelRegistration("Megan");

        System.out.println("Attendees after cancellation: " + event.getAttendeeCount());
    }
}