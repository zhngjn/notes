
// ownship move borrow

u8 u16 u32 u64
i8 i16 i32 i64

u8 // raw byte

// machine word 32/64
// size_t/ptrdiff_t
usize isize 

let i = std::i32::MAX;
i.wrapping_add(1);

// number without postfix will be deduced type
// default type is i32

42u8, 1720isize
0x 0o 0b

2_111_564
0xffff_ffff 
0o123_345
127_u8

// byte literal
b'A'
b'\xhh'

2u16.pow(4)
.abs()
.count_ones()

f32 f64

std::f32::INFINITY, NEG_INFINITY 
NAN
MIN, MAX

std::f32::consts::E, PI 

(2.0_f64).sqrt()
f64::sqrt(2.0)

// explicit conversion
f as f64 
// implicit conversion
not enabled

// bool
true false

if x {} // wrong
if x != 0 {}

true as i32
i32 as bool // wrong

// 32-bit unicode
char
// character literal
'a' '我'

// String is utf-8 stream

'\xHH'
'\u{HHHHHH}'

// no implicit conversion between char and other

// u8 is the only integral type that can be converted to char

std::char::from_u32 -> Option<char>

'A'.is_alphabetic()
'A'.to_digit(10)
'A'.len_utf8()
std::char::from_digit(2, 10)

// tuple
let x = ("jun", 2) // (&str, i32)
x.0 x.1

fn split_at(&self, mid: usize) -> (&str, &str)

// unit type
()

// pointer
1. reference
2. Box 
3. unsafe pointer

// reference
&T 
&mut T 

// array: fixed size
[T; N]
// vector: dynamic
Vec<T>
// slice
&[T]
&mut [T]

v.len()
v[i] // i should be usize

let arr: [i32; 3] = [1, 2, 3];
let arr = ["hello", "jun"];
let mut sieve = [true; 1000];

// buffer
[0u8; 1000]

let mut v = vec![1, 2, 3];
v.iter().fold(1, |a, b| a * b);

let mut v = vec![0; 1000];

let mut v = Vec::new();
v.push(1);
v.push(2);

let v: Vec<i32> = (0..5).collect() // [0, 1, 2, 3, 4]

// Vec's attr: ptr, capacity, size

let mut v = Vec::with_capacity(4);
v.push(1);
v.push(2);
v.len();
v.capacity();

v.insert(3, 10);
v.remove(1);
v.pop() // Option<T>

// slice: fat pointer (pointer and element size)
let a: [i32; 4] = [1, 2, 3, 4];
let v: Vec<i32> = vec![1, 2, 3, 4];

let sa: &[i32] = &a;
let sv: &[i32] = &v;

sa.sort()
sa.reverse()

// reference of slice of slice
&v[0..2]
&v[2..]

// string 
""

// raw string 
r" "
r###" "###

// byte string 
let s = b"get"; // &[u8; 3]

let hello = "hello".to_string() // String 
let ello = &hello[1..] // &str
let me = "me" // &str

"hello".len() // byte number
"hello".chars().count() // char number

// &str -> &[T]
// String -> Vec<T>

v.concat()
v.join(",")

let s = vec![1, 2, 3];
let t = s; // move

let s = vec![1, 2, 3];
let t = s.clone(); // deep copy

v.pop().unwrap();
v.swap_remove(1);
std::mem::replace(&mut v[2], "abc".to_string());

// Option<T>
std::mem::replace(&mut composers[0].name, None);
composers[0].name.take();

// Copy (POD type, bit-bit copy)

// struct is not Copy, if all fields are Copy type, then could make it Copy
#[derive(Copy, Clone)]
struct A { i: i32 }

// (atomic) reference count
// shared, not mutable
use std::rc::Rc; // Arc

let s: Rc<String> = Rc::new("jun".to_string());
let t: Rc<String> = s.clone(); // does not copy, increase refcount


