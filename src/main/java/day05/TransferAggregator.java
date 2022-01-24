package day05;

import com.sun.source.tree.BreakTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TransferAggregator {


    private List<TransferPerClient> allTransactions = new ArrayList<>();

    public List<TransferPerClient> readTransfers(Path path) {
        List<String> lines = readLines(path);
        return summarize(lines);
    }

    private List<TransferPerClient> summarize(List<String> lines) {
        Map<String, TransferPerClient> transfers = new TreeMap<>();
        for (String actual : lines ) {
            String[] parts = actual.split(",");
            String sourceID = parts[0];
            String targetID = parts[1];
            int amount = Integer.parseInt(parts[2]);

           TransferPerClient source = findOrInsert(transfers, sourceID);
           source.increase(amount);

            TransferPerClient target = findOrInsert(transfers, targetID);
            target.increase(amount);
        }
        return new ArrayList<>(transfers.values());
    }

    TransferPerClient findOrInsert(Map<String , TransferPerClient> transfers, String clientID) {
        TransferPerClient transfer = transfers.get(clientID);
        if (transfer == null ) {
            transfer = new TransferPerClient(clientID);
            transfers.put(clientID, transfer);
        }
        return  transfer;
    }


    public List<String> readLines(Path path) {

        try {
            return Files.readAllLines(path);//

        } catch (IOException ioe) {
            throw new IllegalArgumentException("File cannot be found", ioe);
        }
    }

//    public Map<String, TransferPerClient> putInMap() {
//        Map<String, TransferPerClient> transactionInMap = new TreeMap<>();
//        for (TransferPerClient actual : allTransactions) {
//
//            if ( transactionInMap.containsKey(actual.getID())) {
//                actual.increase(actual.getSum());
//                transactionInMap.put(actual.getID(), actual);
//            } else {
//                transactionInMap.put(actual.getID(), actual);
//            }
//        }
//        return transactionInMap;
//    }

//    public List<TransferPerClient> putIntoList(Map<String, TransferPerClient> allTransactions) {
//        List<TransferPerClient> sortedByClient = new ArrayList<>();
//        for (Map.Entry<String, TransferPerClient> actual : allTransactions.entrySet()) {
//            sortedByClient.add(actual.getValue());
//        }
//        return sortedByClient;
//    }


    public static void main(String[] args) {
        TransferAggregator transferAggregator = new TransferAggregator();
        List<TransferPerClient> transactionInAlphabet  = transferAggregator.readTransfers(Paths.get("src/main/resources/transfers.csv"));
        for (TransferPerClient actual : transactionInAlphabet) {
            System.out.println(actual);
            //System.out.println(actual.getID(), actual.getSum(), actual.getNumberOfTransactions());
           // System.out.println("%s %d %d", actual.getID(), actual.getNumberOfTransactions(), actual.getNumberOfTransactions());
        }
    }
}
