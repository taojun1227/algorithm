package com.jt.learn.string;

import java.util.Scanner;

/**
 * <p>Title: Test1 </p>
 *
 * <p>Description:  输入一个字符串首尾相连，计算出现“o”为偶数次，最长字符串的长度</p>
 * <p>Description:  如：lopokbcko 为kbckolop 最长为7</p>
 * <p>Company: </p>
 *
 * <p>date: 2020/9/30 14:09 </p>
 *
 * @author: jt-ape
 */
public class Test1 {
    static String o = "o";

    static  int findCount(String source) {
        int index=0;
        int i = 0;
        while (( index = source.indexOf(o, index))!=-1){
            i++;
            index = index +1 ;
        }
        return i;

    }

    static int findLength(String s) {
        int count = findCount(s);
        if (count ==0) return s.length();
        if(count==1) return s.length()-1;
        int maxCount = count%2==0?count:count-1;//字符串中出现的最大偶数次数
        char[] chars = s.toCharArray();
        char oC = o.charAt(0);
        int length =0; //字符串长度
        for(int j =0;j<s.length();j++){
            int fori = 0;
            int oCount = 0; //o出现的次数
            for(int i=j;i<s.length();i++) {
                if(oC== chars[i])oCount++;
                if(oCount==maxCount+1)break;
                fori++;
                if(i==s.length()-1)i=-1;
            }
            length = fori>length?fori:length;
        }
        return length;
    }
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        while(true) {
            String s = scanner.nextLine();
            System.out.println(findLength(s));
        }

    }
}
