package brown_bricks.bored.brown_bricks.util;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import brown_bricks.bored.brown_bricks.init.BrownBricksItems;
import brown_bricks.bored.brown_bricks.init.BrownBricksBlocks;

public class BrownBricksSmelting {
	public static void init() {
		GameRegistry.addSmelting(BrownBricksItems.brown_clay, new ItemStack(BrownBricksItems.brown_brick), 0.5F);
		//GameRegistry.addSmelting(Items.CLAY_BALL, output, xp);
	}
	
}
