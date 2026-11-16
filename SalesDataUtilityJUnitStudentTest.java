import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalesDataUtilityJUnitStudentTest {

	double[][] numbers = { { 3.14, 7.82 }, { 1.25, 9.63, 4.56, 8.12 }, { 6.78 }, { 2.34, 5.67, 9.01 },
			{ 7.45, 3.21, 8.90, 1.56, 4.32 } };

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHighestNumInArray() {
		assertEquals(9.63, SalesDataUtility.getHighestInArray(numbers), 0.001);
	}

	@Test
	void testLowestNumInArray() {
		assertEquals(1.25, SalesDataUtility.getLowestInArray(numbers), 0.001);
	}

	@Test
	void testLowestInRow() {
		assertEquals(1.56, SalesDataUtility.getLowestInRow(numbers, 4), 0.001);
	}

	@Test
	void testHighestInRow() {
		assertEquals(8.90, SalesDataUtility.getHighestInRow(numbers, 4), 0.001);
	}

	@Test
	void testHighestInColumn() {
		assertEquals(20.96, SalesDataUtility.getColumnTotal(numbers, 0), 0.001);
	}
}
