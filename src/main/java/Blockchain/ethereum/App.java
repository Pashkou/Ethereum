package Blockchain.ethereum;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 *
 */
public class App 
{

	
    public static void main( String[] args )
    {
    	App app = new App();
    	//app.testSynchronousRequests();
    	app.testAsynchronousRequests();
    }
    
    public void testSynchronousRequests() {
    	Connector connector = new Connector(true);
    	try {
			System.out.println(connector.sendSynchronousRequests());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void testAsynchronousRequests() {
    	Connector connector = new Connector(true);
    	try {
			System.out.println(connector.sendAsynchronousRequests());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
    }
}
