# 第 56 场双周赛
[赛题地址](https://leetcode-cn.com/contest/biweekly-contest-56/)

## 赛题及题解
|赛题|题解|
| ---- | ----|
|[a.统计平方和三元组的数目](https://leetcode-cn.com/problems/count-square-sum-triples/)|[a.java](/competition/leetcode/weekly56/a.java)|
|[b.迷宫中离入口最近的出口](https://leetcode-cn.com/problems/nearest-exit-from-entrance-in-maze/)|[b.java](/competition/leetcode/weekly56/b.java)|
|[c.求和游戏](https://leetcode-cn.com/problems/sum-game/)|[c.java](/competition/leetcode/weekly56/c.java)|
|[d.规定时间内到达终点的最小花费](https://leetcode-cn.com/problems/minimum-cost-to-reach-destination-in-time/)|[d.java](/competition/leetcode/weekly56/d.java)|

## 思路
### b
BFS模板题
### c
模拟题

A：左边？个数
B：右边？个数
x: 左边数之和 - 右边数之和

讨论以下几种情况：
1. 如果 A+B 是奇数，由于Alice先手，最后一步一定是Alice，那么Alice可以放置任何数，一定赢。
2. 如果 A+B 是偶数，Alice要使得左右数相加不相等，即大于或小于，讨论下面两种情况： 

① x>0
Alice必然在左侧放9，右侧放0。

假设Alice在左侧？中放置a个9，她还有 ![](https://latex.codecogs.com/svg.image?\frac{A&plus;B}{2}-a) 次操作，这些操作必然是在右侧？中放0。Bob可以在右侧？中放 ![](https://latex.codecogs.com/svg.image?B-(\frac{A&plus;B}{2}-a)\&space;=\&space;\frac{B-A}{2}&plus;a) 次，且一定会是9。

最终左右两侧的数之差 ![](https://latex.codecogs.com/svg.image?\Delta=9*a-9*(\frac{B-A}{2}&plus;a)&space;&plus;&space;x=9*\frac{A-B}{2}&plus;x)

即 ![](https://latex.codecogs.com/svg.image?\Delta&space;=9*\frac{A-B}{2}&plus;x>0) Alice获胜

② x<0

同理，最终左右两侧的数之差 ![](https://latex.codecogs.com/svg.image?\Delta'&space;=9*\frac{B-A}{2}-x) ，即 ![](https://latex.codecogs.com/svg.image?\Delta'&space;=9*\frac{B-A}{2}-x<0) Alice获胜。

**注意**：![](https://latex.codecogs.com/svg.image?\Delta=-\Delta')，![](https://latex.codecogs.com/svg.image?\Delta>0)和![](https://latex.codecogs.com/svg.image?\Delta'<0)，即![](https://latex.codecogs.com/svg.image?\Delta!=0)的情况下，Alice获胜



