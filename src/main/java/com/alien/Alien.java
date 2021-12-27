package com.alien;

import com.alien.blocks.RegisterBlocks;
import com.alien.items.RegisterItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

public class Alien implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("alien");

	public static final String modId = "alien";

	public static final ItemGroup AlienItemGroup = FabricItemGroupBuilder.
			create(new Identifier(modId,"alientab"))
			.icon(()->new ItemStack(RegisterItems.xeno_zip))
			.build();

	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		RegisterItems.Register();
		RegisterBlocks.Register();
	}
}
