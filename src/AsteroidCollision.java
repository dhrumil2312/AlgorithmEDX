import java.util.Stack;

public class AsteroidCollision {


    public static void main(String[] args) {
        int[] asteroids = {-2 , -1 , 2,1};

        Stack<Integer> stack = new Stack<>();

        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        for(int i : stack) System.out.print(i);

    }
}
