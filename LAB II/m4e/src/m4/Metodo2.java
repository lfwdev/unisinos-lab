package m4;

import java.util.Stack;

public class Metodo2 {

    public static void main(String[] args){
        // examples turned into char stack and tested with checkbrackets
        test(charfy("A+B("), "Eq0 should evaluate to false");
        test(charfy("((A+B)"), "Eq1 should evaluate to false");
        test(charfy("((A+B)-(C+D))"), "Eq2 should evaluate to true");
        test(charfy("(A+B)) – (C+D"), "Eq3 should evaluate to false");
        test(charfy(")A+B(-C"), "Eq4 should evaluate to false");
    }

    public static void test(Stack charStack, String id) {
        Metodo2 met2 = new Metodo2();
        System.out.printf("%s %s. Result: %s \n",id,charStack.toString(),met2.checkBrackets(charStack));
    }
    
    public static Stack<Character> charfy(String eq) {
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < eq.length(); i++)
        {
            charStack.push(eq.charAt(i));
        }
        return charStack;
    }

    public boolean checkBrackets(Stack s1){
        
        int open = 0;
        int close = 0;
        int hasClosed = 0;

        while(!s1.empty()){
            Object value = s1.pop();
            // check for closing
            if (value.equals(')')) {
                // remember that we have a closed parenthesis
                hasClosed++;
                close++;
            } else if (value.equals('(')) { // check for opening
                // check for rule 2 
                if (hasClosed <= 0) 
                { 
                    return false; 
                } 
                open++;
                hasClosed--;
            }
        }
        return (open == close);
    }
}
