package moves;

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
import boardgame.Game;
import boardgame.Strategy;
import boardgame.Unit;
import boardgame.fabrices.FabriceArmy;
import boardgame.game.GameWar;
import boardgame.moves.DeployArmy;
import boardgame.players.WarPlayer;
import boardgame.strategy.ConstStrat;
import boardgame.units.Army;

public class DeployArmyTest {

	private String nameAlly;
	private String nameEnemy;
	private Strategy strat;
	private WarPlayer pAlly;
	private WarPlayer pEnemy;

	private Fabrice fab;
	private BoardGame board;
	private Cell cellUp;
	private Cell cellMid;
	private Cell cellRight;
	private Cell cellLeft;

	private Unit unitAlly4;
	private List<Unit> unitsAlly;
	private List<Cell> cellsAlly;
	private List<Unit> unitsEnemy;
	private List<Cell> cellsEnemy;

	private DeployArmy dep;
	private Game game;

	@Before
	public void before() {
		this.nameAlly = "Patrick";
		this.nameEnemy = "Jean Mich Mich";
		this.strat = new ConstStrat();
		this.pAlly = new WarPlayer(this.nameAlly, this.strat);
		this.pEnemy = new WarPlayer(this.nameEnemy, this.strat);

		this.fab = new FabriceArmy();
		this.board = new BoardGame(3, 3, this.fab);
		this.board.setCell(this.cellUp = this.fab.buildPlainCell(1, 0));
		this.board.setCell(this.cellMid = this.fab.buildPlainCell(1, 1));
		this.board.setCell(this.cellRight = this.fab.buildDesertCell(2, 1));
		this.board.setCell(this.cellLeft = this.fab.buildMountainCell(0, 1));

		this.unitAlly4 = new Army(this.board.getCell(1, 1), this.pAlly, 4);
		this.unitsAlly = new ArrayList<Unit>();
		this.unitsAlly.add(unitAlly4);
		this.unitsEnemy = new ArrayList<Unit>();

		this.cellMid.addUnit(unitAlly4);
		this.cellsAlly = new ArrayList<Cell>();
		this.cellsAlly.add(cellMid);
		this.cellsEnemy = new ArrayList<Cell>();

		this.pAlly.addDeployedUnit(unitAlly4);
		this.dep = new DeployArmy();
		this.game = new GameWar(this.board, 10);
		this.pAlly.setPlayingGame(this.game);
	}

	@Test
	public void placeUnitTest() {
		Unit armyPlaced = this.dep.placeUnit(this.cellMid, this.pAlly);
		Unit testUnit = new Army(this.cellMid, this.pAlly, 3);
		assertEquals(testUnit, armyPlaced);
	}

