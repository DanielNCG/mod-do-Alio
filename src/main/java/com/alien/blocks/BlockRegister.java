package com.alien.blocks;

import com.alien.Alien;
import com.alien.blocks.blocks.NeomorphEggSackBlock;
import com.alien.items.RegisterItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegister {
    public static Block neomorphEggSack = new NeomorphEggSackBlock(AbstractBlock.Settings.of(Material.PLANT)
            .dropsNothing()
            .resistance(0.1f)
            .hardness(0.1f));

    public void Register(){
        Registry.register(Registry.BLOCK,new Identifier(Alien.modId,"neomorph_egg_sack"),neomorphEggSack);
    }
}
