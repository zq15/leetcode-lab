package com.zds.leetcode.hash;

import java.util.*;
import java.util.stream.Collectors;

public class T49 {
    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"", ""};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println();
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        // 把单词拆成 字母 -> 次数 的 Map
        List<Map.Entry<String, Map<Character, Integer>>> strMapList = Arrays.stream(strs).toList().stream()
                .map(str -> new AbstractMap.SimpleEntry<>(str, strToMap(str)))
                .collect(Collectors.toList());

        Map<Map<Character, Integer>, List<String>> tempMap = new HashMap<>();

        for (Map.Entry<String, Map<Character, Integer>> stringMapEntry : strMapList) {
            String key = stringMapEntry.getKey();
            Map<Character, Integer> innerMap = stringMapEntry.getValue();

            if (!tempMap.containsKey(innerMap)) {
                tempMap.put(innerMap, new ArrayList<>());
            }
            tempMap.get(innerMap).add(key);
        }

        return new ArrayList<>(tempMap.values());
    }

    private static Map<Character, Integer> strToMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        // 处理空字符串
        if (str.isEmpty()){
            map.put(null, 1);
            return map;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer time = map.get(c);
            if (null != time) {
                map.put(c, ++time);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
