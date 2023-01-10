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
		
		ArrayList<Integer> aL = new ArrayList<Integer>();
		//test (adding 1 element)
		int a1= 2;
		aL.add(a1);
		assertEquals(1, aL.size());
		//test (adding 5 elements)
		int a2 = 10;
		aL.add(a2);
		int a3 = 1;
		aL.add(a3);
		int a4 = 3;
		aL.add(a4);
		int a5 = 8;
		aL.add(a5);
		assertEquals(5, aL.size());
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
	}

	@Test
	void testRetainAll()
	{
	}

	@Test
	void testRemoveAll()
	{
		ArrayList<Integer> aL = new ArrayList<Integer>();
		//test (add 2 elements, remove all)
		int a1= 2;
		int a2 = 10;
		aL.add(a1);
		aL.add(a2);
		aL.remove(0);
		aL.remove(0);
		assertEquals(0,aL.size());
		
		//test (add four elements to list, clear)
		int a3 = 1;
		int a4 = 2;
		int a5 = 3;
		int a6 = 4;
		aL.add(a3);
		aL.add(a4);
		aL.add(a5);
		aL.add(a6);
		aL.clear();
		assertEquals(0,aL.size());
		
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
	}
}
