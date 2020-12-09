let x = 1;
let x, y = 1, 2;

// undefined
let x;

const PI = 3.14;

// identifier
num, alpha, _, $, unicode

// fundamental and object

// fundamental
number
string
boolean
null
undefined
symbol

// builtin type
Array
Date
RegExp
Map WeakMap
Set WeakSet

// boxing type
Number
String
Boolean

// number - all number is double
0x, 0o, ob, Infinity, -Infinity, NaN

// string -> unicode
"abc", 'abc', `abc`

'   ${var} \u00bc   '

true/false

const RED = Symbol()
const GREEN = Symbol("description")

// object
let obj = {}

let obj = {name: 'jun', age: 20}

obj.attr
obj["what attribute"]
obj[SYMBOL]

delete obj.attr

// special attribute
Number.Infinity
s.toUpperCase()

const num = Number("2.3")
const a = parseInt("3a", 16)
const b = parseFloat("3.5a")

toString()

while () {

}

do {

} while ();

if () {

} else if () {

} else {

}

for (let i = 0; i < 10; i++) {

}

Math.random()

break/continue

// key
for (let property in object)

// iterable
for (let object in objects)

// strict equal
// 1. same reference
// 2. same type and value for fundamental
===
!==

// non-strict equal
// 1. same reference
// 2. can convert to each other for fundamental (3 == "3")
== 
!=

isNaN(x)

// false
undefined, null, false, 0, NaN, ''

// true
all objects, all arrays, " "

true ? a : b 

// , operator
x++, y++

<< >> >>>

typeof undefined === "undefined"
typeof null === "object" ???
typeof {} === "object"
typeof true === "boolean"
typeof 1 === "number"
typeof "abc" === "string"
typeof Symbol() === "symbol"
typeof function(){} === "function"

// unpack
const obj = {a: 1, b: 2, c: 3};
const {a, b, c} = obj;

let a, b, c;
({a, b, c} = obj);

const arr = [1, 2, 3, 4, 5];
let [x, y] = arr;
let [x, y, ...rest] = arr;

[a, b] = [b, a];

value = val || default;

function doSomething() {

}

const f = doSomething;

// function no override by parameter

function doSomething({name, age}) {

}
const obj = {name: "jun", age: 20};
doSomething(obj);

function doSomething([name, age]) {

}
const arr = ["jun", 20];
doSomething(arr);

function doSomething(arg0, ...args) {

}

// default parameter (undefined)
function doSomething(a, b="jun", c=20) {

}

const o = {
    name: function() { return "jun"; }
}

const o = {
    n: "jun",
    name() { return this.n; }
}

const f = function() {

}

const g = function f(a) {
    f(a+1);
}

const f = () => "hello";
const f = name => 'hello ${name}';
const f = (a, b) => a + b;

const jun = { name: "jun", age: 20 };
function greet() {
    return 'I am ${this.name}';
}
greet.call(jun);

function update(name, age) {
    this.name = name;
    this.age = age;
}
update.call(jun, "jung", 25);
update.apply(jun, ["jung", 25]);
const newInfo = ["jung", 25];
update.call(jun, ...newInfo);

const arr = [1, 6, 3, 9, 4];
Math.min.apply(null, arr);
Math.min(...arr);

const updateJun = update.bind(jun);
updateJun("jung", 25);

const updateJunJung = update.bind(jun, "jung");
updateJunJung(25);

// name shadowing

// IIFE 
(function() {

})();

const f = (function() {
    let count = 0;
    return function() {
        return count++;
    }
})();
f();

// var -> promotion
// let -> no promotion
// function -> promotion

'use strict';

arr.length
arr = [1, 2, 3]
arr = new Array()
arr = new Array(2) // [undefined, undefined]
arr = new Array(1, 2, 3)

arr.push(a)
arr.pop()
arr.unshift(a)
arr.shift()

arr.concat(1, 2, 3) -> new array, arr unchanged
arr.concat([1, 2, 3])

arr.slice(start) -> slice, arr unchanged
arr.slice(start, end)

arr.splice(start, size, ...elems) -> slice, arr changed

arr.copyWithin(to, from_start)
arr.copyWithin(to, from_start, from_end)

const arr = new Array(5).fill(1)
arr.fill(a)
arr.fill(a, start)
arr.fill(a, start, end)

arr.reverse()
arr.sort()
arr.sort((a, b) => a.name < b.name)

