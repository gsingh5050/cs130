package lists;

public interface ListADT<T>
{
   //  Removes and returns the first element from this list
   public T removeFirst ();

   //  Removes and returns the last element from this list
   public T removeLast ();

   //  Removes and returns the specified element from this list
   public T remove (T element);

   //  Returns a reference to the first element on this list
   public T first ();

   //  Returns a reference to the last element on this list
   public T last ();

   //  Returns true if this list contains the specified target element
   public boolean contains (T target);

   //  Returns true if this list contains no elements
   public boolean isEmpty();

   //  Returns the number of elements in this list
   public int size();

   //  Returns a string representation of this list
   public String toString();
}
