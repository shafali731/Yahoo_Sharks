//Team Sharks
//APCS2 pd 01
//HW46 -- ArrayPriorityQueue
//2018-05-09

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{
  int _size;
  ArrayList arr;

  //constructor
  public ArrayPriorityQueue(){
    _size=0;
    arr= new ArrayList();
  }

  public void add(String x){
    if(_size == 0) {
      arr.add(x);
    }
    for (int i =0; i<_size; i++){
      if (x.compareTo( (String) arr.get(i))<0){
        arr.add(i, x);
      }
    }
    _size++;
  }

  public boolean isEmpty(){
    return _size==0;
  }

  public String peekMin(){
    return (String) arr.get(0);
    }

  public String removeMin(){
    return (String) arr.remove(0);
  }

  public static void main (String[] args){
    ArrayPriorityQueue a = new ArrayPriorityQueue();
    System.out.println(a.isEmpty());
    a.add("hello");
    a.add("leggo");
    a.add("bub");
    a.add("ah");
    System.out.println(a.peekMin());
    System.out.println(a.removeMin());

  }
}
