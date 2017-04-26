package co.humaniq;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;
import org.web3j.protocol.parity.ParityFactory;

import static org.web3j.tx.ManagedTransaction.GAS_PRICE;
import static org.web3j.tx.Transfer.GAS_LIMIT;


public class Web3 {
    private Web3j web3;
    private Parity parity;
    private Web3jService service;
    private static Web3 instance;
    public static String contractAddress = "0xfec335de9d8f1e05ff947dc7664f039aae054580";
    HMQTokenContract hmqTokenContract;

    public static Web3 getInstance() {
        if (instance != null)
            return instance;

        instance = new Web3();
        return instance;
    }

    private Web3() {
        service = new HttpService("http://13.75.106.200/eth_rpc/");
        web3 = Web3jFactory.build(service);
        parity = ParityFactory.build(service);
    }

    public Web3j getWeb3() {
        return web3;
    }

    public Parity getParity() {
        return parity;
    }

    public Web3jService getService() {
        return service;
    }
}