package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        File file = new File("src/main/resources/v14.png");

        ArrayList<DataStream> dataStreams = new ArrayList<>();

        dataStreams.add(new DataStream("C:\\Users\\poloy\\IdeaProjects\\ControlWork\\src\\main\\resources\\v14\\4f2a7df4-8ac2-4974-80ea-2befdb910f6c"));
        dataStreams.add(new DataStream("C:\\Users\\poloy\\IdeaProjects\\ControlWork\\src\\main\\resources\\v14\\4f386992-dbd4-44c9-bf44-e930749480f8"));
        dataStreams.add(new DataStream("C:\\Users\\poloy\\IdeaProjects\\ControlWork\\src\\main\\resources\\v14\\6c230b40-237d-4660-a515-442ea1857855"));
        dataStreams.add(new DataStream("C:\\Users\\poloy\\IdeaProjects\\ControlWork\\src\\main\\resources\\v14\\9c2cf17a-364d-4058-ad74-c7d4994fccc7"));
        dataStreams.add(new DataStream("C:\\Users\\poloy\\IdeaProjects\\ControlWork\\src\\main\\resources\\v14\\68823f58-abfa-4cfc-bf84-09688ae9e8f7"));
        dataStreams.add(new DataStream("C:\\Users\\poloy\\IdeaProjects\\ControlWork\\src\\main\\resources\\v14\\abbe6a4f-fa51-4c6a-bac2-fefe58d9b02f"));
        dataStreams.add(new DataStream("C:\\Users\\poloy\\IdeaProjects\\ControlWork\\src\\main\\resources\\v14\\d90c2af4-7cc8-4a31-9287-c0a3cca6f48c"));
        dataStreams.add(new DataStream("C:\\Users\\poloy\\IdeaProjects\\ControlWork\\src\\main\\resources\\v14\\e20da2b5-1145-4fe8-9e55-0207b0b9c130"));

        dataStreams.forEach(Thread::start);

        dataStreams.forEach(x -> {
            try {
                x.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        dataStreams.sort(Comparator.comparingInt(DataStream::getPart));

        try (DataOutputStream writer = new DataOutputStream(new FileOutputStream(file))) {

            for (DataStream dataStream: dataStreams) {
                writer.write(dataStream.getData());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}