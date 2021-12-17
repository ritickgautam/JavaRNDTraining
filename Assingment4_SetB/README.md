#Core Java Assignment 4(String)



SET B

1.      Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo". 

 

stringBits("Hello") → "Hlo"

stringBits("Hi") → "H"

stringBits("Heeololeo") → "Hello"

 

2.      Given a non-empty string and an int n, return a new string where the char at index n has been removed. The value of n will be a valid index of a char in the original string (i.e. n will be in the range 0..str.length()-1 inclusive). 

 

missingChar("kitten", 1) → "ktten"

missingChar("kitten", 0) → "itten"

missingChar("kitten", 4) → "kittn"

 

3.      Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien". 

 

altPairs("kitten") → "kien"

altPairs("Chocolate") → "Chole"

altPairs("CodingHorror") → "Congrr"