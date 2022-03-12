package players;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import boardgame.BoardGame;
import boardgame.Cell;
import boardgame.Fabrice;
import boardgame.Game;
import boardgame.Resource;
import boardgame.Strategy;
import boardgame.Unit;
import boardgame.cells.PlainCell;
import boardgame.fabrices.FabriceArmy;
import boardgame.game.GameWar;
import boardgame.players.WarPlayer;
import boardgame.resources.Wood;
import boardgame.strategy.RandomStrat;
import boardgame.units.Army;

public class WarPlayerTest { // TODO

	private String name;
	private Strategy strat;
	private WarPlayer p;
	private Cell cell;
	private Army army;
	private Map<String, ArrayList<Resource>> resourceMap;
	private Resource res;
	private List<Unit> units;
	private List<Cell> cells;
	private ArrayList<Resource> resources;

	private Fabrice fab;
	private BoardGame board;
	private Game game;

	@Before
	public void before() {
		this.name = "Patrick";
		this.strat = new RandomStrat();
		this.p = new WarPlayer(this.name, this.strat);
		this.p.allResources().put("Wood", new ArrayList<Resource>());
		this.cell = new PlainCell(1, 2, 3, 4, 5, 6);
		this.army = new Army(this.cell, this.p, 3);
		this.resourceMap = new HashMap<String, ArrayList<Resource>>();
		this.resourceMap.put("Wood", new ArrayList<Resource>());
		this.res = new Wood(5);
		this.units = new ArrayList<Unit>();
		this.cells = new ArrayList<Cell>();
		this.resources = new ArrayList<Resource>();

		this.fab = new FabriceArmy();
		this.board = new BoardGame(3, 3, this.fab);
		this.game = new GameWar(this.board, 10);
	}

	@Test
	public void setAndGetPlayingGameTest() {
		this.p.setPlayingGame(this.game);
		assertEquals(this.game, this.p.getPlayingGame());
	}

	@Test
	public void getGoldTest() {
		assertEquals(0, this.p.getGold());
	}

	@Test
	public void setGoldTest() {
		this.p.setGold(2);
		assertEquals(2, this.p.getGold());
	}

	@Test
	public void getMaxUnitTest() {
		assertEquals(35, this.p.getAvailableUnits());
	}

	@Test
	public void setMaxUnitTest() {
		this.p.setAvailableUnits(2);
		assertEquals(2, this.p.getAvailableUnits());
	}

	@Test
	public void getNeedQtyTest() {
		assertEquals(10, this.p.getNeedQty());
	}

	@Test
	public void setNeedQtyTest() {
		this.p.setNeedQty(2);
		assertEquals(2, this.p.getNeedQty());
	}

	@Test
	public void getScoreTest() {
		assertEquals(0, this.p.getScore());
	}

	@Test
	public void setScoreTest() {
		this.p.setScore(2);
		assertEquals(2, this.p.getScore());
	}

	@Test
	public void getStrategyTest() {
		assertEquals(this.strat, this.p.getStrategy());
	}

	@Test
	public void addDeployedUnitWithEnoughUnitsTest() {
		assertEquals(this.units, this.p.allDeployedUnits());
		this.units.add(this.army);
		this.cells.add(this.cell);
		this.p.addDeployedUnit(this.army);
		assertEquals(this.units, this.p.allDeployedUnits());
		assertEquals(this.cells, this.p.allControlledCells());
		assertEquals(32, this.p.getAvailableUnits());
	}

	@Test
	public void addDeployedUnitWithoutEnoughUnitsTest() {
		assertEquals(this.units, this.p.allDeployedUnits());
		this.p.setAvailableUnits(-1);
		this.p.addDeployedUnit(this.army);
		assertEquals(this.units, this.p.allDeployedUnits());
		assertEquals(this.cells, this.p.allControlledCells());
		assertEquals(-1, this.p.getAvailableUnits());
	}

	@Test
	public void removeUnitTest() {
		assertEquals(0, this.p.getGold());
		this.p.addDeployedUnit(this.army);
		this.p.removeUnit(this.army);
		assertEquals(this.units, this.p.allDeployedUnits());
		assertEquals(this.cells, this.p.allControlledCells());
		assertEquals(1, this.p.getGold());
	}

	@Test
	public void traitorousUnitTest() {
		WarPlayer pTest = new WarPlayer(this.name, this.strat);
		this.p.addDeployedUnit(this.army);
		this.p.traitorousUnit(this.army, pTest);
		assertEquals(this.units, this.p.allDeployedUnits());
		assertEquals(this.cells, this.p.allControlledCells());
		this.units.add(this.army);
		this.cells.add(this.cell);
		assertEquals(this.units, pTest.allDeployedUnits());
		assertEquals(this.cells, pTest.allControlledCells());
	}

	@Test
	public void allControlledCellsTest() {
		assertEquals(this.cells, this.p.allControlledCells());
		this.cells.add(this.cell);
		this.p.addDeployedUnit(this.army);
		assertEquals(this.cells, this.p.allControlledCells());
	}

	@Test
	public void allResourcesTest() {
		assertEquals(this.resourceMap, this.p.allResources());
	}

	@Test
	public void addResourceTest() {
		this.resources.add(this.res);
		this.resourceMap.put(this.res.getId(), this.resources);
		this.p.addResource(this.res);
		assertEquals(this.resourceMap, this.p.allResources());
	}

	@Test
	public void getResAmntTest() {
		assertEquals(0, this.p.getResAmnt("Wood"));
		this.p.addResource(this.res);
		assertEquals(1, this.p.getResAmnt("Wood"));
	}

	@Test
	public void removeResourceNothingLeftTest() {
		this.p.addResource(this.res);
		this.p.removeResource("Wood", 1);
		assertEquals(this.resourceMap, this.p.allResources());
		assertEquals(this.resources, this.p.getResourceList("Wood"));
	}

	@Test
	public void removeResourceOneLeftTest() {
		this.resources.add(this.res);
		this.resourceMap.put("Wood", this.resources);
		this.p.addResource(this.res);
		this.p.addResource(this.res);
		this.p.removeResource("Wood", 1);
		assertEquals(this.resourceMap, this.p.allResources());
		assertEquals(this.resources, this.p.getResourceList("Wood"));
	}

	@Test
	public void getRessourceList() {
		assertEquals(this.resources, this.p.getResourceList("Wood"));
		this.p.addResource(this.res);
		this.resources.add(this.res);
		assertEquals(this.resources, this.p.getResourceList("Wood"));
	}

	@Test
	public void EqualsTest() {
		WarPlayer pTest = new WarPlayer(this.name, this.strat);
		pTest.allResources().put("Wood", new ArrayList<Resource>());
		assertTrue(pTest.equals(this.p));
	}
}