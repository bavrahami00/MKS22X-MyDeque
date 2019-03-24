import java.util.NoSuchElementException;
public class MyDeque<E> {
  private E[] data;
  private int size;
  private int start;
  private int end;
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = 0;
    end = 0;
    size = 0;
  }
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start = 0;
    end = 0;
    size = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String ans = "{";
    for (int x = 0; x < size; x++) {
      ans += data[(x+start)%data.length] + " ";
    }
    ans += "}";
    return ans;
  }
  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (size == data.length) {
      E[] temp = (E[])new Object[2*data.length+1];
      for (int x = 0; x < data.length; x++) {
        temp[x+1] = data[(x+start)%data.length];
      }
      start = 1;
      end = data.length;
      data = temp;
    }
    data[(start+data.length-1)%data.length] = element;
    start = (start+data.length-1)%data.length;
    size++;
  }
  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (size == data.length) {
      E[] temp = (E[])new Object[2*data.length+1];
      for (int x = 0; x < data.length; x++) {
        temp[x] = data[(x+start)%data.length];
      }
      start = 0;
      end = data.length;
      data = temp;
    }
    data[end] = element;
    end = (end+1+data.length)%data.length;
    size++;
  }
  public E removeFirst(){
    try {
      start = (start+1+data.length)%data.length;
      size--;
      return data[(start-1+data.length)%data.length];
    }
    catch (NullPointerException a) {
      throw new NoSuchElementException();
    }
  }
  public E removeLast(){
    try {
      end = (end-1+data.length)%data.length;
      size--;
      return data[(end+1+data.length)%data.length];
    }
    catch (NullPointerException a) {
      throw new NoSuchElementException();
    }
  }
  public E getFirst(){
    try {
      return data[start];
    }
    catch (NullPointerException a) {
      throw new NoSuchElementException();
    }
  }
  public E getLast(){
    try {
      return data[end];
    }
    catch (NullPointerException a) {
      throw new NoSuchElementException();
    }
  }
}
