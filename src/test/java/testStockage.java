import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import Stockage.Stockage;


public class testStockage {
	
	Stockage store = new Stockage(); 
	LinkedList<String> list = new LinkedList<String>();
	
	@Test
	public void testSET() {
		assertEquals("test SET", "Success !!!",store.SET("test","a b c d"));
	}

	@Test
	public void testSETNX() {
		list.clear();
		list.add("a");
		list.add("b");
		list.add("c");
		assertEquals("test SETNX", "Success !!!",store.SETNX("test",list));
	}

	@Test
	public void testGET() {
		store.SET("test","a b c d");
		assertEquals("test GET", "a b c d", store.GET("test"));
	}
	
	@Test
	public void testDEL() {
		store.SET("test","a b c d");
		assertEquals("test DEL", "Success !!!", store.DEL("test"));
	}
	
	@Test
	public void testRPUSH() {
		list.clear();
		list.add("a");
		list.add("b");
		list.add("c");
		store.SETNX("test",list);
		assertEquals("test RPUSH", "[a, b, c, d]", store.RPUSH("test","d"));
	}
	
	@Test
	public void testLPUSH() {
		list.clear();
		list.add("a");
		list.add("b");
		list.add("c");
		store.SETNX("test",list);
		assertEquals("test LPUSH", "[d, a, b, c]", store.LPUSH("test","d"));
	}
	
	@Test
	public void testLPUSHX() {
		list.clear();
		list.add("b");
		list.add("c");
		list.add("d");
		store.SET("test","a");
		assertEquals("test LPUSHX", "[b, c, d, a]", store.LPUSHX("test",list));
	}
	
	@Test
	public void testRPUSHX() {
		list.clear();
		list.add("b");
		list.add("c");
		list.add("d");
		store.SET("test","a");
		assertEquals("test get", "[a, b, c, d]", store.RPUSHX("test",list));
	}
	
	@Test
	public void testLPOP() {
		list.clear();
		list.add("a");
		list.add("b");
		list.add("c");
		store.SETNX("test",list);
		assertEquals("test get", "[b, c]", store.LPOP("test"));
	}
	
	@Test
	public void testRPOP() {
		list.clear();
		list.add("a");
		list.add("b");
		list.add("c");
		store.SETNX("test",list);
		assertEquals("test get", "[a, b]", store.RPOP("test"));
	}
	
	@Test
	public void testLRANGE() {
		list.clear();
		list.add("a");
		list.add("b");
		list.add("c");
		store.SETNX("test",list);
		assertEquals("test get", "[a, b]", store.LRANGE("test","1","2"));
	}
	
	@Test
	public void testLLEN() {
		list.clear();
		list.add("a");
		list.add("b");
		list.add("c");
		store.SETNX("test",list);
		assertEquals("test get size of the list", "La liste test a 3 elements", store.LLEN("test"));
	}
}
