---
title: JUnit Testing
type: Lesson
duration: "1:15"
creator: James Davis (NYC)

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) JUnit Testing

### Learning Objectives

At the end of this lesson, students will be able to:
* Add conditional methods to a test case.
* Perform a JUnit test.

### Lesson Guide

| Timing  | Type  | Topic  |
|:-:|---|---|
| 10 min  | Opening  | Man vs. Machine |
| 5 min   | Introduction  | Unit Tests |
| 20 min  | Demo  | Creating a Unit Test |
| 40 min  | Independent Practice  | Automated Testing |
| 5 min   | Conclusion  | Review/Recap |

## Opening: Man vs. Machine (10 min)

There are many ways to test something. You can do it by hand, which a lot of QA teams do. However, this could get tedious because you usually have to test the full feature even for small changes.

For instance, imagine you're a home inspector checking out a newly built home. As the inspector, you'll have to test if a bedroom is indeed a bedroom. The room must have at least a bed, a dresser, and a closet.

Let's say an interior designer adds a lamp to the dresser. You then have to go back to the room and check if the dresser, bed, and closet are still there.

Now let's say the designer added a rug. You'll have to check again if the bed, dresser, and closet are still there.

Every time something changes, you have to ensure what you're checking does what it's required to do. This can be repetitive and, in some cases, a waste of time.

> **Knowledge Check**: Take one minute to discuss how to prevent this with the person next to you. Be prepared to share your answers with the class.

There are a few ways to tackle this problem. We'll talk about one today called **automation**.

Think about the previous example. Now, imagine you built a robot to inspect the house for you. So every time the designer changes something in the house, the robot would inspect the room for you. And while that's happening, you're on vacation in some remote tropical island.

This is the difference between manual and automated testing. You code tests to religiously check your code for defects, while you and your QA team have more time to do other tasks.

----

## Introduction: Unit tests (5 mins)

There are many, many types of tests: 

- Unit tests
- Smoke tests
- Integration tests
- Regression tests
- Acceptance tests

Each type of test is created and executed to perform a very specific function. Not all types of tests are created by developers. One of the first type of test written by a developer is unit test. In this lesson will focus on writing unit tests.

### What Is a Unit Test?

A unit test tests a piece of code (a unit). In Java, a unit is, in most cases, a class. A unit test asks the question, "Is this class and its methods working as expected?"

----

## Demo: Creating a Unit Test (20 min)

To test our classes (units), we create test classes that test other classes.

Create a new Java project in Eclipse. In the `src` folder, create two subfolders, if not present:

* `main`: The location of your app's main code (classes, activities, resources, and more).
* `test`: The location of tests, where we'll add our test classes.

We'll build a simple app that returns a student's fullname and grade.

First, let's create a `Student` class under package `co.ga.junittesting`, which has 3 `private` fields `firstName`, `lastName` and `grade`. It will have the methods `getFullName()` and `getLetterGrade()`. The first constructor takes a first name and last name, while the second one takes a letter grade.

```
package main.co.ga.junittesting;

public class Student {
	
	private String firstName;
	private String lastName;
	private char grade;
	
	public Student(String firstName, String lastName, char grade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public char getLetterGrade() {
		return grade;
	}

}
```
Before writing unit tests for the class we just created, we have to first add the JUnit library in our project. 

If you're working in **Eclipse**, right-click on the project folder -> Go to Build Path -> click Configure Build Path. A window will open, go to Libraries tab -> click Add Library -> select JUnit -> click Next then Finish -> click Apply and Close.

Then, we'll create a new test in the `src/test` creating the same package we did for `Student` class, `co.ga.junittesting` and call it `StudentTest`.

The idea of testing is to have methods that **implement** the class being tested and **assert** that the methods of the class are working.

In the `StudentTest` class, add methods that test if the `getFullName()` and `getLetterGrade()` methods are correct. Make sure to add the `@Test` annotation, or else JUnit won't recognize it.

<details>
<summary>Here's what it should look like:</summary>

```java
package test.co.ga.junittesting;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void testIfFullNameIsCorrect() {

    }

    @Test
    public void testIfLetterGradeIsCorrect() {

    }
}
```

