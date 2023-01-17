/**
  * This class tests the ArraySet class and it's add, addAll,
  * addAll at index, retainAll, removeAll methods.
  *
  *<p>Bugs: 
  *
  * @author Abby Dumke, Jake Shore
  * @date <date of completion>
  */

package utilities;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ArraySetTest
{
	@Test  
	void testArraySetCollectionOfE()
	{
		ArraySet<Integer> aS  = new ArraySet<Integer>();
		
		//test (no elements in collection)
		assertEquals(0,aS.size());
	
		//test (unique elements in collection)
		int a1 = 1;
		int a2 = 2;
		int a3 = 3;
		aS.addAll(Arrays.asList(a1, a2, a3));
		assertEquals(3,aS.size());
		aS.clear();
	
		
		//test (redundant elements in collection)
		aS.addAll(Arrays.asList(a1, a1, a1, a3, a1));
		assertEquals(2, aS.size());
		////test (add number that is in a set again, should not change the number in the set)
		aS.addAll(Arrays.asList(a3));
		assertEquals(2, aS.size());
		
	}
	@Test
	void testAddE()
	{
		ArraySet<Integer> aS  = new ArraySet<Integer>();
		//test (adding 1 element)
		int a1= 1;
		aS.add(a1);
		assertEquals(1, aS.size());
		
		//test (adding 5 (or four more) elements)
		int a2 = 2;
		aS.add(a2);
		int a3 = 3;
		aS.add(a3);
		int a4 = 4;
		aS.add(a4);
		int a5 = 5;
		aS.add(a5);
		assertEquals(5, aS.size());
		
		//test (adding elements to the set that are already in the set. Should make no change)
		aS.add(a1);
		aS.add(a2);
		aS.add(a5);
		assertEquals(5, aS.size());
	}
	@Test
	void testAddMultipleOfSameE()
	{
		ArraySet<Integer> aS  = new ArraySet<Integer>();
		//test (adding three redundant elements)
		int a1= 4;
		aS.add(a1);
		aS.add(a1);
		aS.add(a1);
		assertEquals(1, aS.size());
		
		
	}
	@Test
	void testAddAllCollectionOfQextendsE()
	{
		//test (add all five integers to ArraySet)
				ArraySet<Integer> aS  = new ArraySet<Integer>();
				int a1 = 1;
				int a2 = 2;
				int a3 = 3;
				int a4 = 4;
				int a5 = 5;
				aS.addAll(Arrays.asList(a1, a2, a3, a4, a5));
				assertEquals(5,aS.size());
				
				//test (add two more integers to ArraySet and three redundant integers)
				int a6 = 6;
				int a7 = 7;
				int a8 = 8;
				int a9 = 8;
				int a10 = 8;
				aS.addAll(Arrays.asList(a6, a7, a8, a9, a10));
				assertEquals(8,aS.size());
				
				
	}
	@Test
	void testRetainAll()
	{
		ArraySet<Integer> aS1  = new ArraySet<Integer>();
		ArraySet<Integer> aS2  = new ArraySet<Integer>();
		
		//test (add three elements to one list and three elements to the other, retain all to first with second as parameter)
		int a1= 1;
		int a2 = 2;
		int a3 = 3;
		aS1.add(a1);
		aS1.add(a2);
		aS1.add(a3);
		int a10= 10;
		int a9 = 9;
		int a8 = 8;
		aS2.add(a10);
		aS2.add(a9);
		aS2.add(a8);
		aS1.retainAll(aS2);
		assertEquals(0,aS1.size());
		assertEquals(3,aS2.size());
		aS1.clear();
		aS2.clear();
		
		//test (add three elements to one list and three elements to the other,
		//two of which are the same, and one is a subset of another.
		//retain all to first with second as parameter. should remove only one in the first set.)
		a10 = 1;
		a9 = 3;
		a8 = 3;
		aS1.add(a1);
		aS1.add(a2);
		aS1.add(a3);
		aS2.add(a10);
		aS2.add(a9);
		aS2.add(a8);
		aS1.retainAll(aS2);
		assertEquals(2,aS1.size());
		assertEquals(2,aS2.size());
	}
	@Test
	void testRemoveAll()
	{
		ArraySet<Integer> aS  = new ArraySet<Integer>();
		
		//test (add 2 elements, remove all)
		int a1= 2;
		int a2 = 10;
		aS.add(a1);
		aS.add(a2);
		aS.removeAll(aS);
		assertEquals(0,aS.size());
		
		//test (add four elements to one list, add two of the same to another list, remove all from another list)
		int a3 = 1;
		int a4 = 2;
		int a5 = 3;
		int a6 = 4;
		ArrayList<Integer> aL = new ArrayList<Integer>();
		aL.add(a3);
		aL.add(a4);
		aS.add(a3);
		aS.add(a4);
		aS.add(a5);
		aS.add(a6);
		aS.removeAll(aL);
		assertEquals(2,aS.size());
		
	}
	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
		ArraySet<Integer> aS  = new ArraySet<Integer>();
		
		//test (add two items to list, then add three at index one. 1, 3, 4, 5, 2)
		int a1 = 1;
		int a2 = 2;
		int a3 = 3;
		int a4 = 4;
		int a5 = 5;
		aS.add(a1);
		aS.add(a2);
		aS.addAll(1,Arrays.asList(a3, a4, a5));
		assertEquals(5,aS.size());
		aS.clear();
		
		//test (add three items from empty list at the first index.
		aS.addAll(0, Arrays.asList(a1,a2));
		assertEquals(2,aS.size());
		
		//test (add elements that are already in the set at an index. Should not add)
		aS.addAll(1, Arrays.asList(a1,a2));
		assertEquals(2,aS.size());
	}
}
