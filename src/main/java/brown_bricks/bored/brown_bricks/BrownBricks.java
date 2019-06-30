package brown_bricks.bored.brown_bricks;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import brown_bricks.bored.brown_bricks.BrownBricksTab;
import brown_bricks.bored.brown_bricks.proxy.IProxy;
import brown_bricks.bored.brown_bricks.util.BrownBricksSmelting;

@Mod(modid = BrownBricks.MODID, name = BrownBricks.NAME, version = BrownBricks.VERSION, acceptedMinecraftVersions = "[1.12, 1.12.2]")

public class BrownBricks {
	public static final String MODID = "brown_bricks";
	public static final String NAME = "Brown Bricks";
	public static final String VERSION = "0.0.1";
	
	public static final BrownBricksTab creativeTab = new BrownBricksTab();
	
	public static final Logger LOGGER = LogManager.getLogger(BrownBricks.MODID);
	
	public static final String CLIENT = "brown_bricks.bored.brown_bricks.proxy.ClientProxy";
	public static final String SERVER = "brown_bricks.bored.brown_bricks.proxy.ServerProxy";
	@SidedProxy(clientSide = BrownBricks.CLIENT, serverSide = BrownBricks.SERVER)
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LOGGER.info(BrownBricks.NAME + " " + BrownBricks.VERSION + " PreInit");
		proxy.preInit(event);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		LOGGER.info(BrownBricks.NAME + " " + BrownBricks.VERSION + " Init");
		proxy.Init(event);
		BrownBricksSmelting.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LOGGER.info(BrownBricks.NAME + " " + BrownBricks.VERSION + " PostInit");
		LOGGER.info("Hmm, do you have that game, \"Miney Crafta\"? Penny was telling me she was playing it on her computer book. Let's play Miney Crafta!");
	}
	
	
}
