/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package edu.uw.complexkotlin

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15).
// use map() to return a list with "", "FIZZ" (for 3s) or "BUZZ" (for 5s).
// use fold() to compress the array of strings down into a single string.
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ for 0..15.
// store this lambda into 'fizzbuzz' so that the tests can call it
//
val fizzbuzz : (IntRange) -> String = { nums ->
    nums.map{
        when {
            it % 3 == 0 && it % 5 == 0 -> "FIZZBUZZ"
            it % 3 == 0 -> "FIZZ"
            it % 5 == 0 -> "BUZZ"
            else -> ""
        }
    }.fold("") {acc, str -> acc + str}
}

val fizzbuzzExtra : (IntRange) -> String = { nums ->
    nums.map{
        when {
            it % 3 == 0 && it % 5 == 0 -> "FIZZBUZZ"
            it % 3 == 0 -> "FIZZ"
            it % 5 == 0 -> "BUZZ"
            it % 7 == 0 -> "DOH!"
            else -> ""
        }
    }.fold("") {acc, str -> acc + str}
}

//fun fizzbuzzgen(divisorMap: Map<Int, String>) {
////    return {
////        print('working')
////    }
//}

// Example usage
/*
if (fizzbuzz(1..2) == "")
    println("Success!")
if (fizzbuzz(1..3) == "FIZZ")
    println("Success!")
if (fizzbuzz(1..5) == "FIZZBUZZ")
    println("Success!")
*/

// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
// Create r1 as a lambda that calls process() with message "FOO" and a block that returns "BAR"
val r1 = { process("FOO") {("BAR")} }

// Create r2 as a lambda that calls process() with message "FOO" and a block that upper-cases
// r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"
val r2_message = "wooga"
val r2 = { process("FOO") {(r2_message.toUpperCase().repeat(3))} }


// write an enum-based state machine between talking and thinking
enum class Philosopher {
    TALKING {
        override fun signal() = THINKING
        override fun toString(): String {
            return "Allow me to suggest an idea..."
        }
    },

    THINKING {
        override fun signal() = TALKING
        override fun toString(): String {
            return "Deep thoughts...."
        }
    };

    abstract fun signal(): Philosopher
}

// create an class "Command" that can be used as a function.
// To do this, provide an "invoke()" function that takes a
// single parameter ("message" of type String). Command's
// primary constructor should take a String argument ("prompt").
// When invoked, the Command object should return a String
// containing the prompt and then the message.
// Example:
// val cmd = Command(": ")
// val result = cmd("Hello!")
// result should equal ": Hello!"
class Command(val prompt: String) {
    operator fun invoke(message: String): String { return prompt + message }
}

// EXTRA CREDIT

// Seneca the Younger:
// was a Stoic philosopher of Ancient Rome.
// He was a statesman, dramatist, and satirist
// he was exiled to the island of Corsica in AD 41
// was allowed to return in AD 49 to tutor Nero
// he later became emperor Nero's advisor
// Nero stopped liking Seneca in AD 65 and he
// was forced to kill himself because he got
// involved in a conspiracy to assassinate Nero
// but he was innocent

// School of philosophy: Stoicism

// Stoicism is a philosophical school that believes people can achieve a well-lived
//life by practicing the four virtues: wisdom, courage, temperance, and justice, and
//living in accordance with nature