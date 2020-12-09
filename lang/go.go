
os.Args

// capitalized variable is exported and public

// declaration
var const type func

package main

// variable is defaultly initialized as 0, nil, false...

var s string
var s = ""
var s string = ""
s := ""

var a, b int 

// it is safe to return local variable

p := new(int)

// compiler will decide to allocate on stack or heap, not based on var or new

a++

x, y = y, x

// Celsius and float64 are different type, need explicit conversion
type Celsius float64
// conversion is allowed when they have same underlying type
Celsius(1.0)

// import path
import (
	"fmt"
	"os"
	a/b/x
	a/b/c/x
)

// package initialization
// 1. package variable
var a = b + c
var b = f()
var c = 1
c -> b -> a

// 2. init in declaration order
func init() {}
func init() {}

// scope: compiling
// lifetime: runtime

// name shadowing

// data type
1. basic type
	number string boolean
2. aggregate type
	array struct
3. reference type
	pointer slice map function channel
4. interface type

int8, int16, int32, int64
uint8, uint16, uint32, uint64
int, uint // platform-dependent

rune // int32, unicode
byte // uint8, raw data
uintptr // pointer

&^ // and not, clear the bits

// 0, 0x, 0X

'a' // rune literal

float32, float64
math.MaxFloat32, math.MaxFloat64

complex64, complex128 // float32, float64

true, false 
// could not implicit conversion between boolean and number

string // immutable, utf-8

// escape
\xhh, \ooo, \uhhhh, \Uhhhhhhhh

// raw string
``

import "unicode/utf8"
len(s) // byte count
utf8.RuneCountInString(s) // char count

// char count
n := 0
for _, _ = range s {
	n++
}

// char count
n := 0
for range s {
	n++
}

// iterate rune
for i := 0; i < len(s); {
	r, size := utf8.DecodeRuneInString(s[i:])
	...
	i += size
}

// iterate rune
for i, r := range s {
	fmt.Printf("%d %q %d", i, r, r) // %q rune in '', e.g. 'A'
}

// when decode error, return '\uFFFD'

s // % x -> e3 83 97
r := []rune(s) // %x -> [30d7 30ed 30b0]
s := string(r) // Println -> "abc"

import (
	"bytes"
	"strings"
	"strconv"
	"unicode"
)

strings.LastIndex(s, "/")

s := "abc"
b := []byte(s)
s := string(b)

// strings
func Contains(s, substr string) bool
func Count(s, sep string) int
func Fields(s string) []string
func HasPrefix(s, prefix string) bool
func Index(s, sep string) int
func Join(a []string, sep string) string 

// bytes
func Contains(s, subslice []byte) bool
func Count(s, sep []byte) int
func Fields(s byte[]) [][]byte
func HasPrefix(s, prefix []byte) bool
func Index(s, sep []byte) int
func Join(s [][]byte, sep []byte) []byte 

// bytes.Buffer
var buf bytes.Buffer 
buf.WriteByte('[')
buf.WriteRune('[')
buf.WriteString("abc")
buf.String()

s := fmt.Sprintf("%d", x)
s := strconv.Itoa(x)

s := strconv.FormatInt(int64(x), 2)
s := strconv.FormatUint(uint64(x), 2)

x, err := strconv.Atoi("123")
x, err := strconv.ParseInt("123", 10, 64) // base 10, to int64
x, err := strconv.ParseUint("123", 10, 64) // base 10, to uint64

// const, expression, compiling value, bool/string/number
const pi = 3.14
const (
	pi = 3.14
	e = 2.72
)

const IPv4Len = 4
var p [IPv4Len]byte 

const (
	a = 0
	b // 0
	c = 1
	d // 1
)

// iota, from 0 on
type Weekday int
const (
	Monday Weekday = iota
	Tuesday // 1
)

const (
	V1 uint = 1 << iota
)

const (
	_ = 1 << (10 * iota)
	KB
	MB
	GB
)

// un-typed const, bool, int, rune, float, complex, string
// have higher precision, > 256
var f float64 = 2 // un-typed float -> float64
var f float64 = (float64)2

d = int32(x) // if overflow, compile error

// when (short) declaration, if type is not designed, un-typed will be implicitly converted to default type
i := 0 // un-typed int -> int
i := '\000' // un-typed rune -> rune
i := 0.0 // un-typed float -> float64
i := 0i // un-typed complex -> complex128
// otherwise
var i := int8(0)
var i int8 = 0

// array, fixed size
var a [3]int

for i, v := range a {

}

// defaultly initialized as 0
var a [3]int = [3]int{1, 2, 3}
var a [3]int = [3]int{1, 2}

a := [...]int{1, 2, 3} // [3]int

type Currency int
const (
	USD Currency = iota
	EUR
	RMB
)
symbol := [...]string{USD: "$", EUR: "e", RMB: "Y"}

r := [...]int{3: 1} // [0, 0, 0, 1]

%t // bool
%T // type

// if element type is comparable, then array is comparable
[2]int{1, 2} == [...]int{1, 2}
[2]int{1, 2} == [3]int{1, 2, 3} // compile error

// array is passed-by-value, so use pointer
func f(ptr *[32]byte) {

}

// slice, []T, refer to underlying array
// {ptr, length, capacity}
slice := []int{1, 2, 3}
slice := s[i:j]
len(slice), cap(slice)

// if slice exceeds cap(s) -> panic
// if slice exceeds len(s) -> slice 

// modify slice will modify the underlying array

// slice could not == !=, only with nil
if slice != nil {

}

// nil slice has no underlying array
var s []int // len(s) == 0, s == nil
var s []int = nil // len(s) == 0, s == nil
var s = []int(nil) // len(s) == 0, s == nil
var s = []int{} // len(s) == 0, s != nil
var s = make([]int, 3)[3:] // len(s) == 0, s != nil

// make slice
// create an anonymous array and return a slice, the array could be visited only by the slice
make([]T, len) // len == cap
make([]T, len, cap) // same as make([]T, cap)[:len]

slice = append(slice, x)

copy(dest_slice, src_slice) // returns min(len1, len2)

x = append(x, x...) // append all elements in x
func f(x int, y ...int) {
	len(y)
	copy(z, y)
}

