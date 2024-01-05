package com.yfs.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExpressionTranslation {
    private static final String OPERATOR_AND = "AND";
    private static final String OPERATOR_OR = "OR";
    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";

    public static void main(String[] args) {
        String str = "( 记录 OR 纪要 ) AND 投资者活动";
        String title = "2022同花顺投资者活动记录";
        Stack<String> expressionTranslationRes = expressionTranslation(str);
        boolean b = expressionCalculate(expressionTranslationRes, title);
        BiTreeNode res = buildBiTree(expressionTranslationRes);
    }

    private static BiTreeNode buildBiTree(Stack<String> s1) {
        Stack<BiTreeNode> s2 = new Stack<>();
        for (String s : s1) {
            if (OPERATOR_AND.equals(s) ){
                s2.push(new BiTreeNode(OPERATOR_AND,s2.pop(), s2.pop()));
            }else if (OPERATOR_OR.equals(s)){
                s2.push(new BiTreeNode(OPERATOR_OR,s2.pop(), s2.pop()));
            } else {
                s2.push(new BiTreeNode(s,null,null));
            }
        }
        return s2.pop();
    }

    private static boolean expressionCalculate(Stack<String> s1, String title) {
        Stack<Boolean> s2 = new Stack<>();
        for (String s : s1) {
            if (OPERATOR_AND.equals(s) ){
                s2.push(s2.pop() && s2.pop());
            }else if (OPERATOR_OR.equals(s)){
                s2.push(s2.pop() || s2.pop());
            } else {
                s2.push(title.contains(s));
            }
        }
        return s2.pop();
    }

    private static Stack<String> expressionTranslation(String str) {
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        String separator = " ";
        List<String> list = Arrays.asList(str.split(separator));
        for (String string : list) {
            switch (string) {
                case OPERATOR_AND:
                case OPERATOR_OR:
                    if (s1.empty()) {
                        s1.push(string);
                        break;
                    }
                    if (OPERATOR_OR.equals(s1.peek()) || OPERATOR_AND.equals(s1.peek())) {
                        s2.push(s1.pop());
                        s1.push(string);
                    } else {
                        s1.push(string);
                    }
                    break;
                case LEFT_BRACKET:
                    s1.push(string);
                    break;
                case RIGHT_BRACKET:
                    while (!s1.empty()) {
                        if (LEFT_BRACKET.equals(s1.peek())) {
                            s1.pop();
                            break;
                        } else {
                            s2.push(s1.pop());
                        }
                    }
                    break;
                default:
                    s2.push(string);
                    break;
            }
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        return s2;
    }

}
