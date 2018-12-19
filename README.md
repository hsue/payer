Before you run:
-Install java (jre1.8 or higher)
-Install MySQL (5.5 or higher)
-Run create.sql in payer/create.sql to create all the necessary DB tables.

To run this project from jar:
run java -jar paryer.jar from <project location>/payer/out/artifacts/payer_jar

To run project in debug mode
(if you have intellij)
-import java persistence project and add existing project location.
-setup your DB connection configuration in the create/import process (optional)
-Run MainTester.java

After run successfully:
-You will see loan, image, lender, term, transaction tables being filled with data.
-All data is from the api except for the transaction table.  This table contains the distribution of the repayment of each lender.
