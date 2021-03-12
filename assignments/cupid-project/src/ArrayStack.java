
/**
 * Implements stack using an array
 * @author Justin Yan
 *
 * @param <T>
 */

public class ArrayStack <T> implements ArrayStackADT<T>{
	private T[] stack; // stores data items
	private int top; // stores position of last data item; initialized to -1
	
	public static String sequence; // tracks arrow path

/**
 * Default constructor creates new array stack of size 14
 * Sets top = -1
 */
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		this.stack = (T[]) new Object[14]; //upcast from Object
		this.top = -1; // indicates empty stack
		sequence = "";
	}
	
	/**
	 * Constructor creates empty stack of length parameter
	 * @param initialCapacity
	 */
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		this.stack = (T[]) new Object[initialCapacity]; //upcast from Object
		this.top = -1;	// indicates empty stack		
		sequence = "";
	}
	
/**
 * Adds dataItem to top of stack, increases size if full stack
 * Will consider 2 cases, one for small stacks and another for larger stacks
 * @param T dataItem to add to top of stack
 */
	@SuppressWarnings("unchecked")
	@Override
	public void push(T dataItem) {
		T[] newStack; //temporary stack
		
		if(stack.length < 50 && (stack[stack.length - 1] != null)) { // checks if stack is smaller than 50 in size
			newStack = (T[])(new Object[stack.length + 10]); // creates new stack with additional capacity of 10
			
			for (int a = 0; a < stack.length; a++) {// assigns old elements in array to new array in same spots
				newStack[a] = stack[a];
			}
			stack = newStack;	// stack will point to the new, bigger stack created
		}
		
		
		if (stack.length >= 50 && (stack[stack.length - 1] != null)) {// checks if stack greater than 50
			newStack = (T[])(new Object[stack.length * 2]);	// creates new stack with doubled capacity
			
			for (int b = 0; b < stack.length; b++) {// copies over all old elements
				newStack[b] = stack[b];
			}
			stack = newStack;	// stack will point to the new, bigger stack created
		}
		
		// checks to see if amount of elements in stack is less that the stack capacity
		if (top + 1 < stack.length) {
			stack[top + 1] = dataItem;		// adds the element dataItem on top of stack
			top++;
		}
		
		if (dataItem instanceof MapCell) {

			sequence += "push" + ((MapCell)dataItem).getIdentifier();
		}
		else {
			sequence += "push" + dataItem.toString();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * removes and returns dataItem at top of stack
	 * @return dataItem
	 */
	public T pop() throws EmptyStackException {
		T[]newStack;
		
		if (isEmpty()) {
			throw new EmptyStackException("Error: empty stack.");
		}
		
		T result = this.stack[top]; 
		this.stack[top] = null;
		top --;
		
		if((this.size()< (stack.length / 4)) && (stack.length / 2 >= 14)){// reduces size if array is less than 25% full
			newStack = (T[])(new Object[(stack.length/2)]);	// creates new stack with half capacity of old stack
			
			for (int a = 0; a < newStack.length; a ++) {
				newStack[a] = stack[a];
			}
			stack = newStack;	// stack will point to the new, bigger stack created
		}
		else if((this.size() < (0.25 * this.length())) && (14 < this.length() && this.length() < 28)){// reduces size if array is less than 25% full
			newStack = (T[])(new Object[14]);	// creates new stack with 14 capacity
			
			for (int a = 0; a < newStack.length; a ++) {
				newStack[a] = stack[a];
			}
			stack = newStack;	// stack will point to the new, bigger stack created
		}
		
		
		if (result instanceof MapCell) {
			sequence += "pop" + ((MapCell)result).getIdentifier();
		}
		else {
			sequence += "pop" + result.toString();
		        }
		return result;		
	}
	

	/**
	 * @return item at top of stack
	 */
	@Override
	public T peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Error: empty stack.");
		}
		return stack[this.top];
	}

	@Override
	/**
	 * @return boolean if stack is empty or not
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.stack[0] == null);
	}

	@Override
	/**
	 * @return number of elements in stack
	 */
	public int size() {
		return this.top + 1;
	}
	
	
	/**
	 * 
	 * @return capacity of array stack
	 */
	public int length() {
		return this.stack.length;
	}
	
	/**
	 * @return String representation of stack
	 */
	@Override
	public String toString() {
		String toString = "Stack: ";
		
		// converts all the elements in the stack to a string
		for (int d = 0; d < stack.length; d ++) {
			if(d + 1 == stack.length) {
				toString = toString + stack[d];
			}
			else if (d + 1 < stack.length) {
				toString = toString + stack[d] + ", ";
			}
		}		
		return toString;		
	}
}
