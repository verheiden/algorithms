package com.example;

/*
 * Reverse the bits of a number.
 */
import java.util.ArrayList;

public class reverseBit {
    public static void main(String[] args){
        reverseBit obj = new reverseBit();
        System.out.println(" Answer is " + String.format("%x", obj.reverse(135)));

    }
    public int  reverse(long a)
    {

        for( int i = 0; i <= 15; i++) {
            long rightBitMask  = (0x1<<i);
            long leftBitMask = (0X1<<(31-i));
            long rightBit = a & rightBitMask ;
            long leftBit = a & leftBitMask ;
            long ans;
            if (((rightBit == 0) && ( leftBit == 0 )) || (( rightBit != 0 ) && ( leftBit != 0) )) /* they are same */
            {
                continue;  /* do not change */
            }
            else if (( rightBit == 0 ) && ( leftBit != 0 ))
            {
                a |= rightBitMask;
                a &= ~leftBitMask;
            }
            else if ((leftBit == 0 ) && (rightBit != 0))
            {
                a |= leftBitMask;
                a &= ~rightBitMask;
            }
        }
        return (int) ( a&0xffffffff );
    }
}
