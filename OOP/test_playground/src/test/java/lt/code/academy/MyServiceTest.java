package lt.code.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyServiceTest {
    private MyService service;

    @BeforeEach
    void setUp(){
        System.out.println("setUp");
        service = new MyService();
    }
    @Test
    void testWhenResultIsCorrect(){
        double result = Math.pow(3, 3);

        assertEquals(27, result);

    }
    @Test
    void testSum() {
        int sum = service.sum(50, 50);

        assertEquals(100, sum);

    }
}