package com.alien.blocks;

import com.alien.Alien;
import com.alien.blocks.blocks.NeomorphEggSackBlock;
import com.alien.items.RegisterItems;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {
    public static Block neomorphEggSack = new NeomorphEggSackBlock(AbstractBlock.Settings.of(Material.PLANT)
            .dropsNothing()
            .resistance(0.1f)
            .hardness(0.1f)
            .nonOpaque());

    public static void Register(){
        Registry.register(Registry.BLOCK,new Identifier(Alien.modId,"neomorph_egg_sack"),neomorphEggSack);
        Registry.register(Registry.ITEM,new Identifier(Alien.modId,"neomorph_egg_sack_item"),new BlockItem(neomorphEggSack, new FabricItemSettings().group(Alien.AlienItemGroup)));
    }
}
