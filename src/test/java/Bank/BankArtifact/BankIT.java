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
		bank.depositAccount(bank.getClientByName("Carlos"), 1000f );
		assertEquals(1000f, bank.getClientByName("Carlos").getAccount().getAmount(),floatTolerance);
	}
	
	@Test	
	public void testWithdrawAmount() {	
		// use the functions depositAccount(Client), getClientByName(String) & withdrawClientAccount(Client) from Bank
		bank.depositAccount(bank.getClientByName("Carlos"), 500f);
		bank.withdrawClientAccount(bank.getClientByName("Carlos"),250f);
		assertEquals(250f, bank.getClientByName("Carlos").getAccount().getAmount(),floatTolerance);
	}
	
	@Test
	public void testTransactionBetweenUsers() {
		// use the functions transfer(Client,Client,float) & getClientByName(String) from Bank
		bank.depositAccount(bank.getClientByName("Carlos"), 5000f);
		bank.transfer(bank.getClientByName("Carlos"), bank.getClientByName("Melo"), 3000f);
		assertEquals(3000, bank.getClientByName("Melo").getAccount().getAmount(),floatTolerance);
	}

}
