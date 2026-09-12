package com.taobao.weex.ui.component.binding;

import android.os.AsyncTask;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taobao.weex.ui.component.list.template.TemplateViewHolder;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
class AsynLayoutTask extends AsyncTask<Void, Void, Void> {
    private final WXComponent component;
    private final int position;
    private final TemplateViewHolder templateViewHolder;

    AsynLayoutTask(TemplateViewHolder templateViewHolder, int i, WXComponent wXComponent) {
        this.templateViewHolder = templateViewHolder;
        this.position = i;
        this.component = wXComponent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.templateViewHolder.getHolderPosition() == this.position && this.component.getInstance() != null && !this.component.getInstance().isDestroy()) {
            synchronized (this.templateViewHolder.getTemplateList()) {
                if (this.templateViewHolder.getTemplateList().isDestoryed()) {
                    return null;
                }
                Layouts.doLayoutOnly(this.component, this.templateViewHolder);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Void r4) {
        if (this.position != this.templateViewHolder.getHolderPosition() || this.component.getInstance() == null || this.component.getInstance().isDestroy()) {
            return;
        }
        Layouts.setLayout(this.component, false);
        if (this.templateViewHolder.getHolderPosition() >= 0) {
            this.templateViewHolder.getTemplateList().fireEvent(TemplateDom.ATTACH_CELL_SLOT, TemplateDom.findAllComponentRefs(this.templateViewHolder.getTemplateList().getRef(), this.position, this.component));
        }
    }
}
