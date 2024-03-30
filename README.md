# TEST with Famous tools
## Abstract
With the development of the software industry, software testing has gradually become a hot topic. 
<br>
This project focuses on using different testing tools and source programs to help everyone understand the succession of testing tools and the basic knowledge of test case generation.
<br>
**It is worth noting that the project is still being updated and is constantly being updated.**

## Structure of the Directory
```
| --- README                             : the introduction
| --- src/main/java/org/example          : source file
| ------ backpack                        : the solutions to '01 backpack'
| --------- Backpack                     : the interface
| --------- BackpackImpl                 : the implimentation of 'backpack'
| --------- BackpackUltimate             : the other solution
| ------ object                          : the objects to represent items and paths in problem '01 backpack'
| ------ bubble
...
...
```

## Test tools
### Mujava
1. Install MuJava. Follow the instructions provided at [here](https://cs.gmu.edu/~offutt/mujava/) to install and configure MuJava on
   your development environment.
2. Generate mutants on cmd(windows).
```commandline
java mujava.gui.GenMutantsMain
```
3. Run mutants.
```commandline
java mujava.gui.RunTestMain
```
#### Special reminder
Here are some precautions for using MuJava
1. Using custom classes, even built-in classes, can cause exceptions that cannot parse trees to be thrown when generating variants.
2. The source program being tested cannot be an implementation class of a certain interface, and the test program cannot be a parameterized test, such as using @RunWith(Parameterized.class), otherwise an exception will be thrown that cannot instantiate the object.
