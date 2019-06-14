BACKGROUND
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

Problem
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.


SYSTEM REQUIREMENTS
Please have the below software installed to run this program

Java 8
Maven 3 or above

EXECUTION

To execute the program you need to clone the repo https://github.com/Swaroop86/Williams-Sonoma-Code-Challenge.git

Executing from terminal / command line
Step1 : Run mvn clean install

Step2: mvn exec:java -Dexec.mainClass="com.ws.code.challenge.Main"

The input can be provided in the file input.txt present in src/main/resources, the input format should be as follows [94133,94133] [94200,94299] [94400,94600], each zip code range should be presnt within [#####,#####] and no space after comma, and the next range shoudl be separated by space please follow the same inputs provided in input.txt. 

NOTE : Everytime the input is modified you need to repeat step1 and Step2.

The output is prinited to console as well as application.log file present in logs folder under the parent directory. The output will list all ther inputs and corresponding outputs

Unit Tests
Unit tests for all classes has been written and can be executed using command "mvn test" from project directory

