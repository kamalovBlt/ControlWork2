package org.example;

import java.io.*;

public class DataStream extends Thread {

    private final String path;

    private byte[] data;
    private int part;

    public DataStream(String path) {
        this.path = path;
    }

    public void run() {
        try(DataInputStream reader = new DataInputStream(new FileInputStream(path))) {

            int sz = reader.readInt();

            this.data = reader.readNBytes(sz);

            int even = reader.readInt();
            this.part = reader.readInt();



            if (cheth(data) != even) {
                throw new DataControlNumNotEqualsException("part " + part + " контрольное число не совпадает");
            }
        } catch (IOException | DataControlNumNotEqualsException e) {
            throw new RuntimeException(e);
        }
    }

    public int cheth(byte[] numbers) {
        int count = 0;
        for(byte b: numbers){
            for (int i = 0; i < 8; i ++){
                count += (b & ( 1 << i)) >> i;
            }
        }
        return count % 2;
    }

    public byte[] getData() {
        return data;
    }

    public int getPart() {
        return part;
    }

}
