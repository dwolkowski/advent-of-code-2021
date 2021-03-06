# Task Content
 - All tasks can be found on **[Advent of Code 2021](https://adventofcode.com/2021)** 
 
## Part One

**Content**

> You barely reach the safety of the cave when the whale smashes into the  
> cave mouth, collapsing it. Sensors indicate another exit to this cave at a  
> much greater depth, so you have no choice but to press on.

> As your submarine slowly makes its way through the cave system, you notice  
> that the four-digit seven-segment displays in your submarine are  
> malfunctioning; they must have been damaged during the escape. You'll be in  
> a lot of trouble without them, so you'd better figure out what's wrong. 

> Each digit of a seven-segment display is rendered by turning on or off any  
> of seven segments named `a` through `g`.

> The problem is that the signals which control the segments have been mixed  
> up on each display. The submarine is still trying to display numbers by  
> producing output on signal wires `a` through `g`, but those wires are connected  
> to segments **randomly**. Worse, the wire/segment connections are mixed up  
> separately for each four-digit display! (All of the digits **within** a display  
> use the same connections, though.)

> So, you might know that only signal wires `b` and `g` are turned on, but that  
> doesn't mean **segments** `b` and `g` are turned on: the only digit that uses two  
> segments is `1`, so it must mean segments `c` and `f` are meant to be on. With   
> just that information, you still can't tell which wire (`b`/`g`) goes to which  
> segment (`c`/`f`). For that, you'll need to collect more information.

> For each display, you watch the changing signals for a while, make a note  
> of **all ten unique signal patterns** you see, and then write down a single  
> **four digit output value** (your puzzle input). Using the signal patterns, you  
> should be able to work out which pattern corresponds to which digit.

> Each entry consists of ten **unique signal patterns**, a `|` delimiter, and  
> finally the **four digit output value**. Within an entry, the same wire/segment  
> connections are used (but you don't know what the connections actually  
> are). The unique signal patterns correspond to the ten different ways the  
> submarine tries to render a digit using the current wire/segment connections. 

> Using this information, you should be able to work out which combination of  
> signal wires corresponds to each of the ten digits. 

> Because the digits `1`, `4`, `7`, and `8` each use a unique number of segments, you  
> should be able to tell which combinations of signals correspond to those digits.

> In the output values, **how many times do digits `1`, `4`, `7`, or `8` appear?**

<details>
  <summary><strong> Example </strong></summary>
<pre>
  0:      1:      2:      3:      4:      5:      6:      7:      8:      9:
 aaaa    ....    aaaa    aaaa    ....    aaaa    aaaa    aaaa    aaaa    aaaa
b    c  .    c  .    c  .    c  b    c  b    .  b    .  .    c  b    c  b    c
b    c  .    c  .    c  .    c  b    c  b    .  b    .  .    c  b    c  b    c
 ....    ....    dddd    dddd    dddd    dddd    dddd    ....    dddd    dddd
e    f  .    f  e    .  .    f  .    f  .    f  e    f  .    f  e    f  .    f
e    f  .    f  e    .  .    f  .    f  .    f  e    f  .    f  e    f  .    f
 gggg    ....    gggg    gggg    ....    gggg    gggg    ....    gggg    gggg
</pre>
  
So, to render a `1`, only segments `c` and `f` would be turned on; the rest   
would be off. To render a `7`, only segments `a`, `c`, and `f` would be turned on.  
  
Here is what you might see in a single entry in your input:  
  
<pre>
  acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf
</pre>

Because `7` is the only digit that uses three segments, dab in the above example means that to render a `7`,   
signal lines d, a, and b are on. Because `4` is the only digit that uses four segments,  
eafb means that to render a `4`, signal lines `e`, `a`, `f`, and `b` are on. 

</details>

<details>
  <summary><strong> Answer </strong></summary>
  <div align="right">
    
   My puzzle answer was: **`452`**
    
  </div>
</details> 

___

## Part Two

**Content**
> Through a little deduction, you should now be able to determine the remaining digits.

> For each entry, determine all of the wire/segment connections and decode the  
> four-digit output values. **What do you get if you add up all of the output values?**

<details>
  <summary><strong> Example </strong></summary>
  
Consider again the first example:
<pre>
acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf
</pre>

After some careful analysis, the mapping between signal wires and segments only make sense in the following configuration:
  
<pre> 
 dddd
e    a
e    a
 ffff
g    b
g    b
 cccc
 </pre>

So, the unique signal patterns would correspond to the following digits:

- `acedgfb`: `8`
- `cdfbe`: `5`
- `gcdfa`: `2`
- `fbcad`: `3`
- `da`b: `7`
- `cefabd`: `9`
- `cdfgeb`: `6`
- `eafb`: `4`
- `cagedb`: `0`
- `ab`: `1`
  
Then, the four digits of the output value can be decoded:

- `cdfeb`: `5`
- `fcadb`: `3`
- `cdfeb`: `5`
- `cdbaf`: `3`
  
Therefore, the output value for this entry is `5353`.

Following this same process for each entry in the second, larger example above, the output value of each entry can be determined:

- `fdgacbe cefdb cefbgd gcbe`: `8394`
- `fcgedb cgb dgebacf gc`: `9781`
- `cg cg fdcagb cbg`: `1197`
- `efabcd cedba gadfec cb`: `9361`
- `gecf egdcabf bgf bfgea`: `4873`
- `gebdcfa ecba ca fadegcb`: `8418`
- `cefg dcbef fcge gbcadfe`: `4548`
- `ed bcgafe cdgba cbgef`: `1625`
- `gbdfcae bgc cg cgb`: `8717`
- `fgae cfgab fg bagce`: `4315`
  
Adding all of the output values in this larger example produces `61229`.

</details>

<details>
  <summary><strong> Answer </strong></summary>
  <div align="right">
    
   My puzzle answer was: **`1096964`**
    
  </div>
</details> 

___

<br />
