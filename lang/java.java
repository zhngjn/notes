boolean Boolean 
char Character  // 16
byte Byte       // 8
short Short     // 16
int Integer     // 32
long Long       // 64
float Float     // 32
double Double   // 64
void Void

BigInteger
BigDecimal

{
    int x = 1;
    {
        int x = 2; // illegal, could not shadow!
    }
}

++a a++

// test reference
== !=

// default test reference, should implement
equals()

L, F, D, 0X, 0

Integer.toBinaryString()
Long.toBinaryString()

widening conversion
narrowing conversion (int)longNum

Math.round()

// char[]
string.toCharArray()

break/continue label

// delegate constructor
class A 
{
    public A(int) {}
    public A(String) {}
    public A(String s, int i) 
    {
        this(s);
        ...
    }
};

// finalize()

// value should be initialized before being used

// member field is initialized as 0, null...

// static initialization block 
static
{

}

// instance initialization block 
{

}

void f(Object... args);
args.length
args.getClass()

package a.b;

// import class file
$CLASSPATH

// access control
public > protected > (package) > private

// class should be public or package

super(1)
super().func()

// subclass method f(int) does not hide superclass method f(boolean),
// while c++ does

// protected
// subclass or same package

// final
1. variable/field
    blank final // not initialized in definition time, later
2. parameter
3. method 
    could not override
    // all private methods are final
4. class 
    could not inherit

// in java, static and final methods are early binding
// other methods are late binding

// field is not dynamic, only method is dynamic

// upcast downcast
((Sub)super).f()

abstract class A 
{
    public abstract void f();
}

public interface A
{
    int VALUE = 5; // static & final
    void f(); // public
}

// used as enum
public interface Month
{
    int JAN = 1;
    int FEB = 2;
}

// inner class can visit all members of outer class

public class Outer
{
    public class Inner
    {
        public Outer outer() 
        {
            return Outer.this;
        }
    }
}
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();

// inner class has a reference to outer class object
// nested class(inner static class) has not such reference

public interface IF {}
public interface IG {}

public class A 
{
    private class F implements IF {}
    protected class G implements IG {}

    public IF getF() 
    {
        return new F();
    }
    public IG getG()
    {
        return new G();
    }
}

// local inner class
public class A
{
    public IF getF() 
    {
        class F implements IF{}
        return new F();
    }
}

// class AA will be compiled anyway, but not visible outside the scope
public class A
{
    public void f(boolean b)
    {
        if (b)
        {
            class AA 
            {
                public void g();
            }
            new AA().g();
        }
    }
}

// anonymous inner class
public class A
{
    public IF getF()
    {
        return new IF() 
        {
            {
                // instance initialization as constructor
            }
            // implementation of F
        }
    }
}

// nested class
public class Outer
{
    public static class Nested 
    {

    }
}

// inner class is oop closure, reference to outer class object

public class Outer
{
    public class Inner
    {

    }
}
public class MyInner extends Inner
{
    public MyInner(Outer outer)
    {
        outer.super();
    }
}

// local inner class works as anonymous inner class

// inner class identifier
Outer$Inner

ArrayList objects = new ArrayList(); // Object[]

import java.util.Arrays;
import java.util.Collections;
Arrays.asList(1, 2, 3);
Collections.addAll(collection, 1, 2, 3);

// default toString()
List // [1, 2]
Set // [1, 2]
Map // {a=1, b=2}

// forward iterator
Iterator<A> it;
it.hasNext();
it.next();
it.remove();

// Bidirectional iterator
ListIterator<A> it;
ListIterator<A> it(2); // second element
it.hasNext();
it.next();
it.remove();
it.hasPrevious();
it.previous();
it.set(a);
it.nextIndex();
it.previousIndex();

Iterable<T>
{
    public Iterator<T> iterator()
}

// List, Set, Map, Queue

// Throwable
throw new MyException();
throw new MyException("error");

public class MyException extends Exception 
{
    public MyException() {}
    public MyException(String msg) { super(msg); }
}

try {

} catch (MyException1 e) {

} catch (MyException2 e) {

} finally {

}

String getMessage();
String getLocalizedMessage();
String toString();
void printStackTrace();
void printStackTrace(PrintStream);
void printStackTrace(java.io.PrintWriter);
Throwable fillInStackTrace();

catch (Exception e) {
    throw e;

    throw (Exception)e.fillInStackTrace();
}

MyException e = new MyException();
e.initCause(new MyException2());

Throwable -> Error // compile-time error and system error
          -> Exception

public void f() throws MyException {} // checked exception
RuntimeException // unchecked exception

// StringBuilder
append(String);
toString();

System.out.format("", ...);
System.out.printf("", ...);

import java.util.Formatter;
format("", ...);

String.format("", ...);

import java.util.regex.*;
Pattern p = Pattern.compile("");
Matcher m = p.matcher("");
while (m.find()) {
    m.group(), m.begin(), m.end();
    m.groupCount(), m.group(i);
}

BufferedReader input = new BufferedReader(new StringReader(""));
String line = input.readLine();
Integer.parseInt("");
Double.parseDouble("");

Scanner input = new Scanner(new BufferedReader(new StringReader("")));
input.useDelimiter("");
input.delimiter(); // Pattern
input.hasNextLine();
input.nextLine();
input.hasNextInt();
input.nextInt();
input.nextDouble();

