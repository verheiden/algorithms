package com.example;

import java.util.ArrayList;
/* solutions to find the max set  by Jung Verheiden */

public class maxSet {

    static public void main(String[] args)
    {
/*        ArrayList<Integer> input = new ArrayList<>();
        input.add(-846930886);
        input.add(-1714636915);
        input.add(424238335);
        input.add(-1649760492);

        ArrayList<Integer> ans = new maxSet().maxset(input);
        for (int i : ans) {
            System.out.println(i);
        } */
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.right = c;
        a.left = b;
        c.left = d;
        c.right = e;
        int num = new maxSet().sumNumbers(a);
    }

    public int sumNumbers(TreeNode a) {
        if (a == null)
            return 0;

        return( sums(a, 0)%1003);
    }

    int sums(TreeNode a, int sum)
    {
        sum = sum*10 + a.val;
        if ((a.left == null) && (a.right == null)) {
            return sum;
        }
        return( sums(a.right, sum) +   sums(a.left, sum) );
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {

        long sum = 0;
        long biggest = -1;
        int start = 0;
        int end = 0;
        int bStart = 0;
        int bEnd = 0;
        while (start < a.size()) {
            sum = -1;
            end = start;
            while ((end < a.size()) && (a.get(end) >= 0)) {
                if (sum == -1)
                    sum = a.get(end);
                else
                    sum += (long) a.get(end);
                end++;
            }
            if (sum >= 0) {
                if (sum > biggest) {
                    bStart = start;
                    bEnd = end;
                    biggest = sum;
                } else if (sum == biggest) {
                    if ((end - start) > (bEnd - bStart)) {
                        bStart = start;
                        bEnd = end;
                    }
                }
            } else
                end++;
            start = end;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = bStart; i < bEnd; i++) {
            ans.add(a.get(i));
        }
        return ans;
    }

    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x)
        {
            val = x;
            left = null;
            right = null;
        }
    }
}
