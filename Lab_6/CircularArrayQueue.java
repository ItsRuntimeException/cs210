//********************************************************************
//  CircularArrayQueue.java       Authors: Lewis/Chase
//  Modifed for CS210 by Bob Wilson - 7/31/2006
//
//  Represents an array implementation of a queue in which the
//  indexes for the front and rear of the queue circle back to 0
//  when they reach the end of the array.
//********************************************************************

public class CircularArrayQueue<T> implements QueueADT<T>
{
  private static final int DEFAULT_CAPACITY = 100;
  private int front, rear, count;
  private T[] queue; 
  
  /******************************************************************
    Creates an empty queue using the default capacity.
  ******************************************************************/
  public CircularArrayQueue()
  {
    this(DEFAULT_CAPACITY);
  }
  
  /******************************************************************
    Creates an empty queue using the specified capacity.
  ******************************************************************/
  public CircularArrayQueue (int initialCapacity)
  {
    queue = (T[]) new Object[initialCapacity];
    front = rear = count = 0;
  }
  
  /******************************************************************
    Adds the specified element to the rear of this queue, expanding
    the capacity of the queue array if necessary.
  ******************************************************************/
  public void enqueue (T element)
  {
    if (size() == queue.length)
    {
        expandCapacity();
    }
    queue[rear] = element;
    rear = (rear + 1) % queue.length;
    count++;
    // Possible to uncomment this line for debugging:
    // System.out.println("Enqueue: front=" + front + " rear=" + rear + " count=" + count);
  }
  
  /******************************************************************
    Removes the element at the front of this queue and returns a
    reference to it. Throws an EmptyCollectionException if the
    queue is empty.
  ******************************************************************/
  public T dequeue() throws EmptyCollectionException
  {
    if (isEmpty())
      throw new EmptyCollectionException("queue");
    
    // else if not empty, modify code to remove and return proper element reference
    T temp = queue[front];
    queue[front] = null;
    front = (front + 1) % queue.length;
    count--;
    // Possible to uncomment this line for debugging:
    // System.out.println("Dequeue: front=" + front + " rear=" + rear + " count=" + count);
    return temp;
  }
  
  /******************************************************************
    Returns a reference to the element at the front of this queue.
    The element is not removed from the queue.  Throws an
    EmptyCollectionException if the queue is empty.  
  ******************************************************************/
  public T first() throws EmptyCollectionException
  {
    if (isEmpty())
      throw new EmptyCollectionException("queue");
    
    // else if not empty, modify code to return an alias of proper element reference
    return queue[front];
  }
  
  /******************************************************************
    Returns true if this queue is empty and false otherwise. 
  ******************************************************************/
  public boolean isEmpty()
  {
    return count == 0;  
  }
  
  /******************************************************************
    Returns the number of elements currently in this queue.
  ******************************************************************/
  public int size()
  {
    return count;    
  }
  
  /******************************************************************
    Returns a string representation of this queue. 
  ******************************************************************/
  public String toString()
  {
    // not yet implemented
    return "";
  }

  /******************************************************************
    Creates a new array to store the contents of this queue with
    twice the capacity of the old one.
  ******************************************************************/
  private void expandCapacity()
  {
    T[] expand = (T[]) new Object[queue.length*2];
    
    for(int i = 0; i < count; i++)
    {
        expand[i] = queue[front];
        front = (front + 1) % queue.length;
    }
    front = 0;
    rear = count;
    queue = expand;
  }
}