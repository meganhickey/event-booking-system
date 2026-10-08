import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    public void testEventCreation() {
        Event event = new Event("Java Workshop", 3);

        Assertions.assertEquals("Java Workshop", event.getName());
        Assertions.assertEquals(3, event.getCapacity());
    }

    @Test
    public void testRegisterAttendee() {
        Event event = new Event("Java Workshop", 3);

        Assertions.assertEquals(0, event.getAttendeeCount());

        event.registerAttendee("Megan");

        Assertions.assertEquals(1, event.getAttendeeCount());
    }

    @Test
    public void testEventCapacity() {
        Event event = new Event("Java Workshop", 3);

        event.registerAttendee("Megan");
        event.registerAttendee("Victoria");
        event.registerAttendee("John");

        Assertions.assertEquals(3, event.getAttendeeCount());

        event.registerAttendee("Sarah");

        // Event is full, so Sarah should not be added
        Assertions.assertEquals(3, event.getAttendeeCount());
    }

    @Test
    public void testDuplicateRegistration() {
        Event event = new Event("Java Workshop", 3);

        event.registerAttendee("Megan");
        Assertions.assertEquals(1, event.getAttendeeCount());

        event.registerAttendee("Megan");

        // Same attendee should not be registered twice
        Assertions.assertEquals(1, event.getAttendeeCount());
    }

    @Test
    public void testCancelRegistration() {
        Event event = new Event("Java Workshop", 3);

        event.registerAttendee("Megan");
        event.registerAttendee("Victoria");

        Assertions.assertEquals(2, event.getAttendeeCount());

        event.cancelRegistration("Megan");

        Assertions.assertEquals(1, event.getAttendeeCount());
    }

    @Test
    public void testCancelUnregisteredAttendee() {
        Event event = new Event("Java Workshop", 3);

        event.registerAttendee("Megan");

        Assertions.assertEquals(1, event.getAttendeeCount());

        event.cancelRegistration("Victoria");

        // Victoria was not registered, so the attendee count should stay the same
        Assertions.assertEquals(1, event.getAttendeeCount());
    }

    @Test
    public void testEventIsFull() {
        Event event = new Event("Java Workshop", 2);

        event.registerAttendee("Megan");
        event.registerAttendee("Victoria");

        Assertions.assertTrue(event.isFull());
    }

    @Test
    public void testEventIsNotFull() {
        Event event = new Event("Java Workshop", 3);

        event.registerAttendee("Megan");

        Assertions.assertFalse(event.isFull());
    }

    @Test
    public void testAvailableSpots() {
        Event event = new Event("Java Workshop", 5);

        event.registerAttendee("Megan");
        event.registerAttendee("Victoria");

        Assertions.assertEquals(3, event.getAvailableSpots());
    }

    @Test
    public void testAvailableSpotsWhenEventIsFull() {
        Event event = new Event("Java Workshop", 2);

        event.registerAttendee("Megan");
        event.registerAttendee("Victoria");

        Assertions.assertEquals(0, event.getAvailableSpots());
    }

    @Test
    public void testSuccessfulRegistrationReturnsTrue() {
        Event event = new Event("Java Workshop", 3);

        boolean result = event.registerAttendee("Megan");

        Assertions.assertTrue(result);
    }

    @Test
    public void testRegistrationWhenFullReturnsFalse() {
        Event event = new Event("Java Workshop", 1);

        event.registerAttendee("Megan");

        boolean result = event.registerAttendee("Victoria");

        Assertions.assertFalse(result);
    }
}