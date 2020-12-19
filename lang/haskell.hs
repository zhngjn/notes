-- comment
{- 
-}

-- expression yields value

-- main function

-- scope is lexical

-- Prelude is imported defaultly

-- ordinary function
print "hello"
-- infix function
2 + 3
(+) 2 3

-- priority ordinary > infix

-- infix function
priority 0-9
infix infixl infixr

-- infix function starts with :

-- ghci
:h :help
:q :quit
:l :load
:t :type
:i :info

-- Prelude
id :: a -> a
const :: a -> b -> a

&& :: Bool -> Bool -> Bool
|| :: Bool -> Bool -> Bool
not :: Bool -> Bool
otherwise :: Bool

fst :: (a, b) -> a
snd :: (a, b) -> b

(++) :: [a] -> [a] -> [a]
!! :: [a] -> Int -> a

head :: [a] -> a
tail :: [a] -> [a]
init :: [a] -> [a]
last :: [a] -> a

null :: [a] -> Bool

length :: [a] -> Int
take :: Int -> [a] -> [a]
drop :: Int -> [a] -> [a]

reverse :: [a] -> [a]

and, or :: [Bool] -> Bool

elem, notElem :: Eq a => a -> [a] -> Bool
(==), (/=) :: Eq a => a -> a -> Bool
(<), (<=), (>), (>=) :: Ord a => a -> a -> Bool

min, max :: Ord a => a -> a -> a

minimum, maximum :: Ord a => [a] -> a

-- type and constructor
data Position = MakePosition Double Double
data Position = Position Double Double

case x of
    pattern1 -> expression1
    pattern2 -> expression2

distance :: Position -> Position -> Double
distance (Position x1 y1) (Position x2 y2) = 
    ...
distance p1 p2 = 
    let Position x1 y1 = p1
        Position x2 y2 = p2
    in ...
distance p1@(Position x1 y1) p2@(Position x2 y2) = 
    ...

-- overloading
data Position = Cartesian Double Double | Polar Double Double

if x then ...
else ...

data Maybe a = Just a | Nothing

-- record syntax
data Position = Position {
    getX :: Double,
    getY :: Double
}
p = Position 3 4
p = Position { getX = 3, getY = 4 }
getX p

-- list
[1, 2, 3]
1 : 2 : 3 : Nil
1 : 2 : 3 : []

[1..3]
[1..]
[1, 3..7]

-- tuple
(1, 2, 3)
() -- Unit

String == [Char]

:k :kind (->) -- type function

-- section: use infix function as ordinary function

