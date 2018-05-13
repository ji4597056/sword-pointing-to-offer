# 剑指offer刷题录(java)

## chapter_01:实现单例模式

- 饿汉模式
- 双重校验锁
- 静态内部类
- 懒汉模式

## chapter_02:二维数组的查找

**描述:** 一个二维数组,每一行从左到右递增,每一列从上到下递增.输入一个二维数组和一个整数,判断数组中是否含有整数.
```java
    public boolean find(int[][] array, int number) {
        //TODO
    }
```

## chapter_03:替换空格

**描述:** 请实现一个函数,把字符串中的每个空格替换成"%20".
```java
    public String replaceBlank(String input) {
        //TODO
    }
```

## chapter_04:从尾到头打印链表

**描述:** 输入一个链表的头结点,从尾到头反过来打印出每个结点的值.
```java
    public <T> void printListReverse(ListNode<T> node) {
        //TODO
    }
```

## chapter_05:重建二叉树

**描述:** 输入二叉树的前序遍历和中序遍历的结果,重建出该二叉树.假设前序遍历和中序遍历结果中都不包含重复的数字.
```java
    public BinaryTreeNode construct(int[] preorder, int[] inorder) {
        //TODO
    }
```

## chapter_06:用两个栈实现队列

**描述:** 用两个栈实现一个队列,实现对了的两个函数appendTail和deleteHead,分别完成在队列尾插入结点和在队列头部删除结点的功能.
```java
    public class CQueue<T> {

        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        public void appendTail(T t) {
            //TODO
        }

        public T deleteHead() {
            //TODO
        }
    }
```

## chapter_07:旋转数组的最小数字

**描述:** 把一个数组最开始的若干个元素搬到数组的末尾,我们称之为数组的旋转.输入一个递增排序的数组的一个旋转,输出旋转数组的最小元素.例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转,该数组的最小值为1.
```java
    public Integer findMinNum(int[] array) {
        //TODO
    }
```

## chapter_08:斐波拉契数列

**描述:** 写一个函数,输入n,求斐波那契数列的第n项.
```java
    public long fibonacci(int n) {
        //TODO
    }
```

## chapter_09:二进制中1的个数

**描述:** 请实现一个函数,输入一个整数,输出该数二进制表示中1的个数.例如把9表示成二进制是1001;有2位是1,因此如果输入9,函数输出2.
```java
    public int numberOfOne1(int n) {
        //TODO
    }
```

## chapter_10:数值的整数次方

**描述:** 实现函数`double Power（double base，int exponent）`,求base的exponent次方.不得使用库函数,同时不需要考虑大数问题.
```java
    public double power(double base, int exponent) throws Exception {
        //TODO
    }
```

## chapter_11:打印1到最大的n位数

**描述:** 输入数字n,按顺序打印出从1到最大的n位进制数.比如输入3,则打印出1、2、3一直到999.
```java
    public void printToMaxOfNDigits(int n) {
        //TODO
    }
```

## chapter_12:在O(1)时间删除链表结点

**描述:** 给定单向链表的头指针和一个结点指针,定义一个函数在O(1)时间删除该结点.
```java
    public <T> void deleteNode(ListNode<T> head, ListNode<T> deListNode) {
        //TODO
    }
```

## chapter_13:调整数组顺序使奇数位于偶数前面

**描述:** 输入一个整数数组,实现一个函数来调整该函数数组中数字的顺序,使得所有奇数位于数组的前半部分,所有的偶数位于数组的后半部分.
```java
    public void reorderOddEven(int[] array) {
        //TODO
    }
```

## chapter_14:链表中倒数第k个结点

**描述:** 输入一个链表,输出该链表中倒数第k个结点.为了符合大多数人的习惯,本题从1开始计数,即链表的尾结点是倒数第一个结点.例如一个有6个结点的链表,从头结点依次是1,2,3,4,5,6.倒数第三个结点就是值为4的结点.
```java
    public <T> ListNode findKToTail(ListNode<T> head, int k) throws Exception {
        //TODO
    }
```

## chapter_15:反转链表

**描述:** 定义一个函数,输入一个链表的头结点,反转该链表并输出反转后链表的头结点.
```java
    public <T> ListNode<T> reverseList(ListNode<T> head) {
        //TODO
    }
```

