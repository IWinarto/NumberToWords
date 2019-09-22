package irsan.winarto.solution;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static irsan.winarto.solution.ConvertNumbersToWords.*;


class ConvertNumbersToWordsTests {
    @Test
    void testZeroDollar() {
        String[] zeroes = {
            "0",
            "0.0",
            "0.00",
            "0.000",
            "0.0000",
            "0.00000",
            "0.00000000000000000000000000000000000000000000000000000000000",
        };

        String expected = "ZERO DOLLAR";

        for(int i = 0; i < zeroes.length; ++i) {
            String translation = convertNumbersToWords(zeroes[i]);
            assertEquals(expected, translation);
        }
    }

    @Test
    void testOneDollar() {
         String[] zeroes = {
            "1",
            "1.0",
            "1.00",
            "1.000",
            "1.0000",
            "1.00000",
            "1.00000000000000000000000000000000000000000000000000000000000",
        };

        String expected = "ONE DOLLAR";

        for(int i = 0; i < zeroes.length; ++i) {
            String translation = convertNumbersToWords(zeroes[i]);
            assertEquals(expected, translation);
        }       
    }

    @Test
    void testOnes() {
        String number = "7.5097598913780190237";

        String expected = "SEVEN DOLLARS AND FIFTY-ONE CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testTens() {
        String number = "21.8207730684170753081761";

        String expected = "TWENTY-ONE DOLLARS AND EIGHTY-TWO CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testHundred() {
        String number = "944.768027196";

        String expected = "NINE HUNDRED AND FORTY-FOUR DOLLARS AND SEVENTY-SEVEN CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testThousand() {
        String number = "9515.434878529796524922";

        String expected = "NINE THOUSAND, FIVE HUNDRED AND FIFTEEN DOLLARS AND FORTY-THREE CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testOneThousandAndOneDollarsAndOneCent() {
        String number = "1001.01499999999999999";

        String expected = "ONE THOUSAND AND ONE DOLLARS AND ONE CENT";

        String translation = convertNumbersToWords(number);
        assertEquals(expected, translation);
    }

