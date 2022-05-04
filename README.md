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

### [Backtracking](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/backtracking)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Subsets](https://leetcode.com/problems/subsets/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/Subsets.java) | Arrays | O(n * 2 ^ n) | O(n) |
| 2 | [Combination Sum](https://leetcode.com/problems/combination-sum/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/backtracking/CombinationSum.java) | Arrays | O(2 ^ mn) | O(mn) |

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


### [Graph](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/graph)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/mst/MinCostToConnectAllPoints.java) | MST, Prim's Algo | O(n^2.logn) | O(n^2) |
| 2 | [Path With Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/grid/PathWithMinimumEffort.java) | Binary Search | O(log(min - max) * m * n) | O(m * n) |
| 3 | [Evaluate Division](https://leetcode.com/problems/evaluate-division/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/DFS/EvaluateDivision.java) | DFS, BFS | O(V + E) | O(V) |
| 4 | [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/BFS/grid/RottingOranges.java) | BFS | O(m * n) | O(m * n) |
| 4 | [Walls and Gates](https://www.lintcode.com/problem/663/description/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/graph/grid/WallsAndGates.java) | BFS | O(m * n) | O(m * n) |

### [Greedy Algorithms](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/greedy)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Gas Station](https://leetcode.com/problems/gas-station/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/greedy/GasStation.java) | Arrays | O(n) | O(1) |

### [Hashing/Hash Table](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/hashing)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Max Number of K-Sum Pairs](https://leetcode.com/problems/max-number-of-k-sum-pairs/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/hashing/MaxNumberOfK_SumPairs.java) | Hash Table | O(n) | O(n) |

### [Heap](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/heap)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/heap/K_ClosestPointsToOrigin.java) | Sorting | O(n.logk) | O(k) |

### [Stack](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/stack)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/stack.arrays/ShortestUnsortedContinuousSubarray.java) | Sorting, 2 Pointers | O(n) | O(n) |

### [Tree](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/tree)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Count Good Nodes in Binary Tree](https://leetcode.com/problems/count-good-nodes-in-binary-tree/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/tree/dfs_bfs/CountGoodNodesInBinaryTree.java) | Tree PreOrder | O(n) | O(height) |

### [Two Pointers](https://github.com/nsky80/Java_Algorithms/tree/main/src/com/two_pointers)

| No | Problem | Solution | Sub Topic | Time | Space |
| --- | ------ | -------- | --------- | ---- | ----- |
| 1 | [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | [Solution](https://github.com/nsky80/Java_Algorithms/blob/main/src/com/tree/dfs_bfs/BackspaceStringCompare.java) | Stack | O(n + m) | O(1) |