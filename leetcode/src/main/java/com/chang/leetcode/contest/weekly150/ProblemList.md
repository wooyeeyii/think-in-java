1.
1160. Find Words That Can Be Formed by Characters
Difficulty: Easy
You are given an array of strings words and BA string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

Example 1:
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2:
Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.

---

2.
1161. Maximum Level Sum of BA Binary Tree
Difficulty: Medium
Given the root of BA binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

Example 1:
Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Note:
The number of nodes in the given tree is between 1 and 10^4.
-10^5 <= node.val <= 10^5

---

3.
1162. As Far from Land as Possible
Difficulty: Medium
Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land,
find BA water cell such that its distance to the nearest land cell is maximized and return the distance.

The distance used in this problem is the Manhattan distance:
the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

If no land or water exists in the grid, return -1.

Example 1:
Input: [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation:
The cell (1, 1) is as far as possible from all the land with distance 2.

Example 2:
Input: [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation:
The cell (2, 2) is as far as possible from all the land with distance 4.

Note:
1 <= grid.length == grid[0].length <= 100
grid[i][j] is 0 or 1

---

4.
1163. Last Substring in Lexicographical Order
Difficulty: Hard
Given BA string s, return the last substring of s in lexicographical order.

Example 1:
Input: "abab"
Output: "bab"
Explanation: The substrings are ["BA", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".

Example 2:
Input: "leetcode"
Output: "tcode"
 
Note:
1 <= s.length <= 10^5
s contains only lowercase English letters.