package moves;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import boardgame.BoardGame;
import boardgame.Cell;
import boardgame.Fabrice;
import boardgame.Game;
import boardgame.Player;
import boardgame.Strategy;
import boardgame.fabrices.FabriceEcolo;
import boardgame.game.GameEco;
import boardgame.moves.Deploy;
import boardgame.moves.DeployWorker;
import boardgame.players.EcoPlayer;
import boardgame.strategy.ConstStrat;
import boardgame.units.Worker;

public class DeployWorkerTest {

	private String name;
	private Strategy strat;
	private Player p;
	private Fabrice fab;
	private Cell cellUp;
	private Deploy dep;

	private BoardGame board;
	private Game game;

	@Before
	public void before() {
		this.name = "Patrick";
		this.strat = new ConstStrat();
		this.p = new EcoPlayer(this.name, this.strat);
		this.fab = new FabriceEcolo();
		this.cellUp = this.fab.buildPlainCell(1, 0);
		this.dep = new DeployWorker();
		this.board = new BoardGame(3, 3, this.fab);
		this.board.setCell(this.cellUp);
		this.game = new GameEco(this.board, 10);
		this.p.setPlayingGame(this.game);
	}

	@Test
	public void placeUnitTest() {
		Worker worker = new Worker(this.cellUp, this.p);
		assertFalse(worker.equals(this.cellUp.getUnit()));
		assertEquals(worker, this.dep.placeUnit(this.cellUp, this.p));
	}

	@Test
	public void executeTest() {
		List<Cell> availableCells = this.board.getAvailableCells();
		availableCells.remove(this.cellUp);
		assertEquals(0, this.p.allDeployedUnits().size());
		assertFalse(this.p.allControlledCells().contains(this.cellUp));
		dep.execute(this.p);
		assertEquals(1, this.p.allDeployedUnits().size());
		assertTrue(this.p.allControlledCells().contains(this.cellUp));
		assertEquals(availableCells, this.board.getAvailableCells());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(DeployWorkerTest.class);
	}

}