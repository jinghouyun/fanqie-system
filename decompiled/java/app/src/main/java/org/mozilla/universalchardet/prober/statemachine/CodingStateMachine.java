package org.mozilla.universalchardet.prober.statemachine;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class CodingStateMachine {
    protected int currentBytePos;
    protected int currentCharLen;
    protected int currentState = 0;
    protected SMModel model;

    public CodingStateMachine(SMModel sMModel) {
        this.model = sMModel;
    }

    public String getCodingStateMachine() {
        return this.model.getName();
    }

    public int getCurrentCharLen() {
        return this.currentCharLen;
    }

    public int nextState(byte b) {
        int i = this.model.getClass(b);
        if (this.currentState == 0) {
            this.currentBytePos = 0;
            this.currentCharLen = this.model.getCharLen(i);
        }
        int nextState = this.model.getNextState(i, this.currentState);
        this.currentState = nextState;
        this.currentBytePos++;
        return nextState;
    }

    public void reset() {
        this.currentState = 0;
    }
}
