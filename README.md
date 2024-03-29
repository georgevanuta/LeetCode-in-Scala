# LeetCode-in-Scala

My solutions for **LeetCode** exercises written in **Scala**. \
If you're curious about a particular solution, just `Ctrl-F` the exact title of the exercise.

## Note

This repo also contains some solutions written in **Java** (the **multithreaded** ones \
because they can't be solved in **Scala**), some **sqlplus** queries, some **c++** code and some **bash** scripts.

## How to use the push/update script

You can find the source code for the script [here](leet.scala).

I've made a simple **scala** script that updates this
**README.md** by adding a solution and then pushing the changes to **github**.
Also, if you want to use it, run the following command in the solution directory:

```bash
scala-cli ../../leet.scala -- "<PROBLEM_NUMBER>. <PROBLEM_TITLE>" "<DIFFICULTY>"
```

For example, if you wanted to add the **1. Two sum problem**:

```bash
scala-cli ../../leet.scala -- "1. Two Sum" E
```

## Easy

[1. Two Sum](src/TwoSum/Solution.scala) \
[9. Palindrome Number](src/IsPalindrome/Solution.scala) \
[13. Roman to Integer](src/RomanToInt/Solution.scala) \
[14. Longest Common Prefix](src/LongestCommonPrefix/Solution.scala) \
[20. Valid Parentheses](src/ValidParanth/Solution.scala) \
[26. Remove Duplicates from Sorted Array](src/RemoveDuplicates/Solution.scala) \
[27. Remove Element](src/RemoveElement/Solution.scala) \
[28. Find the Index of the First Occurrence in a String](src/NeedleHaytstack/Solution.scala) \
[35. Search Insert Position](src/BinarySearch/Solution.scala) \
[58. Length of Last Word](src/LengthOfLastWord/Solution.scala) \
[66. Plus One](src/AddOne/Solution.scala) \
[67. Add Binary](src/AddBinary/Solution.scala) \
[69. Sqrt(x)](src/MySqrt/Solution.scala) \
[83. Remove Duplicates from Sorted List](src/DeleteDuplicates/Solution.scala) \
[94. Binary Tree Inorder Traversal](src/InorderTraversal/Solution.scala) \
[98. Validate Binary Search Tree](src/IsValidBST/Solution.scala) \
[101. Symmetric Tree](src/IsSymmetric/Solution.scala) \
[102. Binary Tree Level Order Traversal](src/LevelOrder/Solution.scala) \
[104. Maximum Depth of Binary Tree](src/MaxDepth/Solution.scala) \
[108. Convert Sorted Array to Binary Search Tree](src/SortedArrayToBST/Solution.scala) \
[110. Balanced Binary Tree](src/IsBalanced/Solution.scala) \
[111. Minimum Depth of Binary Tree](src/MinDepth/Solution.scala) \
[125. Valid Palindrome](src/IsPalindromeString/Solution.scala) \
[136. Single Number](src/SingleNumberI/Solution.scala) \
[141. Linked List Cycle](src/HasCycle/Solution.scala) \
[144. Binary Tree Preorder Traversal](src/PreorderTraversal/Solution.scala) \
[145. Binary Tree Postorder Traversal](src/PostorderTraversal/Solution.scala) \
[160. Intersection of Two Linked Lists](src/GetIntersectionNode/Solution.scala) \
[169. Majority Element](src/MajorityElement/Solution.scala) \
[175. Combine Two Tables](src/CombineTables/solution.sql) \
[181. Employees Earning More Than Their Managers](src/EmployeesMoreThanManagers/solution.sql) \
[182. Duplicate Emails](src/DupEmail/solution.sql) \
[183. Customers Who Never Order](src/CustomersWhoNeverOrder/solution.sql) \
[191. Number of 1 Bits](src/Hamming/Solution.scala) \
[193. Valid Phone Numbers](src/ValidPhoneNumbers/solution.sh) \
[195. Tenth Line](src/TenthLine/solution.sh) \
[202. Happy Number](src/IsHappy/Solution.scala) \
[203. Remove Linked List Elements](src/RemoveElements/Solution.scala) \
[206. Reverse Linked List](src/ReverseList/Solution.scala) \
[217. Contains Duplicate](src/ContainsDuplicates/Solution.scala) \
[226. Invert Binary Tree](src/InvertBT/Solution.scala) \
[231. Power of Two](src/PowerOfTwo/Solution.scala) \
[232. Implement Queue using Stacks](src/MyQueue/MyQueue.scala) \
[234. Palindrome Linked List](src/IsPalindromeLinkedLsit/Solution.scala) \
[242. Valid Anagram](src/IsAnagram/Solution.scala) \
[268. Missing Number](src/MissingNumber/Solution.scala) \
[292. Nim Game](src/NimGame/Solution.scala) \
[326. Power of Three](src/IsPowerOfThree/Solution.scala) \
[342. Power of Four](src/IsPowerOf4/Solution.scala) \
[344. Reverse String](src/ReverseString/Solution.scala) \
[345. Reverse Vowels of a String](src/ReverseVowel/Solution.scala) \
[349. Intersection of Two Arrays](src/Intersection/Solution.scala) \
[350. Intersection of Two Arrays II](src/IntersectionII/Solution.scala) \
[367. Valid Perfect Square](src/ValidPerfectSquare/Solution.cpp) \
[383. Ransom Note](src/RansomNote/Solution.scala) \
[387. First Unique Character in a String](src/FirstUniqueChar/Solution.scala) \
[389. Find the Difference](src/FindTheDifference/Solution.scala) \
[392. Is Subsequence](src/IsSubsequence/Solution.scala) \
[404. Sum of Left Leaves](src/LeftSumBT/Solution.scala) \
[412. Fizz Buzz](src/FizzBuzz/Solution.scala) \
[434. Number of Segments in a String](src/CountSegments/Solution.scala) \
[448. Find All Numbers Disappeared in an Array](src/DissapNums/Solution.scala) \
[459. Repeated Substring Pattern](src/RepeatedSubstring/Solution.scala) \
[461. Hamming Distance](src/HammingBinaryDistance/Solution.scala) \
[485. Max Consecutive Ones](src/FindMaxConsecutiveOnes/Solution.scala) \
[501. Find Mode in Binary Search Tree](src/FindMode/Solution.scala) \
[504. Base 7](src/ConvertToBase7/Solution.scala) \
[509. Fibonacci Number](src/Fibo/Solution.scala) \
[511. Game Play Analysis I](src/GamePlayAnalysisI/solution.sql) \
[530. Minimum Absolute Difference in BST](src/GetMinimumDifference/Solution.scala) \
[551. Student Attendance Record I](src/CheckRecord/Solution.scala) \
[559. Maximum Depth of N-ary Tree](src/NaryMaxDepth/Solution.scala) \
[575. Distribute Candies](src/Candies/Solution.scala) \
[586. Customer Placing the Largest Number of Orders](src/CustomerMostOrders/solution.sql) \
[589. N-ary Tree Preorder Traversal](src/NaryTreePreorderTraversal/Solution.scala) \
[595. Big Countries](src/BigCountries/solution.sql) \
[596. Classes More Than 5 Students](src/ClassesMoreThanFive/solution.sql) \
[617. Merge Two Binary Trees](src/MergeTrees/Solution.scala) \
[620. Not Boring Movies](src/NotBoringMovies/solution.sql) \
[627. Swap Salary](src/SwapSalary/solution.sql) \
[645. Set Mismatch](src/FindErrorNums/Solution.scala) \
[653. Two Sum IV - Input is a BST](src/TwoSumBT/Solution.scala) \
[671. Second Minimum Node In a Binary Tree](src/FindSecondMinimumValue/Solution.scala) \
[700. Search in a Binary Search Tree](src/SearchBST/Solution.scala) \
[705. Design HashSet](src/MyHashSet/MyHashSet.scala) \
[709. To Lower Case](/src/ToLowerCase/Solution.scala) \
[724. Find Pivot Index](src/PivotIndex/Solution.scala) \
[819. Most Common Word](src/BannedWords/Solution.scala) \
[824. Goat Latin](src/ToGoatLatin/Solution.scala) \
[832. Flipping an Image](src/FlipInvert/Solution.scala) \
[836. Rectangle Overlap](src/RectangleOverlap/Solution.scala) \
[867. Transpose Matrix](src/TransposeMatrix/Solution.scala) \
[872. Leaf-Similar Trees](src/LeafSimilar/Solution.scala) \
[876. Middle of the Linked List](src/MiddleNode/Solution.scala) \
[897. Increasing Order Search Tree](src/IncreasingBST/Solution.scala) \
[905. Sort Array By Parity](src/SortByParity/Solution.scala) \
[929. Unique Email Addresses](src/UniqueEmails/Solution.scala) \
[938. Range Sum of BST](src/RangeSumBST/Solution.scala) \
[941. Valid Mountain Array](src/MountainArray/Solution.scala) \
[953. Verifying an Alien Dictionary](src/AlienLanguage/Solution.scala) \
[977. Squares of a Sorted Array](src/SquareOrder/Solution.scala) \
[993. Cousins in Binary Tree](src/IsCousins/Solution.scala) \
[1002. Find Common Characters](src/CommonLetters/Solution.scala) \
[1022. Sum of Root To Leaf Binary Numbers](src/SumBT/Solution.scala) \
[1050. Actors and Directors Who Cooperated At Least Three Times](src/ActorsDirectors/solution.sql) \
[1051. Height Checker](src/HeightChecker/Solution.scala) \
[1108. Defanging an IP Address](src/DefangIP/Solution.scala) \
[1114. Print in Order](src/PrintOrder/Foo.java) \
[1122. Relative Sort Array](src/RelativeSort/Solution.scala) \
[1148. Article Views I](src/ArticleViewsI/solution.sql) \
[1160. Find Words That Can Be Formed by Characters](src/GoodString/Solution.scala) \
[1221. Split a String in Balanced Strings](src/BalancedStrings/Solution.scala) \
[1266. Minimum Time Visiting All Points](src/ShortestPoint/Solution.scala) \
[1290. Convert Binary Number in a Linked List to Integer](src/GetDecimalValue/Solution.scala) \
[1407. Top Travellers](src/TopTravellers/solution.sql) \
[1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence](src/IsPrefixOfWord/Solution.scala) \
[1523. Count Odd Numbers in an Interval Range](src/CountOdds/Solution.scala) \
[1527. Patients With a Condition](src/PatientsDiabetes/solution.sql) \
[1528. Shuffle String](src/ShuffleString/Solution.scala) \
[1572. Matrix Diagonal Sum](src/DiagonalSum/Solution.scala) \
[1636. Sort Array by Increasing Frequency](src/IncrFreqSort/Solution.scala) \
[1667. Fix Names in a Table](src/FixNames/solution.sql) \
[1678. Goal Parser Interpretation](src/GoalParser/Solution.scala) \
[1729. Find Followers Count](src/FollowersCount/solution.sql) \
[1736. Latest Time by Replacing Hidden Digits](src/LatestTime/Solution.scala) \
[1748. Sum of Unique Elements](src/SumOfUnique/Solution.scala) \
[1757. Recyclable and Low Fat Products](src/GoodProducts/solution.sql) \
[1791. Find Center of Star Graph](src/FindCenter/Solution.scala) \
[1876. Substrings of Size Three with Distinct Characters](src/GoodSubstrings/Solution.scala) \
[1890. The Latest Login in 2020](src/LatestLogin/solution.sql) \
[1929. Concatenation of Array](src/GetConcatenation/Solution.scala) \
[1965. Employees With Missing Information](src/EmployeesWithMissingInfo/solution.sql) \
[2000. Reverse Prefix of Word](src/ReversePrefix/Solution.scala) \
[2129. Capitalize the Title](src/CapitalizeTitle/Solution.scala) \
[2133. Check if Every Row and Column Contains All Numbers](src/CheckValid/Solution.scala) \
[2148. Count Elements With Strictly Smaller and Greater Elements](src/CountElements/Solution.scala) \
[2180. Count Integers With Even Digit Sum](src/CountEven/Solution.scala) \
[2206. Divide Array Into Equal Pairs](src/EqualParts/Solution.scala) \
[2220. Minimum Bit Flips to Convert Number](src/MinBitFlips/Solution.scala) \
[2235. Add Two Integers](src/ActualTwoSum/Solution.scala) \
[2236. Root Equals Sum of Children](src/CheckTree/Solution.scala) \
[2239. Find Closest Number to Zero](src/FindClosestNumber/Solution.scala) \
[2248. Intersection of Multiple Arrays](src/IntersectionMatrix/Solution.scala) \
[2283. Check if Number Has Equal Digit Count and Digit Value](src/DigitCount/Solution.scala) \
[2331. Evaluate Boolean Binary Tree](src/EvaluateTree/Solution.scala) \
[2481. Minimum Cuts to Divide a Circle](src/NumberOfCuts/Solution.scala) \
[2490. Circular Sentence](src/IsCircularSentence/Solution.scala) \
[2496. Maximum Value of a String in an Array](src/MaximumValue/Solution.scala) \
[2500. Delete Greatest Value in Each Row](src/DeleteGreatestValue/Solution.scala) \
[2544. Alternating Digit Sum](src/AlternatingDigitSum/Solution.scala)

## Medium

[2. Add Two Numbers](src/AddLists/Solution.scala) \
[5. Longest Palindromic Substring](src/LongestPalindrome/Solution.scala) \
[19. Remove Nth Node From End of List](src/RemoveNthFromEnd/Solution.scala) \
[22. Generate Parentheses](src/GenerateParenthesis/Solution.scala) \
[33. Search in Rotated Sorted Array](src/SearchRotated/Solution.scala) \
[34. Find First and Last Position of Element in Sorted Array](src/FirstAndLast/Solution.scala) \
[36. Valid Sudoku](src/IsValidSudoku/Solution.scala) \
[49. Group Anagrams](src/Anagrams/Solution.scala) \
[59. Spiral Matrix II](src/Spiral/Solution.scala) \
[71. Simplify Path](src/SimplifyPath/Solution.scala) \
[74. Search a 2D Matrix](src/SearchMatrix/Solution.scala) \
[75. Sort Colors](src/SortColors/Solution.scala) \
[79. Word Search](src/WordSearch/Solution.scala) \
[103. Binary Tree Zigzag Level Order Traversal](src/ZigZagLevelOrder/Solution.scala) \
[107. Binary Tree Level Order Traversal II](src/LevelOrderBottom/Solution.scala) \
[109. Convert Sorted List to Binary Search Tree](src/SortedListToBST/Solution.scala) \
[114. Flatten Binary Tree to Linked List](src/FlattenBT/Solution.scala) \
[129. Sum Root to Leaf Numbers](src/SumNumbers/Solution.scala) \
[150. Evaluate Reverse Polish Notation](src/EvalRPN/Solution.scala) \
[162. Find Peak Element](src/Peak/Solution.scala) \
[165. Compare Version Numbers](src/CompareVersions/Solution.scala) \
[173. Binary Search Tree Iterator](src/BSTIterator/BSTIterator.scala) \
[176. Second Highest Salary](src/SecondHighestSalary/solution.sql) \
[199. Binary Tree Right Side View](src/RightSideBT/Solution.scala) \
[200. Number of Islands](src/NrIslands/Solution.scala) \
[223. Rectangle Area](src/ComputeArea/Solution.scala) \
[229. Majority Element II](src/Majority/Solution.scala) \
[230. Kth Smallest Element in a BST](src/KthSmallest/Solution.scala) \
[236. Lowest Common Ancestor of a Binary Tree](src/LowestCommonAncestor/Solution.scala) \
[237. Delete Node in a Linked List](src/DeleteNode/Solution.scala) \
[260. Single Number III](src/SingleNumber/Solution.scala) \
[287. Find the Duplicate Number](src/DuplicateNumber/Solution.scala) \
[328. Odd Even Linked List](src/OddEvenList/Solution.scala) \
[355. Design Twitter](src/Twitter/Twitter.scala) \
[371. Sum of Two Integers](src/GetSum/Solution.scala) \
[382. Linked List Random Node](src/GetRandom/Solution.scala) \
[398. Random Pick Index](src/Pick/Solution.scala) \
[427. Construct Quad Tree](src/ConstructQuadTree/Solution.scala) \
[438. Find All Anagrams in a String](src/FindAnagrams/Solution.scala) \
[445. Add Two Numbers II](src/SumLinkedLists/Solution.scala) \
[450. Delete Node in a BST](src/DeleteNodeBT/Solution.scala) \
[451. Sort Characters By Frequency](src/FreqSort/Solution.scala) \
[508. Most Frequent Subtree Sum](src/FindFrequentTreeSum/Solution.scala) \
[513. Find Bottom Left Tree Value](src/FindBottomLeftValue/Solution.scala) \
[515. Find Largest Value in Each Tree Row](src/MaxEachLevelBT/Solution.scala) \
[567. Permutation in String](src/CheckInclusion//Solution.scala) \
[590. N-ary Tree Postorder Traversal](src/Postorder/Solution.scala) \
[654. Maximum Binary Tree](src/ConstructMaximumBT/Solution.scala) \
[669. Trim a Binary Search Tree](src/TrimBST/Solution.scala) \
[690. Employee Importance](src/EmployeeImportance/Solution.scala) \
[701. Insert into a Binary Search Tree](src/InsertIntoBST/Solution.scala) \
[763. Partition Labels](src/StringPartition/Solution.scala) \
[788. Rotated Digits](src/RotateDig/Solution.scala) \
[791. Custom Sort String](src/CustomOrder/Solution.scala) \
[796. Rotate String](src/RotateShift/Solution.scala) \
[814. Binary Tree Pruning](src/PruneTree/Solution.scala) \
[849. Maximize Distance to Closest Person](src/MaxSeatDist/Solution.scala) \
[900. RLE Iterator](src/RLEIterator/RLEIterator.scala) \
[937. Reorder Data in Log Files](src/Logs/Solution.scala) \
[957. Prison Cells After N Days](src/Prison/Solution.scala) \
[973. K Closest Points to Origin](src/ClosestK/Solution.scala) \
[1019. Next Greater Node In Linked List](src/NextLargerNode/Solution.scala) \
[1021. Remove Outermost Parentheses](src/PrimitiveParenth/Solution.scala) \
[1026. Maximum Difference Between Node and Ancestor](src/MaxAncestorDiff/Solution.scala) \
[1038. Binary Search Tree to Greater Sum Tree](src/BSTtoGST/Solution.scala) \
[1042. Flower Planting With No Adjacent](src/Garden/Solution.scala) \
[1115. Print FooBar Alternately](src/FooBar/FooBar.java) \
[1117. Building H2O](src/H2O/H2O.java) \
[1155. Number of Dice Rolls With Target Sum](src/RollsToTarget/Solution.scala) \
[1302. Deepest Leaves Sum](src/DeepestLeavesSum/Solution.scala) \
[1305. All Elements in Two Binary Search Trees](src/GetAllElements/Solution.scala) \
[1315. Sum of Nodes with Even-Valued Grandparent](src/GrandfatherSum/Solution.scala) \
[1325. Delete Leaves With a Given Value](src/RemoveLeafNodes/Solution.scala) \
[1448. Count Good Nodes in Binary Tree](src/GoodNodes/Solution.scala) \
[1669. Merge In Between Linked Lists](src/MergeLinkedLists/Solution.scala) \
[2095. Delete the Middle Node of a Linked List](src/DeleteMiddle/Solution.scala) \
[2130. Maximum Twin Sum of a Linked List](src/TwinSum/Solution.scala) \
[2221. Find Triangular Sum of an Array](src/TriangularSum/Solution.scala)

## Hard

[23. Merge k Sorted Lists](src/MergeKLists/Solution.scala)
