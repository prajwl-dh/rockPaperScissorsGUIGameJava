/*
 *Author: Prajwal Dhungana
 *Date: Feb 07, 2021
 *This program asks user to enter rock, paper, or scissor
 * as an input in GUI interface, displays the computer's random choice to the user
 * and tells the user if the user won or loose, or tie in GUI interface
 */

/*
 *Use of HTML Tags
 *<b></b> is used to make a bold text
 *<p>,</p> tag is used in the program to set the output text size in pixels
 */

//importing necessary java libraries
import java.util.*;
import javax.swing.*;

public class rockPaperScissorsGUIJava {

    //method to generate random rock, paper, or scissors by the computer
    private static Random rand = new Random();

    public static char  generateComputersChoice()
    {
        int comp_play = rand.nextInt(3);

        switch (comp_play)
        {
            case 0:
                return 'r';
            case 1:
                return 'p';
            case 2:
                return 's';
        }
        return '?';
    }

    //method to get rock, paper, or scissors as input from the user
    public static char enterPlayersChoice()
    {
        ImageIcon icon = new ImageIcon("RPS.png");

        String prompt = "<html><b><h1>Please Select your choice</h1></b></html>\n";

        String[] plays = {"rock", "paper", "scissors"};

        int play = JOptionPane.showOptionDialog(null, prompt, "Rock Paper Scissors Game"+"\t\t by Prajwal Dhungana",
                1,1,icon,plays,plays[0]);

        switch (play)
        {
            case 0:
                return 'r';

            case 1:
                return 'p';

            case 2:
                return 's';
        }
        return '?';
    }

    //method to convert computer choice character 'r','p',or 's' into a string 'rock','paper',or 'scissors'
    public  static String translateCompChar(char compChoice)
    {
        String computerChoice = "";

        if (compChoice == 'r')
        {
            computerChoice = "rock";
        }
        else if (compChoice == 'p')
        {
            computerChoice = "paper";
        }
        else if (compChoice == 's')
        {
            computerChoice = "scissors";
        }

        return computerChoice;
    }

    //method to convert user choice character 'r','p',or 's' into a string 'rock','paper',or 'scissors'
    public static String translateUserChar(char userChoice)
    {
        String userChoiceInput = "";

        if (userChoice == 'r')
        {
            userChoiceInput = "rock";
        }
        else if (userChoice == 'p')
        {
            userChoiceInput = "paper";
        }
        else if (userChoice == 's')
        {
            userChoiceInput = "scissors";
        }

        return userChoiceInput;
    }

    //begin main method
    public static void main(String[] args)
    {
        //declaring necessary variables
        int counter = 0;
        int numGames = 3;

        int wins = 0;
        int losses = 0;
        int ties = 0;

        //while loop for looping the program numGames times
        while (counter < numGames)
        {
            //calling compChoice and userChoice method to get computer and user input
            char compChoice = generateComputersChoice();
            char userChoice = enterPlayersChoice();

            //calling translatedCompChoice and translatedUserChoice method to convert 'r','p',or's' input into
            // 'rock','paper',and 'scissors' respectively for computer as well as user input
            String translatedCompChoice = translateCompChar(compChoice);
            String translatedUserChoice = translateUserChar(userChoice);

            String message = "You chose " + translatedUserChoice + " and \n"+
                    "The computer chose " + translatedCompChoice + "!\n\n";

            if (compChoice == userChoice)
            {
                ImageIcon icon = new ImageIcon("RPSTiedGame.png");
                message += "<html><b><p style=\"font-size:23px\">This is a tie.</b></p></html>\n\n";
                ties++;
                JOptionPane.showOptionDialog(null, message, "Rock Paper Scissors Game"+"\t\t by Prajwal Dhungana",
                        1,1,icon, new String[]{"Ok"}, "Ok");
            }
            else if (compChoice == 'r' && userChoice == 'p')
            {
                ImageIcon icon = new ImageIcon("paperWrapsRock.png");
                message += "<html><b><p style=\"font-size:23px\">paper wraps rock!</b></p></html>\n\n";
                message += "You win!";
                wins++;
                JOptionPane.showOptionDialog(null, message, "Rock Paper Scissors Game"+"\t\t by Prajwal Dhungana",
                        1,1,icon, new String[]{"Ok"}, "Ok");
            }
            else if (compChoice == 'r' && userChoice == 's')
            {
                ImageIcon icon = new ImageIcon("rockCrushScissor.png");
                message += "<html><b><p style=\"font-size:23px\">rock crushes scissors!</b></p></html>\n\n";
                message += "Computer wins!";
                losses++;
                JOptionPane.showOptionDialog(null, message, "Rock Paper Scissors Game"+"\t\t by Prajwal Dhungana",
                        1,1,icon, new String[]{"Ok"}, "Ok");
            }
            else if (compChoice == 's' && userChoice == 'r')
            {
                ImageIcon icon = new ImageIcon("rockCrushScissor.png");
                message += "<html><b><p style=\"font-size:23px\">rock crushes scissors!</b></p></html>\n\n";
                message += "You win!";
                wins++;
                JOptionPane.showOptionDialog(null, message, "Rock Paper Scissors Game"+"\t\t by Prajwal Dhungana",
                        1,1,icon, new String[]{"Ok"}, "Ok");
            }
            else if (compChoice == 's' && userChoice == 'p')
            {
                ImageIcon icon = new ImageIcon("scissorCutPaper.png");
                message += "<html><b><p style=\"font-size:23px\">scissors cuts paper!</b></p></html>\n\n";
                message += "Computer wins!";
                losses++;
                JOptionPane.showOptionDialog(null, message, "Rock Paper Scissors Game"+"\t\t by Prajwal Dhungana",
                        1,1,icon, new String[]{"Ok"}, "Ok");
            }
            else if (compChoice == 'p' && userChoice == 'r')
            {
                ImageIcon icon = new ImageIcon("paperWrapsRock.png");
                message += "<html><b><p style=\"font-size:23px\">paper wraps rock!</b></p></html>\n\n";
                message += "Computer wins!";
                losses++;
                JOptionPane.showOptionDialog(null, message, "Rock Paper Scissors Game"+"\t\t by Prajwal Dhungana",
                        1,1,icon, new String[]{"Ok"}, "Ok");
            }
            else if (compChoice == 'p' && userChoice == 's')
            {
                ImageIcon icon = new ImageIcon("scissorCutPaper.png");
                message += "<html><b><p style=\"font-size:23px\">scissors cuts paper!</b></p></html>\n\n";
                message += "You win!";
                wins++;
                JOptionPane.showOptionDialog(null, message, "Rock Paper Scissors Game"+"\t\t by Prajwal Dhungana",
                        1,1,icon, new String[]{"Ok"}, "Ok");
            }

            counter++;
        }

        //printing the final score board in GUI
        String message = "Final score board for " + numGames + " games.\n\n"+
                "<html><b><p style=\"font-size:30px\">" + "Wins: " + wins + "</b></p></html>\n" +
                "<html><b><p style=\"font-size:30px\">" +"Loses: " + losses + "</b></p></html>\n" +
                "<html><b><p style=\"font-size:30px\">" +"Ties: " + ties + "</b></p></html>\n";

        ImageIcon icon = new ImageIcon("RPS2.png");

        JOptionPane.showOptionDialog(null, message, "Rock Paper Scissors Game"+"\t\t by Prajwal Dhungana",
                1,1, icon, new String[]{"Ok"}, "Ok");

    }
    //end of main class
}
