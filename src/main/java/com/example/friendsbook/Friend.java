package com.example.friendsbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    // public fields to store friend's name, age, and favorite cheese
    public String name;
    public String age;
    public String cheese;

    // constructor to initialize Friend object with name, age, and cheese
    public Friend(String name, String age, String cheese) {
        this.name = name;
        this.age = age;
        this.cheese = cheese;
    }

    // method to write friend details to a file
    // appends name, age, and cheese to the specified file
    public void writeToFile(String filename) throws IOException {
        // FileWriter in append mode (true) to add content without overwriting
        FileWriter fw = new FileWriter(filename, true);
        // BufferedWriter to handle the file writing
        BufferedWriter bw = new BufferedWriter(fw);

        // write name, age, and cheese separated by commas, followed by a new line
        bw.write(name + ",");
        bw.write(age + ",");
        bw.write(cheese + "");
        bw.write("\r"); // write carriage return (new line)

        bw.close();
        fw.close();
    }

    // override the toString() method to return the friend's name when the object is printed
    @Override
    public String toString() {
        return name;
    }
}
