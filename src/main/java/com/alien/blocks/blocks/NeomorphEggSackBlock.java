package com.alien.blocks.blocks;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import io.netty.handler.codec.mqtt.MqttProperties;
import net.minecraft.block.*;
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
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class NeomorphEggSackBlock extends PlantBlock {

    public static final BooleanProperty POPPED = BooleanProperty.of("popped");
    public NeomorphEggSackBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(POPPED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(!state.get(POPPED)){
            LivingEntity livingEntity = (LivingEntity) entity;
            Random RNG = world.getRandom();
            if(RNG.nextInt(4) == 1){
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,20*10));
            }
            world.setBlockState(pos,state.with(POPPED,true));
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(POPPED);
    }

}
