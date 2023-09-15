package traben.entity_model_features.models.animation.animation_math_parser;

public interface MathComponent {


    float get();


    default boolean isConstant() {
        return false;
    }

    class EMFMathException extends Exception {

        final String errorMsg;

        public EMFMathException(String s) {
            errorMsg = s;
        }

        @Override
        public String toString() {
            return errorMsg;
        }
    }


}
