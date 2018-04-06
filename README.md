# 剑指offer刷题录(java)

## chapter_01:实现单例模式

- 懒汉模式
- 饿汉模式
- 双重校验锁
- 静态内部类

## chapter_02:二维数组的查找

**描述:** 一个二维数组,每一行从左到右递增,每一列从上到下递增.输入一个二维数组和一个整数,判断数组中是否含有整数.
```java
    public static boolean find(int[][] array, int number) {
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
    public static <T> void printListReverse(ListNode<T> node) {
        //TODO
    }
```

## chapter_05:重建二叉树

**描述:** 输入二叉树的前序遍历和中序遍历的结果,重建出该二叉树.假设前序遍历和中序遍历结果中都不包含重复的数字.
```java
    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
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
    public static long fibonacci(int n) {
        //TODO
    }
```

## chapter_09:二进制中1的个数

**描述:** 请实现一个函数,输入一个整数,输出该数二进制表示中1的个数.例如把9表示成二进制是1001;有2位是1,因此如果输入9,函数输出2.
```java
    public static int numberOfOne1(int n) {
        //TODO
    }
```

## chapter_10:数值的整数次方

**描述:** 实现函数`double Power（double base，int exponent）`,求base的exponent次方.不得使用库函数,同时不需要考虑大数问题.
```java
    public static double power(double base, int exponent) throws Exception {
        //TODO
    }
```