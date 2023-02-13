package demo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.*;

public class MainController implements Initializable {

  @FXML
  private Label testing1, testing2, testing3, testing4, testing5;
  @FXML
  private TextField testbox1, testbox2, testbox3, testbox4, testbox5;

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {

    testing1.setOnDragDetected(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent event) {
        System.out.println("drag");
        Dragboard db = testing1.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putString(testing1.getText());
        db.setContent(content);
        event.consume();
      }
    });

    testbox1.setOnDragOver(new EventHandler<DragEvent>() {
      public void handle(DragEvent event) {
        System.out.println("over");
        if (event.getGestureSource() != testbox1 &&
            event.getDragboard().hasString()) {

          event.acceptTransferModes(TransferMode.MOVE);
        }

        event.consume();
      }
    });
    testbox1.setOnDragEntered(new EventHandler<DragEvent>() {
      public void handle(DragEvent event) {
        if (event.getGestureSource() != testbox1 &&
            event.getDragboard().hasString()) {

        }

        event.consume();
      }
    });
    // testbox1.setOnDragDropped((DragEvent event) -> {
    // System.out.println("drop");
    // // Dragboard db = event.getDragboard();
    // // if (db.hasString()) {
    // // System.out.println("Dropped: " + db.getString());
    // // event.setDropCompleted(true);
    // // } else {
    // // event.setDropCompleted(false);
    // // }
    // event.consume();
    // });
    testbox1.setOnDragDropped(new EventHandler<DragEvent>() {
      public void handle(DragEvent event) {
        System.out.println("drop");
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
          testbox1.setText(db.getString());
          success = true;
        }
        event.setDropCompleted(success);
        event.consume();
      }
    });

    testbox1.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
      public void handle(MouseDragEvent event) {
        System.out.println("drop");
        // Dragboard db = event.getDragboard();
        // boolean success = false;
        // if (db.hasString()) {
        // testbox1.setText(db.getString());
        // success = true;
        // }
        // event.setDropCompleted(success);
        // event.consume();
      }
    });

    testing1.setOnDragDone(new EventHandler<DragEvent>() {
      public void handle(DragEvent event) {
        System.out.println("dropped");
        if (event.getTransferMode() == TransferMode.MOVE) {
          testing1.setText("");
        }
      }
    });
  }

}
