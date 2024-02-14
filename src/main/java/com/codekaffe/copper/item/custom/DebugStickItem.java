package com.codekaffe.copper.item.custom;

import com.codekaffe.copper.sound.ModSounds;
import com.codekaffe.copper.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DebugStickItem extends Item {
    public DebugStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("For debugging purposes.").formatted(Formatting.YELLOW));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        // When right-clicking a block this item will scan for ores.

        // server side code
        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i < positionClicked.getY(); i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;

                    context
                            .getWorld()
                            .playSound(null,
                                    positionClicked,
                                    ModSounds.UWU,
                                    SoundCategory.BLOCKS,
                                    1f,
                                    1f
                            );

                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(Text.literal("No valuables found."));
            }
        }

        context
                .getStack()
                .damage(1,
                        context.getPlayer(),
                        playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand())
                );

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal(String.format(
                "Found %s at (%d, %d, %d)",
                block.asItem().getName().getString(),
                blockPos.getX(),
                blockPos.getY(),
                blockPos.getZ()
        )), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.DEBUG_STICK_DETECTABLE_BLOCKS);
    }
}
