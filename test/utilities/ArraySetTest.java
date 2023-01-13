/**
  * Write a succinct, meaningful description of the class here. You should avoid wordiness 
  * and redundancy. If necessary, additional paragraphs should be preceded by <p>,
  * the html tag for a new paragraph.
  *
  *<p>Bugs: 
  *
  * @author Abby Dumke, Jake Shore
  * @date <date of completion>
  */

package utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArraySetTest
{
	@Test
	void testArraySetCollectionOfE()
	{
	}

	@Test
	void testAddE()
	{
		ArraySet<Integer> aS  = new ArraySet<Integer>();
		//test (adding 1 element)
		int a1= 4;
		aS.add(a1);
		assertEquals(1, aS.size());
		
		//test (adding 5 elements)
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
		
	}
}
