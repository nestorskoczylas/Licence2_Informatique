package cells;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import boardgame.Cell;
import boardgame.cells.OceanCell;
import boardgame.resources.Sand;

public class OceanCellTest {

	private OceanCell cell;

	@Before
	public void before() {
		this.cell = new OceanCell(12, 15, 0, 1, 5, 5);
	}

	@Test
	public void getRessourceTest() {
		Sand notExpected = new Sand(5);
		assertNull(this.cell.getResource());
		assertFalse(notExpected.equals(this.cell.getResource()));
	}

	@Test
	public void getGoldTest() {
		assertEquals(this.cell.getGold(), 1);
	}

	@Test
	public void getAdvantageTest() {
		assertEquals(0, this.cell.getAdvantage());
	}

	@Test
	public void setAdvantageTest() {
		this.cell.setAdvantage(1);
		assertEquals(1, this.cell.getAdvantage());
	}

	@Test
	public void getValueTest() {
		assertEquals(5, this.cell.getValue());
	}

	@Test
	public void getXTest() {
		assertEquals(this.cell.getX(), 12);
	}

	@Test
	public void getYTest() {
		assertEquals(this.cell.getY(), 15);
	}

	@Test
	public void getMaxUnitTest() {
		assertEquals(5, this.cell.getMaxUnit());
	}

	@Test
	public void isBusyTest() {
		assertFalse(this.cell.isBusy());
	}

	@Test
	public void getAndSetCostTest() {
		assertEquals(0, this.cell.getCost());
		this.cell.setCost(10);
		assertEquals(10, this.cell.getCost());
	}

	@Test
	public void equalsTest() {
		assertTrue(this.cell.equals(this.cell));

		Cell cell2 = new OceanCell(12, 15, 0, 1, 5, 6);
		assertFalse(this.cell.equals(cell2));

		Cell cell3 = new OceanCell(12, 15, 0, 1, 6, 5);
		assertFalse(this.cell.equals(cell3));

		Cell cell4 = new OceanCell(12, 15, 0, 2, 5, 5);
		assertFalse(this.cell.equals(cell4));

		Cell cell5 = new OceanCell(12, 15, 1, 1, 5, 5);
		assertFalse(this.cell.equals(cell5));

		Cell cell6 = new OceanCell(12, 1, 0, 1, 5, 5);
		assertFalse(this.cell.equals(cell6));

		Cell cell7 = new OceanCell(1, 15, 0, 1, 5, 6);
		assertFalse(this.cell.equals(cell7));
	}

}