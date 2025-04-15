import managers.CollectionManager;
import managers.DumpManager;
import managers.Runner;
import models.Flat;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;

public class Helper {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        Set<Flat> collection = new LinkedHashSet<>();
        collection = DumpManager.readCollection("/Users/anton/Documents/java/lab5/src/data.json");
        CollectionManager collectionManager = new CollectionManager(collection);
        Runner runner = new Runner(buf, "/Users/anton/Documents/java/lab5/src/data.json", null, -1);
        runner.run(collectionManager);


    }
}

