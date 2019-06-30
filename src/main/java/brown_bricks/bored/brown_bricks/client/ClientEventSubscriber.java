package brown_bricks.bored.brown_bricks.client;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nonnull;

import brown_bricks.bored.brown_bricks.BrownBricks;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

/**
 * Subscribe to events that should be handled on the PHYSICAL CLIENT in this class
 */
@Mod.EventBusSubscriber(modid = BrownBricks.MODID, value = CLIENT)
public final class ClientEventSubscriber {

	/**
	 * This method will be called by Forge when it is time for the mod to register its models.
	 * This method will always be called after the block and item registry methods.
	 */
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void onRegisterModelsEvent(@Nonnull final ModelRegistryEvent event) {
		ForgeRegistries.ITEMS.getValues().stream()
		.filter(item -> item.getRegistryName().getResourceDomain().equals(BrownBricks.MODID))
		.forEach(item -> {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));
		});

	}

}
