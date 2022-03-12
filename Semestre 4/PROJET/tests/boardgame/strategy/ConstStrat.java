package boardgame.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import boardgame.BoardGame;
import boardgame.Cell;
import boardgame.Move;
import boardgame.Resource;
import boardgame.Strategy;
import boardgame.Unit;

/**
 * ONLY USED FOR TESTING. Changer les valeurs au return qui vous sont utiles.
 */

public class ConstStrat implements Strategy {

	private Random random;
	private boolean exchangeDone;

	public ConstStrat() {
		this.exchangeDone = false;
	}

	public void setExchangeDone(boolean b) {
		this.exchangeDone = b;
	}

	@Override
	public Cell chooseCell(BoardGame board) {
		boolean possibleToPlace = false;
		Cell cell = null;
		while (!possibleToPlace) {
			int x = 1;
			int y = 0;
			cell = board.getCell(x, y);
			if (!cell.isBusy()) {
				possibleToPlace = true;
			}
		}
		return cell;
	}

	@Override
	public int chooseSize(int min, int max) {
		return 3;
	}

	@Override
	public int chooseAmount(int min, int max) {
		return 1;
	}

	@Override
	public int chooseX(int min, int max) {
		return 1;

	}

	@Override
	public int chooseY(int min, int max) {
		return 1;
	}

	@Override
	public Move chooseMove(List<Move> moves) {
		return moves.get(this.random.nextInt(moves.size()));
	}

	@Override
	public String chooseResourceType(HashMap<String, ArrayList<Resource>> resource) {
		Set<String> key = resource.keySet();
		String[] ar = key.toArray(new String[0]);

		if (exchangeDone) {
			exchangeDone = false;
			return ar[0];
		} else {
			return null;
		}
	}

	@Override
	public Unit chooseUnit(List<Unit> ownedUnits) {
		Unit chosenUnit = null;
		for (Unit unit : ownedUnits) {
			if (chosenUnit == null) {
				chosenUnit = unit;
			}
		}
		return chosenUnit;
	}

}
