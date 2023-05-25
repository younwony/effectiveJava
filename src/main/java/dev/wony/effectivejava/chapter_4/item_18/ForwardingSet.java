package dev.wony.effectivejava.chapter_4.item_18;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// 전달 클래스
public class ForwardingSet<E> implements Set<E> {

    private final Set<E> set;

    public ForwardingSet(Set<E> set){
        this.set = set;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty(){
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o){
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(E e){
        return set.add(e);
    }

    @Override
    public boolean remove(Object o){
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear(){
        set.clear();
    }

    @Override
    public boolean equals(Object o){
        return set.equals(o);
    }

    @Override
    public int hashCode(){
        return set.hashCode();
    }

    @Override
    public String toString(){
        return set.toString();
    }

}
