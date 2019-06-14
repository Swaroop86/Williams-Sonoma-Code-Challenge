<h1>Williams-Sonoma-Coding Challenge</h1>
<p>Author: Swaroop Shivarudrappa</p>
<p>Date: 06-14-2019</p>

<h2>Background</h2>
<p>Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:</p>
<p>[94133,94133] [94200,94299] [94600,94699]</p>
<p>Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.</p>
<p>Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.</p>

<h2>Problem</h2>
<p>Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.</p>

<h2>Notes</h2>
<ul>
  <li>The ranges above are just examples, your implementation should work for any set of arbitrary ranges</li>
  <li>Ranges may be provided in arbitrary order</li>
  <li>Ranges may or may not overlap</li>
  <li>Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices</li>
</ul>
<h2>Examples</h2>
<p>If the input = [94133,94133] [94200,94299] [94600,94699]</p>
<p>Then the output should be = [94133,94133] [94200,94299] [94600,94699]</p>
<p>If the input = [94133,94133] [94200,94299] [94226,94399]</p>
<p>Then the output should be = [94133,94133] [94200,94399]</p>

<h2>Requirements</h2>
<p>Please have the below software installed to run this program:</p>
<ul>
  <li>Java 8</li>
  <li>Maven 3 or above</li>
</ul>

<h2>EXECUTION</h2>
<p>To execute the program you need to clone the repo https://github.com/Swaroop86/Williams-Sonoma-Code-Challenge.git</p>
<p>Executing from terminal / command line</p>
<ul>
  <li>Step1 : Run mvn clean install</li>
  <li>Step2: mvn exec:java -Dexec.mainClass="com.ws.code.challenge.Main"</li>
</ul>

<p>The input can be provided in the file input.txt present in src/main/resources, the input format should be as follows [94133,94133] [94200,94299] [94400,94600], each zip code range should be presnt within [#####,#####] and no space after comma, and the next range shoudl be separated by space please follow the same inputs provided in input.txt.</p>

<p>NOTE : Everytime the input is modified you need to repeat step1 and Step2.</p>

<p>The output is printed to console as well as application.log file present in logs folder under the parent directory. The output will list all ther inputs and corresponding outputs</p>


<h2>Unit Tests</h2>
<p>Unit Tests Unit tests for all classes has been written and can be executed using command <strong>mvn test</strong> from project directory</p>

