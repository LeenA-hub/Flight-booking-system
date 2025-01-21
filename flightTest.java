package flight.booking.system;


import org.junit.Test;

public class flightTest {

    @Test
    public void testConstructor() {
        flight flight = new flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 100, 1000.0);
        assertEquals(1030, flight.getFlightNumber());
        assertEquals("Toronto", flight.getOrigin());
        assertEquals("Kolkata", flight.getDestination());
        assertEquals("03/02/99 7:50 pm", flight.getDepartureTime());
        assertEquals(100, flight.getCapacity());
        assertEquals(100, flight.getNumberOfSeatsLeft());
        assertEquals(1000.0, flight.getOriginalPrice(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        // This should throw an IllegalArgumentException because origin and destination are the same
        new Flight(1031, "Toronto", "Toronto", "03/02/99 7:50 pm", 100, 1000.0);
    }

    @Test
    public void testBookASeat() {
        flight flight = new flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 100, 1000.0);

        // Book a seat and verify the result
        assertTrue(flight.bookASeat());
        assertEquals(99, flight.getNumberOfSeatsLeft());

        // Book all seats
        for (int i = 0; i < 99; i++) {
            assertTrue(flight.bookASeat());
        }

        // No seats left, booking should fail
        assertFalse(flight.bookASeat());
        assertEquals(0, flight.getNumberOfSeatsLeft());
    }

    @Test
    public void testToString() {
        flight flight = new flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 100, 1000.0);
        String expected = "Flight 1030, Toronto to Kolkata, 03/02/99 7:50 pm, original price: $1000.0";
        assertEquals(expected, flight.toString());
    }

    @Test
    public void testGettersAndSetters() {
        flight flight = new flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 100, 1000.0);

        // Test getters
        assertEquals(1030, flight.getFlightNumber());
        assertEquals("Toronto", flight.getOrigin());
        assertEquals("Kolkata", flight.getDestination());
        assertEquals("03/02/99 7:50 pm", flight.getDepartureTime());
        assertEquals(100, flight.getCapacity());
        assertEquals(1000.0, flight.getOriginalPrice(), 0.001);

        // Test setters
        flight.setFlightNumber(2040);
        flight.setOrigin("Vancouver");
        flight.setDestination("Delhi");
        flight.setDepartureTime("04/03/99 8:00 pm");
        flight.setCapacity(150);
        flight.setNumberOfSeatsLeft(120);
        flight.setOriginalPrice(1200.0);

        assertEquals(2040, flight.getFlightNumber());
        assertEquals("Vancouver", flight.getOrigin());
        assertEquals("Delhi", flight.getDestination());
        assertEquals("04/03/99 8:00 pm", flight.getDepartureTime());
        assertEquals(150, flight.getCapacity());
        assertEquals(120, flight.getNumberOfSeatsLeft());
        assertEquals(1200.0, flight.getOriginalPrice(), 0.001);
    }
}
