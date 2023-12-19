import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Activity2 {
	
	 @Test
	    void notEnoughFundsTest() {
	        // Create an object for BankAccount class
	        BankAccount account = new BankAccount(9);

	        // Assertion for exception
	        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10),
	                "Balance must be greater than amount of withdrawal");
	    }

	    @Test
	    void enoughFundsTest() {
	        // Create an object for BankAccount class
	        BankAccount account = new BankAccount(100);
	        // Assertion for no exceptions
	        assertDoesNotThrow(() -> account.withdraw(100));
	    }

}
