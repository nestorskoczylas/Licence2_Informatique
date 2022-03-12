package fabrices;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import boardgame.Cell;
import boardgame.Fabrice;
import boardgame.cells.DesertCell;
import boardgame.cells.ForestCell;
import boardgame.cells.MountainCell;
import boardgame.cells.OceanCell;
import boardgame.cells.PlainCell;
import boardgame.fabrices.FabriceArmy;

public class FabriceArmyTest {

	private Fabrice fab;
	private int x;
	private int y;

	@Before
	public void before() {
		this.fab = new FabriceArmy();
		this.x = 5;
		this.y = 7;
	}

	@Test
	public void createPlainCellTest() {
		Cell c = this.fab.createCell(this.x, this.y, Fabrice.PLAIN);
		Cell c2 = new PlainCell(this.x, this.y, 1, 1, 5, 5);
		assertTrue(c.equals(c2));
	}

	@Test
	public void createMountainCellTest() {
		Cell c = this.fab.createCell(this.x, this.y, Fabrice.MOUNTAIN);
		Cell c2 = new MountainCell(this.x, this.y, 1, 1, 3, 0);
		assertTrue(c.equals(c2));
	}

	@Test
	public void createForestCellTest() {
		Cell c = this.fab.createCell(this.x, this.y, Fabrice.FOREST);
		Cell c2 = new ForestCell(this.x, this.y, 1, 1, 5, 1);
		assertTrue(c.equals(c2));
	}

	@Test
	public void createDesertCellTest() {
		Cell c = this.fab.createCell(this.x, this.y, Fabrice.DESERT);
		Cell c2 = new DesertCell(this.x, this.y, 2, 1, 3, 0);
		assertTrue(c.equals(c2));
	}

	@Test
	public void createOceanCellTest() {
		Cell c = this.fab.createCell(this.x, this.y, Fabrice.OCEAN);
		Cell c2 = new OceanCell(this.x, this.y, 1, 0, 0, 0);
		assertTrue(c.equals(c2));
	}

}