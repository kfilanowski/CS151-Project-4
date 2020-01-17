# Word-Ladder
Computes a word ladder from two given words.

A word ladder from one word to another means to change one character in the starting word and as long as it is a valid word
and moves us closer to the second word, we move onto that word and repeat this process.
This results in a chain of words with a one letter difference from the starting word to the ending word.
For example, from three to house we have:
```
three
threw
shrew
screw
scree
saree
sarge
marge
marse
morse
horse
house
```
There are 12 words total.

# Authors
Kevin Filanowski

Tyler Baylson

# Version
December 2017

# Contents
src
* A folder containing the source code for the project.

bin
* The java class files, we can run these directly.

dictionary.txt
* The dictionary that we're using to validate and find words from. The larger the dictionary, the more word ladders it can find.

# Usage
The files come pre-compiled in the bin directory, so as long as we are in the word ladder directory, if we run:

`java -cp ./bin Driver`

Then the program should prompt for a dictionary and a starting and ending word. The dictionary file is already supplied as dictionary.txt.
Then, pick whatever starting and ending word you would like.

For example, the following code:
`java -cp ./bin Driver dictionary.txt house eight`

yields these results:

```
eight
bight
bigot
begot
beget
beret
buret
burst
hurst
horst
horse
house
There are 12 words total.
```

