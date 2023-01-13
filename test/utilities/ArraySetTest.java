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
import java.util.Collection;
import org.junit.jupiter.api.Test;
class ArraySetTest
{
	@Test  //NOT COMPLETED FIXME
	void testArraySetCollectionOfE()
	{
		ArraySet<Integer> aS  = new ArraySet<Integer>();
		
		//add items to ArraySet and then see if they are there
		
		/*int a1 = 1;
		int a2 = 2;
		int a3 = 3;
		int a4 = 4;
		int a5 = 5;
		Arrays.asList(a1, a2, a3, a4, a5);
		*/
	}
	@Test
	void testAddE()
	{
		ArraySet<Integer> aS  = new ArraySet<Integer>();
		//test (adding 1 element)
		int a1= 4;
		aS.add(a1);
		assertEquals(1, aS.size());
		
		//test (adding 5 (or four more) elements)
		int a2 = 10;
		aS.add(a2);
		int a3 = 1;
		aS.add(a3);
		int a4 = 3;
		aS.add(a4);
		int a5 = 8;
		aS.add(a5);
		assertEquals(5, aS.size());
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
				
				//test (add five more integers to ArraySet)
				int a6 = 6;
				int a7 = 7;
				int a8 = 8;
				int a9 = 9;
				int a10 = 10;
				aS.addAll(Arrays.asList(a6, a7, a8, a9, a10));
				assertEquals(10,aS.size());
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
		aS.remove(0);
		aS.remove(0);
		assertEquals(0,aS.size());
		
		//test (add four elements to list, clear)
		int a3 = 1;
		int a4 = 2;
		int a5 = 3;
		int a6 = 4;
		aS.add(a3);
		aS.add(a4);
		aS.add(a5);
		aS.add(a6);
		aS.clear();
		assertEquals(0,aS.size());
		
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
		
	}
}
