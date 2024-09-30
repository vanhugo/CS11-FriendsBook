package com.example.friendsbook;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    @FXML
    public TextField friendName;
    public TextField friendAge;
    public TextField friendCheese;
    public ListView<Friend> friendList;
    public Label displayName;
    public Label displayAge;
    public Label displayCheese;

    // method to handle when the create button is pressed
    @FXML
    public void onCreateButtonPressed(ActionEvent actionEvent) {
        // add a new friend to the list using the entered text fields
        friendList.getItems().add(new Friend(friendName.getText(), (friendAge.getText()), (friendCheese.getText())));
        // clear the text fields after adding the friend
        friendName.clear();
        friendAge.clear();
        friendCheese.clear();
    }

    // method to save the list of friends to a file
    public void onSaveButtonPressed (ActionEvent actionEvent) throws IOException {
        ObservableList<Friend> myList = friendList.getItems();
        FileChooser fileChooser = new FileChooser();
        Node node = (Node) actionEvent.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        // set the initial directory to the user's current directory
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        File selectedFile = fileChooser.showSaveDialog(thisStage);
        if (selectedFile != null) {
            String filename = selectedFile.getName();
            // write each friend's details to the selected file
            for(Friend f : myList) {
                f.writeToFile(filename);
            }
        }
        // clear the friend list after saving
        friendList.getItems().clear();
    }

    // method to load friends from a file
    public void onLoadButtonPressed (ActionEvent actionEvent) throws IOException {
        // clear the current list before loading new data
        friendList.getItems().clear();
        FileChooser fileChooser = new FileChooser();
        Node node = (Node) actionEvent.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        // set the initial directory to the user's current directory
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        File selectedFile = fileChooser.showOpenDialog(thisStage);
        if (selectedFile != null) {
            // load all friends from the selected file
            ArrayList<Friend> friends = CreateFriend.createAllFriends(selectedFile);
            for (Friend f : friends) {
                friendList.getItems().add(f);
            }
        }
    }

    // method to display details of the selected friend in the labels
    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        displayName.setText(temp.name);
        displayAge.setText(temp.age);
        displayCheese.setText(temp.cheese);
    }
}