## chapter_16:合并两个排序的链表

**描述:** 输入两个递增排序的链表,合并这两个链表并使新链表中的结点仍然是按照递增排序的.
```java
    public ListNode<Integer> mergeList(ListNode<Integer> head1, ListNode<Integer> head2) {
        //TODO
    }
```

## chapter_17:树的子结构

**描述:** 输入两颗二叉树A和B,判断B是不是A的子结构.
```java
    public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        //TODO
    }
```

## chapter_18:二叉树的镜像

**描述:** 请完成一个函数,输入一个二叉树,该函数输出它的镜像.
```java
    public BinaryTreeNode mirrorBinaryTree(BinaryTreeNode root) {
        //TODO
    }
```

## chapter_19:顺时针打印矩阵

**描述:** 输入一个矩阵,按照从外向里以顺时针的顺序依次打印出每一个数字.
```java
    public void printMatixClockwisely(int[][] array) {
        //TODO
    }
```

## chapter_20:包含min函数的栈

**描述:** 定义栈的数据结构,请在该类型中实现一个能够得到栈的最小元素的min函数.在该栈中,调用min、push及pop德尔时间复杂度都是O(1).
```java
    public class StackWithMin {

        public void push(Integer data) {
            //TODO
        }

        public Integer pop() {
            //TODO
        }

        public Integer min() {
            //TODO
        }
    }
```

## chapter_21:栈的压入、弹出序列

**描述:** 输入两个整数序列,第一个序列表示栈的压入顺序,请判断第二个序列是否为该栈的弹出序列.假设压入栈的所有数字均不相等.例如压栈序列为1、2、3、4、5.序列4、5、3、2、1是压栈序列对应的一个弹出序列,但4、3、5、1、2却不是.
```java
    public boolean isPopOrder(int[] line1, int[] line2) {
        //TODO
    }
```

## chapter_22:从上往下打印二叉树

**描述:** 从上往下打印二叉树的每个结点,同一层的结点按照从左到右的顺序打印.
```java
    public void printFromTopToBottom(BinaryTreeNode root) {
        //TODO
    }
```

## chapter_23:二叉搜索树的后序遍历序列

**描述:** 输入一个整数数组,判断该数组是不是某二叉搜索树的后序遍历的结果.是则返回true,否则返回false.
```java
    public boolean verfiySequenceOfBST(int[] sequence) {
        //TODO
    }
```

## chapter_24:二叉树中和为某一值的路径

**描述:** 输入一颗二叉树和一个整数,打印出二叉树中结点值的和为输入整数的所有路径.从树的根节点开始往下一直到叶结点所经过的结点形成一条路径.
```java
    public void findPath(BinaryTreeNode root, int sum) {
        //TODO
    }
```

## chapter_25:复杂链表的复制

**描述:** 实现函数复制一个复杂链表.在复杂链表中,每个结点除了有一个next指针指向下一个结点外,还有一个指向链表中任意结点或null.
```java
    public ComplexListNode clone(ComplexListNode head) {
        //TODO
    }
```

## chapter_26:二叉搜索树与双向链表

**描述:** 输入一棵二叉搜索树,将该二叉搜索树转换成一个排序的双向链表.要求不能创建任何新的结点,只能调整树中结点指针的指向.
```java
    public BinaryTreeNode convert(BinaryTreeNode root) {
        //TODO
    }
```

## chapter_27:字符串的排列

**描述:** 输入一个字符串,打印出该字符串中字符的所有排列.
```java
    public void permutation(String str) {
        //TODO
    }
```

## chapter_28:数组中出现次数超过一半的数组

**描述:** 数组中有一个数字出现次数超过数组长度的一半,请找出这个数字.例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}.2出现的次数超过数组长度的一半，因此输出2.
```java
    public Integer moreThanHalfNum(int[] array) {
        //TODO
    }
```

## chapter_29:最小的k个数

**描述:** 输入n个整数,找出其中最小的k个数.例如输入4,5,1,6,2,7,3,8这8个数字,则最少的4个数字是1,2,3,4.
```java
    public void getLeastNumbers(int[] array, int k) {
        //TODO
    }
```

## chapter_30:连续子数组的最大和

