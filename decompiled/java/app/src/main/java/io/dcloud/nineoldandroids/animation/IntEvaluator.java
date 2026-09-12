package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
public class IntEvaluator implements TypeEvaluator<Integer> {
    @Override // io.dcloud.nineoldandroids.animation.TypeEvaluator
    public Integer evaluate(float f, Integer num, Integer num2) {
        int iIntValue = num.intValue();
        return Integer.valueOf((int) (iIntValue + (f * (num2.intValue() - iIntValue))));
    }
}
