# Java Algorithm Implementation
Solved coding problems in Java from different learning platforms and implementation of standard Algorithms and Data Structures.

## Different Packages
| Name of Package | Description |
| ----------------| ----------- |
| [com.arrays](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/arrays) | Problem based on Arrays Data Structure |
| [com.concurrency](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/concurrency) | Problems for concurrency and multithreading |
| [com.design](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/design) | Standard implementation of requirement using OOPs and library function implementation |
| [com.disjoint_set](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/disjoint_set) | Problem based on Union Find |
| [com.dp](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/dp) | Most frequent used pattern of Dynamic Programming |
| [com.graph](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/graph) | Implementation of well-known graph algorithms and DFS, BFS |


## Topic Wise Problems

### [Arrays](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/arrays)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/hashing/TwoSum.java) | Hashing | O(n) | O(n) |
| 2 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/arrays/ContainsDuplicate.java) | Hashing | O(n) | O(n) |
| 3 | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/arrays/ProductOfArrayExceptSelf.java) | Prefix Sum | O(n) | O(1) |
| 4 | [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/arrays/ValidSudoku.java) | Grid | O(n^2) | O(n) |
| 5 | [Range Sum Query 2D - Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/arrays/prefix_sum/RangeSumQuery2D_Immutable.java) | Prefix Sum, Grid | O(mn + q) | O(mn) |

