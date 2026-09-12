package io.dcloud.common.DHInterface;

import io.dcloud.common.adapter.util.MessageHandler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class FeatureMessageDispatcher {
    public static CopyOnWriteArrayList<MessageListener> sFeatureMessage = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    @Deprecated
    public interface MessageListener {
        void onReceiver(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static abstract class StrongMessageListener implements MessageListener {
        Object mFlag;

        public StrongMessageListener(Object obj) {
            this.mFlag = obj;
        }

        @Override // io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener
        public abstract void onReceiver(Object obj);
    }

    public static boolean contains(Object obj) {
        try {
            for (MessageListener messageListener : sFeatureMessage) {
                if ((messageListener instanceof StrongMessageListener) && obj.equals(((StrongMessageListener) messageListener).mFlag)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void dispatchMessage(Object obj, final Object obj2) {
        try {
            for (MessageListener messageListener : sFeatureMessage) {
                if (messageListener instanceof StrongMessageListener) {
                    if (obj.equals(((StrongMessageListener) messageListener).mFlag)) {
                        MessageHandler.sendMessage(new MessageHandler.IMessages() { // from class: io.dcloud.common.DHInterface.FeatureMessageDispatcher.1
                            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                            public void execute(Object obj3) {
                                ((MessageListener) obj3).onReceiver(obj2);
                            }
                        }, messageListener);
                    }
                } else if (obj2 != null) {
                    MessageHandler.sendMessage(new MessageHandler.IMessages() { // from class: io.dcloud.common.DHInterface.FeatureMessageDispatcher.2
                        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                        public void execute(Object obj3) {
                            ((MessageListener) obj3).onReceiver(obj2);
                        }
                    }, messageListener);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerListener(MessageListener messageListener) {
        sFeatureMessage.add(messageListener);
    }

    public static void unregisterListener(MessageListener messageListener) {
        sFeatureMessage.remove(messageListener);
    }

    @Deprecated
    public static void dispatchMessage(Object obj) {
        dispatchMessage(null, obj);
    }
}
