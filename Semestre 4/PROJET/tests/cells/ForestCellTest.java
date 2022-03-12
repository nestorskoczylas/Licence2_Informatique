package cells;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import boardgame.Cell;
import boardgame.Unit;
import boardgame.cells.ForestCell;
import boardgame.cells.OceanCell;
import boardgame.players.WarPlayer;
import boardgame.resources.Sand;
import boardgame.resources.Wood;
import boardgame.strategy.RandomStrat;
import boardgame.units.Army;

public class ForestCellTest {

	private ForestCell cell;
	private Unit army;
	private WarPlayer player;

	@Before
	public void before() {
		this.cell = new ForestCell(12, 15, 0, 1, 5, 5);
		this.player = new WarPlayer("Patrick", new RandomStrat());
		this.army = new Army(this.cell, this.player, 4);
		cell.addUnit(army);
	}

	@Test
	public void getRessourceTest() {
		Sand notExpected = new Sand(5);
		Wood expected = new Wood(5);
		assertEquals(expected, this.cell.getResource());
		assertFalse(notExpected.equals(this.cell.getResource()));
	}

	@Test
	public void getGoldTest() {
		assertEquals(this.cell.getGold(), 1);
	}

	@Test
	public void getValueTest() {
		assertEquals(5, this.cell.getValue());
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
	public void addandGetUnitOKTest() {
		Cell anotherCell = new ForestCell(1, 1, 0, 1, 5, 5);
		assertNull(anotherCell.getUnit());
		Army anotherArmy = new Army(anotherCell, null, 4);
		assertTrue(anotherCell.addUnit(anotherArmy));
		assertEquals(anotherArmy, anotherCell.getUnit());
	}

	@Test
	public void addUnitFalseBecauseBusyTest() {
		assertTrue(this.cell.isBusy());
		assertFalse(this.cell.addUnit(this.army));
	}

	@Test
	public void addUnitFalseBecauseOverMaxUnitTest() {
		Army army2 = new Army(this.cell, null, 6);
		assertFalse(this.cell.addUnit(army2));
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
		Cell otherCell = new ForestCell(15, 10, 0, 1, 5, 5);
		assertFalse(otherCell.isBusy());
		assertTrue(this.cell.isBusy());
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