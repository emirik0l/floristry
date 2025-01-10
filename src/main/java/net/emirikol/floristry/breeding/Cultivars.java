package net.emirikol.floristry.breeding;

import net.emirikol.floristry.block.FloristryBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.command.argument.packrat.Cut;

import java.util.*;

public class Cultivars {
	// Chances for vanilla flowers to propagate.
	private static final float VANILLA_COMMON = 0.25f;
	private static final float VANILLA_RARE = 0.20f;

	// Chance for "special" flowers to propagate.
	private static final float SPECIAL_PROPAGATE = 0.20f;

	// Chances for "special" flowers to mutate, according to tier.
	private static final float T1_MUTATE = 0.20f;
	private static final float T2_MUTATE = 0.15f;
	private static final float T3_MUTATE = 0.10f;
	private static final float T4_MUTATE = 0.05f;

	// Vanilla flower breeding.
	public static final Cultivar[] VANILLA = {
			new Cultivar(Blocks.ALLIUM, VANILLA_COMMON),
			new Cultivar(Blocks.AZURE_BLUET, VANILLA_COMMON),
			new Cultivar(Blocks.BLUE_ORCHID, VANILLA_COMMON),
			new Cultivar(Blocks.CORNFLOWER, VANILLA_COMMON),
			new Cultivar(Blocks.DANDELION, VANILLA_COMMON),
			new Cultivar(Blocks.OPEN_EYEBLOSSOM, VANILLA_RARE),
			new Cultivar(Blocks.LILAC, VANILLA_COMMON),
			new Cultivar(Blocks.LILY_OF_THE_VALLEY, VANILLA_COMMON),
			new Cultivar(Blocks.ORANGE_TULIP, VANILLA_COMMON),
			new Cultivar(Blocks.OXEYE_DAISY, VANILLA_COMMON),
			new Cultivar(Blocks.PINK_PETALS, VANILLA_COMMON),
			new Cultivar(Blocks.PINK_TULIP, VANILLA_COMMON),
			new Cultivar(Blocks.PEONY, VANILLA_COMMON),
			new Cultivar(Blocks.POPPY, VANILLA_COMMON),
			new Cultivar(Blocks.RED_TULIP, VANILLA_COMMON),
			new Cultivar(Blocks.ROSE_BUSH, VANILLA_COMMON),
			new Cultivar(Blocks.SUNFLOWER, VANILLA_COMMON),
			new Cultivar(Blocks.TORCHFLOWER, VANILLA_RARE),
			new Cultivar(Blocks.WHITE_TULIP, VANILLA_COMMON),
			new Cultivar(Blocks.WITHER_ROSE, VANILLA_RARE)
	};

	// Tier 1 flower breeding.
	public static final Cultivar[] BLOOMING_THISTLE = {
			new Cultivar(Blocks.ALLIUM, Blocks.LILAC, FloristryBlocks.BLOOMING_THISTLE, T1_MUTATE),
			new Cultivar(FloristryBlocks.BLOOMING_THISTLE, SPECIAL_PROPAGATE)
	};

	public static final Cultivar[] BRANDFLOWER = {
			new Cultivar(Blocks.TORCHFLOWER, Blocks.ORANGE_TULIP, FloristryBlocks.BRANDFLOWER, T1_MUTATE),
			new Cultivar(FloristryBlocks.BRANDFLOWER, SPECIAL_PROPAGATE)
	};

	public static final Cultivar[] BUBBLEBUD = {
			new Cultivar(Blocks.LILY_OF_THE_VALLEY, Blocks.ORANGE_TULIP, FloristryBlocks.BUBBLEBUD, T1_MUTATE),
			new Cultivar(Blocks.LILY_OF_THE_VALLEY, Blocks.PINK_TULIP, FloristryBlocks.BUBBLEBUD, T1_MUTATE),
			new Cultivar(Blocks.LILY_OF_THE_VALLEY, Blocks.RED_TULIP, FloristryBlocks.BUBBLEBUD, T1_MUTATE),
			new Cultivar(Blocks.LILY_OF_THE_VALLEY, Blocks.WHITE_TULIP, FloristryBlocks.BUBBLEBUD, T1_MUTATE),
			new Cultivar(FloristryBlocks.BUBBLEBUD, SPECIAL_PROPAGATE)
	};

	public static final Cultivar[] FALSE_ROSE = {
			new Cultivar(Blocks.ROSE_BUSH, Blocks.BLUE_ORCHID, FloristryBlocks.FALSE_ROSE, T1_MUTATE),
			new Cultivar(FloristryBlocks.FALSE_ROSE, SPECIAL_PROPAGATE)
	};

	public static final Cultivar[] HERMIT_PURPLE = {
			new Cultivar(Blocks.POPPY, Blocks.CORNFLOWER, FloristryBlocks.HERMIT_PURPLE, T1_MUTATE),
			new Cultivar(Blocks.RED_TULIP, Blocks.CORNFLOWER, FloristryBlocks.HERMIT_PURPLE, T1_MUTATE),
			new Cultivar(Blocks.ROSE_BUSH, Blocks.CORNFLOWER, FloristryBlocks.HERMIT_PURPLE, T1_MUTATE),
			new Cultivar(FloristryBlocks.HERMIT_PURPLE, SPECIAL_PROPAGATE)
	};

	public static final Cultivar[] MOONFLOWER = {
			new Cultivar(Blocks.SUNFLOWER, Blocks.OPEN_EYEBLOSSOM, FloristryBlocks.MOONFLOWER, T1_MUTATE),
			new Cultivar(FloristryBlocks.MOONFLOWER, SPECIAL_PROPAGATE)
	};

	public static final Cultivar[] PATINA_FLOWER = {
			new Cultivar(Blocks.AZURE_BLUET, Blocks.DANDELION, FloristryBlocks.PATINA_FLOWER, T1_MUTATE),
			new Cultivar(Blocks.AZURE_BLUET, Blocks.OXEYE_DAISY, FloristryBlocks.PATINA_FLOWER, T1_MUTATE),
			new Cultivar(FloristryBlocks.PATINA_FLOWER, SPECIAL_PROPAGATE)
	};

	public static final Cultivar[] WITHER_BUSH = {
			new Cultivar(Blocks.WITHER_ROSE, Blocks.ROSE_BUSH, FloristryBlocks.WITHER_BUSH, T1_MUTATE),
			new Cultivar(FloristryBlocks.WITHER_BUSH, SPECIAL_PROPAGATE)
	};

	//Tier 2 flower breeding.
	// TODO

	// Tier 3 flower breeding.
	// TODO

	// Tier 4 flower breeding.
	// TODO

	public static final List<Cultivar> CULTIVARS = new ArrayList<Cultivar>() {{
		addAll(List.of(VANILLA));
		addAll(List.of(BLOOMING_THISTLE));
		addAll(List.of(BRANDFLOWER));
		addAll(List.of(BUBBLEBUD));
		addAll(List.of(FALSE_ROSE));
		addAll(List.of(HERMIT_PURPLE));
		addAll(List.of(MOONFLOWER));
		addAll(List.of(PATINA_FLOWER));
		addAll(List.of(WITHER_BUSH));
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
