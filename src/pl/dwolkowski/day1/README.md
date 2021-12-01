# Task Content
 - All tasks can be found on **[Advent of Code 2021](https://adventofcode.com/2021)** 
 
## Part One

**Content**
> As the submarine drops below the surface of the ocean, it automatically  
> performs a sonar sweep of the nearby sea floor. On a small screen, the sonar  
> sweep report (your puzzle input) appears: each line is a measurement of the sea  
> floor depth as the sweep looks further and further away from the submarine.  

> The first order of business is to figure out how quickly the depth  
> increases, just so you know what you're dealing with - you never know if  
> the keys will get carried into deeper water by an ocean current or a fish or something.  

> To do this, **count the number of times a depth measurement increases** from the previousmeasurement.  
> In the example below, the changes are as follows:

<details>
  <summary><strong> Example </strong></summary>
  <pre>
199 (N/A - no previous measurement)
200 (increased)
208 (increased)
210 (increased)
200 (decreased)
207 (increased)
240 (increased)
269 (increased)
260 (decreased)
263 (increased)</pre>
</details>

<details>
  <summary><strong> Answer </strong></summary>
  <div align="right">
    
   My puzzle answer was: **`1791`**
    
  </div>
</details> 

___

## Part Two

**Content**
> Considering every single measurement isn't as useful as you expected:   
> there's just too much noise in the data.  
> Instead, consider **sums of a three-measurement sliding window**.

> Start by comparing the first and second three-measurement windows. The  
> measurements in the first window are marked `A (199, 200, 208);` their sum is  
> `199 + 200 + 208 = 607`. The second window is marked `B (200, 208, 210);` its  
> sum is 618. The sum of measurements in the second window is larger than the  
> sum of the first, so this first comparison **increased**.  

> Your goal now is to count **the number of times the sum of measurements in  
> this sliding window increases** from the previous sum. So, compare A with B,  
> then compare B with C, then C with D, and so on. Stop when there aren't  
> enough measurements left to create a new three-measurement sum.  

<details>
  <summary><strong> Example </strong></summary>
  <pre>
199  A      
200  A B    
208  A B C  
210    B C D
200  E   C D
207  E F   D
240  E F G  
269    F G H
260      G H
263        H</pre>
</details>

<details>
  <summary><strong> Answer </strong></summary>
  <div align="right">
    
   My puzzle answer was: **`1822`**
    
  </div>
</details> 

___

<br />
