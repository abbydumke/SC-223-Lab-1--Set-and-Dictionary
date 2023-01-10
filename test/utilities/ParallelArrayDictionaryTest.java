package utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		dict.put(1, 'c');
		assertEquals('c', dict.get(1));
	}

	@Test
	void testPut() {
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
