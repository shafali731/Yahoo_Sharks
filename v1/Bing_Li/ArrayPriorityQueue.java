/*
  Team Yahoo Search -- Bing Li, Lily Yan
  APCS2 pd1
  HW46 -- Arrr, There Be Priorities Here Matey
  2018-05-09
*/

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
    //instance vars
    private int _size;
    private ArrayList<String> _data;

    //constructor
    public ArrayPriorityQueue() {
	_size = 0; //queue is empty at birth
	_data = new ArrayList<String>();
    }

    //~~~~~~~~~~~~ API methods ~~~~~~~~~~~~~~~~~
    public void add(String x) {
        _data.add(x);
	_size += 1;
    }

    public boolean isEmpty() {
	return (_size == 0);
    }

    public String peekMin() {
	String min = _data.get(0);
	for (String s: _data) {
	    if (s.compareTo(min) < 0) min = s;
	}
	return min;
    }

    public String removeMin() {
	int minIndex = 0;
	for (int ctr = 0; ctr < _size; ctr ++) {
	    if (_data.get(ctr).compareTo(_data.get(minIndex)) < 0) minIndex = ctr;
	}
	_size -= 1;
	return _data.remove(minIndex);
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //toString
    public String toString() {
	String retStr = "FRONT-->";
	for (String s: _data) retStr += s + "-->";
	retStr += "END";
	return retStr;
    }
    
    //main
    public static void main(String[] args) {
	System.out.println("\nInitializing ArrayPriorityQueue lobster...");
	ArrayPriorityQueue lobster = new ArrayPriorityQueue();

	System.out.println("Is lobster empty?: " + lobster.isEmpty());

	System.out.println("\n\nFilling up lobster...");

	lobster.add("the");
	lobster.add("quick");
	lobster.add("brown");
	lobster.add("fox");
	lobster.add("zooped");
	lobster.add("over");
	lobster.add("the");
	lobster.add("zany");
	lobster.add("dog");

	System.out.println("\nLobster: " + lobster);
	System.out.println("Is lobster empty?: " + lobster.isEmpty());

	System.out.println("\n\nEmptying lobster...");
	while (! lobster.isEmpty()) {
	    System.out.println("\nCurrent minimum: " + lobster.peekMin());
	    System.out.println("Element removed: " + lobster.removeMin());
	    System.out.println("State of lobster: " + lobster);
	}

	System.out.println("\nIs lobster empty?: " + lobster.isEmpty());   
	   
    }
}
