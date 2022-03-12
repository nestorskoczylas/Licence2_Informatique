import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import boardgame.BoardGame;
import boardgame.Cell;
import boardgame.Fabrice;
import boardgame.fabrices.FabriceArmy;

public class BoardGameTest {

	private Fabrice fab;
	private BoardGame persBoard;
	private Cell cellUp;
	private Cell cellMid;
	private Cell cellRight;
	private Cell cellLeft;
	private Cell cellDown;

	@Before
	public void before() {
		this.fab = new FabriceArmy();
		this.persBoard = new BoardGame(3, 3, this.fab);
		this.persBoard.setCell(this.cellUp = this.fab.buildDesertCell(1, 0));
		this.persBoard.setCell(this.cellMid = this.fab.buildPlainCell(1, 1));
		this.persBoard.setCell(this.cellRight = this.fab.buildForestCell(2, 1));
		this.persBoard.setCell(this.cellLeft = this.fab.buildOceanCell(0, 1));
		this.persBoard.setCell(this.cellDown = this.fab.buildMountainCell(1, 2));
	}

	@Test
	public void getWidthTest() {
		assertEquals(3, this.persBoard.getWidth());
	}

	@Test
	public void getLengthTest() {
		assertEquals(3, this.persBoard.getLength());
	}

	@Test
	public void getCellTest() {
		assertEquals(this.cellMid, this.persBoard.getCell(1, 1));
	}

	@Test
	public void setCellTest() {
		Cell cellMidTest = this.fab.buildMountainCell(1, 1);
		persBoard.setCell(cellMidTest);
		assertEquals(cellMidTest, this.persBoard.getCell(1, 1));
	}

	@Test
	public void getAdjacentCellAtCenterTest() {
		List<Cell> adjCellTest = new ArrayList<Cell>();
		adjCellTest.add(this.cellUp);
		adjCellTest.add(this.cellDown);
		adjCellTest.add(this.cellLeft);
		adjCellTest.add(this.cellRight);
		assertEquals(adjCellTest, this.persBoard.getAdjacentCell(this.cellMid));
	}

	@Test
	public void getAdjacentCellAtUpRightTest() {
		List<Cell> adjCellTest = new ArrayList<Cell>();
		adjCellTest.add(this.cellLeft);
		adjCellTest.add(this.cellUp);
		assertEquals(adjCellTest, this.persBoard.getAdjacentCell(this.persBoard.getCell(0, 0)));
	}

	@Test
	public void getAdjacentCellAtDownLeftTest() {
		List<Cell> adjCellTest = new ArrayList<Cell>();
		adjCellTest.add(this.cellRight);
		adjCellTest.add(this.cellDown);
		assertEquals(adjCellTest, this.persBoard.getAdjacentCell(this.persBoard.getCell(2, 2)));
	}

	@Test
	public void oceanSurroundTrueTest() {
		this.persBoard.setCell(this.cellLeft = this.fab.buildOceanCell(1, 0));
		this.persBoard.setCell(this.cellLeft = this.fab.buildOceanCell(2, 1));
		this.persBoard.setCell(this.cellLeft = this.fab.buildOceanCell(1, 2));
		assertTrue(this.persBoard.oceanSurround(1, 1));
	}

	@Test
	public void oceanSurroundFalseTest() {
		assertFalse(this.persBoard.oceanSurround(1, 1));
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(BoardGameTest.class);
	}
}
