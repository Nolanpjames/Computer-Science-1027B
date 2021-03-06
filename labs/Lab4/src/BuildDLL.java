
public class BuildDLL {
	
	DoubleLinkedNode<Character> front, rear;
	private static char[] letters = new char[] {'K', 'T', 'E', 'N', 'P', 'A', 'L'};

	public BuildDLL () {
		build();
	}
	
	

	public void remove (Character elem) {

		// Add code in here to remove the node with the given value.
		DoubleLinkedNode<Character> temporary = null;
		if(front.getElement() == elem) {
			temporary = front;
			front = front.getNext();
			front.setPrevious(null);
		}
		else if(rear.getElement() == elem) {
			temporary = rear;
			rear = rear.getPrevious();
			rear.setNext(null);
		}
		else {
			DoubleLinkedNode<Character> currentOne = front.getNext();
			while(currentOne!=null){
				if(currentOne.getElement()==elem){
					temporary = currentOne;
					break;
				}
				currentOne = currentOne.getNext();
			}
			if(temporary!=null){
				temporary.getPrevious().setNext(temporary.getNext());

				temporary.getNext().setPrevious(temporary.getPrevious());

			}else{
				System.out.println("\nValue is already present");
			}
		}
	}
	
	
	private void build () {
		DoubleLinkedNode<Character> pnode, node;
		
		node = new DoubleLinkedNode<Character>(letters[0]);
		pnode = front = node;
		for (int i = 1; i < 7; i++) {
			node = new DoubleLinkedNode<Character>(letters[i]);
			pnode.setNext(node);
			node.setPrevious(pnode);
			pnode = node;
		}
		rear = node;
	}
	
	public DoubleLinkedNode<Character> getFront () {
		return front;
	}
	
	public DoubleLinkedNode<Character> getRear () {
		return rear;
	}
	
	public void printF (DoubleLinkedNode<Character> node) {
		
		DoubleLinkedNode<Character> curr = front;
		while (curr != null) {
			System.out.print(curr.getElement() + " ");
			curr = curr.getNext();

		}
		System.out.print("\n");
	}
	
	
	public static void main (String[] args) {
		BuildDLL dll = new BuildDLL();

		System.out.println("Original List:");
		dll.printF(dll.getFront());
		System.out.println("***");
		
		System.out.println("Removing an internal node:");
		dll.remove('N');
		dll.printF(dll.getFront());
		System.out.println("***");

		System.out.println("Removing the front node:");
		dll.remove('K');
		dll.printF(dll.getFront());
		System.out.println("***");
		
		System.out.println("Removing the rear node:");
		dll.remove('L');
		dll.printF(dll.getFront());
		System.out.println("***");
	}

}
