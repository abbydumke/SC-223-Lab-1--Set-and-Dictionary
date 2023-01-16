/**
  * The class tests the ParallelArrayDictionary class's get, put, remove, putAll,
  * and clear methods. 
  * 
  * <p>Bugs: 
  *
  * @author Abby Dumke, Jake Shore
  * @date <date of completion>
  */

package utilities;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	
	@Test
	void testGetNotInDictionary()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		assertNull(dict.get(1));
	}

	@Test
	void testPutAndGetOne()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		assertNull(dict.put(1,'a'));
		assertEquals('a', dict.get(1));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutAndGetFive()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		for(int i=1; i<=5; i++)
		{
			assertNull(dict.put(i, makeCharacter(i-1)));
			assertEquals(makeCharacter(i-1), dict.get(i));
		}
		assertEquals(5, dict.size());
	}
	
	@Test
	void testPutandGetNullKey()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		dict.put(null, 'a');
		
		assertEquals('a', dict.get(null));
	}
	
	@Test
	void testPutAndGetNullValue()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		dict.put(1, null);
		
		assertEquals(null, dict.get(1));
	}
	
	@Test
	void testPutAndGetEmptyKey()
	{
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		
		dict.put("", "world");
		
		assertEquals("world", dict.get(""));
	}
	
	@Test
	void testPutAndGetEmptyValue()
	{
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		
		dict.put("Hello", "");
		
		assertEquals("", dict.get("Hello"));
	}
	
	@Test
	void testPutModifyAndGetOne()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		dict.put(1, 'a');
		
		assertEquals('a', dict.put(1, 'b'));
		assertEquals('b', dict.get(1));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutModifyAndGetFive()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		for(int i=1; i<=5; i++)
		{
			dict.put(i,makeCharacter(i-1));
			assertEquals(makeCharacter(i-1), dict.put(i, makeCharacter(i)));
			assertEquals(makeCharacter(i), dict.get(i));
		}
		assertEquals(5, dict.size());
	}

	@Test
	void testRemoveOne() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		dict.put(1, 'a');
		
		assertEquals('a', dict.remove(1));
	}
	
	@Test
	void testRemoveFive()
	{
		addAndRemove(5, 5);
	}
	
	@Test
	void testRemoveSome()
	{
		addAndRemove(5, 3);
	}
	
	@Test
	void testRemoveNullKey()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		dict.put(null, 'a');
		
		assertEquals('a', dict.remove(null));
	}
	
	@Test
	void testRemoveNullValue()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		dict.put(1, null);
		
		assertEquals(null, dict.remove(1));
	}
	
	@Test
	void testRemoveEmptyKey()
	{
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		
		dict.put("", "World");
		
		assertEquals("World", dict.remove(""));
	}
	
	@Test
	void testRemoveEmptyValue()
	{
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		
		dict.put("Hello", "");
		
		assertEquals("", dict.remove("Hello"));
	}
	
	@Test
	void testRemoveNotInDictionary()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		assertEquals(null, dict.remove(1));
		assertEquals(0, dict.size());
	}
	
	@Test
	void testAddThenRemoveThanAddSame()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		dict.put(1, 'a');
		
		assertEquals('a', dict.remove(1));
		assertNull(dict.put(1,'b'));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testRemoveThenAddThenRemoveDifferent()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		dict.put(1, 'a');
		
		assertEquals('a', dict.remove(1));
		assertNull(dict.put(2,'b'));
		assertEquals(1, dict.size());
	}

	@Test
	void testPutAllOne()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		
		map.put(1, 'a');
		dict.putAll(map);
		
		assertEquals('a', dict.get(1));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutAllFive()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		
		for(int i=1; i<=5; i++) {
			map.put(i, makeCharacter(i-1));
		}
		dict.putAll(map);
		
		for(int i=1; i<=5; i++) {
			assertEquals(makeCharacter(i-1), dict.get(i));
		}
		assertEquals(5, dict.size());
	}
	
	@Test
	void testPutAllMultiple()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		HashMap<Integer, Character> map1 = new HashMap<Integer, Character>();
		HashMap<Integer, Character> map2 = new HashMap<Integer, Character>();
		
		map1.put(1, 'a');
		map2.put(2, 'b');
		dict.putAll(map1);
		dict.putAll(map2);
		
		assertEquals('a', dict.get(1));
		assertEquals('b', dict.get(2));
		assertEquals(2, dict.size());
	}
	
	@Test
	void testPutAllMultipleModify()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		HashMap<Integer, Character> map1 = new HashMap<Integer, Character>();
		HashMap<Integer, Character> map2 = new HashMap<Integer, Character>();
		
		map1.put(1, 'a');
		map2.put(1, 'b');
		dict.putAll(map1);
		dict.putAll(map2);
		
		assertEquals('b', dict.get(1));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutAllNullKey()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		
		map.put(null, 'a');
		dict.putAll(map);
		
		assertEquals('a', dict.get(null));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutAllNullValue()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		
		map.put(1, null);
		dict.putAll(map);
		
		assertEquals(null, dict.get(1));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutAllEmptyKey()
	{
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("", "World");
		dict.putAll(map);
		
		assertEquals("World", dict.get(""));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutAllEmptyValue()
	{
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("Hello", "");
		dict.putAll(map);
		
		assertEquals("", dict.get("Hello"));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutAllEmptyMap()
	{
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		
		dict.putAll(new HashMap<String, String>());
		
		assertEquals(0, dict.size());
	}
	
	@Test
	void testClear()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		dict.put(1,'a');
		dict.clear();
		assertEquals(0, dict.size());
	}
	
	@Test
	void testClearThenPut()
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		dict.put(1,'a');
		dict.clear();
		assertNull(dict.put(1,'a'));
		assertEquals(1, dict.size());
	}
	
	private char makeCharacter(int offset)
	{
		return (char)('a' + offset);
	}
	
	private void addAndRemove(int addAmount, int removeAmount)
	{
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		
		for(int i=1; i<=addAmount; i++)
		{
			dict.put(i, makeCharacter(i-1));
		}
		
		for(int i=1; i<=removeAmount; i++)
		{
			assertEquals(makeCharacter(i-1), dict.remove(i));
		}
		assertEquals(addAmount - removeAmount, dict.size());
	}
}
