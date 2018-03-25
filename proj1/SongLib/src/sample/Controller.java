//Jonathen Sheffer
//Aaron Teitz

package sample;
import javafx.collections.FXCollections;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.collections.ObservableList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import javafx.scene.control.*;

//import java.util.Optional;
//import javafx.collections.FXCollections;
import java.util.Collections;
import java.util.Comparator;

import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javax.xml.soap.Text;
//import java.awt.event.ActionEvent;


public class Controller {
    @FXML
    TreeView tree;

    @FXML
    ListView<songs> listView;

    @FXML
    ListView<songs> descriptionview;

    @FXML
    Button buttonAdd;

    @FXML
    Button buttonEdit;

    @FXML
    Button buttonDelete;

    @FXML
    TextField album;

    @FXML
    TextField songname;

    @FXML
    TextField year;

    @FXML
    TextField artist;


    public ObservableList<songs> obsList;

    //int i = 0;

    public void start()
    {
        String filename = "Songlist.txt";



        obsList = FXCollections.observableArrayList();
        listView.setItems(obsList);
        descriptionview.setItems(obsList);



    }

    public void cruster(javafx.event.ActionEvent e){


        Button b = (Button)e.getSource();
        if(b == buttonAdd) {

            songs newsong = new songs(null,null,null,null);
            if(songname.getText().isEmpty()|| artist.getText().isEmpty()){
                //insert error pop up
                //System.out.println("SDF");
            }

            else {
                //System.out.println("PRINT:" + songname.getText());
                //System.out.println("PRINT " + artist.getText());
                //newsong = (songname.getText(), artist.getText(), year.getText(), album.getText());
                newsong.setName(songname.getText());
                newsong.setArtist(artist.getText());
                //newsong.index = i;
                newsong.year = year.getText();
                newsong.album = album.getText();
//                Comparator<songs> comparator = Comparator.comparingInt(songs:getName());
//
//                if (!stateASC.isSelected()) {
//                    comparator = comparator.reversed();
//                }
//                obsList.sort(songs.compareTo(newsong.name));



                obsList.sorted();



            }

            obsList.add(newsong);


            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                String content = "Song: " + newsong.getName() + "    Artist: " + newsong.getArtist() + "    Album: " + newsong.getAlbum() +
                        "   Year: " + newsong.getYear()+"\n";
                fw = new FileWriter("SongList.txt");
                bw = new BufferedWriter(fw);
                bw.write(content);


                //System.out.println("Done");

            } catch (IOException f) {

                f.printStackTrace();

            }
            finally {

                try {

                    if (bw != null)
                        bw.close();

                    if (fw != null)
                        fw.close();

                } catch (IOException ex) {

                    ex.printStackTrace();

                }

            }
           // obsList.add(i,(newsong));
            //obsList.set(0,title);
            //i++;
            return;

        }
         if(b == buttonEdit)
        {
            int x = obsList.indexOf(listView.getSelectionModel().getSelectedItems());
            songs s = new songs(null, null, null, null);
            if(!songname.getText().isEmpty()){
                s.setName(songname.getText());
            }
            if(!artist.getText().isEmpty()){
                s.setArtist(artist.getText());
            }
            if(!year.getText().isEmpty()){
                s.setYear(year.getText());
            }
            if(!album.getText().isEmpty()){
                s.setAlbum(album.getText());
            }
            obsList.remove(listView.getSelectionModel().getSelectedIndex());
            listView.getSelectionModel().select(listView.getSelectionModel().getSelectedIndex()+1);
            obsList.add(s);
            return;
        }
         if(b == buttonDelete)
        {
            //listView.getSelectionModel().select(listView.getSelectionModel().getSelectedIndex()+1);
            obsList.remove(listView.getSelectionModel().getSelectedIndex());
            listView.getSelectionModel().select(listView.getSelectionModel().getSelectedIndex()+1);

        }


    }


}
