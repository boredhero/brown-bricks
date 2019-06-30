package brown_bricks.bored.brown_bricks;

import com.google.common.base.Preconditions;

import brown_bricks.bored.brown_bricks.BrownBricks;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = BrownBricks.MODID)
public final class EventSubscriber {

	/**
	 * This method will be called by Forge when it is time for the mod to register its blocks.
	 * This method will always be called before the item registry method.
	 */
	@SubscribeEvent
	public static void onRegisterBlocksEvent(@Nonnull final RegistryEvent.Register<Block> event) {

		event.getRegistry().registerAll(
			setup(new Block(Material.ROCK), "brown_bricks_block").setCreativeTab(BrownBricks.creativeTab)
		);

	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {

		final IForgeRegistry<Item> registry = event.getRegistry();

		registry.registerAll(
			
			setup(new Item(), "brown_brick").setCreativeTab(BrownBricks.creativeTab),
			setup(new Item(), "brown_clay").setCreativeTab(BrownBricks.creativeTab)
		);

		ForgeRegistries.BLOCKS.getValues().stream()
		.filter(block -> block.getRegistryName().getResourceDomain().equals(BrownBricks.MODID))
		.filter(EventSubscriber::hasItemBlock)
		.forEach(block -> {
				registry.register(setup(new ItemBlock(block), block.getRegistryName()));
		});

	}

	/**
	 * Helper method to determine if a block has an ItemBlock
	 */
	private static boolean hasItemBlock(@Nonnull final Block block) {
		return true; //change this to return false if the block doesn’t have an ItemBlock
	}

	/**
	 * Helper method to correctly setup a registry entry.
	 * Calls setRegistryName with the appropriate parameters
	 * If applicable also calls setTranslationKey with the appropriate parameters
	 * @return Returns the entry passed in
	 */
	@SuppressWarnings("rawtypes")
	@Nonnull
	public static <T extends IForgeRegistryEntry> T setup(@Nonnull final T entry, @Nonnull final String name) {
		return setup(entry, new ResourceLocation(BrownBricks.MODID, name));
	}

	/**
	 * Helper method to correctly setup a registry entry.
	 * Calls setRegistryName with the appropriate parameters
	 * If applicable also calls setTranslationKey with the appropriate parameters
	 * @return Returns the entry passed in
	 */
	@SuppressWarnings("rawtypes")
	@Nonnull
	public static <T extends IForgeRegistryEntry> T setup(@Nonnull final T entry, @Nonnull final ResourceLocation registryName) {

		Preconditions.checkNotNull(entry, "entry to setup must not be null!");
		Preconditions.checkNotNull(registryName, "registryName to assign must not be null!");

		entry.setRegistryName(registryName);
		if (entry instanceof Block) {
			((Block) entry).setUnlocalizedName(registryName.getResourceDomain() + "." + registryName.getResourcePath());
		}
		if (entry instanceof Item) {
			((Item) entry).setUnlocalizedName(registryName.getResourceDomain() + "." + registryName.getResourcePath());
		}
		return entry;
	}

}
