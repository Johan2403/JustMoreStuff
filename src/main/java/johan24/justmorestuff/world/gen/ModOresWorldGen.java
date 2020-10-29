package johan24.justmorestuff.world.gen;

import java.util.Random;

import johan24.justmorestuff.init.ModBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModOresWorldGen implements IWorldGenerator {
	
	private final WorldGenMinable obsdianiteOreOverworldGen;
	private final WorldGenMinable ancientDebrisNetherGen;

	public ModOresWorldGen() {
		obsdianiteOreOverworldGen = new WorldGenMinable(ModBlocks.OBSIDIANITE_ORE.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE));
		ancientDebrisNetherGen = new WorldGenMinable(ModBlocks.ANCIENT_DEBRIS.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.NETHERRACK));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionType()) {
		 
	    case NETHER:
	    	genStandard(ancientDebrisNetherGen, world, random, chunkX, chunkZ, 3, 8, 22);
	        break;
	 
	    case OVERWORLD:
	        genStandard(obsdianiteOreOverworldGen, world, random, chunkX, chunkZ, 10, 5, 16);
	        break;
	 
	    case THE_END:
	        break;
	 
	    }
	}
	
	private void genStandard(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int spawnTries, int minHeight, int maxHeight) {
		if(minHeight < 0) minHeight = 0;
	    if(maxHeight > 255) maxHeight = 255;
	 
	    if(maxHeight < minHeight) {
	        int i = minHeight;
	        minHeight = maxHeight;
	        maxHeight = i;
	    } else if(maxHeight == minHeight) {
	        if(maxHeight < 255) {
	            maxHeight++;
	        } else minHeight--;
	    }
	 
	    BlockPos chunkPosAsBlockPos = new BlockPos(chunkX << 4, 0, chunkZ << 4);
	    int heightDiff = maxHeight - minHeight + 1;
	 
	    for (int i = 0; i < spawnTries; i++) {
	        generator.generate(world, random, 
	        	chunkPosAsBlockPos.add(
	        		random.nextInt(16),
	        		minHeight + random.nextInt(heightDiff),
	        		random.nextInt(16)
	        	)
	        );
	    }
	}
}
