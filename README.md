# Java Projects

A collection of various Java console applications developed for school assignments. The source code and in-program text are primarily in Italian.

## Projects

This repository includes the following small projects:

*   **`Babilonese.java`**: A command-line tool that calculates the square root of a given number using the Babylonian method, allowing the user to specify the desired accuracy.

*   **`Genpass.java`**: A simple random password generator. The user specifies the desired length (up to 100 characters), and the program generates a string of random characters.

*   **`IMC.java`**: A Body Mass Index (BMI) calculator. It prompts the user for their height and weight, calculates the BMI, and provides a corresponding classification (e.g., underweight, normal weight, overweight).

*   **`calcolatrice/`**: A basic command-line calculator.
    *   `Calc.java`: A class containing methods for addition, subtraction, multiplication, and division.
    *   `MenuCalc.java`: The main application class that provides a menu-driven interface for performing calculations, viewing the history of the last five results, and inputting new numbers.

*   **`cript/Cifratura.java`**: A simple text encryption tool that implements a Caesar cipher. It shifts each character of the input string forward by 3 positions in the ASCII table.

*   **`media/`**: Contains two variations of a program to calculate the average of three numbers.
    *   `media.java`: Takes three numbers as separate inputs.
    *   `media_arr.java`: Uses an array to store and process the numbers.

*   **`superenalotto/`**: A simulation of the "SuperEnalotto" lottery game.
    *   `Superenalotto.java`: The user inputs six unique numbers between 1 and 20. The program then generates six random winning numbers and compares them to the user's selection to determine the score.

## Getting Started

To run any of these projects, you need to have a Java Development Kit (JDK) installed on your system.

### How to Compile and Run

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/mattiasaan/java_projects.git
    cd java_projects
    ```

2.  **Navigate to a project's directory.** For standalone files like `IMC.java`, you can stay in the root directory. For projects in subdirectories, change into them.

3.  **Compile the Java source file(s):**
    ```sh
    javac FileName.java
    ```
    For projects with multiple files in one directory:
    ```sh
    javac directory_name/*.java
    ```

4.  **Run the compiled application:**
    ```sh
    java ClassName
    ```
    *Note: Run using the class name, not the file name (e.g., `java IMC`, not `java IMC.java`).*

### Examples

**Running the BMI Calculator:**
```sh
javac IMC.java
java IMC
```

**Running the Calculator:**
```sh
cd calcolatrice
javac *.java
java MenuCalc
```

**Running the SuperEnalotto Game:**
```sh
cd superenalotto
javac Superenalotto.java
java Superenalotto
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
