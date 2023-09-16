package traben.entity_model_features.mixin;


import net.minecraft.client.model.Model;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import traben.entity_model_features.models.EMFModelPartRoot;
import traben.entity_model_features.models.IEMFModel;
import traben.entity_model_features.utils.EMFManager;

import java.util.function.Function;

@Mixin(Model.class)
public class MixinEntityModel implements IEMFModel {
    @Unique
    private EMFModelPartRoot emf$thisEMFModelRoot = null;

    @Inject(method = "<init>",
            at = @At(value = "TAIL"))
    private void emf$discoverEMFModel(Function<?, ?> layerFactory, CallbackInfo ci) {
        emf$thisEMFModelRoot = EMFManager.lastCreatedRootModelPart;
        EMFManager.lastCreatedRootModelPart = null;
    }

    @Override
    public boolean emf$isEMFModel() {
        return emf$thisEMFModelRoot != null;
    }

    @Override
    public EMFModelPartRoot emf$getEMFRootModel() {
        return emf$thisEMFModelRoot;
    }
}
