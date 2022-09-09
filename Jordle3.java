import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import java.util.Random;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import java.io.File;

/** This class uses creates a jorlde game which is like Wordle.
 * @author Nitya Jani
 * @version 3
 */
public class Jordle3 extends Application {
    /**
    * @param i is the column
    */
    private int i = 0;
    /**
    * @param j is the row
    */
    private int j = 0;
    /**
    * @param ran is a random
    */
    private Random ran = new Random();
    /**
    * @param in is a random index
    */
    private int ind = ran.nextInt(29);
    /**
    * @param wordArr an array that holds one word. It may be replaced.
    */
    private String[] wordArr = {Words.list.get(ind)};
    /**
    * @param letters is the letters that the user types.
    */
    private String letters = "";
    /**
    * @param primaryStage is the stage
    * @throws TooShortException if the word entered is too short
    */
    public void start(Stage primaryStage) throws TooShortException {
//-------------------------------------------------------------------------------------------
        BorderPane border = new BorderPane();
        VBox title = new VBox();
        title.setAlignment(Pos.CENTER);
        Text text = new Text("Jordle");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Bubblegum Sans", FontWeight.BOLD, 50));
        HBox h = new HBox();
        h.setAlignment(Pos.CENTER);
        title.getChildren().add(text);
//---------------------------------------------------------------------------------------------
        ToggleGroup group = new ToggleGroup();
        RadioButton btn1 = new RadioButton("Jordle");
        RadioButton btn2 = new RadioButton("Fordle");
        RadioButton btn3 = new RadioButton("Ciordle");
        btn1.setToggleGroup(group);
        btn2.setToggleGroup(group);
        btn3.setToggleGroup(group);
        VBox side = new VBox();
        side.getChildren().addAll(btn1, btn2, btn3);
        side.setSpacing(200);
        btn1.setFont(Font.font("Bubblegum Sans", 30));
        btn2.setFont(Font.font("Bubblegum Sans", 30));
        btn3.setFont(Font.font("Bubblegum Sans", 30));
        btn1.fire();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
                if (i == 0 && j == 0) {
                    Random rand = new Random();
                    int index = rand.nextInt(29);
                    String word = Words.list.get(index);
                    wordArr[0] = word;
                    text.setText("Jordle");
                    border.requestFocus();
                    //System.out.println(wordArr[0]);
                } else {
                    border.requestFocus();
                }
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
                if (i == 0 && j == 0) {
                    Random rand = new Random();
                    int index = rand.nextInt(29);
                    String word = Words.list2.get(index);
                    wordArr[0] = word;
                    //System.out.println(wordArr[0]);
                    text.setText("Fordle");
                    border.requestFocus();
                } else {
                    border.requestFocus();
                }
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
                if (i == 0 && j == 0) {
                    Random rand = new Random();
                    int index = rand.nextInt(29);
                    String word = Words.list3.get(index);
                    wordArr[0] = word;
                    text.setText("Ciordle");
                    border.requestFocus();
                    //System.out.println(wordArr[0]);
                } else {
                    border.requestFocus();
                }
            }
        });
//----------------------------------------------------------------------------------------------
        HBox btns = new HBox();
        btns.setAlignment(Pos.CENTER);
        Button restart = new Button("Restart");
        Button instructions = new Button("Instructions");
        Label status = new Label("Try guessing a word!");
        status.setFont(Font.font("Bubblegum Sans", 20));
        restart.setPrefWidth(150);
        restart.setPrefHeight(70);
        restart.setFont(Font.font("Bubblegum Sans", 15));
        instructions.setPrefWidth(150); instructions.setPrefHeight(70);
        instructions.setFont(Font.font("Bubblegum Sans", 15));
        btns.getChildren().add(status); btns.getChildren().add(restart); btns.getChildren().add(instructions);
        btns.setSpacing(50);
        HBox info = new HBox();
        info.setAlignment(Pos.CENTER);
        Text instruc = new Text("Welcome to Jordle, Fordle, or Ciordle!\nIn this game, you will try to guess a "
            + "word relating to computer science, food, or cities! \nYou will have 6 tries to guess the word. "
            + "The word has to be 5 letters, and your guesses must be as well.\n"
            + "There are no repeated letters in the word! To start, click which version you would like to play.\n"
            + "Jordle is about cs, Fordle is about food, and Ciordle is cities. "
            + "You can only choose a version \nwhen you haven't typed any guesses or right after you press restart.\n"
            + "Selecting a new version during a game will not do anything. Type a letter and it "
            + "will be entered into the box.\nPress enter to guess. Press backspace to delete a letter.\n"
            + "If a letter box turns green, the letter you guessed is in the right place! \nIf a letter"
            + " box turns yellow, the letter you guessed is somewhere in the word but it's in the wrong place.\n"
            + "If the letter box turns blue, the letter you guessed"
            + " is not in the word. If letters are not appearing, "
            + "try clicking\nunder the title. Have fun!");
        instruc.setFont(Font.font("Times New Roman", 20));
        info.getChildren().add(instruc);
        Stage other = new Stage();
        other.setTitle("Instructions");
        Scene otherScene = new Scene(info, 900, 300);
        other.setScene(otherScene);
