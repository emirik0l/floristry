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

	public boolean isMatch(Block[] parentCandidates) {
		return (this.parents[0] == parentCandidates[0] && this.parents[1] == parentCandidates[1]) || (this.parents[0] == parentCandidates[1] && this.parents[1] == parentCandidates[0]);
	}

	public Block getChild() { return this.child; }
	public float getFrequency() { return this.frequency; }

	@Override
	public String toString() {
		return String.format("%s + %s = %s", parents[0].getName().getString(), parents[1].getName().getString(), child.getName().getString());
	}
}
