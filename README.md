# Jordle
This is a program based on the game "Wordle".
These are the instructions displayed in the game: "Welcome to Jordle, Fordle, or Ciordle! In this game, you will try to guess a word relating to computer science, food, or cities! You will have 6 tries to guess the word. The word has to be 5 letters, and your guesses must be as well. There are no repeated letters in the word! To start, click which version you would like to play. Jordle is about cs, Fordle is about food, and Ciordle is cities. You can only choose a version when you haven't typed any guesses or right after you press restart. Selecting a new version during a game will not do anything. Type a letter and it will be entered into the box. Press enter to guess. Press backspace to delete a letter. If a letter box turns green, the letter you guessed is in the right place! If a letter box turns yellow, the letter you guessed is somewhere in the word but it's in the wrong place. If the letter box turns blue, the letter you guessed is not in the word. If letters are not appearing, try clicking under the title. Have fun!"
These are some attributes I added to the game:
I created a toggle group so users can pick what type of Jordle they want to play.
I added two lists to words.java, one with foods and one with cities.
I created radio buttons, each with their own action events.
I changed the title when users changed the game.
I edited which list the word was being generated from so that ie. it wouldn't generate a city when the user was playing Jordle.
Users can't change what type of game they're playing in the middle of a game. 
If they try to change it I made sure nothing happened and the current word stayed the same.
I added sound effects for typing letters, deleting letters, winning, and losing.
I made sure the sounds would only play if the letters were being added or taken away from the grid, not any time the user pressed a key.

To compile: javac --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls --add-modules javafx.media Jordle3.java
To run: java --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls --add-modules javafx.media Jordle3

You have to download "Words.java" and the sound effects for the full game.
