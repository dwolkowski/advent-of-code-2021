# Task Content
 - All tasks can be found on **[Advent of Code 2021](https://adventofcode.com/2021)** 
 
## Part One

**Content**

> You reach another volcanically active part of the cave. It would be nice if  
> you could do some kind of thermal imaging so you could tell ahead of time  
> which caves are too hot to safely enter.

> Fortunately, the submarine seems to be equipped with a thermal camera! When  
> you activate it, you are greeted with:

> Congratulations on your purchase! To activate this infrared thermal imaging 
> camera system, please enter the code found on page 1 of the manual.

> Apparently, the Elves have never used this feature. To your surprise, you  
> manage to find the manual; as you go to open it, page 1 falls out. It's a  
> large sheet of **transparent paper**! The transparent paper is marked with  
> random dots and includes instructions on how to fold it up (your puzzle input).

> The first section is a list of dots on the transparent paper. `0,0`  
> represents the top-left coordinate. The first value, `x`, increases  
> to **the right**. The second value, `y`, increases **downward**.

> Then, there is a list of fold instructions. Each instruction indicates a  
> line on the transparent paper and wants you to fold the paper up (for  
> horizontal `y=...` lines) or left (for vertical `x=...` lines).

> **How many dots are visible after completing just the first fold instruction  
> on your transparent paper?**


<details>
  <summary><strong> Example </strong></summary>
  
<pre>
6,10
0,14
9,10
0,3
10,4
4,11
6,0
6,12
4,1
0,13
10,12
3,4
3,0
8,4
1,10
2,14
8,10
9,0

fold along y=7
fold along x=5
</pre>
<pre>
...#..#..#.
....#......
...........
#..........
...#....#.#
...........
...........
...........
...........
...........
.#....#.##.
....#......
......#...#
#..........
#.#........
</pre>

In this example, the first fold instruction is fold along `y=7`, which designates the  
line formed by all of the positions where `y` is `7` (marked here with -):
 
<pre> 
...#..#..#.
....#......
...........
#..........
...#....#.#
...........
...........
-----------
...........
...........
.#....#.##.
....#......
......#...#
#..........
#.#........
</pre>

Because this is a horizontal line, fold the bottom half up. Some of the dots might end up  
overlapping after the fold is complete, but dots will never appear exactly on a fold line.   
The result of doing this fold looks like this:

<pre>
#.##..#..#.
#...#......
......#...#
#...#......
.#.#..#.###
...........
...........
</pre>

Now, only `17` dots are visible.

The second fold instruction is fold along `x=5`, which indicates this line:
  
<pre>
#.##.|#..#.
#...#|.....
.....|#...#
#...#|.....
.#.#.|#.###
.....|.....
.....|.....
</pre>  

Because this is a vertical line, fold left:

<pre>
#####
#...#
#...#
#...#
#####
.....
.....
</pre>  

The transparent paper is pretty big, so for now, focus on just completing the first fold.  
After the first fold in the example above, `17` dots are visible - dots that end up   
overlapping after the fold is completed count as a single dot.  
  
</details>

<details>
  <summary><strong> Answer </strong></summary>
  <div align="right">
    
   My puzzle answer was: **`682`**
    
  </div>
</details> 

___

## Part Two

**Content**
> Finish folding the transparent paper according to the instructions. The  
> manual says **the code is always eight capital letters**.

> **What code do you use to activate the infrared thermal imaging camera system?**

<details>
  <summary><strong> Example </strong></summary>
<br />
  
Same steps as in the example above.
 
After all the folds, you need to write down all the points in the console, they will form the answer.
  
</details>

<details>
  <summary><strong> Answer </strong></summary>
  <div align="right">
    
   My puzzle answer was: **`FAGURZHE`**
    
  </div>
</details> 

___

<br />
