import java.util.Stack;

class MinStack {
    Stack<Integer> min = new Stack<Integer>();
    Stack<Integer> num = new Stack<Integer>();
    public void push(int x) {
        if(min.isEmpty() || x<=min.peek()){
            min.push(x);
        } 
        num.push(x);
    }

    public void pop() {
        if(num.isEmpty()) return;
        if(num.peek().equals(min.peek())){
            min.pop();
        }
        num.pop();
    }

    public int top() {
        if(num.isEmpty()) return -1;
        return num.peek();
    }

    public int getMin() {
        if(min.isEmpty()){
            return -1;
        }
        return min.peek();
    }
    
    
    public static void main(String[] args){
    	MinStack ms = new MinStack();
    	ms.push(5);
    	ms.push(4);
    	ms.push(6);
    	ms.push(3);
    	ms.push(4);
    	ms.push(2);
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.getMin());
    }
}
