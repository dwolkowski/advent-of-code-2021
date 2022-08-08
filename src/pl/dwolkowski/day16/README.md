# Task Content
 - All tasks can be found on **[Advent of Code 2021](https://adventofcode.com/2021)** 
 
## Part One

**Content**

> As you leave the cave and reach open waters, you receive a transmission  
> from the Elves back on the ship. The transmission was sent using the Buoyancy  
> Interchange Transmission System (BITS), a method of packing numeric  
> expressions into a binary sequence. Your submarine's computer has saved  
> the transmission in hexadecimal (your puzzle input).

> **What do you get if you add up the version numbers in all packets?**

<details>
  <summary><strong> Example </strong></summary>
  
<br />  

The first step of **decoding the message** is to convert the hexadecimal representation into binary. Each character of **hexadecimal**  
corresponds to **four bits of binary** data:
  
<pre>
0 = 0000
1 = 0001
2 = 0010
3 = 0011
4 = 0100
5 = 0101
6 = 0110
7 = 0111
8 = 1000
9 = 1001
A = 1010
B = 1011
C = 1100
D = 1101
E = 1110
F = 1111
</pre>

The BITS transmission contains a single packet at its outermost layer which itself contains many other packets. 
The hexadecimal representation of this  packet might encode a few extra `0` bits at the end; these are not part of the transmission and should be ignored.

Every packet begins with a standard header: the first three bits encode the **packet version**, and the next three bits encode the packet **type ID**.  
These two values are numbers; all numbers encoded in any packet are represented as binary with the most significant bit first. 
For example, a version encoded as the binary sequence `100` represents the number `4`.

<br />  

Packets with type **ID `4`** represent a literal value. Literal value packets encode a single binary number. To do this, the binary number is padded  
with leading zeroes until its length is a multiple of four bits, and then it is broken into groups of four bits. Each group is prefixed by a `1` bit  
except the last group, which is prefixed by a `0` bit. These groups of five bits immediately follow the packet header. 

For example, the hexadecimal string **`D2FE28`** becomes:
<pre>
110100101111111000101000
VVVTTTAAAAABBBBBCCCCC
</pre>

Below each bit is a label indicating its purpose:

 - **The three bits** labeled `V` (`110`) are the packet version, **`6`**.
 - **The three bits** labeled `T` (`100`) are the packet type ID, **`4`**, which means the packet is a literal value.
 - **The five bits** labeled `A` (`10111`) start with a `1` (not the last group, keep reading) and contain the first four bits of the number, **`0111`**.
 - **The five bits** labeled `B` (`11110`) start with a `1` (not the last group, keep reading) and contain four more bits of the number, **`1110`**.
 - **The five bits** labeled `C` (`00101`) start with a `0` (last group, end of packet) and contain the last four bits of the number, **`0101`**.
 - **The three** unlabeled `0` bits at the end are extra due to the hexadecimal representation and should be ignored.

<br />  

Every other type of packet (any packet with a type ID other than 4) represent an operator that performs some calculation on one or more 
sub-packets contained within. Right now, the specific operations aren't important; focus on parsing the hierarchy of sub-packets.

An operator packet contains one or more packets. To indicate which subsequent binary data represents its sub-packets, an operator packet
can use one of two modes indicated by the bit immediately after the packet header; this is called the length type ID:

 - If the length type ID is `0`, then the next **`15 bits`** are a number that represents the total length in bits of the sub-packets contained by this packet.
 - If the length type ID is `1`, then the next **`11 bits`** are a number that represents the number of sub-packets immediately contained by this packet.

Finally, after the length type ID bit and the `15-bit` or `11-bit` field, the sub-packets appear.

</details>

<details>
  <summary><strong> Answer </strong></summary>
  <div align="right">
    
   My puzzle answer was: **`895`**
    
  </div>
</details> 

___

## Part Two

**Content**
> Now that you have the structure of your transmission decoded, you  
> can calculate the value of the expression it represents.

> **What do you get if you evaluate the expression represented  
> by your hexadecimal-encoded BITS transmission?**

<details>
  <summary><strong> Example </strong></summary>
<br />
  
**Literal values (type ID 4)** represent a single number as described above. The remaining type IDs are more interesting:

 - `0` are sum packets - their value is the **sum of the values** of their sub-packets. If they only have a single sub-packet, their value is the value of the sub-packet.
 - `1` are product packets - their value is the result of **multiplying together the values** of their sub-packets. If they only have a single sub-packet, their value is the value of the sub-packet.
 - `2` are minimum packets - their value is the **minimum of the values** of their sub-packets.
 - `3` are maximum packets - their value is the **maximum of the values** of their sub-packets.
 - `5` are greater than packets - their value is **1 if the value of the first sub-packet is greater than the value of the second sub-packet; otherwise, their value is 0**. These packets always have exactly two sub-packets.
 - `6` are less than packets - their value is **1 if the value of the first sub-packet is less than the value of the second sub-packet; otherwise, their value is 0**. These packets always have exactly two sub-packets.
 - `7` are equal to packets - their value is **1 if the value of the first sub-packet is equal to the value of the second sub-packet; otherwise, their value is 0**. These packets always have exactly two sub-packets.

Using these rules, you can now work out the **value of the outermost packet** in your BITS transmission.
  
 - `C200B40A82` finds the sum of `1` and `2`, resulting in the value **`3`**.
 - `04005AC33890` finds the product of `6` and `9`, resulting in the value **`54`**.
 - `880086C3E88112` finds the minimum of `7`, `8`, and `9`, resulting in the value **`7`**.
 - `CE00C43D881120` finds the maximum of `7`, `8`, and `9`, resulting in the value **`9`**.
 - `D8005AC2A8F0` produces **`1`**, because `5` is less than `15`.
 - `F600BC2D8F` produces **`0`**, because `5` is not greater than `15`.
 - `9C005AC2F8F0` produces **`0`**, because `5` is not equal to `15`.
 - `9C0141080250320F1802104A08` produces **`1`**, because `1 + 3 = 2 * 2`.

</details>

<details>
  <summary><strong> Answer </strong></summary>
  <div align="right">
    
   My puzzle answer was: **`1148595959144`**
    

___

<br />
