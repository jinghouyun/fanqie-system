package com.taobao.weex.el.parse;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class ArrayStack<T> {
    private ArrayList<T> stack = new ArrayList<>(4);

    public void add(int i, T t) {
        this.stack.add(i, t);
    }

    public T get(int i) {
        return this.stack.get(i);
    }

    public List<T> getList() {
        return this.stack;
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public T peek() {
        ArrayList<T> arrayList = this.stack;
        return arrayList.get(arrayList.size() - 1);
    }

    public T pop() {
        ArrayList<T> arrayList = this.stack;
        return arrayList.remove(arrayList.size() - 1);
    }

    public void push(T t) {
        this.stack.add(t);
    }

    public T remove(int i) {
        return this.stack.remove(i);
    }

    public int size() {
        return this.stack.size();
    }
}
