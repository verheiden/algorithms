package com.example;

import java.util.ArrayList;

public class reverseBit {
    public static void main(String[] args){
        reverseBit obj = new reverseBit();
        System.out.println(obj.reverse(3));

    }
    public long reverse(long a)
    {

        for( int i = 0; i <= 15; i++) {
            long right  = (0x1<<i);
            long left = (0X1<<(31-i));
            long rightBit = a & right ;
            long leftBit = a & left ;
            long ans;
            if ((leftBit == rightBit)/*0*/ || ((rightBit == right) && (leftBit == left))/*1*/) {
                left >>= 1;
                right <<= 1;
                continue;
            }
            if ((rightBit == 0) && (leftBit != 0)) {
                a &= (~left);
                a |= right;
            } else if ((rightBit != 0) && (leftBit == 0)) {
                a |= left;
                a &= (~right);
            }
            left = left >> 1;
            right = right << 1;
        }
        return a&0xffffffff;
    }
}
