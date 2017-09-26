# Asymmetrik Coding Challenge, TESTING
## Morgan Philie, Sept 2017

### Testing Design:
To test the BusinessCardParser, at each milestone of the code, I will test small pieces
 of the code. In this manner, the code will be assembled in building blocks; making each small
 functioning piece work on its own first, then implementing the logic of parsing in order
 to complete the task. 

#### Code Layout Testing
Here, I set up all of my functions with pseudocode and put simple print statements
 in key areas of function. Running BusinessCardParser from here traced through the program
 and verified that my design was sound and ready to be implemented.
```
MacBook-Pro:AsymmetrikPhilie morgan$ java BusinessCardParser
came to init ContactInfo object

came to set name to Anthony

came to get name

Name is: Anthony
MacBook-Pro:AsymmetrikPhilie morgan$
```

#### Parsed Into Strings
My next step was to simply separate out each line of the business card. By 
completing this step, I could begin to analyze each line of the card.
```
MacBook-Pro:AsymmetrikPhilie morgan$ java BusinessCardParser
OCR document: 
Marco Polo
Asymmetrik LTD
Tour Guide
phone:443-896-4833
fax:1234567890
me@me.com
```

#### Getting the Email
Next, I singled out the email. Once I found the email, I printed it to stdout.
```
MacBook-Pro:AsymmetrikPhilie morgan$ java BusinessCardParser
OCR document: 
Marco Polo
Asymmetrik LTD
Tour Guide
phone:443-896-4833
fax:1234567890
me@me.com

Email: me@me.com
```

#### Getting the Phone Number
I continued by implementing the parsing out of the phone number. Later, I refined
 the formatting of the displayed phone number in order to comply with the specs of
 this assignment.
```
MacBook-Pro:AsymmetrikPhilie morgan$ java BusinessCardParser
OCR document: 
Marco Polo
Asymmetrik LTD
Tour Guide
phone:443-896-4833
fax:1234567890
me@me.com

Phone: 443-896-4833
Email: me@me.com
```

#### Putting it all together...
The last component was the name. I put three different test documents in my program
 to test the robustness of my code. The following is the output from that test.

```
MacBook-Pro:AsymmetrikPhilie morgan$ java BusinessCardParser
OCR document 1: 
Marco Polo
Asymmetrik LTD
Tour Guide
phone:443-896-4833
fax:1234567890
me@me.com

Name: Marco Polo
Phone: 4438964833
Email: me@me.com

OCR document 2: 
Foobar Technologies
Analytic Developer
Lisa Haung
1234 Sentry Road
Columbia, MD 12345
Phone: 410-555-1234
Fax: 410-555-4321
lisa.haung@foobartech.com

Name: Lisa Haung
Phone: 4105551234
Email: lisa.haung@foobartech.com

OCR document 3: 
Arthur Wilson
Software Engineer
Decision & Security Technologies
ABC Technologies
123 North 11th Street
Suite 229
Arlington, VA 22209
Tel: +1 (703) 555-1259
Fax: +1 (703) 555-1200
awilson@abctech.com

Name: Arthur Wilson
Phone: 17035551259
Email: awilson@abctech.com
MacBook-Pro:AsymmetrikPhilie morgan$ 
```


