package irsan.winarto.console;

import java.io.Console;
import irsan.winarto.solution.*;


class TheConsole {
    /**
     * @author Irsan Winarto
     */
    public static void main(String[] args) {
        // non-interactive mode
        if (args.length > 0) {
            System.out.println(translateNumberToWords(args[0]));
            return;
        }

        // interactive mode
        Console console = System.console();

        console.printf("-------------------------------------------------------%n");
        console.printf("| Author: Irsan Winarto                               |%n");
        console.printf("|                                                     |%n");
        console.printf("| Welcome!                                            |%n");
        console.printf("|                                                     |%n");
        console.printf("| Input a non-negative real number or \"quit\" to exit. |%n");
        console.printf("-------------------------------------------------------%n");

        String input = "";
        String result = null;

        while (true) {
            // prompt and get input
            console.printf("%nInput:%n");
            console.flush();

            input = console.readLine();
            console.printf("%n");

            if (input.toLowerCase().equals("quit"))
                break;
            
            result = translateNumberToWords(input);

            console.printf("Result:%n%s%n%n", result);
            console.flush();
        }
    }

    private static String translateNumberToWords(String input) {
            
        // convert the given number string if it is a valid non-negative real number
        try {
            return ConvertNumbersToWords.convertNumbersToWords(input);
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}
