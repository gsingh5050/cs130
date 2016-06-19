package lists;
/**
 * <p>Title: OrderedListADT.java</p>
 *
 * <p>Description: Defines the interface to an ordered list collection. Only
 * Comparable elements are stored, kept in the order determined by
 * the inherent relationship among the elements.</p>
 *
 */
public interface OrderedListADT<E> extends ListADT<E>
{
   /** Adds the specified item to this list at the proper location */
   public void add (E item);
}

