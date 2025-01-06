package net.emirikol.floristry.breeding;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.*;

public class Cultivars {
	private static final float VANILLA_COMMON = 0.25f;
	private static final float VANILLA_RARE = 0.15f;

	// Vanilla flower breeding.
	public static final Cultivar ALLIUM = new Cultivar(Blocks.ALLIUM, Blocks.ALLIUM, Blocks.ALLIUM, VANILLA_COMMON);
	public static final Cultivar AZURE_BLUET = new Cultivar(Blocks.AZURE_BLUET, Blocks.AZURE_BLUET, Blocks.AZURE_BLUET, VANILLA_COMMON);
	public static final Cultivar BLUE_ORCHID = new Cultivar(Blocks.BLUE_ORCHID, Blocks.BLUE_ORCHID, Blocks.BLUE_ORCHID, VANILLA_COMMON);
	public static final Cultivar CORNFLOWER = new Cultivar(Blocks.CORNFLOWER, Blocks.CORNFLOWER, Blocks.CORNFLOWER, VANILLA_COMMON);
	public static final Cultivar DANDELION = new Cultivar(Blocks.DANDELION, Blocks.DANDELION, Blocks.DANDELION, VANILLA_COMMON);
	public static final Cultivar LILAC = new Cultivar(Blocks.LILAC, Blocks.LILAC, Blocks.LILAC, VANILLA_COMMON);
	public static final Cultivar LILY_OF_THE_VALLEY = new Cultivar(Blocks.LILY_OF_THE_VALLEY, Blocks.LILY_OF_THE_VALLEY, Blocks.LILY_OF_THE_VALLEY, VANILLA_COMMON);
	public static final Cultivar ORANGE_TULIP = new Cultivar(Blocks.ORANGE_TULIP, Blocks.ORANGE_TULIP, Blocks.ORANGE_TULIP, VANILLA_COMMON);
	public static final Cultivar OXEYE_DAISY = new Cultivar(Blocks.OXEYE_DAISY, Blocks.OXEYE_DAISY, Blocks.OXEYE_DAISY, VANILLA_COMMON);
	public static final Cultivar PINK_TULIP = new Cultivar(Blocks.PINK_TULIP, Blocks.PINK_TULIP, Blocks.PINK_TULIP, VANILLA_COMMON);
	public static final Cultivar PEONY = new Cultivar(Blocks.PEONY, Blocks.PEONY, Blocks.PEONY, VANILLA_COMMON);
	public static final Cultivar POPPY = new Cultivar(Blocks.POPPY, Blocks.POPPY, Blocks.POPPY, VANILLA_COMMON);
	public static final Cultivar RED_TULIP = new Cultivar(Blocks.RED_TULIP, Blocks.RED_TULIP, Blocks.RED_TULIP, VANILLA_COMMON);
	public static final Cultivar ROSE_BUSH = new Cultivar(Blocks.ROSE_BUSH, Blocks.ROSE_BUSH, Blocks.ROSE_BUSH, VANILLA_COMMON);
	public static final Cultivar SUNFLOWER = new Cultivar(Blocks.SUNFLOWER, Blocks.SUNFLOWER, Blocks.SUNFLOWER, VANILLA_COMMON);
	public static final Cultivar TORCHFLOWER = new Cultivar(Blocks.TORCHFLOWER, Blocks.TORCHFLOWER, Blocks.TORCHFLOWER, VANILLA_RARE);
	public static final Cultivar WHITE_TULIP = new Cultivar(Blocks.WHITE_TULIP, Blocks.WHITE_TULIP, Blocks.WHITE_TULIP, VANILLA_COMMON);
	public static final Cultivar WITHER_ROSE = new Cultivar(Blocks.WITHER_ROSE, Blocks.WITHER_ROSE, Blocks.WITHER_ROSE, VANILLA_RARE);

	// Tier 1 flower breeding.
	// TODO

	//Tier 2 flower breeding.
	// TODO

	// Tier 3 flower breeding.
	// TODO

	// Tier 4 flower breeding.
	// TODO

	public static final List<Cultivar> CULTIVARS = new ArrayList<Cultivar>() {{
		add(ALLIUM);
		add(AZURE_BLUET);
		add(BLUE_ORCHID);
		add(CORNFLOWER);
		add(DANDELION);
		add(LILAC);
		add(LILY_OF_THE_VALLEY);
		add(ORANGE_TULIP);
		add(OXEYE_DAISY);
		add(PINK_TULIP);
		add(PEONY);
		add(POPPY);
		add(RED_TULIP);
		add(ROSE_BUSH);
		add(SUNFLOWER);
		add(TORCHFLOWER);
		add(WHITE_TULIP);
		add(WITHER_ROSE);
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
