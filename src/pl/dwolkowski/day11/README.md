# Task Content
 - All tasks can be found on **[Advent of Code 2021](https://adventofcode.com/2021)** 
 
## Part One

**Content**

> You enter a large cavern full of rare bioluminescent dumbo octopuses! They  
> seem to not like the Christmas lights on your submarine, so you turn them  
> off for now.

> There are `100` octopuses arranged neatly in a `10` by `10` grid. Each octopus  
> slowly gains **energy** over time and **flashes** brightly for a moment when its  
> energy is full. Although your lights are off, maybe you could navigate  
> through the cave without disturbing the octopuses if you could predict when  
> the flashes of light will happen.

> Each octopus has an **energy level** - your submarine can remotely measure the  
> energy level of each octopus (your puzzle input).

> Given the starting energy levels of the dumbo octopuses in your cavern,  
> simulate `100` steps. **How many total flashes are there after `100` steps?**

<details>
  <summary><strong> Example </strong></summary>
  
<pre>
Before any steps:
11111
19991
19191
19991
11111

After step 1:
34543
40004
50005
40004
34543

After step 2:
45654
51115
61116
51115
45654
</pre>

You can model the energy levels and flashes of light in steps. During  
 a single step, the following occurs:
- First, the energy level of each octopus increases by `1`.
- Then, any octopus with an energy level greater than `9` flashes. This  
  increases the energy level of all adjacent octopuses by `1`, including  
  octopuses that are diagonally adjacent. If this causes an octopus to  
  have an energy level greater than `9`, it also flashes. This process  
  continues as long as new octopuses keep having their energy level  
  increased beyond `9`. **(An octopus can only flash at most once per step.)**  
- Finally, any octopus that flashed during this step has its energy  
level set to `0`, as it used all of its energy to flash.

</details>

<details>
  <summary><strong> Answer </strong></summary>
  <div align="right">
    
   My puzzle answer was: **`1719`**
    
  </div>
</details> 

___

## Part Two

**Content**
> It seems like the individual flashes aren't bright enough to navigate.  
> However, you might have a better option: the flashes seem to be **synchronizing!**

> If you can calculate the exact moments when the octopuses will all flash  
> simultaneously, you should be able to navigate through the cavern. **What is  
> the first step during which all octopuses flash?**

<details>
  <summary><strong> Example </strong></summary>
 
<pre>
After step 193:
5877777777
8877777777
7777777777
7777777777
7777777777
7777777777
7777777777
7777777777
7777777777
7777777777

After step 194:
6988888888
9988888888
8888888888
8888888888
8888888888
8888888888
8888888888
8888888888
8888888888
8888888888

After step 195:
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
</pre>

 In the example above, the first time all octopuses flash simultaneously is step `195`:

</details>

<details>
  <summary><strong> Answer </strong></summary>
  <div align="right">
    
   My puzzle answer was: **`232`**
    
  </div>
</details> 

___

<br />
