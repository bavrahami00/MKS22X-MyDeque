public class MyDeque<E> {
  private E[] data;
  private int size;
  private int start;
  private int end;
  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
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
      int[] temp = new int[2*data.length+1];
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
      int[] temp = new int[2*data.length+1];
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

  }
  public E removeLast(){

  }
  public E getFirst(){

  }
  public E getLast(){

  }
}
