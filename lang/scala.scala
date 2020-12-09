
val // const
var // const

var s = "hello"
var s: String = "hello"

def f(x: Int, y: Int): Int = {

}
(x: Int, y:Int)Int 

// short
def f(x: Int, y: Int) = if (x > y) x else y

()Unit // void

// args, args(0)

println()
print()

// ; is optional

while () {

}

args.foreach(arg => println(arg))
args.foreach((arg: String) => println(arg))
args.foreach(println)

// function literal
(x: Int, y: Int) => x + y

// arg is val
for (arg <- args) {

}

var weekdays = new Array[String](3)
weekdays(0) = "mon"

for (i <- 0 to 2)
// (0).to(2)

arr(0)
arr.apply(0)

arr(0) = "mon"
arr.update(0, "mon")

// companion object's factory method
val weekdays = Array("mon", "tue", "wed")
val weekdays = Array.apply("mon", "tue", "wed")

// Array: mutable
// List: immutable
val l1 = List(1, 2, 3)
val l2 = List(4, 5, 6)
val l3 = l1 ::: l2 // l2.:::(l1) 
val l4 = 0 :: l1 // l1.::(0)
val l5 = 0 :: 1 :: Nil

// tuple
val t1 = (10, true, "jun") // Tuple3[Int, Boolean, String]
t1._1, t1._2

scala.collection.mutable.Set
scala.collection.immutable.Set

var weekdays = Set("mon", "tue") // Set[String]
weekdays += "wed"

import scala.collection.mutable
var weekdays = mutable.Set("mon", "tue")

immutable.HashSet
mutable.HashSet
immutable.HashMap
mutable.HashMap

val weekdays = Map[Int, String]()
weekdays += (1 -> "mon") // (1).->("mon")

val weekdays = Map(
    1 -> "mon", 2 -> "tue"
)
weekdays(1)

args.mkString("\n")

assert(cond)

import scala.io.Source
Source.fromFile(path).getLines() // Iterator[String]
Source.fromFile(path).getLines().toList()

class A {
    private var i = 0
    var j = 0 // public

    def add(b: Byte): Unit = {
        i += b
    }
    def add(b: Byte) = i += b
    def add(b: Byte): Unit = i += b
    // method parameter is val!
}
val a = new A

x +
y

(x
+ y)

// singleton object, companion object, companion class
// static
object A {
    def h(): Unit = {

    }
}
A.h()

// companion object without companion class is standalone object

// java.lang, Predef is defaultly imported

// App trait
object MyApp extends App {
    println("hello")
}

// integral type
Byte, Short, Int, Long, Char
//
Float, Double
// numeric type

// octane number is not supported

// raw string
""" """
// align left
"""|hello
   |jun""".stripMargin

// scala.Symbol
val s = 'aSymbol // Symbol("aSymbol")
s.name

s"hello $name"
s"hello ${name}"

raw"no \\\\escape"

f"pi is ${math.Pi}%.5f"

// operator is method
// any method can be operator

// infix
s indexOf 'o'
s indexOf ('o', 5)

// postfix 
7 toLong

// prefix
(2.0).unary_- // -2.0

unary_+, unary_-, unary_!, unary_~

// with side effect -> println()
// without side effect -> s toLowerCase

& |
// same with && || but not short-circuit

& | ^ ~
<< >> >>>

== != // calls equals, compare value
eq ne // compare reference

class Rational(n: Int, d: Int)
val x = new Rational(1, 2)
// n, d is class parameter
// primary constructor
// no {}
// no field
// this.field to refer self

class Rational(n: Int, d: Int) {
    // precondition
    require(d != 0) // IllegalArgumentException

    // auxiliary constructor
    // every constructor should lead to primary constructor!
    def this(n: Int) = this(n, 1)

    // field
    val numer: Int = n
    val denom: Int = d

    override def toString = n + "/" + d

    def add(that: Rational): Rational = {
        new Rational(..., ...)
    }

    // private field
    // initialized in order of declaration order
    private val g = gcd(n.abs, d.abs)
    val numer = n / g
    val denom = d / g

    private def gcd(a: Int, b: Int): Int = 
        if (b == 0) a else gcd(b, a % b)

    // operator
    def + (that: Rational): Rational = 
        new Rational(..., ...)
    
    // override
    def + (i: Int): Rational = 
}

// implicit conversion, should exist in scope
implicit def intToRational(x: Int) = new Rational(x)

// identifier
1. alphanumeric identifier 
    alpha, numeric, _, $
2. operator identifier 
    + ++ ::: <?> :->
    internal translation: $colon$minus$greater
3. mixed identifier 
    unary_+
4. literal identifier
    `<clinit>` `yield`

// all control structure is expression that generate value

val filename = 
    if (!args.isEmpty) args(0)
    else "default.txt"
println(if (!args.isEmpty) args(0) else "default.txt")

while () {}
do {} while ()

def f(): Unit = println("hello")
() == f() // true

a = b // return ()

a to b // [a, b]
a until b // [a, b)

// we could also use {}
for (file <- files if file.getName.endsWith(".txt"))
    println(file)

for (
    file <- files 
    if file.isFile
    if file.getName.endsWith(".txt")
) println(file)

for (
    file <- files 
    if file.getName.endsWith(".txt")
    line <- getLines(file)
    if line.trim.matches(pattern)
) println(file + ": " + line.trim)

// mid-stream
for (
    file <- files 
    if file.getName.endsWith(".txt")
    line <- getLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
) println(file + ": " + trimmed)

// generate a collection
// return Array[File], should be same as type of files
def txtFiles = 
    for {
        file <- files 
        if file.getName.endsWith(".txt")
    } yield file

for (i <- 1 to 9) yield {
    val j = i * i
    val k = i * 2
    j + k + 1
}

throw new RuntimeException("oom") // -> Nothing

try {

} catch {
    case ex: FileNotFoundException => 
    case ex: IOException => 
} finally {

}

try return 1 finally return 2 // 2
try 1 finally 2 // 1

val i: Int = 
    s match {
        case "mon" => 1
        case "tue" => 2
        case _ => 0
    }

def search(i: Int): Int = 
    if (i >= args.length) -1
    else if (args(i).startsWith("-")) search(i + 1)
    else if (args(i).endsWith(".txt") i
    else search(i + 1)

// no break, continue

import scala.util.control.Breaks._ 
breakable {
    while (true) {
        if (...) break
    }
}

// scala enables name shadowing, java does not allow

