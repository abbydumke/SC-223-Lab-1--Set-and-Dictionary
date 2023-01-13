/**
  * The class tests the ParallelArrayDictionary class's default constructor, get, put,
  * remove, putAll, and clear methods. 
  * 
  * <p>Bugs: 
  *
  * @author Abby Dumke, Jake Shore
  * @date <date of completion>
  */

package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	@Test
	void testParallelArrayDictionary() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		assertNotNull(dict);
		assertEquals(0, dict.size());
	}
	
	@Test
	void testGetNotInDictionary() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		assertNull(dict.get(1));
	}

	@Test
	void testPutAndGetOne() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		assertNull(dict.put(1,'a'));
		assertEquals('a', dict.get(1));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutAndGetFive() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		for(int i=1; i<=5; i++) {
			assertNull(dict.put(i, makeCharacter(i-1)));
			assertEquals(makeCharacter(i-1), dict.get(i));
		}
		assertEquals(5, dict.size());
	}
	
	@Test
	void testPutandGetNullKey() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		dict.put(null, 'a');
		assertEquals('a', dict.get(null));
	}
	
	@Test
	void testPutAndGetNullValue() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		dict.put(1, null);
		assertEquals(null, dict.get(1));
	}
	
	@Test
	void testPutAndGetEmptyKey() {
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		dict.put("", "world");
		assertEquals("world", dict.get(""));
	}
	
	@Test
	void testPutAndGetEmptyValue() {
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		dict.put("Hello", "");
		assertEquals("", dict.get("Hello"));
	}
	
	@Test
	void testPutModifyAndGetOne() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		dict.put(1, 'a');
		assertEquals('a', dict.put(1, 'b'));
		assertEquals('b', dict.get(1));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutModifyAndGetFive() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		for(int i=1; i<=5; i++) {
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
	void testRemoveFive() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		for(int i=1; i<=5; i++) {
			dict.put(i, makeCharacter(i-1));
			System.out.println(i + " " + dict.get(i));
		}
		for(int i=1; i<=5; i++) {
			assertEquals(makeCharacter(i-1), dict.remove(i));
		}
		assertEquals(0, dict.size());
	}
	
	@Test
	void testRemoveSome() {
	}
	
	@Test
	void testRemoveNullKey() {
	}
	
	@Test
	void testRemoveNullValue() {
	}
	
	@Test
	void testRemoveEmptyKey() {
	}
	
	@Test
	void testRemoveEmptyValue() {
	}
	
	@Test
	void testRemoveNotInDictionary() {
	}
	
	@Test
	void testRemoveThenAddThenRemove() {
	}

	@Test
	void testPutAll() {
	}

	@Test
	void testClear() {
	}
	
	@Test
	void testAddThenClearThenAdd() {
	}
	
	private char makeCharacter(int offset) {
		return (char)('a' + offset);
	}
}
