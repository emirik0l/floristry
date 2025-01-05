package net.emirikol.floristry.breeding;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class Cultivars {
	// Vanilla flower breeding.
	public static final Cultivar POPPY = new Cultivar(Blocks.POPPY, Blocks.POPPY, Blocks.POPPY, 0.10f);
	public static final Cultivar ROSE_BUSH = new Cultivar(Blocks.ROSE_BUSH, Blocks.ROSE_BUSH, Blocks.ROSE_BUSH, 0.10f);

	public static final List<Cultivar> CULTIVARS = new ArrayList<Cultivar>() {{
		add(POPPY);
		add(ROSE_BUSH);
	}};

	public static List<Cultivar> getMatches(Block[] parents) {
		List<Cultivar> output = new ArrayList<Cultivar>();
		for (Cultivar cultivar : CULTIVARS) {
			if (cultivar.isMatch(parents)) { output.add(cultivar); }
		}
		return output;
	}
}
