import managers.CollectionManager;
import managers.DumpManager;
import managers.Runner;
import models.Flat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        Set<Flat> flats = new LinkedHashSet<>();
        String fileName;
        while(true) {
            System.out.print("Введите название файла, в котором содержится коллекция: ");
            fileName = buf.readLine();
            flats = DumpManager.readCollection(fileName);
            if (!flats.isEmpty()) {
                break;
            }
        }
        CollectionManager collectionManager = new CollectionManager(flats);
        System.out.println("Введите команду в терминал");
        Runner runner = new Runner(buf, fileName, null, -1);
        runner.run(collectionManager);
    }
}