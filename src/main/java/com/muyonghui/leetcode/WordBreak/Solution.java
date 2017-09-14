package com.muyonghui.leetcode.WordBreak;

/*
* Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences.
For example, given
s ="catsanddog",
dict =["cat", "cats", "and", "sand", "dog"].
A solution is["cats and dog", "cat sand dog"].
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public  ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> lists = new ArrayList<String>();
        ArrayList<String> strings = new ArrayList<String>();
        int len = s.length();
        dfs(s,len,dict,lists,strings);
        return lists;

    }

    public  void dfs(String s,int len,Set<String> dict, ArrayList<String> lists,ArrayList<String> strings) {
        if(len<=0){
            int size = strings.size()-1;
            StringBuilder sb = new StringBuilder();
            for(;size>=0;size--){
                sb.append(strings.get(size));
                if(size!=0)
                    sb.append(" ");
            }
            lists.add(sb.toString());
        }
        for(int k = len-1;k>=0;k--){
            if(dict.contains(s.substring(k,len))){
                strings.add(s.substring(k,len));
                dfs(s,k,dict,lists,strings);
                strings.remove(strings.size()-1);
            }
        }

    }
}
