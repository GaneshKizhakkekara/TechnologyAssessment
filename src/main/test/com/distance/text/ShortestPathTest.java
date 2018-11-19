package com.distance.text;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.distance.ShortestPath;
import com.distance.controller.ShortestPathController;

public class ShortestPathTest {
	ShortestPathController sc;
	ShortestPath sp;

	@Test
	public void test() throws IOException {

		assertEquals("0 - 4 - 3 - 1 - 2 - 0. Distance = 32 (ShortestPath)", sp.calculate("5","D:\\Distance.txt"));

	}

}
