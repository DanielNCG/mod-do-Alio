package com.alien.items;

import com.alien.Alien;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {
    public static final Item xeno_zip = new Item(new FabricItemSettings() //Create new Effect Later
            .food(new FoodComponent.Builder()
                    .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,20*(60*5),1),1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20*(60*5), 0),1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED,20*(60*5), 0),1f)
                    .alwaysEdible()
                    .snack()
                    .hunger(2)
                    .build()
            ).group(Alien.AlienItemGroup));
    public static void Register() {
        Registry.register(Registry.ITEM,new Identifier(Alien.modId,"xeno_zip"),xeno_zip);
    }
}
