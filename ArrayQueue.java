public class ArrayQueue <T> implements Queue <T>{
	private int length =10;
	private Object [] temp1;
	private T[] arr;
	private int head;
	private int tail;
	private int size;


	public ArrayQueue (){
		head =0;
		tail=0;
		size =0;

		// casting our temporary object array into an array of our type (because we cant create generic arrays)
		temp1 = new Object[length];
		arr= (T[])temp1;
		
	}

/////////////////////////////////////////////////////////////////////////////////

	public T dequeue (){
		if (empty()){
			return null;
		}

		T temp = arr[head]; 
		head = (head+1)%arr.length; // circular movement of head in the array (which removes the first element of the queue)
		size--; // decrement length of queue
		return temp;
	}

/////////////////////////////////////////////////////////////////////////////////

	public void enqueue (T type){
		if ((tail+1) %arr.length == head){ 
			expandArray(); 
		}
		arr[tail++] = type;
		tail = tail%arr.length; //moves the tail in circular motion (ensures that when it reaches end of array it goes to first index)
		size++; // increment length of queue
	}
/////////////////////////////////////////////////////////////////////////////////

	public boolean empty(){
		// checks if our queue is empty (when both head and tail are in the same position)
		if (head == tail){
			return true;
		}
		return false;
	}
/////////////////////////////////////////////////////////////////////////////////

	private void expandArray (){

		// casting our temporary object array into an array of our type (because we cant create generic arrays)
		Object [] temp2 = new Object [arr.length*2];
		T[] newTemp = (T[]) temp2;

		// checks if head is in a position before the tail
		if (head<tail){

			int j=0;
			for (int i = head; i<=head+tail;i++){
				newTemp[j++] = arr[i];
			}

			head =0; tail = size;
		} 

		else{ // else if tail is before or in the same position as the tail

			int j=0;
			for (int i = 0; i<=tail;i++){ // copy the elements from the beginning of the original array till the tail
				newTemp[j++] = arr[i];
			}
			for (int i = tail+1; i<=head;i++){ // copy the elements from the index after tail till the head
				newTemp[j++] = arr[i];
			}

			for (int i = head+1; i<arr.length;i++){ // then copy elements from the index after head till end of array
				newTemp[j++] = arr[i];
			}
		
			head=0; tail = size; 
		}
		arr = newTemp;
	}




}