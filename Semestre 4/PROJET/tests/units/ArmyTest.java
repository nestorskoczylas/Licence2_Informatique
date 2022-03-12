package units;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import boardgame.Cell;
import boardgame.Player;
import boardgame.Strategy;
import boardgame.cells.PlainCell;
import boardgame.players.WarPlayer;
import boardgame.strategy.ConstStrat;
import boardgame.units.Army;

public class ArmyTest {

	private ConstStrat strat;
	private Player player;
	private WarPlayer realP;
	private PlainCell cell;
	private PlainCell cell2;
	private Army army1;
	private Army army2;

	@Before
	public void before() {
		this.player = null;
		this.strat = new ConstStrat();
		this.realP = new WarPlayer("Player", this.strat);
		this.cell = new PlainCell(4, 7, 1, 1, 1, 5);
		this.cell2 = new PlainCell(2, 6, 2, 2, 2, 3);
		this.army1 = new Army(this.cell, this.realP, 4);
		this.army2 = new Army(this.cell, this.player, 4);
	}

	@Test
	public void quitTest() {
		this.army1.quit();
		assertNull(this.army1.getCell());
		assertEquals(this.army1.getTeam(), this.realP);
		assertEquals(this.army1.getGold(), 0);
		assertEquals(this.army1.getSize(), 0);
		assertEquals(1, this.realP.getGold());
	}

	@Test
	public void getTeamTest() {
		assertEquals(this.army1.getTeam(), this.realP);
	}

	@Test
	public void getCellTest() {
		assertEquals(this.army2.getCell(), this.cell);
	}

	@Test
	public void setCellTest() {
		assertEquals(this.army2.getCell(), this.cell);
		this.army2.setCell(this.cell2);
		assertEquals(this.army2.getCell(), this.cell2);
	}

	@Test
	public void getGoldTest() {
		assertEquals(this.army2.getGold(), 0);
	}

	@Test
	public void setGoldTest() {
		assertEquals(this.army2.getGold(), 0);
		this.army2.setGold(10);
		assertEquals(this.army2.getGold(), 10);
	}

	@Test
	public void getSizeTest() {
		assertEquals(this.army2.getSize(), 4);
	}

	@Test
	public void setSizeTest() {
		assertEquals(this.army2.getSize(), 4);
		this.army2.setSize(1);
		assertEquals(this.army2.getSize(), 1);
	}

	@Test
	public void equalsTest() {

		Army army2 = new Army(this.cell, null, 4);
		assertTrue(this.army2.equals(army2));

		Strategy strat = new ConstStrat();
		Player pTest = new WarPlayer("yé sui 1 tést", strat);
		Army army3 = new Army(this.cell, pTest, 4);
		assertFalse(this.army2.equals(army3));

		Army army4 = new Army(this.cell, null, 4);
		army4.setGold(1);
		assertFalse(this.army2.equals(army4));

		Army army5 = new Army(this.cell, null, 5);
		assertFalse(this.army2.equals(army5));

		Cell cellTest = new PlainCell(1, 1, 1, 1, 1, 1);
		Army army6 = new Army(cellTest, null, 4);
		assertFalse(this.army2.equals(army6));
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(ArmyTest.class);
	}

}