**描述:** 输入一个整型数组,数组里有正数也有负数.数组中一个或连续的多个整数组成一个子数组.求所有子数组的和的最大值.要求时间复杂度为O(n).例如输入的数组为{1,-2,3,10,-4,7,2,-5},和最大的子数组为{3,10,-4,7,2}.
```java
    public int findGreatestSubArray(int[] array) {
        //TODO
    }
```

## chapter_31:从1到n整数中1出现的次数

**描述:** 输入一个整数n,求从1到n这n个整数的十进制表示中1出现的次数.例如输入12,这些整数中包含1的数字有1,10,11,12,1一共出现了5次.
```java
    public long countOne(long n) {
        //TODO
    }
```

## chapter_32:把数组排成最小的数

**描述:** 输入一个正整数数组,把数组里所有数字拼接起来排成一个数,打印能拼接出的所有数字的最小的一个.例如输入{3,32,321},则打印最小的数字是321323.
```java
    public static void printMin(int[] array) {
        //TODO
    }
```

## chapter_33:丑数

**描述:** 我们把只包含因子2,3,和5的称为丑数.求按从小到大的顺序的第1500个丑数.例如6、8都是丑数,但14不是,因为它包含因子7.习惯上我们把1当做第一个丑数.
```java
    public static int getUglyNumber(int n) {
        //TODO
    }
```

## chapter_34:第一个只出现一次的字符

**描述:** 在字符串中找出第一个只出现一次的字符.如果输入"abaccdeff",则输出'b'.
```java
    public static Character firstNotRepeatChar(String str) {
        //TODO
    }
```

## chapter_35:数组中的逆序对

**描述:** 在数组中的两个数字如果前一个数字大于后一个数字,则这两个数字组成一个逆序对.输入一个数组,求出这个数组的逆序对的总数.例如在数组{7,5,6,4}中,一共存在5个逆序对,分别是(7,6)、(7,5)、(7,4)、(6,4)、(5,4).
```java
    public int inversePairs(int[] array) {
        //TODO
    }
```

## chapter_36:两个链表的第一个公共结点

**描述:** 输入两个链表,找出它们的第一个公共结点.
```java
    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        //TODO
    }
```

## chapter_37:数字在排序数组中出现的次数

**描述:** 统计一个数字在排序数组中出现的次数.例如输入排序数组{1,2,3,3,3,3,3,4,5}和数字3,由于3在这个数组中出现了4次,因此输出4.
```java
    public int getNumberOfK(int[] array, int k) {
        //TODO
    }
```

## chapter_38:二叉树的深度

**描述:** 题目一:输入一棵二叉树的根结点,求该树的深度.从根结点到叶结点依次经过的结点(含根、叶结点)形成树的一条路径,最长路径的长度为树的深度.
```java
    public int treeDepth(BinaryTreeNode root) {
        //TODO
    }
```

**描述:** 题目二:输入一棵二叉树的根结点,判断该树是不是平衡二叉树.如果某二叉树中任意结点的左右子树的深度相差不超过1,那么他就是一棵平衡二叉树.
```java
    public boolean isBalanced(BinaryTreeNode root) {
        //TODO
    }
```

## chapter_39:数组中只出现一次的数字

**描述:** 一个整型数组里除了两个数字之外,其他的数字都出现了两次.请写程序找出这两个只出现一次的数字.要求时间复杂度是O(n),空间复杂度为O(1).
```java
    public void findNumsAppearOnce(int[] array) {
        //TODO
    }
```

## chapter_40:和为s的两个数字VS和为s的连续正数序列

**描述:** 题目一:输一个递增排序的数组和一个数字s,在数组中查找两个数使得它们的和正好是s.如果有多对数字的和等于s,输出任意一对即可.例如:输入数组{1,2,4,7,11,15}和数字为15.输出4和11.
```java
    public boolean findNumberWithSum(int[] data, int sum) {
        //TODO
    }
```

**描述:** 题目二:输入一个正数s,打印出所有和为s的连续正数序列(至少含两个数).例如输入15,由于1+2+3+4+5=4+5+6=7+8=15,所以结果打印出3个连续序列1-5、4-6和7-8.
```java
    public void findContinuesSequence(int sum) {
        //TODO
    }
```