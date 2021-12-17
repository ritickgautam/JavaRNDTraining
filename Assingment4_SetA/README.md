#Core Java Assignment 4(String)

SET A

 

1.      Given a string, if the string "del" appears starting at index 1, return a string where that "del" has been deleted. Otherwise, return the string unchanged.

 

delDel("adelbc") → "abc"

delDel("adelHello") → "aHello"

delDel("adedbc") → "adedbc"

 

2.      Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and". The string length will be at least 3.

 

middleThree("Candy") → "and"

middleThree("and") → "and"

middleThree("solving") → "lvi"

 

3.      Given two strings, append them together (known as "concatenation") and return the result. However, if the strings are different lengths, omit chars from the longer string so it is the same length as the shorter string. So "Hello" and "Hi" yield "loHi". The strings may be any length.

 

minCat("Hello", "Hi") → "loHi"

minCat("Hello", "java") → "ellojava"

minCat("java", "Hello") → "javaello"