package com.alien.blocks.blocks;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import io.netty.handler.codec.mqtt.MqttProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class NeomorphEggSackBlock extends Block {

    public static final BooleanProperty POPPED = BooleanProperty.of("popped");
    public static final IntProperty TYPE = IntProperty.of("type",0,2);
    public NeomorphEggSackBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(POPPED, false));
        setDefaultState(getStateManager().getDefaultState().with(TYPE, 0));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        state.with(TYPE, world.getRandom().nextInt(2));
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        LivingEntity livingEntity = (LivingEntity) entity;
        Random RNG = world.getRandom();
        if(RNG.nextInt(4) == 1){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA));
        }
        super.onSteppedOn(world,pos,state,entity);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(POPPED);
        stateManager.add(TYPE);
    }

}
