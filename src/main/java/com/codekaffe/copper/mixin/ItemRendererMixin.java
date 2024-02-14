package com.codekaffe.copper.mixin;

import com.codekaffe.copper.KafCopper;
import com.codekaffe.copper.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useKaferiumStaffModel(BakedModel value, ItemStack stack,
                                     ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.KAFERIUM_STAFF) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this)
                    .mccourse$getModels()
                    .getModelManager()
                    .getModel(new ModelIdentifier(KafCopper.MOD_ID, "kaferium_staff_3d", "inventory"));

        }

        return value;
    }
}