    @Test
    void testTenThousand() {
        String number = "32491.50702222";

        String expected = "THIRTY-TWO THOUSAND, FOUR HUNDRED AND NINETY-ONE DOLLARS AND FIFTY-ONE CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testHundredThousand() {
        String number = "766571.8617837338";

        String expected = "SEVEN HUNDRED AND SIXTY-SIX THOUSAND, FIVE HUNDRED AND SEVENTY-ONE DOLLARS AND EIGHTY-SIX " +
                          "CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testMillion() {
        String number = "6821170.19";

        String expected = "SIX MILLION, EIGHT HUNDRED AND TWENTY-ONE THOUSAND, ONE HUNDRED AND SEVENTY DOLLARS AND " +
                          "NINETEEN CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testBillion() {
        String number = "7561994011.199166869908";

        String expected = "SEVEN BILLION, FIVE HUNDRED AND SIXTY-ONE MILLION, NINE HUNDRED AND NINETY-FOUR THOUSAND " +
                          "AND ELEVEN DOLLARS AND TWENTY CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testTrillion() {
        String number = "2757116168738.049321863105266391703441";

        String expected = "TWO TRILLION, SEVEN HUNDRED AND FIFTY-SEVEN BILLION, ONE HUNDRED AND SIXTEEN MILLION, ONE " +
                          "HUNDRED AND SIXTY-EIGHT THOUSAND, SEVEN HUNDRED AND THIRTY-EIGHT DOLLARS AND FIVE CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testQuadrillion() {
        String number = "5952395186865422.6740718741218356";

        String expected = "FIVE QUADRILLION, NINE HUNDRED AND FIFTY-TWO TRILLION, THREE HUNDRED AND NINETY-FIVE " +
                          "BILLION, ONE HUNDRED AND EIGHTY-SIX MILLION, EIGHT HUNDRED AND SIXTY-FIVE THOUSAND, FOUR " +
                          "HUNDRED AND TWENTY-TWO DOLLARS AND SIXTY-SEVEN CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testQuintillion() {
        String number = "1767879773347627071.0681770547937965676128";

        String expected = "ONE QUINTILLION, SEVEN HUNDRED AND SIXTY-SEVEN QUADRILLION, EIGHT HUNDRED AND " +
                          "SEVENTY-NINE TRILLION, SEVEN HUNDRED AND SEVENTY-THREE BILLION, THREE HUNDRED AND " +
                          "FORTY-SEVEN MILLION, SIX HUNDRED AND TWENTY-SEVEN THOUSAND AND SEVENTY-ONE DOLLARS AND " +
                          "SEVEN CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testSextillion() {
        String number = "7036279796855547463901.766580005418367180336";

        String expected = "SEVEN SEXTILLION, THIRTY-SIX QUINTILLION, TWO HUNDRED AND SEVENTY-NINE QUADRILLION, SEVEN " +
                          "HUNDRED AND NINETY-SIX TRILLION, EIGHT HUNDRED AND FIFTY-FIVE BILLION, FIVE HUNDRED AND " +
                          "FORTY-SEVEN MILLION, FOUR HUNDRED AND SIXTY-THREE THOUSAND, NINE HUNDRED AND ONE DOLLARS " +
                          "AND SEVENTY-SEVEN CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testSeptillion() {
        String number = "6065356366221143170225296.060658825972368689968066";

        String expected = "SIX SEPTILLION, SIXTY-FIVE SEXTILLION, THREE HUNDRED AND FIFTY-SIX QUINTILLION, THREE " +
                          "HUNDRED AND SIXTY-SIX QUADRILLION, TWO HUNDRED AND TWENTY-ONE TRILLION, ONE HUNDRED AND " +
                          "FORTY-THREE BILLION, ONE HUNDRED AND SEVENTY MILLION, TWO HUNDRED AND TWENTY-FIVE " +
                          "THOUSAND, TWO HUNDRED AND NINETY-SIX DOLLARS AND SIX CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testOctillion() {
        String number = "6745348987827288672058355233.033916808";

        String expected = "SIX OCTILLION, SEVEN HUNDRED AND FORTY-FIVE SEPTILLION, THREE HUNDRED AND FORTY-EIGHT " +
                          "SEXTILLION, NINE HUNDRED AND EIGHTY-SEVEN QUINTILLION, EIGHT HUNDRED AND TWENTY-SEVEN " +
                          "QUADRILLION, TWO HUNDRED AND EIGHTY-EIGHT TRILLION, SIX HUNDRED AND SEVENTY-TWO BILLION, " +
                          "FIFTY-EIGHT MILLION, THREE HUNDRED AND FIFTY-FIVE THOUSAND, TWO HUNDRED AND THIRTY-THREE " +
                          "DOLLARS AND THREE CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testNonillion() {
        String number = "1112752275043563054241208344166.9424406698390667393814";

        String expected = "ONE NONILLION, ONE HUNDRED AND TWELVE OCTILLION, SEVEN HUNDRED AND FIFTY-TWO SEPTILLION, " +
                          "TWO HUNDRED AND SEVENTY-FIVE SEXTILLION, FORTY-THREE QUINTILLION, FIVE HUNDRED AND " +
                          "SIXTY-THREE QUADRILLION, FIFTY-FOUR TRILLION, TWO HUNDRED AND FORTY-ONE BILLION, TWO " +
                          "HUNDRED AND EIGHT MILLION, THREE HUNDRED AND FORTY-FOUR THOUSAND, ONE HUNDRED AND " +
                          "SIXTY-SIX DOLLARS AND NINETY-FOUR CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testDecillion() {
        String number = "6984816369484750713544245628136607.356234797728026600933";

        String expected = "SIX DECILLION, NINE HUNDRED AND EIGHTY-FOUR NONILLION, EIGHT HUNDRED AND SIXTEEN " +
                          "OCTILLION, THREE HUNDRED AND SIXTY-NINE SEPTILLION, FOUR HUNDRED AND EIGHTY-FOUR " +
                          "SEXTILLION, SEVEN HUNDRED AND FIFTY QUINTILLION, SEVEN HUNDRED AND THIRTEEN QUADRILLION, " +
                          "FIVE HUNDRED AND FORTY-FOUR TRILLION, TWO HUNDRED AND FORTY-FIVE BILLION, SIX HUNDRED AND " +
                          "TWENTY-EIGHT MILLION, ONE HUNDRED AND THIRTY-SIX THOUSAND, SIX HUNDRED AND SEVEN DOLLARS " +
                          "AND THIRTY-SIX CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testUndecillion() {
        String number = "7974400915557861026000287039905333313.99346601372375";

        String expected = "SEVEN UNDECILLION, NINE HUNDRED AND SEVENTY-FOUR DECILLION, FOUR HUNDRED NONILLION, NINE " +
                          "HUNDRED AND FIFTEEN OCTILLION, FIVE HUNDRED AND FIFTY-SEVEN SEPTILLION, EIGHT HUNDRED AND " +
                          "SIXTY-ONE SEXTILLION, TWENTY-SIX QUINTILLION, TWO HUNDRED AND EIGHTY-SEVEN TRILLION, " +
                          "THIRTY-NINE BILLION, NINE HUNDRED AND FIVE MILLION, THREE HUNDRED AND THIRTY-THREE " +
                          "THOUSAND, THREE HUNDRED AND THIRTEEN DOLLARS AND NINETY-NINE CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testDuodecillion() {
        String number = "5280822943842200732961938595000553280809.7374332311513585779316";

        String expected = "FIVE DUODECILLION, TWO HUNDRED AND EIGHTY UNDECILLION, EIGHT HUNDRED AND TWENTY-TWO " +
                          "DECILLION, NINE HUNDRED AND FORTY-THREE NONILLION, EIGHT HUNDRED AND FORTY-TWO OCTILLION, " +
                          "TWO HUNDRED SEPTILLION, SEVEN HUNDRED AND THIRTY-TWO SEXTILLION, NINE HUNDRED AND " +
                          "SIXTY-ONE QUINTILLION, NINE HUNDRED AND THIRTY-EIGHT QUADRILLION, FIVE HUNDRED AND " +
                          "NINETY-FIVE TRILLION, FIVE HUNDRED AND FIFTY-THREE MILLION, TWO HUNDRED AND EIGHTY " +
                          "THOUSAND, EIGHT HUNDRED AND NINE DOLLARS AND SEVENTY-FOUR CENTS";
        
        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testTredecillion() {
        String number = "7239629360902378152996403134581777258419312.949461296973164";

        String expected = "SEVEN TREDECILLION, TWO HUNDRED AND THIRTY-NINE DUODECILLION, SIX HUNDRED AND TWENTY-NINE " +
                          "UNDECILLION, THREE HUNDRED AND SIXTY DECILLION, NINE HUNDRED AND TWO NONILLION, THREE " +
                          "HUNDRED AND SEVENTY-EIGHT OCTILLION, ONE HUNDRED AND FIFTY-TWO SEPTILLION, NINE HUNDRED " +
                          "AND NINETY-SIX SEXTILLION, FOUR HUNDRED AND THREE QUINTILLION, ONE HUNDRED AND " +
                          "THIRTY-FOUR QUADRILLION, FIVE HUNDRED AND EIGHTY-ONE TRILLION, SEVEN HUNDRED AND " +
                          "SEVENTY-SEVEN BILLION, TWO HUNDRED AND FIFTY-EIGHT MILLION, FOUR HUNDRED AND NINETEEN " +
                          "THOUSAND, THREE HUNDRED AND TWELVE DOLLARS AND NINETY-FIVE CENTS";
        
        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testQuattuordecillion() {
        String number = "9856663739196905303534725158843057279148530289.1880794";

        String expected = "NINE QUATTUORDECILLION, EIGHT HUNDRED AND FIFTY-SIX TREDECILLION, SIX HUNDRED AND " +
                          "SIXTY-THREE DUODECILLION, SEVEN HUNDRED AND THIRTY-NINE UNDECILLION, ONE HUNDRED AND " +
                          "NINETY-SIX DECILLION, NINE HUNDRED AND FIVE NONILLION, THREE HUNDRED AND THREE OCTILLION, " +
                          "FIVE HUNDRED AND THIRTY-FOUR SEPTILLION, SEVEN HUNDRED AND TWENTY-FIVE SEXTILLION, ONE " +
                          "HUNDRED AND FIFTY-EIGHT QUINTILLION, EIGHT HUNDRED AND FORTY-THREE QUADRILLION, " +
                          "FIFTY-SEVEN TRILLION, TWO HUNDRED AND SEVENTY-NINE BILLION, ONE HUNDRED AND FORTY-EIGHT " +
                          "MILLION, FIVE HUNDRED AND THIRTY THOUSAND, TWO HUNDRED AND EIGHTY-NINE DOLLARS AND " +
                          "NINETEEN CENTS";
        
        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testQuindecillion() {
        String number = "2681729884822799915262426297115257030675284200154.2307216075653844038611";

        String expected = "TWO QUINDECILLION, SIX HUNDRED AND EIGHTY-ONE QUATTUORDECILLION, SEVEN HUNDRED AND " +
                          "TWENTY-NINE TREDECILLION, EIGHT HUNDRED AND EIGHTY-FOUR DUODECILLION, EIGHT HUNDRED AND " +
                          "TWENTY-TWO UNDECILLION, SEVEN HUNDRED AND NINETY-NINE DECILLION, NINE HUNDRED AND FIFTEEN " +
                          "NONILLION, TWO HUNDRED AND SIXTY-TWO OCTILLION, FOUR HUNDRED AND TWENTY-SIX SEPTILLION, " +
                          "TWO HUNDRED AND NINETY-SEVEN SEXTILLION, ONE HUNDRED AND FIFTEEN QUINTILLION, TWO HUNDRED " +
                          "AND FIFTY-SEVEN QUADRILLION, THIRTY TRILLION, SIX HUNDRED AND SEVENTY-FIVE BILLION, TWO " +
                          "HUNDRED AND EIGHTY-FOUR MILLION, TWO HUNDRED THOUSAND, ONE HUNDRED AND FIFTY-FOUR DOLLARS " +
                          "AND TWENTY-THREE CENTS";
        
        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testSexdecillion() {
        String number = "8124101149124052435468652593464459710494615836987471.914391915";

        String expected = "EIGHT SEXDECILLION, ONE HUNDRED AND TWENTY-FOUR QUINDECILLION, ONE HUNDRED AND ONE " +
                          "QUATTUORDECILLION, ONE HUNDRED AND FORTY-NINE TREDECILLION, ONE HUNDRED AND TWENTY-FOUR " +
                          "DUODECILLION, FIFTY-TWO UNDECILLION, FOUR HUNDRED AND THIRTY-FIVE DECILLION, FOUR HUNDRED " +
                          "AND SIXTY-EIGHT NONILLION, SIX HUNDRED AND FIFTY-TWO OCTILLION, FIVE HUNDRED AND " +
                          "NINETY-THREE SEPTILLION, FOUR HUNDRED AND SIXTY-FOUR SEXTILLION, FOUR HUNDRED AND " +
                          "FIFTY-NINE QUINTILLION, SEVEN HUNDRED AND TEN QUADRILLION, FOUR HUNDRED AND NINETY-FOUR " +
                          "TRILLION, SIX HUNDRED AND FIFTEEN BILLION, EIGHT HUNDRED AND THIRTY-SIX MILLION, NINE " +
                          "HUNDRED AND EIGHTY-SEVEN THOUSAND, FOUR HUNDRED AND SEVENTY-ONE DOLLARS AND NINETY-ONE " +
                          "CENTS";
        
        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testSeptendecillion() {
        String number = "4129657087600337964535701753766029366139595015613003560.0209281047725071";

        String expected = "FOUR SEPTENDECILLION, ONE HUNDRED AND TWENTY-NINE SEXDECILLION, SIX HUNDRED AND " +
                          "FIFTY-SEVEN QUINDECILLION, EIGHTY-SEVEN QUATTUORDECILLION, SIX HUNDRED TREDECILLION, " +
                          "THREE HUNDRED AND THIRTY-SEVEN DUODECILLION, NINE HUNDRED AND SIXTY-FOUR UNDECILLION, " +
                          "FIVE HUNDRED AND THIRTY-FIVE DECILLION, SEVEN HUNDRED AND ONE NONILLION, SEVEN HUNDRED " +
                          "AND FIFTY-THREE OCTILLION, SEVEN HUNDRED AND SIXTY-SIX SEPTILLION, TWENTY-NINE " +
                          "SEXTILLION, THREE HUNDRED AND SIXTY-SIX QUINTILLION, ONE HUNDRED AND THIRTY-NINE " +
                          "QUADRILLION, FIVE HUNDRED AND NINETY-FIVE TRILLION, FIFTEEN BILLION, SIX HUNDRED AND " +
                          "THIRTEEN MILLION, THREE THOUSAND, FIVE HUNDRED AND SIXTY DOLLARS AND TWO CENTS";
        
        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testOctodecillion() {
        String number = "5430906110176266053705419148476485173233704889836266415684.503458";

        String expected = "FIVE OCTODECILLION, FOUR HUNDRED AND THIRTY SEPTENDECILLION, NINE HUNDRED AND SIX " +
                          "SEXDECILLION, ONE HUNDRED AND TEN QUINDECILLION, ONE HUNDRED AND SEVENTY-SIX " +
                          "QUATTUORDECILLION, TWO HUNDRED AND SIXTY-SIX TREDECILLION, FIFTY-THREE DUODECILLION, " +
                          "SEVEN HUNDRED AND FIVE UNDECILLION, FOUR HUNDRED AND NINETEEN DECILLION, ONE HUNDRED " +
                          "AND FORTY-EIGHT NONILLION, FOUR HUNDRED AND SEVENTY-SIX OCTILLION, FOUR HUNDRED AND " +
                          "EIGHTY-FIVE SEPTILLION, ONE HUNDRED AND SEVENTY-THREE SEXTILLION, TWO HUNDRED AND " +
                          "THIRTY-THREE QUINTILLION, SEVEN HUNDRED AND FOUR QUADRILLION, EIGHT HUNDRED AND " +
                          "EIGHTY-NINE TRILLION, EIGHT HUNDRED AND THIRTY-SIX BILLION, TWO HUNDRED AND SIXTY-SIX " +
                          "MILLION, FOUR HUNDRED AND FIFTEEN THOUSAND, SIX HUNDRED AND EIGHTY-FOUR DOLLARS AND FIFTY " +
                          "CENTS";
        
        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testNovemdecillion() {
        String number = "8687761023292284801896158999787700963136771078049062673219901.26310425632993";

        String expected = "EIGHT NOVEMDECILLION, SIX HUNDRED AND EIGHTY-SEVEN OCTODECILLION, SEVEN HUNDRED AND " +
                          "SIXTY-ONE SEPTENDECILLION, TWENTY-THREE SEXDECILLION, TWO HUNDRED AND NINETY-TWO " +
                          "QUINDECILLION, TWO HUNDRED AND EIGHTY-FOUR QUATTUORDECILLION, EIGHT HUNDRED AND ONE " +
                          "TREDECILLION, EIGHT HUNDRED AND NINETY-SIX DUODECILLION, ONE HUNDRED AND FIFTY-EIGHT " +
                          "UNDECILLION, NINE HUNDRED AND NINETY-NINE DECILLION, SEVEN HUNDRED AND EIGHTY-SEVEN " +
                          "NONILLION, SEVEN HUNDRED OCTILLION, NINE HUNDRED AND SIXTY-THREE SEPTILLION, ONE HUNDRED " +
                          "AND THIRTY-SIX SEXTILLION, SEVEN HUNDRED AND SEVENTY-ONE QUINTILLION, SEVENTY-EIGHT " +
                          "QUADRILLION, FORTY-NINE TRILLION, SIXTY-TWO BILLION, SIX HUNDRED AND SEVENTY-THREE " +
                          "MILLION, TWO HUNDRED AND NINETEEN THOUSAND, NINE HUNDRED AND ONE DOLLARS AND TWENTY-SIX " +
                          "CENTS";
        
        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testVigintillion() { 
        String number = "2487267846699413640462183779868608065710618353263324659995014327.718";

        String expected = "TWO VIGINTILLION, FOUR HUNDRED AND EIGHTY-SEVEN NOVEMDECILLION, TWO HUNDRED AND " +
                          "SIXTY-SEVEN OCTODECILLION, EIGHT HUNDRED AND FORTY-SIX SEPTENDECILLION, SIX HUNDRED AND " +
                          "NINETY-NINE SEXDECILLION, FOUR HUNDRED AND THIRTEEN QUINDECILLION, SIX HUNDRED AND FORTY " +
                          "QUATTUORDECILLION, FOUR HUNDRED AND SIXTY-TWO TREDECILLION, ONE HUNDRED AND EIGHTY-THREE " +
                          "DUODECILLION, SEVEN HUNDRED AND SEVENTY-NINE UNDECILLION, EIGHT HUNDRED AND SIXTY-EIGHT " +
                          "DECILLION, SIX HUNDRED AND EIGHT NONILLION, SIXTY-FIVE OCTILLION, SEVEN HUNDRED AND TEN " +
                          "SEPTILLION, SIX HUNDRED AND EIGHTEEN SEXTILLION, THREE HUNDRED AND FIFTY-THREE " +
                          "QUINTILLION, TWO HUNDRED AND SIXTY-THREE QUADRILLION, THREE HUNDRED AND TWENTY-FOUR " +
                          "TRILLION, SIX HUNDRED AND FIFTY-NINE BILLION, NINE HUNDRED AND NINETY-FIVE MILLION, " +
                          "FOURTEEN THOUSAND, THREE HUNDRED AND TWENTY-SEVEN DOLLARS AND SEVENTY-TWO CENTS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testOneVigintillionAndOne() {
        String number = "1000000000000000000000000000000000000000000000000000000000000001.000000000";

        String expected = "ONE VIGINTILLION AND ONE DOLLARS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testMax() {
        String number = "9999999999999999999999999999999999999999999999999999999999999999";

        String expected = "NINE VIGINTILLION, NINE HUNDRED AND NINETY-NINE NOVEMDECILLION, NINE HUNDRED AND " +
                          "NINETY-NINE OCTODECILLION, NINE HUNDRED AND NINETY-NINE SEPTENDECILLION, NINE HUNDRED AND " +
                          "NINETY-NINE SEXDECILLION, NINE HUNDRED AND NINETY-NINE QUINDECILLION, NINE HUNDRED AND " +
                          "NINETY-NINE QUATTUORDECILLION, NINE HUNDRED AND NINETY-NINE TREDECILLION, NINE HUNDRED " +
                          "AND NINETY-NINE DUODECILLION, NINE HUNDRED AND NINETY-NINE UNDECILLION, NINE HUNDRED AND " +
                          "NINETY-NINE DECILLION, NINE HUNDRED AND NINETY-NINE NONILLION, NINE HUNDRED AND " +
                          "NINETY-NINE OCTILLION, NINE HUNDRED AND NINETY-NINE SEPTILLION, NINE HUNDRED AND " +
                          "NINETY-NINE SEXTILLION, NINE HUNDRED AND NINETY-NINE QUINTILLION, NINE HUNDRED AND " +
                          "NINETY-NINE QUADRILLION, NINE HUNDRED AND NINETY-NINE TRILLION, NINE HUNDRED AND " +
                          "NINETY-NINE BILLION, NINE HUNDRED AND NINETY-NINE MILLION, NINE HUNDRED AND NINETY-NINE " +
                          "THOUSAND, NINE HUNDRED AND NINETY-NINE DOLLARS";

        String translation = convertNumbersToWords(number);

        assertEquals(expected, translation);
    }

    @Test
    void testThrowMustNotBeNull() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> convertNumbersToWords(null));
        assertEquals("numberString must not be null", e.getMessage());
    }

    @Test
    void testThrowMustNotBeEmptyString() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> convertNumbersToWords(""));
        assertEquals("numberString must not be an empty string", e.getMessage());
    }

    @Test
    void testThrowMustNotBeginWithDecimalPoint() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> convertNumbersToWords(".2231832"));
        assertEquals("numberString must not begin with the decimal point", e.getMessage());
    }

    @Test
    void testThrowMustNotEndWithDecimalPoint() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> convertNumbersToWords("192382."));
        assertEquals("numberString must not end with the decimal point", e.getMessage());
    }

    @Test
    void testThrowMustNotBeginWithZeroOrZeroes() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> convertNumbersToWords("00"));
        assertEquals(
            "numberString must not be prefixed with a zero or zeroes, unless it is 0 or decimals such as 0.00 or " +
            "or 0.0809 or 0.3847382, etc",
            e.getMessage()
        );
    }

    @Test
    void testThrowMustNotContainInvalidCharacters() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> convertNumbersToWords("128938e2"));
        assertEquals("numberString contains an invalid character e",e.getMessage());
    }

    @Test
    void testThrowMustNotContainMultipleDecimalPoints() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> convertNumbersToWords("398842..3823"));
        assertEquals("numberString contains multiple decimal points",e.getMessage());
    }

    @Test
    void testThrowMustNotExceedMaximum() {
        Exception e = assertThrows(
            IllegalArgumentException.class,
            () -> convertNumbersToWords("39884129381938917328917389217389217379813892173821738919831829328273213.3823")
        );
        assertEquals("the number of digits of the integer part must not exceed " + getMaxIntPartLength(), e.getMessage());
    }
}