</details>

Let's break that down. What do we see going on here?

#### org.junit.Test

In Java, annotations are used to provide supplemental information about a program. They provide metadata about a class or method without being a part of the program itself. They don't change the actual *action* of a program, but affect how the compiler treats that line of code when it's compiled or at runtime. 

In this case, we use the **@Test** annotation to indicate that the upcoming method represents a test case and needs to be executed as a JUnit test.

#### org.junit.Assert

To assert something, you would use jUnit's `assert_____()` static methods. We import static `Assert` because all the assert methods are static. Some of the main ones are:

```java
assertEquals(4, 2 + 2);
assertTrue(true);
assertFalse(false);
assertNull(null);
assertNotNull("Not null");
```

Each of these take an **expected value** and an **actual value**. The expected value is what the method should return, and the actual value is what the method actually returns.

Let's fill both our test methods, one will check if the `getFullName()` is behaving as expected and the other will check `getLetterGrade()`.

```java
package test.co.ga.junittesting;

import org.junit.Test;

import main.co.ga.junittesting.Student;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testIfFullNameIsCorrect() {
    	Student student = new Student("Leslie", "Knope", 'A');
    	
		String expected = "Leslie Knope";
		String actual = student.getFullName();
	
		assertEquals(expected, actual);
    }

    @Test
    public void testIfLetterGradeIsCorrect() {
    	
    	Student student = new Student("Leslie", "Knope", 'A');
    	
		char expected = 'A';
		char actual = student.getLetterGrade();
	
		assertEquals(expected, actual);

    }}
```
>**Note**: If you write multiple test classes, you can right click on the folder that contains the classes and click "Run tests in ______" to run all of them.

To run the test, right click on the class in the "Project View" and click "Run StudentTest." 

Both the tests right now are happy path tests. According to [wikipedia](https://en.wikipedia.org/wiki/Happy_path), Happy path testing is a well-defined test case using known input, which executes without exception and produces an expected output. Slowly we will learn to test every aspect of our code, even the ones which give an error.




## Bonus: @Before

If you have noticed that we are creating an instance of `Student` for each method. This is not the best programming practice. Our code needs to be DRY (Do not Repeat Yourself). What we will do is use`@Before` annotation that `Test` provides us to do this for us. Your refactored class will look like,

```
package test.co.ga.junittesting;

import org.junit.Test;

import main.co.ga.junittesting.Student;

import static org.junit.Assert.*;

import org.junit.Before;

public class StudentTest {
	
	private Student student;
	
	@Before
	public void initializeStudent() {
		student = new Student("Leslie", "Knope", 'A');
	}
	
    @Test
    public void testIfFullNameIsCorrect() {
	
    	String expected = "Leslie Knope";
		String actual = student.getFullName();
	
		assertEquals(expected, actual);
    }

    @Test
    public void testIfLetterGradeIsCorrect() {
    
		char expected = 'A';
		char actual = student.getLetterGrade();
	
		assertEquals(expected, actual);

    }
}
```
**@Before** annotation tells our compiler to execute `initializeStudent()` first before running any other tests. This way our `student` object gets initialized before being used by the test methods.

----

## Independent Practice: Automated Testing (40 min)

Now it's your turn to write some tests.

The `Math` class provides some handy methods for performing mathematical operations on numbers. Let's write some tests to make sure it's working properly.

* `Math.abs(x)` returns the absolute value of `x`.
	* Test for both integers and decimal numbers.

* `Math.sqrt(x)` returns the square root of `x`.

* `Math.pow(x, y)` returns the value of `x` to the power of `y`.

* `Math.max(x, y)` returns the larger value between `x` and `y`.
	* Test for both integers and decimal numbers.

* `Math.min(x, y)` returns the smaller value between `x` and `y`.
	* Test for both integers and decimal numbers.

Need a hint? Check out [Oracle's docs for the `Math` class](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html).

> **Knowledge Check**: With five minutes left, let's review the solution. 

----

## Conclusion (5 min)

* What's the difference between a manual and an automated test?
* What's a unit test?
* Give an "Explain it like I'm 5" definition of how JUnit works.

