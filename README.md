# RPNCalc

Author: Nicklas Molving.

This project was created for a school assignment in functional programming.
The project is a Reverse Polish Notation Calculator written in Java.

## HOW THE PROGRAM WORKS:
the program runs ona a single class(main) that takes input from the user, evaluates the input,
pushes each number onto a stack for later use. if the input is evaluated as a supported math operator,
the program will pop the last two elements(numbers) pushed to the stack and perform the given math operation,
and then push the result to the stack, and finally print the stack. 
the program makes use of a blocking statement to read input from the user. 

If the input contains anything but supported commands,
the program will print an error message, and the entire input, the one containing illegal commands, will be discarded.


## HOW TO INSTALL THE PROGRAM:
There is two approaches to run this project;
1. download the project from github.
2a. either import the project to you favorite Java IDE and run it.
2b. or open a command promt and navigate to the folder containing a .jar file.
Here you should run the project with java -jar RPNCalc.jar

## ACCEPTED COMMANDS:
Once the program is running you can enter the following;
- positive numbers and math operators. OBS! this project only supports + - * /
- input to the program should be written as such: 3 4 + (3 + 4) if only a math operator is entered, the program wil try
to pop the last to numbers pushed to the stack, if not enough numbers are available, an error message will be printed.
- hit enter/return on you keyboard to print the numbers currently in the stack.
- stop the program by inputting the command "stop".

## KNOW BUGS:
- if the user tries to divide by zero, an Arithmetic Exception will be thrown and the program will stop.
