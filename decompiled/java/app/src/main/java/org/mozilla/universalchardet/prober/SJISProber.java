package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis;
import org.mozilla.universalchardet.prober.distributionanalysis.SJISDistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.SJISSMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class SJISProber extends CharsetProber {
    private static final SMModel smModel = new SJISSMModel();
    private CodingStateMachine codingSM = new CodingStateMachine(smModel);
    private SJISContextAnalysis contextAnalyzer = new SJISContextAnalysis();
    private SJISDistributionAnalysis distributionAnalyzer = new SJISDistributionAnalysis();
    private byte[] lastChar = new byte[2];
    private CharsetProber.ProbingState state;

    public SJISProber() {
        reset();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String getCharSetName() {
        return Constants.CHARSET_SHIFT_JIS;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float getConfidence() {
        return Math.max(this.contextAnalyzer.getConfidence(), this.distributionAnalyzer.getConfidence());
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState handleData(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        for (int i4 = i; i4 < i3; i4++) {
            int iNextState = this.codingSM.nextState(bArr[i4]);
            if (iNextState == 1) {
                this.state = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (iNextState == 2) {
                this.state = CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (iNextState == 0) {
                int currentCharLen = this.codingSM.getCurrentCharLen();
                if (i4 == i) {
                    byte[] bArr2 = this.lastChar;
                    bArr2[1] = bArr[i];
                    this.contextAnalyzer.handleOneChar(bArr2, 2 - currentCharLen, currentCharLen);
                    this.distributionAnalyzer.handleOneChar(this.lastChar, 0, currentCharLen);
                } else {
                    this.contextAnalyzer.handleOneChar(bArr, (i4 + 1) - currentCharLen, currentCharLen);
                    this.distributionAnalyzer.handleOneChar(bArr, i4 - 1, currentCharLen);
                }
            }
        }
        this.lastChar[0] = bArr[i3 - 1];
        if (this.state == CharsetProber.ProbingState.DETECTING && this.contextAnalyzer.gotEnoughData() && getConfidence() > 0.95f) {
            this.state = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.state;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void reset() {
        this.codingSM.reset();
        this.state = CharsetProber.ProbingState.DETECTING;
        this.contextAnalyzer.reset();
        this.distributionAnalyzer.reset();
        Arrays.fill(this.lastChar, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void setOption() {
    }
}
