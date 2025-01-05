package net.emirikol.floristry.breeding;


import net.minecraft.block.Block;

import java.util.*;

public class Cultivar {
	private Block[] parents;
	private Block child;
	private float frequency;

	public Cultivar(Block left, Block right, Block child, float frequency) {
		this.parents = new Block[2];
		this.parents[0] = left;
		this.parents[1] = right;
		this.child = child;
		this.frequency = frequency;
	}

	public boolean roll() {
		Random rand = new Random();
		return rand.nextFloat() <= this.frequency;
	}

	public boolean isMatch(Block[] parents) {
		return (this.parents[0] == parents[0] && this.parents[1] == parents[1]) || (this.parents[0] == parents[1] && this.parents[1] == parents[0]);
	}
}
