package irsan.winarto.solution;

import java.lang.Character;
import java.util.*;


public class ConvertNumbersToWords {
    // "dictionaries" for translating ones and tens
    private final static Map<String, String> ones = new HashMap<>();
    private final static Map<String, String> tens = new HashMap<>();

    // invariance: this constant equals to the length of the integer part in the
    //             largest number scale contained in the scaleNames array,
    //             which is VIGINTILLION (10 raised to 63)
    private final static int MAX_INT_PART_LENGTH = 64;

    // invariance: powers of 1000 in the ascending order starting from 0 power
    private final static String[] scaleNames = {
        "", "THOUSAND", "MILLION", "BILLION", "TRILLION", "QUADRILLION", 
        "QUINTILLION", "SEXTILLION", "SEPTILLION", "OCTILLION", "NONILLION",
        "DECILLION", "UNDECILLION", "DUODECILLION", "TREDECILLION", 
        "QUATTUORDECILLION", "QUINDECILLION", "SEXDECILLION", "SEPTENDECILLION",
        "OCTODECILLION", "NOVEMDECILLION", "VIGINTILLION"
    };

    static {
        ones.put("0", "ZERO");
        ones.put("1", "ONE");
        ones.put("2", "TWO");
        ones.put("3", "THREE");
        ones.put("4", "FOUR");
        ones.put("5", "FIVE");
        ones.put("6", "SIX");
        ones.put("7", "SEVEN");
        ones.put("8", "EIGHT");
        ones.put("9", "NINE");

        tens.put("10", "TEN");
        tens.put("11", "ELEVEN");
        tens.put("12", "TWELVE");
        tens.put("13", "THIRTEEN");
        tens.put("14", "FOURTEEN");
        tens.put("15", "FIFTEEN");
        tens.put("16", "SIXTEEN");
        tens.put("17", "SEVENTEEN");
        tens.put("18", "EIGHTEEN");
        tens.put("19", "NINETEEN");
        // '0' is deliberately excluded from the tails of the numbers below
        tens.put("2", "TWENTY");
        tens.put("3", "THIRTY");
        tens.put("4", "FORTY");
        tens.put("5", "FIFTY");
        tens.put("6", "SIXTY");
        tens.put("7", "SEVENTY");
        tens.put("8", "EIGHTY");
        tens.put("9", "NINETY");
    }

    /**
     * @author Irsan Winarto
     * @param numberString is a non-negative real number given as a string
     *
     * @return the Australian English translation of numberString using the 
     *         short scale naming system for large numbers
     *
     * @require numberString is either null or a valid non-negative real number
     *          given as a string; it is invalid to begin or end a number with
     *          the period character
     *
     * @ensure the Australian English translation of the given numberString is
     *         returned 
     */
    public static String convertNumbersToWords(String numberString) {

        // this may throw an IllegalArgumentException if numberString is invalid
        checkArgumentHelper(numberString);

        String[] intAndFrac = getIntegerAndFractionalParts(numberString);

        String integerPart = intAndFrac[0];
        String fractionalPart = intAndFrac[1];

        String result = convertIntegerToWords(integerPart, "DOLLAR");

        if (fractionalPart != null) {
            fractionalPart = convertIntegerToWords(fractionalPart, "CENT");
            // do NOT say "ZERO CENT"
            if (!fractionalPart.contains("ZERO"))
                result += " AND " + fractionalPart;
        }

        return result;
    }

    /**
     * This helper method converts an integer into English words and append a 
     * unit to the translation.
     * 
     * @param intString must be a valid integer number
     * @param unit must be a singular noun in uppercase such as "DOLLAR" or 
     *             "CENT", whose plural form ends with an 'S'
     * @return the number written in English words with the given unit appended
     *         all in uppercase letters
     * 
     * @require intString is a String of digits such that can only be prepended
     *          by exactly one "0" only, (e.g. 01 cent or 09 cents)
     * 
     *          unit is a singular noun in uppercase letters whose plural form 
     *          ends with an 'S'
     * 
     * @ensure what is described in the return tag is true
     */
    private static String convertIntegerToWords(String intString, String unit) {
        // this will contain intString chunks of 3 consecutive digits
        List<String> chunks = new ArrayList<>();

        final int LENGTH = intString.length();
        final int MAX_TRIPLE_COUNT = (int) Math.ceil((double)LENGTH / 3);

        String currentTriple = null;

        for (int index = 0; index < MAX_TRIPLE_COUNT; ++index) {
            int upperIndex = LENGTH - index * 3;
            int lowerIndex = Math.max(upperIndex - 3, 0);

            currentTriple = convertAtMostHundredsToWords(
                intString.substring(lowerIndex, upperIndex)
            );

            if (currentTriple == null)
                // "00" or "000" in intString is currently being parsed
                continue;

            // if intString is at least 1000
            if (index > 0)
                currentTriple = currentTriple + " " + scaleNames[index];

            chunks.add(0, currentTriple);
        }

        final int SIZE = chunks.size();
        final String leastSigTriple = chunks.get(SIZE - 1);

        // put a ", " after every power of 1000 starting from "MILLION"
        String result = String.join(", ", chunks.subList(0, SIZE - 1));

        if (SIZE > 1) {
            if (leastSigTriple.contains("HUNDRED")) {
                // normal case
                result += ", " + leastSigTriple + " " + unit;
            } else {
                // edge-case example 9011 is "THOUSAND AND" and not "THOUSAND, "
                result += " AND " + leastSigTriple + " " + unit;
            }
        } else {
            result = chunks.get(0) + " " + unit;
        }

        // if plural
        if (!intString.equals("01") && (intString.length() > 1 || intString.charAt(0) > '1'))
            result += "S";

        return result;
    }

