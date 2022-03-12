package moves;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import boardgame.BoardGame;
import boardgame.Cell;
import boardgame.Fabrice;
import boardgame.Resource;
import boardgame.Strategy;
import boardgame.Unit;
import boardgame.fabrices.FabriceArmy;
import boardgame.moves.Harvest;
import boardgame.players.EcoPlayer;
import boardgame.strategy.ConstStrat;
import boardgame.units.Worker;

public class HarvestTest {

	private String name;
	private Strategy strat;
	private EcoPlayer p;
	private Harvest harv;

	private Fabrice fab;
	private BoardGame board;

	private Cell cell;
	private Unit worker;

	private Map<String, ArrayList<Resource>> resourceMap;
	private Resource res;
	private ArrayList<Resource> resources;

	@Before
	public void before() {
		this.name = "Patrick";
		this.strat = new ConstStrat();
		this.p = new EcoPlayer(this.name, this.strat);
		this.p.allResources().put("Wood", new ArrayList<Resource>());
		this.harv = new Harvest();

		this.fab = new FabriceArmy();
		this.board = new BoardGame(3, 3, this.fab);
		this.board.setCell(this.cell = this.fab.buildForestCell(1, 1));

		this.worker = new Worker(this.cell, this.p);

		this.resourceMap = new HashMap<String, ArrayList<Resource>>();
		this.resourceMap.put("Wood", new ArrayList<Resource>());
		this.resources = new ArrayList<Resource>();
	}

	@Test
	public void executeTest() {
		this.p.addDeployedUnit(this.worker);
		this.res = this.cell.getResource();
		this.resources.add(this.res);
		this.resourceMap.put(this.res.getId(), this.resources);
		this.harv.execute(this.p);
		assertEquals(this.resourceMap, this.p.allResources());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(HarvestTest.class);
	}
}