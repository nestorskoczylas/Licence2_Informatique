package units;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import boardgame.Player;
import boardgame.cells.PlainCell;
import boardgame.players.EcoPlayer;
import boardgame.strategy.RandomStrat;
import boardgame.units.Worker;

public class WorkerTest {

	private Worker worker;
	private Player player;
	private PlainCell cell;
	private PlainCell cell2;

	@Before
	public void before() {
		this.player = new EcoPlayer("Patrick", new RandomStrat());
		this.cell = new PlainCell(4, 7, 1, 1, 1, 5);
		this.cell2 = new PlainCell(2, 6, 2, 2, 2, 3);
		this.worker = new Worker(this.cell, this.player);
	}

	@Test
	public void quitTest() {
		this.worker.quit();
		assertNull(this.worker.getCell());
		assertEquals(this.worker.getTeam(), this.player);
		assertEquals(this.worker.getGold(), 0);
		assertEquals(this.worker.getSize(), 0);
	}

	@Test
	public void getTeamTest() {
		assertEquals(this.worker.getTeam(), this.player);
	}

	@Test
	public void getCellTest() {
		assertEquals(this.worker.getCell(), this.cell);
	}

	@Test
	public void setCellTest() {
		assertEquals(this.worker.getCell(), this.cell);
		this.worker.setCell(this.cell2);
		assertEquals(this.worker.getCell(), this.cell2);
	}

	@Test
	public void getGoldTest() {
		assertEquals(this.worker.getGold(), 0);
	}

	@Test
	public void setGoldTest() {
		assertEquals(this.worker.getGold(), 0);
		this.worker.setGold(10);
		assertEquals(this.worker.getGold(), 10);
	}

	@Test
	public void getSizeTest() {
		assertEquals(this.worker.getSize(), 1);
	}

	@Test
	public void setSizeTest() {
		assertEquals(this.worker.getSize(), 1);
		this.worker.setSize(2);
		assertEquals(this.worker.getSize(), 2);
	}

	@Test
	public void equalsTest() {

		Worker worker2 = new Worker(this.cell, this.player);
		assertTrue(this.worker.equals(worker2));

		Worker worker3 = new Worker(new PlainCell(1, 1, 1, 1, 1, 1), this.player);
		assertFalse(this.worker.equals(worker3));

		Worker worker4 = new Worker(this.cell, null);
		assertFalse(this.worker.equals(worker4));

		Worker worker5 = new Worker(this.cell, this.player);
		worker5.setGold(1);
		assertFalse(this.worker.equals(worker5));
	}

}
