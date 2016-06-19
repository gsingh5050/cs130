package queues;

public class Testing2 {

	public static void main(String[] args) {


		CircularArrayQueue<Integer> caq = new CircularArrayQueue<Integer>();

		caq.enqueue(5);
		caq.enqueue(9);
		caq.enqueue(3);
		caq.enqueue(9);
		caq.enqueue(2);
		
		
		System.out.println(caq.toString());
		
		
		caq.dequeue();
		
		System.out.println(caq.toString());

		System.out.println(caq.countItem(9) + "\n\n" + caq.toString());

	}

}
