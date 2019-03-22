public class ArrayStack <T> implements Stack <T>{
	private int length =10;
	private Object [] temp1;
	private T[] arr;
	private int last;

	public ArrayStack (){
		// casting our temporary object array into an array of our type (because we cant create generic arrays)
		temp1 = new Object[length];
		arr= (T[])temp1;
		last= -1;
	}

/////////////////////////////////////////////////////////////////////////////////

	public T peek (){
		if (empty()  == true){
			return null;
		}
		return arr[last];
	}

/////////////////////////////////////////////////////////////////////////////////

	public boolean empty(){
		// checks if stack is empty

		if (last == -1){ // which is true when the topmost element is set to -1
			return true;
		}
		return false;
	}

/////////////////////////////////////////////////////////////////////////////////

	public void push (T element){
		if (last == arr.length-1){
			expandArray(); // helper function that deals with expanding the arr function (no arguments needed)
		}

		arr[++last] = element; // increments the topmost element location and sets its value to the new element

	}
/////////////////////////////////////////////////////////////////////////////////

	public T pop (){ // removes last element from stack

		if (empty()){ 

			return null;
		}
		return arr[last--]; //returns element removed from stack then decrements the index that refers to our last element in stack
	}

/////////////////////////////////////////////////////////////////////////////////

	private void expandArray (){

		// casting our temporary object array into an array of our type (because we cant create generic arrays)
		Object [] temp2 = new Object [arr.length*2];
		T[] newTemp = (T[]) temp2;


		for (int index=0; index<arr.length;index++){
			newTemp[index] = arr[index];
		}

		// this makes our previous array point to the expanded array
		arr = newTemp;
	}

}




