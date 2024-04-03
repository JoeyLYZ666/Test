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
| --- Lab_4                              : the project
| ------ src/main/java                   : the solutions to classify or get the area of the triangle
| ------ test/main/java                  : the JUnit test
| ------ target/                         : the classes           
| ------ build.xml                       : the Configuration file for project process definition
| ------ run.sh                          : the shell script
| --- major                              : the whole major
| ------ mml                             : the mutators
...
...
```


### Major
*Environment:Linux*
1. Install Major. Follow the instructions provided at [here](https://mutation-testing.org/tutorial.html) to install and configure Major on your development environment.

2. Configure `~/.bashrc` or `~/.profile` in Linux. (include Major and JDK)
```commandline
$ nano ~/.bashrc
```
3. Make PATHs active.
```commandline
$ source ~/.bashrc
```
4. Modify `build.xml` and `run.sh` according to your own project structure.
5. Modify tutorial.mml according to your own mutation operator requirements.
6. Compile 'tutorial.mml'.
```commandline
$ mmlc tutorial.mml tutorial.mml.bin
```
7. Run the whole project through Major.
```commandline
$ ./run.sh
```