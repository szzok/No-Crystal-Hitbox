package net.szokk.nocrystalhitbox.client.mixin;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.szokk.nocrystalhitbox.client.MainClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class EndCrystalHitboxMixin {

    @Inject(method = "renderHitbox",
            at = @At("HEAD"),
            cancellable = true)
    private static void cancelEndCrystalHitbox(MatrixStack matrices,
                                               VertexConsumer vertices,
                                               Entity entity,
                                               float tickDelta,
                                               float red, float green, float blue,
                                               CallbackInfo ci) {
        if (MainClient.enabled && entity instanceof EndCrystalEntity) {
            ci.cancel();
        }
    }
}