//-------------------------------------------------------------------------------------------
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(5);
        for (int r = 0; r < 5; r++) {
            for (int w = 0; w < 6; w++) {
                StackPane p = new StackPane();
                p.setPrefSize(90, 90);
                p.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                grid.add(p, r, w);
            }
        }
        StackPane stacked = new StackPane(); stacked.getChildren().add(grid);
        Alert alert = new Alert(AlertType.ERROR, "That word is too short. Please enter a 5 letter word.");

//----------------------------------------------------------------------------------------------------

        border.setTop(title); border.setCenter(stacked); border.setBottom(btns); border.setLeft(side);
        border.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        border.setPadding(new Insets(20, 20, 10, 35));
        Scene scene = new Scene(border, 900, 900);

        restartMethod(btn1, btn2, btn3, grid, border, status, restart, text);
        writeLetters(grid, border, status, alert);

//-------------------------------------------------------------------------------------------------
        primaryStage.setTitle("Jordle");
        primaryStage.setScene(scene);
        primaryStage.show();
        border.requestFocus();
//------------------------------------------------------------------------------------------------------
        instructions.setOnAction((ActionEvent e) -> {
            other.show();
            border.requestFocus();
        });

//--------------------------------------------------------------------------------------------------------
    }
//-----------------------------------------------------------------------------------------------------
    //watch where the cursor is
    class Increment {
        public int[] check(int in, int jn) {
            int[] arr = new int[2];
            if (jn <= 5 && in == 5) {
                jn++;
                in = 0;
            } else {
                in++;
            }
            arr[0] = in;
            arr[1] = jn;
            return arr;
        }
    }
    //exception
    class TooShortException extends Exception {
        TooShortException() {
            super("That word is too short! Please enter a 5 letter word.");
        }
    }
    /**
    * @param grid is the current grid
    * @param border is the main scene
    * @param status is the label at the bottom
    * @param alert is an alert that tells the user if the word is too short
    */
    public void writeLetters(GridPane grid, BorderPane border,
        Label status, Alert alert) {
        border.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent k) {
                if (!k.getCode().isLetterKey() && !k.getCode().equals(KeyCode.BACK_SPACE)
                    && !k.getCode().equals(KeyCode.ENTER)) {
                    Text letter = null;
                    k.consume();
                } else if (i != 5 && j != 6 && k.getCode().isLetterKey()
                    && !status.getText().equals("You guessed the word!\nClick restart to play again")
                        && !k.getCode().equals(KeyCode.SPACE)) {

                    Text letter = new Text("  " + k.getCode().getName().toUpperCase());
                    letter.setFont(Font.font("Comic Sans", 60));
                    grid.add(letter, i, j);
                    letters = letters + k.getCode().getName();
                    //System.out.println(letters);
                    Increment inc = new Increment();
                    int[] ans = inc.check(i, j);
                    i = ans[0];
                    j = ans[1];

                    String musicFile = "Click.wav";
                    Media sound = new Media(new File(musicFile).toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();

                }
                if (k.getCode().equals(KeyCode.BACK_SPACE) && j >= 0 && (i - 1) >= 0) {
                    StackPane p = new StackPane();
                    p.setPrefSize(90, 90);
                    p.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    String musicFile3 = "pop1.wav";
                    Media sound3 = new Media(new File(musicFile3).toURI().toString());
                    MediaPlayer mediaPlayer3 = new MediaPlayer(sound3);
                    if (i == 0) {
                        grid.add(p, 4, j);
                        j = j - 1;
                        mediaPlayer3.play();
                    } else if (i == 1) {
                        grid.add(p, 0, j);
                        i = 0;
                        mediaPlayer3.play();
                    } else if (i > 0 && i != 1) {
                        grid.add(p, i - 1, j);
                        i = i - 1;
                        mediaPlayer3.play();
                    }
                    if (letters.length() > 5) {
                        letters = letters.substring(0, 5);
                        letters = letters.substring(0, letters.length() - 1);

                    } else {
                        letters = letters.substring(0, letters.length() - 1);
                    }
                }
                if (k.getCode().equals(KeyCode.ENTER)
                    && j <= 5 && !status.getText().equals("You guessed the word!\nClick restart to play again")) {
                    try {
                        if (letters.length() < 5) {
                            throw new TooShortException();
                        }
                        if (letters.length() > 5) {
                            letters = letters.substring(0, 5);
                        }
                        for (int q = 0; q < 5; q++) {
                            char c = letters.charAt(q);
                            String s = Character.toString(c);
                            s = s.toLowerCase();
                            char cInWord = wordArr[0].charAt(q);
                            String sInWord = Character.toString(cInWord);
                            //System.out.println(s);
                            //System.out.println(sInWord);
                            if (s.equals(sInWord)) {
                                StackPane p = new StackPane();
                                p.setPrefSize(90, 90);
                                p.setBackground(new Background(new BackgroundFill(new
                                    Color(0.1, 0.7, 0.2, 0.2), CornerRadii.EMPTY, Insets.EMPTY)));
                                grid.add(p, q, j);
                            } else if (wordArr[0].contains(s)) {
                                StackPane p = new StackPane();
                                p.setPrefSize(90, 90);
                                p.setBackground(new Background(new BackgroundFill(new
                                    Color(1.0, 0.9, 0, 0.2), CornerRadii.EMPTY, Insets.EMPTY)));
                                grid.add(p, q, j);
                            } else {
                                StackPane p = new StackPane();
                                p.setPrefSize(90, 90);
                                p.setBackground(new Background(new BackgroundFill(new
                                    Color(0, 0.6, 0.9, 0.2), CornerRadii.EMPTY, Insets.EMPTY)));
                                grid.add(p, q, j);
                            }
                        }
                        Increment in2 = new Increment();
                        int[] ans2 = in2.check(i, j);
                        i = ans2[0];
                        j = ans2[1];
                        if (letters.toLowerCase().equals(wordArr[0])) {
                            status.setText("You guessed the word!\nClick restart to play again");
                            String musicFile2 = "Winner.wav";
                            Media sound2 = new Media(new File(musicFile2).toURI().toString());
                            MediaPlayer mediaPlayer2 = new MediaPlayer(sound2);
                            mediaPlayer2.play();
                        } else if (j == 6) {
                            status.setText("Sorry, you lost! The word was " + wordArr[0] + ".");
                            String musicFile4 = "Lose.wav";
                            Media sound4 = new Media(new File(musicFile4).toURI().toString());
                            MediaPlayer mediaPlayer4 = new MediaPlayer(sound4);
                            mediaPlayer4.play();
                        }
                        letters = "";

                    } catch (TooShortException tse) {
                        alert.showAndWait();
                    }
                }
            }
        });
    }
    /**
    * @param btn1 is the first button for Jordle
    * @param btn2 is the second button for Fordle
    * @param btn3 is the third button for Ciordle
    * @param grid is the current grid
    * @param border is the main border pane
    * @param status is the label at the bottom
    * @param restart is the restart button
    * @param text is the title
    */
    public void restartMethod(RadioButton btn1, RadioButton btn2, RadioButton btn3,
        GridPane grid, BorderPane border, Label status, Button restart, Text text) {
        restart.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent a) {
                grid.getChildren().clear();
                letters = "";
                for (int r = 0; r < 5; r++) {
                    for (int w = 0; w < 6; w++) {
                        StackPane p = new StackPane();
                        p.setPrefSize(90, 90);
                        p.setBackground(new Background(new
                            BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                        grid.add(p, r, w);
                    }
                }
                status.setText("Try guessing a word!");
                if (btn1.isSelected()) {
                    Random randN = new Random();
                    int indexN = randN.nextInt(29);
                    text.setText("Jordle");
                    wordArr[0] = Words.list.get(indexN);
                } else if (btn2.isSelected()) {
                    Random randN = new Random();
                    int indexN = randN.nextInt(29);
                    text.setText("Fordle");
                    wordArr[0] = Words.list2.get(indexN);
                } else if (btn3.isSelected()) {
                    Random randN = new Random();
                    int indexN = randN.nextInt(29);
                    text.setText("Ciordle");
                    wordArr[0] = Words.list3.get(indexN);
                }

                i = 0;
                j = 0;
                border.requestFocus();
            }
        });
    }
}