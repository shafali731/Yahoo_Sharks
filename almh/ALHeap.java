/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /*****************************************************
   * default constructor  ---  inits empty heap
   *****************************************************/
  public ALHeap()
  {
      _heap = new ArrayList<Integer>();
  }



  /*****************************************************
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   *****************************************************/
  public String toString()
  {
      String retStr = "";
      int level = 1;
      for (int i = 0; i < _heap.size(); i++) {
	  if(i == Math.pow(2,level) - 1) {
	      retStr += "\n";
	      level++;
	  }
	  retStr += _heap.get(i) + " ";
      }
      return retStr + "\n";
  }//O(n)


  /*****************************************************
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   *****************************************************/
  public boolean isEmpty()
  {
      return _heap.isEmpty();
  }//O(1)


  /*****************************************************
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
  public Integer peekMin()
  {
      return _heap.get(0);
  }//O(1)


  /*****************************************************
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * Algorithm:
   * Insert the Integer at the end of the arrayList
   * Keep moving up the tree (aka. swap with the parent node) if it's less
   * Repeat the previous step until the Integer reaches the root or it is bigger than the parent
   *****************************************************/
  public void add( Integer addVal )
  {
      if(_heap.size() == 0) {
	  _heap.add(addVal);
      }

      _heap.add(addVal); //insert integer at the end
      int current = _heap.size() - 1;

      //keep swapping when current is less than parent
      while(addVal < _heap.get((current - 1) / 2)) {  //thanks coiffe
	  swap(current , (current - 1) / 2);
	  current = (current - 1) / 2;
      }


  }//O(logn)


  /*****************************************************
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * Algorithm:
   * Replace the last value in the ArrayList with the first value. We wanted to swap the root with the last element because that costs minimum run time O(1) if we were to remove it
   * Remove the last value (aka. the original root)
   * Keep on comparing and swapping the current root with the children nodes.
           If bigger than child, keep traversing down
           If smaller than child, algorithm ends
   *****************************************************/
  public Integer removeMin()
  {
    if ( isEmpty() )
  	    return null;

    Integer ret = peekMin();

    Integer temp = _heap.get( _heap.size() - 1);
  	swap( 0, _heap.size() - 1 );
  	_heap.remove( _heap.size() - 1);

  	int pos = 0;
  	int minC;

  	while( pos < _heap.size() ) {
  	    minC = minChildPos(pos);
  	    if ( minC == -1 ) {
  		      break;
  	    }
  	    else if ( temp <= _heap.get(minC) ){
  		      break;
  	    }
  	    else {
  		      swap( pos, minC);
  		        pos = minC;
  	    }
  	}
  	return ret;

  }//O(logn)


  /*****************************************************
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int minChildPos( int pos )
  {
    int ret;
    int lc = 2*pos + 1;
    int rc = 2*pos + 2;

    if ( pos >= _heap.size() || pos < 0 ){
      ret = -1;
    }
    else if (lc >= _heap.size()){
      return -1;
    }
    else if ( rc >= _heap.size() ){
      ret = lc;
    }
    else if (lc>= _heap.size()){
      ret = rc;
    }
    else if ( _heap.get(rc) < (_heap.get(lc)) ){
      ret = rc;
    }
    else{
      ret = lc;
    }
    return ret;
  }//O(1)


  //************ aux helper fxns ***************
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
	    return a;
    else
	    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //********************************************



  //main method for testing
  public static void main( String[] args )
  {

      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);


      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
