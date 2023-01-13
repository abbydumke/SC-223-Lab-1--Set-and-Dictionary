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
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
	void testGet() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		dict.put(1,'c');
		assertEquals('c', dict.get(1));
	}

	@Test
	void testPutOneE() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		dict.put(1,'a');
		assertEquals('a', dict.get(1));
		assertEquals(1, dict.size());
	}
	
	@Test
	void testPutFiveE() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		for(int i=1; i<=5; i++) {
			dict.put(i,(char)('a'+i-1));
			assertEquals((char)('a'+i-1), dict.get(i), "value a key="+i+" is not "+(char)('a'+i-1));
		}
		assertEquals(5, dict.size());
	}
	
	@Test
	void testPutNullKey() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		dict.put(null, 'a');
		assertEquals('a', dict.get(null));
	}
	
	@Test
	void testPutNullValue() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		dict.put(1, null);
		assertEquals(null, dict.get(1));
	}
	
	@Test
	void testPutEmptyKey() {
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		dict.put("", "world");
		assertEquals("world", dict.get(""));
	}
	
	@Test
	void testPutEmptyValue() {
		ParallelArrayDictionary<String, String> dict = new ParallelArrayDictionary<String, String>();
		dict.put("Hello", "");
		assertEquals("", dict.get("Hello"));
	}
	
	@Test
	void testPutModify() {
		ParallelArrayDictionary<Integer, Character> dict = new ParallelArrayDictionary<Integer, Character>();
		dict.put(1, 'a');
		dict.put(1, 'b');
		assertEquals('b', dict.get(1));
	}

	@Test
	void testRemove() {
	}

	@Test
	void testPutAll() {
	}

	@Test
	void testClear() {
	}
}
