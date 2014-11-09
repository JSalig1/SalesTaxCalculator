##Sales Tax Calculator

This program will:

- Ask for a file name
- Read the contensts line by line treating each line as a Product objext(instance)
- Calcualte the Sales Tax of each product, while checking for exemptions
- Calculate the Import Tax of each pruduct, while checking for "imported"
- Store combined tax value in the product object
- Add each Product to a Cart object where the total tax and grand total is also stored
- Pass the cart into a receipt generator which writes the following to a new "NAME_receipt" file:
 - cart contents
 - total tax
 - grand total

Additionally I have implimented functionality to adjust calculations based on different quantities.

***

##Running The Program

To run this program cd into this directory and run the jar archive using the command:

    java -jar SalesTaxCalculator.jar

It will ask you for one of the input files included in this directory, but they are just basic text files with data formatted like this:

    1 book at 12.49
    1 music CD at 14.99
    1 chocolate bar at 0.85

You can also run this program from the java source file, but you will have to add apache FileUtils to the classpath like this:

    java -classpath .:lib/commons-io-2.4.jar: app.SalesTaxCalculator

The jar file includes this classpath in its Manifest file.  In either case be sure that lib/commons-io-2.4.jar is present for File io purposes.
