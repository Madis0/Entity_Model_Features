package traben.entity_model_features.forge;

import traben.entity_texture_features.ETFApi;

public class ETFCheck {
    public static boolean isETFValidAPI(){
        //noinspection ConstantValue
        return ETFApi.ETFApiVersion >= 4;
    }
}