package Bank.BankArtifact;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Bank.BankArtifact.Bank;
import Bank.BankArtifact.Client;

public class BankIT {
	public final float floatTolerance = 0.0001f;
	private Bank bank;
	
	@Before
    public void setUp() {
		// this is a simple abstraction from what would be a database connection
		// testing several systems with one simple test
		
		bank = new Bank();
		Client carlos = new Client("Carlos");
		Client melo = new Client("Melo");
		Client rui = new Client("Rui");
		
		bank.addClient(carlos);	bank.addClient(melo); bank.addClient(rui);
    }
	

	@Test
	public void testDepositAmount() {
		// use the functions depositAccount(Client,float) & getClientByName(String) from Bank 
		bank.depositAccount(bank.getClientByName("Carlos"), 1000 );
		assertEquals(1000, bank.getClientByName("Carlos").getAccount());
	}
	
	@Test	
	public void testWithdrawAmount() {	
		// use the functions depositAccount(Client), getClientByName(String) & withdrawClientAccount(Client) from Bank
		bank.depositAccount(bank.getClientByName("Carlos"), 500);
		bank.withdrawClientAccount(bank.getClientByName("Carlos"),250);
		assertEquals(250, bank.getClientByName("Carlos").getAccount());
	}
	
	@Test
	public void testTransactionBetweenUsers() {
		// use the functions transfer(Client,Client,float) & getClientByName(String) from Bank
		bank.depositAccount(bank.getClientByName("Carlos"), 5000);
		bank.transfer(bank.getClientByName("Carlos"), bank.getClientByName("Melo"), 3000);
		assertEquals(3000, bank.getClientByName("Melo").getAccount());
	}

}