	@Test
	public void theFightWithNoEnemiesTest() {
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAlly = new Army(this.board.getCell(1, 1), this.pAlly, 4);

		assertEquals(testUnitAlly, this.unitAlly4);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());
		assertEquals(31, this.pAlly.getAvailableUnits());
	}

	@Test
	public void theFightWithAllyHigherInPlainTest() {
		Army unitAlly4 = new Army(this.board.getCell(1, 0), this.pAlly, 4);
		this.cellUp.addUnit(unitAlly4);
		this.pAlly.addDeployedUnit(unitAlly4);
		this.cellsAlly.add(this.cellUp);
		this.unitsAlly.add(unitAlly4);
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAllyBase4 = new Army(this.board.getCell(1, 1), this.pAlly, 4);
		Unit testUnitAlly4 = new Army(this.board.getCell(1, 0), this.pAlly, 4);

		assertEquals(testUnitAllyBase4, this.unitAlly4);
		assertEquals(testUnitAlly4, unitAlly4);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());
		assertEquals(27, this.pAlly.getAvailableUnits());
	}

	@Test
	public void theFightWithEnemyHigherInPlainTest() {
		Army unitEnemy4 = new Army(this.board.getCell(1, 0), this.pEnemy, 4);
		this.cellUp.addUnit(unitEnemy4);
		this.pEnemy.addDeployedUnit(unitEnemy4);
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAlly = new Army(this.board.getCell(1, 1), this.pAlly, 4);
		Cell testCellAlly = this.fab.buildPlainCell(1, 1);
		testCellAlly.addUnit(this.unitAlly4);

		Unit testUnitenemy = new Army(this.board.getCell(1, 0), this.pEnemy, 4);

		assertEquals(testUnitAlly, this.unitAlly4);
		assertEquals(testUnitenemy, unitEnemy4);

		this.cellsEnemy.add(this.cellUp);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());
		assertEquals(this.cellsEnemy, this.pEnemy.allControlledCells());

		this.unitsEnemy.add(unitEnemy4);
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());
		assertEquals(this.unitsEnemy, this.pEnemy.allDeployedUnits());

		assertEquals(31, this.pAlly.getAvailableUnits());
		assertEquals(31, this.pEnemy.getAvailableUnits());
	}

	@Test
	public void theFightWithEnemyHigherInMountainButLowerInNumberTest() {
		Army unitEnemy3 = new Army(this.board.getCell(0, 1), this.pEnemy, 3);
		this.cellLeft.addUnit(unitEnemy3);
		this.pEnemy.addDeployedUnit(unitEnemy3);
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAlly = new Army(this.board.getCell(1, 1), this.pAlly, 4);
		Unit testUnitEnemy = new Army(this.board.getCell(0, 1), this.pEnemy, 3);

		assertEquals(testUnitAlly, this.unitAlly4);
		assertEquals(testUnitEnemy, unitEnemy3);

		this.cellsEnemy.add(this.cellLeft);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());
		assertEquals(this.cellsEnemy, this.pEnemy.allControlledCells());

		this.unitsEnemy.add(unitEnemy3);
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());
		assertEquals(this.unitsEnemy, this.pEnemy.allDeployedUnits());

		assertEquals(31, this.pAlly.getAvailableUnits());
		assertEquals(32, this.pEnemy.getAvailableUnits());
	}

	@Test
	public void theFightWithAllyNormallyLowerInMountainAndCanGrowUpTest() {
		Army unitAlly2 = new Army(this.board.getCell(0, 1), this.pAlly, 2);
		this.cellLeft.addUnit(unitAlly2);
		this.pAlly.addDeployedUnit(unitAlly2);
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAlly4 = new Army(this.board.getCell(1, 1), this.pAlly, 4);
		testUnitAlly4.setGold(1);
		Unit testUnitAlly2 = new Army(this.board.getCell(0, 1), this.pAlly, 3);

		assertEquals(testUnitAlly4, this.unitAlly4);
		assertEquals(testUnitAlly2, unitAlly2);

		this.cellsAlly.add(this.cellLeft);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());

		this.unitsAlly.add(unitAlly2);
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());

		assertEquals(29, this.pAlly.getAvailableUnits());
	}

	@Test
	public void theFightWithAllyLowerInPlainTest() {
		Army unitAlly2 = new Army(this.board.getCell(1, 0), this.pAlly, 2);
		this.cellUp.addUnit(unitAlly2);
		this.pAlly.addDeployedUnit(unitAlly2);
		this.cellsAlly.add(this.cellUp);
		this.unitsAlly.add(unitAlly2);
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAlly3 = new Army(this.board.getCell(1, 1), this.pAlly, 4);
		testUnitAlly3.setGold(1);
		Unit testUnitAlly2 = new Army(this.board.getCell(1, 0), this.pAlly, 3);

		assertEquals(testUnitAlly3, this.unitAlly4);
		assertEquals(testUnitAlly2, unitAlly2);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());
		assertEquals(29, this.pAlly.getAvailableUnits());
	}

	@Test
	public void theFightWithAllyLowerButCannotGrowUpTest() {
		Army unitAlly3 = new Army(this.board.getCell(2, 1), this.pAlly, 3);
		this.cellRight.addUnit(unitAlly3);
		this.pAlly.addDeployedUnit(unitAlly3);
		this.cellsAlly.add(this.cellRight);
		this.unitsAlly.add(unitAlly3);
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAlly4 = new Army(this.board.getCell(1, 1), this.pAlly, 4);
		testUnitAlly4.setGold(1);
		Unit testUnitAlly3 = new Army(this.board.getCell(2, 1), this.pAlly, 3);

		assertEquals(testUnitAlly4, this.unitAlly4);
		assertEquals(testUnitAlly3, unitAlly3);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());
		assertEquals(28, this.pAlly.getAvailableUnits());
	}

	@Test
	public void theFightWithEnemyLowerButNotAloneInPlainTest() {
		Army unitEnemy3 = new Army(this.board.getCell(1, 0), this.pEnemy, 3);
		this.cellUp.addUnit(unitEnemy3);
		this.pEnemy.addDeployedUnit(unitEnemy3);
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAlly = new Army(this.board.getCell(1, 1), this.pAlly, 4);
		Unit testUnitenemy = new Army(this.board.getCell(1, 0), this.pEnemy, 1);

		assertEquals(testUnitAlly, this.unitAlly4);
		assertEquals(testUnitenemy, unitEnemy3);

		this.cellsEnemy.add(this.cellUp);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());
		assertEquals(this.cellsEnemy, this.pEnemy.allControlledCells());

		this.unitsEnemy.add(unitEnemy3);
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());
		assertEquals(this.unitsEnemy, this.pEnemy.allDeployedUnits());

		assertEquals(31, this.pAlly.getAvailableUnits());
		assertEquals(32, this.pEnemy.getAvailableUnits());
	}

	@Test
	public void theFightWithEnemyLowerButNotAloneInMountainTest() {
		this.unitAlly4.setSize(5);
		Army unitEnemy2 = new Army(this.board.getCell(0, 1), this.pEnemy, 2);
		this.cellLeft.addUnit(unitEnemy2);
		this.pEnemy.addDeployedUnit(unitEnemy2);
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAlly = new Army(this.board.getCell(1, 1), this.pAlly, 5);
		Unit testUnitenemy = new Army(this.board.getCell(0, 1), this.pEnemy, 1);

		assertEquals(testUnitAlly, this.unitAlly4);
		assertEquals(testUnitenemy, unitEnemy2);

		this.cellsEnemy.add(this.cellLeft);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());
		assertEquals(this.cellsEnemy, this.pEnemy.allControlledCells());

		this.unitsEnemy.add(unitEnemy2);
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());
		assertEquals(this.unitsEnemy, this.pEnemy.allDeployedUnits());

		assertEquals(31, this.pAlly.getAvailableUnits());
		assertEquals(33, this.pEnemy.getAvailableUnits());
	}

	@Test
	public void theFightWithEnemyLowerAndAloneInPlainTest() {
		Army unitEnemy1 = new Army(this.board.getCell(1, 0), this.pEnemy, 1);
		this.cellUp.addUnit(unitEnemy1);
		this.pEnemy.addDeployedUnit(unitEnemy1);
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAlly4 = new Army(this.board.getCell(1, 1), this.pAlly, 4);
		testUnitAlly4.setGold(2);
		Unit testUnitAlly1 = new Army(this.board.getCell(1, 0), this.pAlly, 1);

		assertEquals(testUnitAlly4, this.unitAlly4);

		this.cellsAlly.add(this.cellUp);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());
		assertEquals(this.cellsEnemy, this.pEnemy.allControlledCells());

		this.unitsAlly.add(testUnitAlly1);
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());
		assertEquals(this.unitsEnemy, this.pEnemy.allDeployedUnits());

		assertEquals(31, this.pAlly.getAvailableUnits());
		assertEquals(34, this.pEnemy.getAvailableUnits());
	}

	@Test
	public void theFightWithEnemyLowerAndAloneInMountainTest() {
		Army unitEnemy1 = new Army(this.board.getCell(0, 1), this.pEnemy, 1);
		this.cellLeft.addUnit(unitEnemy1);
		this.pEnemy.addDeployedUnit(unitEnemy1);
		this.dep.theFight(this.cellMid, this.board);

		Unit testUnitAlly4 = new Army(this.board.getCell(1, 1), this.pAlly, 4);
		testUnitAlly4.setGold(2);
		Unit testUnitAlly1 = new Army(this.board.getCell(0, 1), this.pAlly, 1);

		assertEquals(testUnitAlly4, this.unitAlly4);

		this.cellsAlly.add(this.cellLeft);
		assertEquals(this.cellsAlly, this.pAlly.allControlledCells());
		assertEquals(this.cellsEnemy, this.pEnemy.allControlledCells());

		this.unitsAlly.add(testUnitAlly1);
		assertEquals(this.unitsAlly, this.pAlly.allDeployedUnits());
		assertEquals(this.unitsEnemy, this.pEnemy.allDeployedUnits());

		assertEquals(31, this.pAlly.getAvailableUnits());
		assertEquals(34, this.pEnemy.getAvailableUnits());
	}

	@Test
	public void executeTest() {
		List<Cell> availableCells = this.board.getAvailableCells();
		availableCells.remove(this.cellMid);
		assertEquals(1, this.pAlly.allDeployedUnits().size());
		assertFalse(this.pAlly.allControlledCells().contains(this.cellUp));
		dep.execute(this.pAlly);
		assertEquals(2, this.pAlly.allDeployedUnits().size());
		assertTrue(this.pAlly.allControlledCells().contains(this.cellUp));
		assertEquals(availableCells, this.board.getAvailableCells());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(DeployArmyTest.class);
	}

}