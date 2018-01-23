import java.util.Stack;

public class Homework1 {

    public static Node Tonmai;
    public static Stack<Character> Tree = new Stack<Character>();

    public static void main(String[] args) {
        // Begin of arguments input sample
        if (args.length > 0) {
            String input = args[0];
            if (input.equalsIgnoreCase("251-*32*+")) {
                System.out.println("(2*(5-1))+(3*2)=14");
            }
        }
        // End of arguments input sample

        // TODO: Implement your project here
        String profix = args[0];
        for (int i = 0; i < profix.length(); i++) {
            Tree.add(profix.charAt(i));
        }

        Tonmai = new Node(Tree.pop());
        infix(Tonmai);
        inorder(Tonmai);
        System.out.print("=" + calculate(Tonmai));
    }


    public static void infix(Node A) {
        if (A.T_ree == '+' || A.T_ree == '-' || A.T_ree == '*' || A.T_ree == '/') {
            A.Right = new Node(Tree.pop());
            infix(A.Right);
            A.Left = new Node(Tree.pop());
            infix(A.Left);
        }
    }

    public static void inorder(Node B) {
        if (B.T_ree == '+' || B.T_ree == '-' || B.T_ree == '*' || B.T_ree == '/') {
            if (B != Tonmai) {
                System.out.print("(");
            }
            inorder(B.Left);
            System.out.print(B.T_ree);
            inorder(B.Right);
            if (B != Tonmai) {
                System.out.print(")");
            }
        } else {
            if (B != Tonmai) {
                System.out.print(B.T_ree);
            }
        }
    }


    public static int calculate(Node ccl) {
        if (ccl == null) {
            return 0;
        }
        if (ccl.T_ree == '+') {
            return calculate(ccl.Left) + calculate(ccl.Right);
        }
        if (ccl.T_ree == '-') {
            return calculate(ccl.Left) - calculate(ccl.Right);
        }
        if (ccl.T_ree == '*') {
            return calculate(ccl.Left) * calculate(ccl.Right);
        }
        if (ccl.T_ree == '/') {
            return calculate(ccl.Left) / calculate(ccl.Right);
        } else return Integer.parseInt(ccl.T_ree.toString());
    }
}

