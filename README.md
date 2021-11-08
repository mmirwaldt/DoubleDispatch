# Double dispatch
### What is this?
This example shows how double dispatch may lead to a better solution.  
I hope this example is quite simple to understand on the one hand but complicated enough 
to see why double dispatch is useful.
The examples are about printing a text and a fraction on different printers.
The available printers are the console and the file system.
They also include a Main class with a main method to illustrate how the solutions are used.

### Where can I find the solution without double dispatch?
You can find the solution **without** double dispatch here:    
https://github.com/mmirwaldt/DoubleDispatch/tree/master/src/main/java/net/mirwaldt/no/doubledispatch   
It uses the enum Printer and if-clauses with a printer class.

### Where can I find the solution with double dispatch?
You can find the solution **with** double dispatch here:    
https://github.com/mmirwaldt/DoubleDispatch/tree/master/src/main/java/net/mirwaldt/doubledispatch      
It uses the interface Printer which is implemented by a Console class and a FileSystem class.

### Why do I use the name Printer?
I decided to use the name 'Printer' because the JDK already knows the interface 'Writer'.  
I haven't found any better names.

### Why does the file system use a DataOutputStream in both solutions?
I wanted to introduce an important difference between the Console and the FileSystem:
The console prints out everything as visible characters while the file system 
uses the binary representation of the text string and the binary representations
of the ints of the fraction class.
This avoids using strings everywhere which would make the use of double dispatch useless 
because one single print method for printing strings would just be enough. 
