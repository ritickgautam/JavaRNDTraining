#Core Java Assignment 4(String)

SET C

 

1.      Return true if the given string contains between 1 and 3 'e' chars. 

 

stringE("Hello") → true

stringE("Heelle") → true

stringE("Heelele") → false

 

2.      Given a string, take the last char and return a new string with the last char added at the front and back, so "cat" yields "tcatt". The original string will be length 1 or more. 

 

backAround("cat") → "tcatt"

backAround("Hello") → "oHelloo"

backAround("a") → "aaa"

 

3.      Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx". 

 

countXX("abcxx") → 1

countXX("xxx") → 2

countXX("xxxx") → 3