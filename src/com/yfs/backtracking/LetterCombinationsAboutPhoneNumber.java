package com.yfs.backtracking;

import java.util.*;

/**
 * 题号:[17]
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsAboutPhoneNumber {
    private static Map<String, List<String>> map;


    static {
        map = new HashMap<>();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
    }


    public static void main(String[] args) {
        while (true){

            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            System.out.println(getLetterCombinationsAboutPhoneNumber(s));
        }
    }

    public static List<String> getLetterCombinationsAboutPhoneNumber(String digits) {
        ArrayList<String> res = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();

        //  非空校验
        if (digits == null || digits.length() == 0) {
            return res;
        }

        //  输入合法性校验
        String[] strings = digits.split("");
        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i])) {
                return res;
            }
        }

        backTracking(strings, 0, buffer,res);

        return res;
    }

    /**
     *  @param arr 输入参数
     * @param index 遍历到第几个输入的数字（树的第几层）
     * @param buffer 用于暂存遍历树的路径（也可以定义为全局）
     * @param res
     */
    private static void backTracking(String[] arr, Integer index, StringBuffer buffer, ArrayList<String> res) {
        if (buffer.length() == arr.length) {
            res.add(buffer.toString());
            return;
        }

        for (int j = 0; j < map.get(arr[index]).size(); j++) {
            buffer.append(map.get(arr[index]).get(j));
            backTracking(arr, index + 1, buffer, res);
            buffer.delete(buffer.length() - 1, buffer.length());
        }
    }
}
