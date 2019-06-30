package brown_bricks.bored.brown_bricks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import brown_bricks.bored.brown_bricks.BrownBricks;
import brown_bricks.bored.brown_bricks.init.BrownBricksItems;

public class BrownBricksTab extends CreativeTabs{
	
	public BrownBricksTab() {
		super(BrownBricks.MODID);
		setBackgroundImageName("item_search.png");
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BrownBricksItems.brown_brick);
	}
	@Override
	public boolean hasSearchBar(){
		return true;
	}
}