import org.junit.Test;

import static org.junit.Assert.*;

public class endpointTests {

    @Test
    public void testGetValue() {
        Endpoint endpoint = new Endpoint(4, -1);
        assertEquals(4, endpoint.getValue());
    }

    @Test
    public void testGetP() {
        Endpoint endpoint = new Endpoint(4, -1);
        assertEquals(-1, endpoint.getP());
    }
}