arr.indexOf(a)
arr.lastIndexOf(a)

arr.findIndex(o => o.id === 5)
arr.find(o => o.id === 5)

arr.some(o => o.id === 1)
arr.every(o => o.id === 1)

const names = arr.map(obj => obj.name)

arr.filter(obj => obj.age === 20)

arr.reduce((a, x) => a += x, 0)
// no initial value, use first element as initial value
arr.reduce((a, x) => a += x)

delete arr[1]

for (let prop in obj) {
    if (!obj.hasOwnProperty(prop)) continue; // only attr in instance
    ...
}
// only attr in prototype
Object.keys(obj).forEach(prop => console.log('${prop}:${obj[prop]}'))

class Car {
    constructor(engine, wheels) {
        this.engine = engine;
        this.wheels = wheels;
        this._gears = ['P', 'N', 'R', 'D'];
    }

    get gear() {}
    set gear(value) {}
}

// to implement real private members
const Car = (function() {
    const carGear = new WeakMap();
    
    class Car {
        constructor(engine, wheels) {
            this.engine = engine;
            this.wheels = wheels;
            this._gears = ['P', 'N', 'R', 'D'];
            carGear.set(this, { gear: this._gears[0] });
        }

        get gear() { return carGear.get(this).gear; }
        set gear(value) { carGear.get(this).gear = value; }
    }

    return Car;
})();

// class is function
typeof Car is "function"

// ES5
function Car(engine, wheels) {
    this.engine = engine;
    this.wheels = wheels;
}

Car.prototype.gear
Car#gear

// instance created by new will store its prototype in __proto__

// search attr
// instance attr -> prototype attr

class Car {
    static getNextId() {
        return Car.nextId++;
    }
}
Car.nextId = 0;

class Car extends Vehicle {
    constructor() {
        super();
        ...
    }
}
const c = new Car();
c instanceof Car // true
c instanceof Vehicle // true

// ultimate base
Object
toString()

// mixin
function makeMovable(o) {
    o.forward = function(dist) { }
    o.backward = function(dist) { }
}
const c = new Car();
makeMovable(c);
c.forward(10);
c.backward(10);

makeMovable(Car.prototype);
const c = new Car();
c.forward(10);
c.backward(10);

const MOVE_FORWARD = Symbol();
const MOVE_BACKWARD = Symbol();
const MOVE_DIST = Symbol();
function makeMovable(o) {
    o[MOVE_FORWARD] = function(dist) { this[MOVE_DIST] += dist; } 
    o[MOVE_BACKWARD] = function(dist) { this[MOVE_DIST] -= dist; }
}

// Map
const weekdays = new Map();
weekdays.set(mon, 1);
weekdays.set(mon, 1).set(tue, 2);

const weekdays = new Map([
    [mon, 1],
    [tue, 2],
    [wed, 3],
]);

weekdays.get(mon); // undefined if not exist
weekdays.has(mon);

weekdays.size;

for (let k of weekdays.keys())
for (let v of weekdays.values())
for (let e of weekdays.entries()) // e[0] e[1]
for (let [k, v] of weekdays.entries())
for (let [k, v] of weekdays)

[...weekdays.values()]

weekdays.delete(fri)
weekdays.clear()

// WeakMap
// key must be object, could be destructed by gc, could not iterate or clear

// Set
const weekdays = new Set();
weekdays.add("mon");

weekdays.size;
weekdays.delete("mon");

// WeakSet

// error
throw new Error("error")

try {

} catch (err) {

} finally {
    console.log(err.stack);
}

// iterator
const it = arr.values()
let cur = it.next()
while (!cur.done) {
    console.log(cur.value);
    cur = it.next();
}

class X {
    [Symbol.iterator]() {
        const arr = this.arr;
        let i = 0;
        return {
            next() {
                if (i < arr.length) {
                    return { value: arr[i], done: false };
                } else {
                    return { value: undefined, done: true };
                }
            }
        }
    }
}

// generator
function* weekdays() {
    yield "mon";
    yield "tue";
    yield "wed";
    yield "thu";
    yield "fri";
    yield "sat";
    yield "sun";
}
const wd = weekdays();
wd.next(); // mon, false

for (let wd of weekdays()) {

}

function* validate() {
    const user = yield "user:";
    const passwd = yield "passwd:";
    return "Login finished!";
}
const it = validate();
it.next();
it.next('jun');
it.next('1234');

// yield will not end the generator
// return will end the generator, and done is true
