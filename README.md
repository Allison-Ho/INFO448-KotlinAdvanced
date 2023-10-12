# UW Homework: Kotlin - Advanced
This homework is designed to force you to exercise your knowledge of the Kotlin programming language. It does not involve Android in any way yet. Like the previous assignment, it will be done entirely from the command-line using Gradle and a good text editor.

## Goal
Your task is simple: ***Make the code compile, and make all the unit tests pass.***

Again, all your work should be in the `Library.kt` file, and you may not modify the `LibraryTest.kt` file in any substantive way.

## To obtain this code...
... you must first obtain a copy of the source. You do that by cloning this repository. Two options are available to you:

1. **Fork this repository.** From the GitHub repository web page, click "Fork" in the upper-right. This will create a copy of this repository in your own GitHub account. From there do a `git clone` from your own copy of the GitHub repository.

2. **Clone and re-home this repository.** Open a "Command Prompt" or "Terminal" instance and use:

        git clone https://github.com/tedneward/INFO448-KotlinAdvanced complexkotlin

    ... to do the deed. This will also create a local copy of the project on your machine in a directory called `complexkotlin`. You will also need to "re-home" your local copy so it points to your own GitHub account; you can do this by creating a repository of this same name (`INFO448-KotlinAdvanced`) in your GitHub account and then executing `git remote set-url origin https://github.com/[your-ID]/INFO448-KotlinAdvanced.git`. (Needless to say, it's a lot easier to fork the repo.)

## Now what?
If you do not see the `Library.kt` and `LibraryTest.kt` files at first, you can find them here:

* `src/main/kotlin/edu/uw/complexkotlin/Library.kt`
* `src/test/kotlin/edu/uw/complexkotlin/LibraryTest.kt`

Note that you will do all of your work in the `Library.kt` file, and you should not need to modify anything in the `LibraryTest.kt` file; in fact, modifying that file could jeopardize your grade! If you feel you need to make changes to it, contact the TA before doing so--chances are very good that the problem lies elsewhere.

## The assignment
The code is broken into a sequence of sections. Your job is to implement the body of each section, so that the tests will pass.

### FIZZBUZZ lambda
In the first section, you will be using the collection methods `map` and `fold` to perform the "FIZZBUZZ test". This is a simple algorithm, usually used as part of an interview process as a way of verifying developer skill (and rather poorly at that). 

FIZZBUZZ goes like this: For any sequence of numbers (such as 1 to 15), any number that is divisible by 3 returns "FIZZ", and any number divisible by 5 returns "BUZZ". Numbers which are divisible by both 3 and 5 return "FIZZBUZZ". 

Use the `map` function to transform the range of numbers into an list of strings (either "FIZZ", "BUZZ" or the empty string ""), and then use `fold` to combine them all down into a single String. The end result should be "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ". 

You need to define all this in a lambda value, called `fizzbuzz`, that I can call from the tests. Be prepared to support *any* range of numbers from 0 to 15 (0 to 1, 0 to 0, 4 to 12, and so on). You need not worry about negative numbers, or numbers greater than 15 (but it shouldn't be too hard to figure out how to do FIZZBUZZ for any number).

> In addition to teaching you FizzBuzz (which really is used a lot in programmer interviews, I'm not making that up), this is an exercise in understanding how `map` and `fold` work, as they are commonly used in Kotlin code. Both come in a triad along with `filter`, and these three functions are the cornerstone library set of "functional programming". You are free to use `filter` as well, if you so choose, but you do not need to in order to pass the tests. This exercise also reinforces your comfort level with lambda and block syntax.

***Extra Credit:*** Write new tests in `src/test/kotlin/edu/uw/complexkotlin/LibraryTest.kt` to test your FizzBuzz out to 50 and 100, then make your implementation work for it. (Let the TA know when you submit the assignment that you've done this so they can look for it.)

***Extra Credit:*** Introduce DOH! When the number is evenly divisible by 7, return DOH! Write some tests to test for this. (Again, let the TA know when you submit the assignment that you've done this.)

***Extra Credit (2 pts):*** Create a function that builds a fizzbuzz function. Create a new function, `fizzbuzzgen`, that takes a map of divisors and strings to print (as in, a `mapOf(3 to "FIZZ",5 to "BUZZ")`) as a parameter, and returns a lambda function that does the fizzbuzz algorithm. Then write some tests that test your new implementation. This is worth 2 points! (Again, let the TA know when you submit the assignment that you've done this.)

### Use `process`
In the second section, your job is to use the `process` function defined in the code to generate strings. The process function takes a parameter and a block of code. Your job is to write the lambdas `r1` and `r2` to call `process` such that the tests for `r1` and `r2` pass. 

> This is an exercise in getting the "block syntax" correct, as well as more practice around lambdas. If it's not becoming clear, the use of anonymous functions, lambdas, and block syntax is really important in Kotlin and other languages, and it's incredibly useful to be able to understand and use. Lambdas open up a whole new world of capability in code design. To my mind, this means you need to know it.

### Ho, Socrates!
In the third section, you are to create an `enum` class called `Philosopher`. This is going to be a peculiar use of `enum`, however, as we are going to model a very simple state machine: that of the classic Greek philosopher. 

As everybody knows, philosophers split their time between THINKING and TALKING, and only shift from one state to the other when told to do so via the method call `signal` (which you will need to define). Additionally, each state should override the `toString` function to indicate the `Philosopher`'s current state. When THINKING, a `Philosopher` will return "Deep thoughts..." and when TALKING, a `Philosopher` will return "Allow me to suggest an idea...". If you are not sure of the syntax here, check out [the Kotlin reference page on Enum classes](https://kotlinlang.org/docs/enum-classes.html).

> Modeling state machines in a mobile application is a very common occurrence, so this forces you to think about how to do that using this Kotlin feature. And giving you the link to the Kotlin reference page really makes this a "gimme", honestly.

> ***Extra Credit:*** By the way, I will give 1 extra credit point to anyone who can find out who Seneca the Younger was, and which school of philosophy he is commonly associated with. You get another 1 extra credit point if you can summarize that school of philosophy in a single sentence. Put your answers in comments in the code, and let the TA know so they can make sure to look for them. Direct copy-and-paste from Wikipedia does not count.

> On another note, when you have some time to kill, play "The Wikipedia Game"--pick any random subject on Wikipedia, and click the first link on that page. On the page that comes up, click the first link on that page. Continue doing this until you have reached the Wikipedia page on Philosophy, and marvel at how everything in human existence essentially traces its roots back to philosophy and a bunch of dead Greeks in togas. STEM is not the only thing you should be learning while you are in college--it may not feel like it now, but stepping into the world of the liberal arts and philosophy in particular will make you a much better programmer--and human--down the road.

## Command (object)!
In the fourth section, create a class called `Command` that can be used as a function. This means you will need to provide an `invoke` method on the class. The primary constructor should take a String parameter (prompt), and the `invoke` operator should also take a String parameter (message), and return a concatenation of the prompt and the message. The tests will invoke `Command` objects in several different ways, to verify that the concatenation works correctly.

## Rubric
As with the previous assignment, 5 points if all the tests pass, and 0 points if any of them fail.

Where this README appears to disagree with the code, follow the code, but do not change the tests.
