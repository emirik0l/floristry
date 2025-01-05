package net.emirikol.floristry.breeding;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.*;

public class Cultivars {
	// Vanilla flower breeding.
	public static final Cultivar POPPY = new Cultivar(Blocks.POPPY, Blocks.POPPY, Blocks.POPPY, 0.10f);
	public static final Cultivar ROSE_BUSH = new Cultivar(Blocks.ROSE_BUSH, Blocks.ROSE_BUSH, Blocks.ROSE_BUSH, 0.10f);

	public static final List<Cultivar> CULTIVARS = new ArrayList<Cultivar>() {{
		add(POPPY);
		add(ROSE_BUSH);
	}};

	public static List<Cultivar> getMatches(Block[] parents) {
		return new ArrayList<Cultivar>() {{
			for (Cultivar cultivar: CULTIVARS) {
				if (cultivar.isMatch(parents)) { add(cultivar); }
			}
		}};
	}

	public static Optional<Cultivar> breedingRoll(List<Cultivar> candidates) {
		Random rand = new Random();

		// Sort and then reverse the list to arrange in descending order of frequency.
		candidates.sort(Comparator.comparing(Cultivar::getFrequency));
		Collections.reverse(candidates);

		// Iterate through candidates until one returns a hit.
		for (Cultivar candidate : candidates) {
			if (rand.nextFloat() <= candidate.getFrequency()) { return Optional.of(candidate); }
		}

		// If no hits, return nothing.
		return Optional.empty();
	}
}
