### 感悟

006 控制类的描述

---

二分法的查找，最熟悉的应该是快排算法，其中最经典的就是i的挪动，每次挪动的位置，就是一个“劈开”，一个二分之一，这个是非常的经典的案例，应该可以开出来，非常好玩的题目，其中就包括：

LeetCode0004： [4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)

这种问题的关键，还是做到劈开的条件，也就是挪动的规律，然后还要小心后续的处理！

---

DP问题的过程中，一个是确定子问题，这个需要经验，或者推理，暂时不讨论，后续有了感悟再继续的说明   

另外的一个问题，就是子问题的初始化的问题：这个刚刚有一个一点感悟，根据子问题的转移方程，画表，分析出来规律，然后   
去转化为代码

LeetCode0005：[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

---
如果可以的话，请把限制条件，尽可能的精确

LeetCode0015：关于去重，优化的时候 ``` j > i 和 j>i+1 有可能就引发错误的case ```

---
分析问题，解决问题，最重要的是弄明白题目的意思，并且**身体力行** 的去计算，笔画，想，结果是
如何计算出来的！

---
如果可以的话，请把限制条件，尽可能的精确

LeetCode0015：关于去重，优化的时候 ``` j > i 和 j>i+1 有可能就引发错误的case ```

---  

递归和回溯
是要联系，还是要有这个概念，迭代过程中的一个主要的概念，是循环，这个循环中需要确认三个量：
1. 输入
2. 输出
3. 处理

最重要的是确认输入和输出

~~~ 

static class Node{
        public int val;
        public Node next;

        public Node(int i) {
            this.val=i;
        }
    }

    public static void main(String[] args) {
        Node h1 = new Node(0);
        h1.next = new Node(1);
        h1.next.next = new Node(3);

        Node h2 = new Node(2);
        h2.next = new Node(4);
        h2.next.next = new Node(5);
        Node re =  mergeTwoList(h1,h2);
        System.out.println(re);
    }

    public static Node mergeTwoList(Node l1,Node l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }  

~~~
