package com.alien;

import com.alien.items.RegisterItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Alien implements ModInitializer {

	public static final String modId = "alien";
	public static final ItemGroup AlienItemGroup = FabricItemGroupBuilder.
			create(new Identifier(modId,"alientab"))
			.icon(()->new ItemStack(RegisterItems.xeno_zip))
			.build();

	@Override
	public void onInitialize() {
		RegisterItems.Register();
	}
}