    /**
     * A helper method for converting at most 3-digit number into words.
     * 
     * @author Irsan Winarto
     * @param intString is a string of digits whose length is >= 1 && <= 3
     * @return a String of the English writing of intString if intString is not
     *         "00" or "000"; else, null is returned
     * 
     * @require 1 <= intString.length() <= 3 && intString is digits only
     * 
     * @ensure what is described in the return tag above is true
     */
    private static String convertAtMostHundredsToWords(String intString) {

        if (intString.equals("00") || intString.equals("000"))
            return null;

        final int LENGTH = intString.length();

        // the English name for the first digit
        String result = ones.get(intString.substring(LENGTH - 1, LENGTH));

        if (intString.length() > 1) {
            // tens is a Map<String, String>, so secondDigit must be a String
            String secondDigit = intString.substring(LENGTH - 2, LENGTH - 1);

            if (secondDigit.equals("1")) 
                // between "ten" to "nineteen" inclusive
                result = tens.get(intString.substring(LENGTH - 2));

            else if (!secondDigit.equals("0")) 
                if (!result.equals("ZERO"))
                    // if the first digit is not "0"
                    result = tens.get(secondDigit) + "-" + result;
                else
                    result = tens.get(secondDigit);
        }

        if (intString.length() == 3) {
            // ones is a Map<String, String>, so thirdDigit must be a String
            String thirdDigit = intString.substring(0, 1);

            // "000" is impossible at this point due to the check at the top
            if (!thirdDigit.equals("0")) {
                String hundredString = ones.get(thirdDigit) + " HUNDRED";

                if (!result.equals("ZERO"))
                    // if the first two digits are not "00"
                    result = hundredString + " AND " + result;
                else
                    result = hundredString;
            }
        }

        return result;
    }

    /**
     * @param numberString is a non-negative real number given as a string
     * 
     * @return an array containing exactly two String elements:
     *              array[0] is the integer part of numberString
     *              array[1] is the fractional part of numberString if it exists
     *                          or null if it doesn't exist; this is strictly 
     *                          the number after the decimal point
     * 
     *                          if the fractional part exists and it is not 
     *                          a series of '0' characters, then it will be
     *                          rounded to two digits using standard rounding;
     *                          else, the fractional part will be the String "0"
     * 
     * @require numberString has passed checkArgumentCheckHelper() check
     * 
     * @ensure the return value is as described in the return tag above
     */
    private static String[] getIntegerAndFractionalParts(String numberString) {
        final int MAX_SPLIT = 2;

        // integer part in [0] and fractional part in [1]
        String[] result = numberString.split("\\.", MAX_SPLIT);

        // default to null if numberString has no fractional part
        if (result.length == 1) {
            result = Arrays.copyOf(result, MAX_SPLIT);
            result[1] = null;
        }
        
        else {
            // if there is only one digit in the fraction, it is in "tens"
            if (result[1].length() == 1) {
                result[1] = result[1] + "0";
            }

            // round the fractional part to two integer digits or round to "0"
            else if (result[1].length() > 2) {
                String frac = result[1].substring(0, 2) + "." + result[1].charAt(2);
                result[1] = String.valueOf(Math.round(Float.valueOf(frac)));
            }
            
            if (result[1].equals("00")) {
                result[1] = "0";
            }
        }

        return result;
    }

    /**
     * @param numberString the number-string to be checked
     * 
     * @throws IllegalArgumentException 
     *              if 1. numberString is not a valid non-negative real number
     *              or 2. numberString begins or ends with a '.' character
     *              or 3. the integer part exceeds 64 digits (vigintillion)
     */
    private static void checkArgumentHelper(String numberString) 
        throws IllegalArgumentException {

        if (numberString == null) 
            throw new IllegalArgumentException("numberString must not be null");
 
        if (numberString.equals(""))
            throw new IllegalArgumentException("numberString must not be an empty string");

        if (numberString.startsWith("."))
            throw new IllegalArgumentException("numberString must not begin with the decimal point");

        if (numberString.endsWith("."))
            throw new IllegalArgumentException("numberString must not end with the decimal point");
 
        if (numberString.startsWith("0") && numberString.length() > 1 && numberString.charAt(1) != '.')
            throw new IllegalArgumentException(
                "numberString must not be prefixed with a zero or zeroes, unless it is 0 or decimals such as 0.00 or " +
                "or 0.0809 or 0.3847382, etc"
            );


        // the number of decimal points in numberString
        int dotCount = 0;
        // the number of digits in the integer part of numberString
        int intLength = 0;

        for (char c : numberString.toCharArray()) {

            if (! Character.isDigit(c)) {
                if (c != '.') {
                    throw new IllegalArgumentException("numberString contains an invalid character " + c);
                } else if (++dotCount > 1) {
                    throw new IllegalArgumentException("numberString contains multiple decimal points");
                }
            }
            // c is now a digit; dotCount checks whether a decimal point has been reached
            else if (dotCount == 0 && ++intLength > MAX_INT_PART_LENGTH) {
                throw new IllegalArgumentException(
                    "the number of digits of the integer part must not exceed " + MAX_INT_PART_LENGTH
                );
            }
        }
    }

    /**
     * This method is used for unit-testing only
     * @return the maximum length of the integer part allowable
     */
    public static int getMaxIntPartLength() {
        return MAX_INT_PART_LENGTH;
    }
}