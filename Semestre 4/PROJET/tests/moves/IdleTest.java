package moves;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import boardgame.BoardGame;
import boardgame.Cell;
import boardgame.Fabrice;
import boardgame.Player;
import boardgame.Strategy;
import boardgame.Unit;
import boardgame.fabrices.FabriceEcolo;
import boardgame.moves.Idle;
import boardgame.moves.IdleEco;
import boardgame.players.EcoPlayer;
import boardgame.strategy.ConstStrat;
import boardgame.units.Worker;

//import

public class IdleTest {

	private String name;
	private Strategy strat;
	private Player p;
	private Fabrice fab;
	private Cell cellUp;
	private Cell cellMid;
	private Cell cellRight;
	private Cell cellLeft;
	private Idle idle;
	private BoardGame board;

	@Before
	public void before() {
		this.name = "Patrick";
		this.strat = new ConstStrat();
		this.p = new EcoPlayer(this.name, this.strat);
		this.idle = new IdleEco();
		this.fab = new FabriceEcolo();

		this.board = new BoardGame(3, 3, this.fab);
		this.board.setCell(this.cellUp = this.fab.buildForestCell(1, 0));
		this.board.setCell(this.cellMid = this.fab.buildPlainCell(1, 1));
		this.board.setCell(this.cellRight = this.fab.buildDesertCell(2, 1));
		this.board.setCell(this.cellLeft = this.fab.buildMountainCell(0, 1));
	}

	@Test
	public void executeWithNoWorkerDeployedTest() {
		this.idle.execute(this.p);
		assertEquals(15, this.p.getNeedQty());
	}

	@Test
	public void executeWithWorkerOnPlainTest() {
		Unit worker = new Worker(this.board.getCell(1, 1), this.p);
		this.cellMid.addUnit(worker);
		this.p.addDeployedUnit(worker);
		this.idle.execute(this.p);
		assertEquals(16, this.p.getNeedQty());
	}

	@Test
	public void executeWithWorkerOnForestTest() {
		Unit worker = new Worker(this.board.getCell(1, 0), this.p);
		this.cellUp.addUnit(worker);
		this.p.addDeployedUnit(worker);
		this.idle.execute(this.p);
		assertEquals(16, this.p.getNeedQty());
	}

	@Test
	public void executeWithWorkerOnDesertTest() {
		Unit worker = new Worker(this.board.getCell(2, 1), this.p);
		this.cellRight.addUnit(worker);
		this.p.addDeployedUnit(worker);
		this.idle.execute(this.p);
		assertEquals(17, this.p.getNeedQty());
	}

	@Test
	public void executeWithWorkerOnMountainTest() {
		Unit worker = new Worker(this.board.getCell(0, 1), this.p);
		this.cellLeft.addUnit(worker);
		this.p.addDeployedUnit(worker);
		this.idle.execute(this.p);
		assertEquals(15, this.p.getNeedQty());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(IdleTest.class);
	}

}