package App;

import Spel.Rummikub;
import javafx.application.Application;
import javafx.stage.Stage;

/* Start spel en launch startscherm. */

public class Main { //extends Application {
    public static void main(String[] args) {
        Rummikub rummikub = new Rummikub();
        rummikub.Start();
    }

    //Dit roept het startscherm op
    //@Override
    //public void start(Stage primaryStage) throws Exception {
    //    primaryStage.setTitle("Rummikub");
    //}
}
