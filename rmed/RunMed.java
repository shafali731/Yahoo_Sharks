/*****************************************************
 * Class runMed
 * calculates running median of input stream of Integers by using a min and max heap

 * Algorithm for RunMed:
 * 1. If nextValue < root of maxheap. Add to maxheap. Else: add to min heap
 * 2. Balance heaps if size difference >=  2: Remove from larger heap, add to smaller heap until balances
 * 3. at any find med by
       a. heap size equal: med is the mean of the roots
       b. heap size unequal: return root of max heap
 *****************************************************/

import java.util.ArrayList;
import java.util.*;

public class RunMed {

    //instance vars
    private ALHeapMax lilVals; //lilVals is a max heap even though it has smaller values, because if think mathematically, median is the max of the smaller half of the number set
    private ALHeapMin bigVals; //big Vals is a min heap with larger values because median is the min of the larger half of the number set

    //constructor
    public RunMed() {
	lilVals = new ALHeapMax();
	bigVals = new ALHeapMin();
    }

    //Returns medians in both heaps
    //throws NoSuchElementException if heaps are empty
    public Integer getMedian() {
	//if min heap is empty, no element was added yet, throw exception
	if(lilVals.isEmpty()) {
	    throw new NoSuchElementException("No medians can be found!");
	}
	//if both min and max are equal in # of nodes, return average of the root
	else if (lilVals.getSize() == bigVals.getSize()) {
	    return((lilVals.peekMax() + bigVals.peekMin()) / 2);
	}
	//if max heap has more values than min heap (usually the case),
	//then return the max of all the min values
	else if (lilVals.getSize() > bigVals.getSize()) {
	    return lilVals.peekMax();
	}
	return bigVals.peekMin();
    }

    //adds to the appropriate heap
    //balance the heap if size difference > 1 --> def of complete tree
    public void add(Integer newVal) {
      if (lilVals.isEmpty()){
        lilVals.add(newVal);
      }
      else if(newVal < lilVals.peekMax()){
          lilVals.add(newVal);
        }
      else{
          bigVals.add(newVal);
        }
      int sizeDiff = Math.abs(bigVals.getSize() - lilVals.getSize());
      if (sizeDiff>1) {
          if (lilVals.getSize() < bigVals.getSize())
                lilVals.add(bigVals.removeMin());
          else
                bigVals.add(lilVals.removeMax());
      }
    }

    public static void main(String[] args) {
	RunMed test = new RunMed();
	//10 addition
	for(int i = 0; i < 10; i++) {
	    int randVal = (int)(Math.random() * 500);

	    System.out.println("\nValue being added: " + randVal);
	    test.add(randVal);

	    System.out.println("Current median: " + test.getMedian());
	}

	RunMed test1 = new RunMed();
	//15 addition
	for (int j = 0; j < 15; j++) {
	    int randVal = (int)(Math.random() * 500);

	    System.out.println("\nValue being added: " + randVal);
	    test1.add(randVal);

	    System.out.println("Current median: " + test1.getMedian());
	}

    }




}
