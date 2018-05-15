package Blockchain.ethereum;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.ipc.WindowsIpcService;

public class Connector {
	private Web3j web3;
	
	public Connector(boolean isIPC) {
		if(isIPC) {
			web3 = Web3j.build(new WindowsIpcService("\\\\.\\pipe\\geth.ipc"));
		}else {
			web3 = Web3j.build(new HttpService()); // defaults to http://localhost:8545/
		}
	}
	
	public String sendSynchronousRequests() throws IOException {
		Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
		return web3ClientVersion.getWeb3ClientVersion();
	}

	public String sendAsynchronousRequests() throws InterruptedException, ExecutionException {
		Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
		return web3ClientVersion.getWeb3ClientVersion();
	}

}