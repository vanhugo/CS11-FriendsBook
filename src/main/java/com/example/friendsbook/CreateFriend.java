package com.example.friendsbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    private static String name;
    private static String cost;
    private static String cheese;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<Friend>();

    // method to create all friends from the file
    public static ArrayList<Friend> createAllFriends(File file) throws IOException {
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        String line;

        // loop to read file line by line
        while ((line = br.readLine()) != null) {
            parseFriend(line);
        }
        return friends; // return the list of friends
    }

    // method to parse each friend's details
    private static void parseFriend(String string) {
        String name = "";
        String age = "";
        String cheese = "";
        String[] fields = string.split(",");
        friends.add(new Friend(fields[0], fields[1], fields[2]));
    }
}
