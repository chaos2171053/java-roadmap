package org.example.array;

public class ReverseWords {
    // 解法一：先根据空格拆分字符串，再翻转
//    public String reverseWords(String s) {
//        String[] words = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int i = words.length-1; i >=0 ; i--) {
//            sb.append(words[i]);
//            if(i!=0){
//                sb.append(" ");
//            }
//        }
//        return  sb.toString();
//    }

//    解法二：先将整个字符串 s 反转：
//
//
//    s = "gnodalubal dlrow olleh"
//    然后将每个单词分别反转：
//
//
//    s = "labuladong world hello"
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        reverse(chars,0,chars.length-1);
        for (int i = 0; i < chars.length ; i++) {
            if(chars[i]==' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        // 反转最后一个单词
        reverse(chars, start, chars.length - 1);
        return new String(chars);
    }
    private void reverse(char[] chars, int start, int end) {
        while(start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
