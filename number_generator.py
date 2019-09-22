# Author: Irsan Winarto
# 
# Use this script to generate random real numbers and their translations in 
# English for the following scales: ones, tens, hundreds, thousands, 
# tens of thousands, hundreds of thousands, and all powers of a thousand up to
# vigintillion (10**63)
# 
# Requirements: num2words and decimal.getcontext().prec must be big enough

from collections import deque
from num2words import num2words

import decimal
import random


def gen_random(int_length, max_frac_length=25):
    """
    Parameters:
        int_length is the length of the integer part

        max_fract_length is the maximum length of the fractional part
    
    Return:

        one random real number such that the length of the integer part is 
        int_length and the length of the fractional part is between 0 and 
        max_frac_length
    """
    random.seed()

    # integer part
    integer = deque(random.choices(range(10), k=int_length - 1))
    integer.appendleft(random.randrange(1, 10))
    integer = ''.join(str(i) for i in integer)

    assert len(integer) == int_length, f"length {len(integer)} != {int_length}"

    if max_frac_length > 0:
        # maximum length of the fractional part
        max_frac_length = random.randrange(max_frac_length)

    if max_frac_length == 0:
        return integer

    fraction = ''.join(
        str(i) for i in random.choices(range(10), k=max_frac_length)
    )

    return f"{integer}.{fraction}"


def translate_number_to_english_words(number, unit="dollar"):
    """
    Parameters:
        number is a string of digits to be translated into English words
    
    Return:
        the number treated as a currency value and expressed in English words 
        with the given unit appended

        every occurrence of "SEPTDECILLION" is replaced by "SEPTENDECILLION"
    """

    if (round(float(number)) > 1):
        unit = f"{unit}s"

    translated_number = num2words(number, to='currency') \
                            .replace("septdecillion", "septendecillion")
    
    translated_number = translated_number.replace("euro,", f"{unit} and")

    # delete "zero cents" (bad design from the num2words devs)
    if ("zero cents" in translated_number):
        translated_number.replace(" and zero cents", "")

    return translated_number.upper()



if __name__ == "__main__":
    # need to increase default scale for num2words to work properly
    decimal.getcontext().prec = 100

    # integer part lengths ones, tens, hundreds, thousands, tens of thousands,
    # hundred thousands, and all powers of a thousand up to 10**63
    int_lengths = tuple(range(1, 7)) + tuple(range(7, 65, 3))

    for int_length in int_lengths:
        print(f"Integer part length: {int_length}\n")

        number = gen_random(int_length)
        translated_number = translate_number_to_english_words(number)

        print(f"{number}\n\n{translated_number}\n\n")
