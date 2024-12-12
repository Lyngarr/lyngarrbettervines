package nonamecrackers2.witherstormmod;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrackersWitherStormClient implements ClientModInitializer {
	public static final String MOD_ID = "witherstormmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		LOGGER.info("CLIENT Hello Fabric world! " + MOD_ID);
	}
}