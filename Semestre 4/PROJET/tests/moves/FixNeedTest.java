package moves;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import boardgame.BoardGame;
import boardgame.Cell;
import boardgame.Fabrice;
import boardgame.Game;
import boardgame.Player;
import boardgame.Resource;
import boardgame.Strategy;
import boardgame.Unit;
import boardgame.fabrices.FabriceArmy;
import boardgame.fabrices.FabriceEcolo;
import boardgame.game.GameWar;
import boardgame.moves.FixNeed;
import boardgame.players.EcoPlayer;
import boardgame.players.WarPlayer;
import boardgame.strategy.ConstStrat;
import boardgame.units.Army;
import boardgame.units.Worker;

public class FixNeedTest {

	private String nameArmy;
	private Strategy strat;
	private WarPlayer pArmy;
	private String nameEco;
	private Player pEco;

	private FixNeed fix;

	private Fabrice fabEco;
	private BoardGame boardEco;
	private Cell cellPlainEco;

	private Fabrice fabArmy;
	private BoardGame boardArmy;
	private List<Cell> available;
	private Cell cellPlainArmy;

	private List<Unit> unitsPArmy;
	private List<Cell> cellsPArmy;
	private List<Unit> unitsPEco;
	private List<Cell> cellsPEco;

	private Unit army4;
	private Unit worker;

	private Game game;

	@Before
	public void before() {
		this.nameArmy = "Army";
		this.strat = new ConstStrat();
		this.pArmy = new WarPlayer(this.nameArmy, this.strat);
		this.pArmy.allResources().put("Wood", new ArrayList<Resource>());
		this.nameEco = "Eco";
		this.pEco = new EcoPlayer(this.nameEco, this.strat);

		this.fix = new FixNeed();

		this.fabEco = new FabriceEcolo();
		this.boardEco = new BoardGame(3, 3, this.fabEco);
		this.boardEco.setCell(this.cellPlainEco = this.fabEco.buildPlainCell(1, 1));

		this.fabArmy = new FabriceArmy();
		this.boardArmy = new BoardGame(3, 3, this.fabArmy);
		this.available = this.boardArmy.getAvailableCells();
		this.boardArmy.setCell(this.cellPlainArmy = this.fabArmy.buildPlainCell(1, 1));

		this.unitsPArmy = new ArrayList<Unit>();
		this.cellsPArmy = new ArrayList<Cell>();
		this.unitsPEco = new ArrayList<Unit>();
		this.cellsPEco = new ArrayList<Cell>();

		this.army4 = new Army(this.boardArmy.getCell(1, 1), this.pArmy, 4);
		this.pArmy.addDeployedUnit(this.army4);
		this.unitsPArmy.add(army4);
		this.cellPlainArmy.addUnit(army4);
		this.cellsPArmy.add(cellPlainArmy);

		this.worker = new Worker(this.boardEco.getCell(1, 1), this.pEco);
		this.pEco.addDeployedUnit(this.worker);
		this.unitsPEco.add(worker);
		this.cellPlainEco.addUnit(worker);
		this.cellsPEco.add(cellPlainEco);

		this.game = new GameWar(this.boardArmy, 10);
		this.pArmy.setPlayingGame(this.game);
	}

	@Test
	public void satisfyingPlainArmyTest() {
		this.fix.setRqdNeed(4);
		this.fix.satisfying(this.pArmy, this.army4);
		assertEquals(6, this.pArmy.getNeedQty());
		assertEquals(0, this.fix.getRqdNeed());
		assertEquals(0, this.army4.getGold());
	}

	@Test
	public void satisfyingPlainEcoTest() {
		this.fix.setRqdNeed(1);
		this.fix.satisfying(this.pEco, this.worker);
		assertEquals(14, this.pEco.getNeedQty());
		assertEquals(0, this.fix.getRqdNeed());
		assertEquals(1, this.worker.getGold());
	}

	@Test
	public void sacrificeOccuringTest() {
		this.fix.setRqdNeed(0);
		this.unitsPArmy.remove(0);
		this.fix.sacrificeOccuring(this.pArmy, this.army4, this.boardArmy);
		assertEquals(-4, this.fix.getRqdNeed());
		assertEquals(this.unitsPArmy, this.pArmy.allDeployedUnits());
	}

	@Test
	public void sacrificeSelectionTest() {
		this.fix.setRqdNeed(0);
		this.unitsPArmy.remove(0);
		this.fix.sacrificeSelection(this.pArmy, this.boardArmy);
		assertEquals(-4, this.fix.getRqdNeed());
		assertEquals(this.unitsPArmy, this.pArmy.allDeployedUnits());
		assertEquals(1, this.pArmy.getGold());
	}

	@Test
	public void everybodyIsGoneTest() {
		this.pArmy.addDeployedUnit(new Army(this.boardArmy.getCell(0, 1), this.pArmy, 4));
		this.unitsPArmy.remove(0);
		this.cellsPArmy.remove(0);
		this.fix.everybodyIsGone(this.pArmy, this.boardArmy);
		assertEquals(0, this.fix.getRqdNeed());
		assertEquals(cellsPArmy, this.pArmy.allControlledCells());
		assertEquals(unitsPArmy, this.pArmy.allDeployedUnits());
		assertEquals(this.available, this.boardArmy.getAvailableCells());
		assertEquals(2, this.pArmy.getGold());
	}

	@Test
	public void executeWith0SatisfiableNeedFromPlayerTest() {
		this.pArmy.setNeedQty(0);
		this.unitsPArmy.remove(0);
		this.cellsPArmy.remove(0);
		this.fix.execute(this.pArmy);
		assertEquals(0, this.fix.getRqdNeed());
		assertEquals(cellsPArmy, this.pArmy.allControlledCells());
		assertEquals(unitsPArmy, this.pArmy.allDeployedUnits());
		assertEquals(this.available, this.boardArmy.getAvailableCells());
	}

	@Test
	public void executeWithEnoughSatisfiableNeedFromPlayerTest() {
		this.fix.execute(this.pArmy);
		assertEquals(6, this.pArmy.getNeedQty());
		assertEquals(0, this.fix.getRqdNeed());
		assertEquals(0, this.army4.getGold());
	}

	@Test
	public void executeWithNotEnoughSatisfiableNeedFromPlayerTest() {
		this.pArmy.setNeedQty(1);
		this.unitsPArmy.remove(0);
		this.cellsPArmy.remove(0);
		this.fix.execute(this.pArmy);
		assertEquals(1, this.pArmy.getNeedQty());
		assertEquals(0, this.fix.getRqdNeed());
		assertEquals(cellsPArmy, this.pArmy.allControlledCells());
		assertEquals(unitsPArmy, this.pArmy.allDeployedUnits());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(FixNeedTest.class);
	}

}