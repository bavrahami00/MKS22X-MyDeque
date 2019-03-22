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
  }
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start = 0;
    end = 0;
  }
  public int size(){
    return (data.length+end-start)%data.length+1;
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
  }
  public void addLast(E element){
    if (size == data.length) {
      E[] temp = (E[])new Object[2*data.length+1];
      for (int x = 0; x < data.length; x++) {
        temp[x] = data[(x+start)%data.length];
      }
      start = 0;
      end = data.length;
      data = temp;
    }
    data[(start+1)%data.length] = element;
  }
  public E removeFirst(){
    start = (start+1+data.length)%data.length;
    return data[(start-1+data.length)%data.length];
  }
  public E removeLast(){
    end = (end-1+data.length)%data.length;
    return data[(end+1+data.length)%data.length];
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
}