### [Backtracking](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/backtracking)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Subsets](https://leetcode.com/problems/subsets/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/Subsets.java) | Arrays | O(n * 2 ^ n) | O(n) |
| 2 | [Combination Sum](https://leetcode.com/problems/combination-sum/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/CombinationSum.java) | Math | O(2 ^ mn) | O(mn) |
| 3 | [Permutations](https://leetcode.com/problems/permutations/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/Permutations.java) | Math | O(n * n!) | O(n) |
| 4 | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/LetterCombinationsOfPhoneNumber.java) | Math | O(n * 4^n) | O(n) |
| 5 | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/GenerateParentheses.java) | String | [O(4^n / sqrt(n))](https://leetcode.com/problems/generate-parentheses/solution/#:~:text=of%20opening%20brackets.-,Complexity%20Analysis,-Our%20complexity%20analysis) | O(4^n / sqrt(n)) |
| 6 | [Permutations II](https://leetcode.com/problems/permutations-ii/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/PermutationsII.java) | Math, HashTable | O(n.n!) | O(n) |
| 7 | [Subsets II](https://leetcode.com/problems/subsets-ii/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/SubsetsII.java) | String | O(n.2^n) | O(n) |
| 8 | [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/CombinationSumII.java) | Array | O(2^n) | O(n) |
| 9 | [N-Queens](https://leetcode.com/problems/n-queens/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/N_Queens.java) | Array | ~ O(N!) | O(n) |
| 10 | [N-Queens II](https://leetcode.com/problems/n-queens-ii/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/N_QueensII.java) | Array | ~ O(N!) | O(n) |
| 11 | [Word Search](https://leetcode.com/problems/word-search/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/WordSearch.java) | Grid | O(m*n*4^s) | O(m + n) |

### [Binary Search](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/searching/binary)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/searching/binary/LongestIncreasingSubsequence.java) | Greedy, DP | O(nlogn) | O(n) |
| 2 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/searching/binary/SearchInRotatedSortedArray.java) | Arrays | O(logn) | O(1) |
| 3 | [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/searching/binary/FindMinimumInRotatedSortedArray.java) | Arrays | O(logn) | O(1) |

### [Bit Manipulation](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/bit_manipulation)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/bit_manipulation/NumberOfOneBits.java) | Number | O(1) | O(1) |
| 2 | [Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/bit_manipulation/NumberOfStepsToReduceNumberToZero.java) | Number | O(logn) | O(1) |
| 3 | [Missing Number](https://leetcode.com/problems/missing-number/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/bit_manipulation/MissingNumber.java) | Math | O(n) | O(1) |
| 4 | [Maximum Product of Word Lengths](https://leetcode.com/problems/maximum-product-of-word-lengths/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/bit_manipulation/MaximumProductOfWordLengths.java) | BitMask | O(n * (n + N)) | O(n) |
| 5 | [Check String Contains All Binary Codes Of Size K](https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/bit_manipulation/CheckStringContainsAllBinaryCodesOfSizeK.java) | Rolling Hash | O(n) | O(2^k) |
| 6 | [Divide Two Integers](https://leetcode.com/problems/divide-two-integers/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/bit_manipulation/DivideTwoIntegers.java) | Bit Shifting | O(logn) | O(1) |

### [Concurrency](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/concurrency)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Print In Order](https://leetcode.com/problems/print-in-order/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/concurrency/semaphores/PrintInOrder.java) | Semaphores | O(1) | O(1) |

### [Dynamic Programming](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/dp)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/medium/BestTimeToBuyAndSellStockWithCooldown.java) | Arrays | O(n) | O(n) |
| 2 | [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/lcs/CountLCS_DP.java) | String, Arrays | O(mn) | O(max(m, n)) |
| 3 | [Coin Change](https://leetcode.com/problems/coin-change/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/coin_change/CoinChange.java) | Arrays | O(m * n) | O(m) |
| 4 | [Coin Change 2](https://leetcode.com/problems/coin-change-2/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/coin_change/CoinChange2.java) | Arrays | O(m * n) | O(m) |
| 5 | [Target Sum](https://leetcode.com/problems/target-sum/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/medium/TargetSum.java) | 2D Arrays | O(m * n) | O(m * n) |
| 6 | [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/medium/PartitionEqualSubsetSum.java) | Subset Sum | O(n * m) | O(m)-Optimized |
| 7 | [Interleaving String](https://leetcode.com/problems/interleaving-string/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/string/InterleavingString.java) | String | O(n * m) | O(m * n) |
| 8 | [Count Sorted Vowel Strings](https://leetcode.com/problems/count-sorted-vowel-strings/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/string/CountSortedVowelStrings.java) | String | O(n * 5) | O(n * 5) |
| 9 | [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/lcs/DistinctSubsequences.java) | String | O(n * m) | O(n * m) |
| 10 | [Edit Distance](https://leetcode.com/problems/edit-distance/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/edit_distance) | String | O(n * m) | O(m)-Optimized |
| 11 | [Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/medium/OnesAndZeroes.java) | String | O(n * m * k) | O(n * m)-Optimized |
| 12 | [Delete Operation for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/dp/lcs/DeleteOperationForTwoStrings.java) | String | O(n * m) | O(m)-Optimized |

### [Graph](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/graph)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/mst/MinCostToConnectAllPoints.java) | MST, Prim's Algo | O(n^2.logn) | O(n^2) |
| 2 | [Path With Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/grid/PathWithMinimumEffort.java) | Binary Search | O(log(min - max) * m * n) | O(m * n) |
| 3 | [Evaluate Division](https://leetcode.com/problems/evaluate-division/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/DFS/EvaluateDivision.java) | DFS, BFS | O(V + E) | O(V) |
| 4 | [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/BFS/grid/RottingOranges.java) | BFS | O(m * n) | O(m * n) |
| 5 | [Walls and Gates](https://www.lintcode.com/problem/663/description/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/grid/WallsAndGates.java) | BFS | O(m * n) | O(m * n) |
| 6 | [Course Schedule](https://leetcode.com/problems/course-schedule/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/dag/topological_sort/CourseSchedule.java) | DFS, Cycle Detection | O(V + E) | O(V + E) |
| 7 | [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/dag/topological_sort/CourseSchedule2.java) | DFS, BFS, Top Sort | O(V + E) | O(V + E) |
| 8 | [Redundant Connection](https://leetcode.com/problems/redundant-connection/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/disjoint_set/RedundantConnection.java) | DFS, Union Find | O(n) | O(n) |
| 9 | [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph.DFS.grid/LongestIncreasingPathInA_Matrix.java) | DFS, DP, Top-Sort | O(m * n) | O(m * n) |
| 10 | [Network Delay Time](https://leetcode.com/problems/network-delay-time/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com.graph.dijkstra/NetworkDelayTime.java) | Shortest Path | O(N + ElogN) | O(E) |
| 11 | [Clone Graph](https://leetcode.com/problems/clone-graph/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com.graph/CloneGraph.java) | Hashing | O(V + E) | O(V) |
| 12 | [Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com.graph.scc/CriticalConnectionsInNetwork.java) | SCC, Tarjan's Algo | O(V + E) | O(V + E) |

### [Greedy Algorithms](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/greedy)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Gas Station](https://leetcode.com/problems/gas-station/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/greedy/GasStation.java) | Arrays | O(n) | O(1) |
| 2 | [Hand of Straights](https://leetcode.com/problems/hand-of-straights/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/greedy/HandOfStraights.java) | HashTable | O(nlogn) | O(n) |
| 3 | [Merge Triplets to Form Target Triplet](https://leetcode.com/problems/merge-triplets-to-form-target-triplet/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/greedy/MergeTripletsToFormTargetTriplet.java) | Arrays | O(n) | O(1) |

### [Hashing/Hash Table](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/hashing)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Max Number of K-Sum Pairs](https://leetcode.com/problems/max-number-of-k-sum-pairs/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/hashing/MaxNumberOfK_SumPairs.java) | Hash Table | O(n) | O(n) |

### [Heap](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/heap)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/heap/K_ClosestPointsToOrigin.java) | Sorting | O(n.logk) | O(k) |

### [Intervals](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/intervals)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Merge Intervals](https://leetcode.com/problems/merge-intervals/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/intervals/MergeIntervals.java) | Sorting | O(n.logn) | O(n) |
| 2 | [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/intervals/NonOverlappingIntervals.java) | Sorting | O(n.logn) | O(n) |

### [Linked-List](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/linkedList)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Reorder List](https://leetcode.com/problems/reorder-list/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/linkedList/ReorderList.java) | Two Pointers | O(n) | O(1) |
| 2 | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/linkedList/RemoveNthNodeFromEndOfList.java) | Two Pointers | O(n) | O(1) |
| 3 | [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/linkedList/CopyListWithRandomPointer.java) | HashMap | O(n) | O(1)-Optimized |
| 4 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/linkedList/AddTwoNumbers.java) | Traversal | O(n) | O(1) |
| 5 | [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/linkedList/IntersectionOfTwoLinkedLists.java) | Two pointers | O(m + n) | O(1) |

### [Math](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/maths)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Rotate Image](https://leetcode.com/problems/rotate-image/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/matrix/RotateImage.java) | Matrix, Rotation | O(n * n) | O(1) |

### [Sliding Window](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/sliding_window)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/sliding_window/LongestSubstringWithoutRepeatingCharacters.java) | Hash Table | O(n) | O(n) |
| 2 | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/sliding_window/LongestRepeatingCharacterReplacement.java) | String | O(n) | O(1) |
| 3 | [Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/sliding_window/MinimumOperationsToReduceXtoZero.java) | Greedy, Hashing | O(n) | O(1) |
| 4 | [Maximum Erasure Value](https://leetcode.com/problems/maximum-erasure-value/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/sliding_window/MaximumErasureValue.java) | Hashing | O(n) | O(set(n)) |


### [Sorting](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/sorting)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/sorting/MergeK_SortedLists.java) | PQ, Merge Sort | O(nlogk) | O(logk) |
| 2 | [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/sorting/KthLargestElementInAnArray.java) | PQ, QuickSelect | Avg.-O(n) | O(1) |

### [Stack](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/stack)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/stack/arrays/ShortestUnsortedContinuousSubarray.java) | Sorting, 2 Pointers | O(n) | O(n) |
| 2 | [Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/stack/ImplementStackUsingQueues.java) | Design | O(n) O(1) O(1) | O(1) |
| 3 | [Remove All Adjacent Duplicates in String II](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/stack/RemoveAllAdjacentDuplicatesInStringII.java) | String | O(n) | O(n) |
| 4 | [132 Pattern](https://leetcode.com/problems/132-pattern/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/stack/monotonic_stack/Pattern132.java) | Monotonic Stack | O(n) | O(n) |
| 5 | [Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/stack/monotonic_stack/RemoveDuplicateLetters.java) | Monotonic Stack | O(n) | O(n) |
| 6 | [Remove K Digits](https://leetcode.com/problems/remove-k-digits/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/stack/monotonic_stack/RemoveKDigits.java) | Monotonic Stack | O(n) | O(n) |
| 7 | [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/stack/monotonic_stack/DailyTemperatures.java) | Monotonic Stack | O(n) | O(1)-Optimized |
| 8 | [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/stack/EvaluateReversePolishNotation.java) | Stack | O(n) | O(n) |
| 9 | [Car Fleet](https://leetcode.com/problems/car-fleet/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/stack/CarFleet.java) | Monotonic Stack, Sorting | O(nlogn) | O(n) |

### [Tree](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/tree)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Count Good Nodes in Binary Tree](https://leetcode.com/problems/count-good-nodes-in-binary-tree/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/tree/dfs_bfs/CountGoodNodesInBinaryTree.java) | Tree PreOrder | O(n) | O(height) |
| 2 | [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/tree/traversal/ValidateBinarySearchTree.java) | BST | O(n) | O(height) |
| 3 | [Maximum Binary Tree / Cartesian Tree](https://leetcode.com/problems/maximum-binary-tree/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/tree/CartesianTree.java) | BST | O(n^2) | O(height) |
| 4 | [Populating Next Right Pointers in Each Node II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/tree/PopulatingNextRightPointersInEachNodeII.java) | LinkedList, BFS | O(n) | O(1) |
| 5 | [Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/tree/dfs_bfs/DeepestLeavesSum.java) | DFS, BFS | O(n) | O(n) |
| 6 | [Tree from Preorder and Inorder](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/tree/creation/ConstructBinaryTreeFromPreorderAndInorderTraversal.java) | Hashing | O(n) | O(n) |
| 7 | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/tree/creation/BinaryTreeMaximumPathSum.java) | DFS | O(n) | O(n) |

### [Two Pointers](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/two_pointers)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/tree/dfs_bfs/BackspaceStringCompare.java) | Stack | O(n + m) | O(1) |
| 2 | [3Sum](https://leetcode.com/problems/3sum/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/two_pointers/ThreeSum.java) | Sorting | O(n * n) | O(n) |
| 3 | [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/two_pointers/MergeSortedArray.java) | Sorting | O(n) | O(1) |
| 4 | [Remove Palindromic Subsequences](https://leetcode.com/problems/remove-palindromic-subsequences/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/two_pointers/RemovePalindromicSubsequences.java) | String | O(n) | O(1) |
| 5 | [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/two_pointers/TwoSumII_InputArrayIsSorted.java) | Binary Search | O(n) | O(1) |