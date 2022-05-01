package com.Lab3Solution1.controller;

import java.util.Stack;

public class BalancingBrackets{
    public static void main(String[] args) {
        String input = "( [ [ { } ] ] ) )";
        //"( [ [ { } ] ] )" e.g. balanced

        if(checkBalancedBrackets(input)){
            System.out.println("The entered String has Balanced Brackets");
        }
        else{
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }

    static boolean checkBalancedBrackets(String bracketExpression) {
        Stack<Character> expresstionStack = new Stack<>();

        for (int i = 0; i < bracketExpression.length(); i++) {
            char expch = bracketExpression.charAt(i);
            if (expch == '[' || expch == '{' || expch == '(') {
                expresstionStack.push(expch);
                continue;
            }
            if (expresstionStack.isEmpty())
                return false;

            char tempch;
            switch (expch) {
                case '}':
                    tempch = expresstionStack.pop();
                    if (tempch == '(' || tempch == '[') {
                        return false;
                    }
                    break;
                case ')':
                    tempch = expresstionStack.pop();
                    if (tempch == '{' || tempch == '[') {
                        return false;
                    }
                    break;
                case ']':
                    tempch = expresstionStack.pop();
                    if (tempch == '{' || tempch == '(') {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }

        return expresstionStack.isEmpty();
    }
}