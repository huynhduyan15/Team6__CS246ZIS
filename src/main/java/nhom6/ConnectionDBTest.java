package nhom6;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConnectionDBTest {

    private ConnectionDB testSubject;

    @Before
    public void setUp() throws Exception {
        testSubject = new ConnectionDB();
    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void testGetStm() throws Exception {
        Statement result = testSubject.getStm();
        assertNotNull(result);
    }

    @Test
    public void testSetStm() throws Exception {
        Statement stm = testSubject.getStm();
        testSubject.setStm(stm);
        assertEquals(stm, testSubject.getStm());
    }

    @Test
    public void testGetConn() throws Exception {
        Connection result = ConnectionDB.getConn();
        assertNotNull(result);
    }

    @Test
    public void testSetConn() throws Exception {
        Connection conn = ConnectionDB.getConn();
        ConnectionDB.setConn(conn);
        assertEquals(conn, ConnectionDB.getConn());
    }
  
}
