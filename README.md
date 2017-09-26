# Asymmetrik Coding Challenge: Business Card OCR
## Morgan Philie
### Sept 2017

**Compiling:**
`javac ContactInfo.java` and `javac BusinessCardParser.java` to compile the programs

**Usage:**
 * `BusinessCardParser` is the executable program via `java BusinessCardParser`.
 * It is expected that _before_ running the Parser, the user has a suitable Java
 environment. I worked under Java version 1.8.0_60.

`BusinessCardParser` takes various hard-coded examples of possible documents read from the
 OCR and parses their main components: name, phone number, and email address.

**Assumptions:**
* The user is in an environment capable of running this program.
* The results of the OCR include "newline" characters for each line of the business card.
* All emails have an "@" symbol.
* The phone number listed first is the most relevant.
	
**Limitations:**
* To recognize names to parse out, the program compares potential names to a list of Strings
 that are clearly not names, like "LTD" and "Engineer". We are limited here by limiting the 
 possibilities of possible company names to look out for when trying to decipher between
 names and places/titles.
 