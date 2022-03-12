package moves;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import boardgame.Resource;
import boardgame.moves.Exchange;
import boardgame.players.EcoPlayer;
import boardgame.resources.Wood;
import boardgame.strategy.ConstStrat;

//import

public class ExchangeTest {

	private String name;
	private ConstStrat strat;
	private EcoPlayer p;
	private Exchange exch;

	private Map<String, ArrayList<Resource>> resourceMap;
	private List<Resource> resources;
	private Wood wood;

	@Before
	public void before() {
		this.name = "Patrick";
		this.strat = new ConstStrat();
		this.p = new EcoPlayer(this.name, this.strat);
		this.p.allResources().put("Wood", new ArrayList<Resource>());
		this.exch = new Exchange(false);

		this.resourceMap = new HashMap<String, ArrayList<Resource>>();
		this.resourceMap.put("Wood", new ArrayList<Resource>());
		this.resources = new ArrayList<Resource>();
		this.wood = new Wood(2);

		this.resources.add(wood);
		this.p.addResource(wood);
		this.resourceMap.get("Wood").add(wood);
	}

	@Test(expected = NullPointerException.class)
	public void ExecuteWithNoResourcesTest() {
		this.p.removeResource("Wood", 1);
		this.exch.execute(this.p);
	}

	@Test(expected = NullPointerException.class)
	public void ExecuteButPlayerDoNotExchangeTest() {
		this.exch.execute(this.p);
		assertEquals(15, this.p.getNeedQty());
		assertEquals(this.resourceMap, this.p.allResources());
	}

	@Test(expected = NullPointerException.class)
	public void ExecuteWithNotEnoughResourcesTest() {
		this.exch.execute(this.p);
		assertEquals(15, this.p.getNeedQty());
		assertEquals(this.resourceMap, this.p.allResources());
	}

	@Test
	public void ExecuteWithEnoughResourcesTest() {
		this.strat.setExchangeDone(true);
		this.resourceMap.get("Wood").remove(wood);
		this.exch.execute(this.p);
		assertEquals(17, this.p.getNeedQty());
		assertEquals(this.resourceMap, this.p.allResources());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(ExchangeTest.class);
	}

}