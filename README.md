Project Setup
-----------------------------------------------------------------------------------------

1) Download Maven from https://maven.apache.org/download.cgi

2) Set JAVA_HOME to your JDK folder

3) Add the bin directory of the created directory apache-maven-3.3.9 to the PATH environment variable

4) Add JAVA_HOME\bin to the PATH environment variable

5) Check maven installation – On command prompt, run  
mvn –v  
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T08:41:47-08:00)  
Maven home: C:\apache-maven-3.3.9  
Java version: 1.8.0_91, vendor: Oracle Corporation  
Java home: C:\Program Files\Java\jdk1.8.0_91\jre  
Default locale: en_US, platform encoding: Cp1252  
OS name: "windows 7", version: "6.1", arch: "amd64", family: "dos"  

6) Install TestNG in Eclipse. Reference http://toolsqa.wpengine.com/selenium-webdriver/install-testng/

Note that we have set up maven pom to get chrome driver executable from https://github.com/bonigarcia/webdrivermanager   

Reference : Ahttps://objectpartners.com/2016/04/20/automatically-download-os-specific-webdriver-executable/

Git Commands
-----------------------------------------------------------------------------------------

For developers to pull from the repository for the first time
--------------------------------------------------------------

mkdir SamppleTests   
cd SamppleTests  
git config --global user.name "<your git user id>"  
git config --global user.email "<your email>"   
  
git clone git@github.com:pooja-reddy/SeleniumAutomationFramework.git
git fetch  
git checkout master   

For developers to push to the repository
-----------------------------------------

cd SampleTests   
git config --global user.name "<your git user id>"  
git config --global user.email "<your email>"  
  
git add <filename>  
git commit -m "<Add a comment>"  
git push origin master

Maven Commands - To run the test suite
------------------------------------------------------------------------------------------------------------------------

mvn clean  
mvn test  

Output Folders
------------------------------------------------------------------------------------------------------------------------

All the logs will be written to the below folder

.\logs\SampleTests.log

If running the test suite using maven, output will be generated in

 .\target\surefire-reports\SampleTests-YahooFinance\Index.html