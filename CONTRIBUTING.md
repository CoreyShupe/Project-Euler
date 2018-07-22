# How do I contribute?
## Check if the project has already been done!
To check if the project has already been done you can use `java -jar ProjectEuler.java <projectNumber#>` and make sure it throws an exception.
<br>
If it already exists then it will provide an answer along with the class for the solution.
### Think you can make the solution better?
Great! Remodel the class and submit a PR with the changes. Make sure the PR is based around that change and nothing else.
<br>
Before solutions are added they are tested against Project-Euler. If they fail they won't be accepted, so make sure your changes don't change the answer.
## If it doesn't already exist.
Make sure the class for the problem `implements Problem` and has the proper annotations.
<br>
In this structure you must provide the annotation `ProjectEulerProblem` with the value as the project number.
<br>
An example would be: `test`
```java
@ProjectEulerProblem(1)
public class Problem1 implements Problem<Integer> {
  public int getSolution() {
    return 1; // This is not the answer, but an example.
  }
}
```
Also, remember to document linking the Project-Euler problem and giving a brief explanation of the problem.
<br>
When documenting the class it should follow the template:
```java
/**
 * To solve this problem, you must find the sum of all numbers below 1000 of the multiples 3 and 5.
 * <br>
 * @see <a href="https://projecteuler.net/problem=1">Problem 1</a>
 */
```
Any other methods in the class also need to be documented before PR'd.
<br>
Also make sure that the problem has been defined in the main class inside of the `registerProblems()` method.
<br>
It can be done very simple by using `registerProblem(ProblemX.class, map)` within the method.
## Spotless
This project follows [Spotless](https://github.com/diffplug/spotless) with verification.
<br>
Doing this makes sure the codebase is pretty consistent with how it looks and how it's made even amongst different contributors.
<br>
The PR will fail travis if not formatted properly.
<br>
To automatically format the project you can use `mvn spotless:apply` in the project.
