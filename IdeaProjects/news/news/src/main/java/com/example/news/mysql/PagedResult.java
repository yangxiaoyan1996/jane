package com.example.news.mysql;

import java.util.*;

/**
 * 功能描述: 分页结果集
 *
 * @param:
 * @return:
 * @auther: MLC
 * @date: 2018/9/17 18:29
 */
public class PagedResult<E> implements List<E> {

    /**
     * 总页数
     */
    private Integer totalPages = 0;

    /**
     * 总条数
     */
    private Integer totalCount = 0;

    /**
     * 分页内容
     */
    private List<E> data = new ArrayList();

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public int size() {
        return getData().size();
    }

    public boolean isEmpty() {
        return getData().isEmpty();
    }

    public boolean contains(Object o) {
        return getData().contains(o);
    }

    public Iterator<E> iterator() {
        return getData().iterator();
    }

    public Object[] toArray() {
        return getData().toArray();
    }

    public <T> T[] toArray(T[] a) {
        return getData().toArray(a);
    }

    public boolean add(E e) {
        return getData().add(e);
    }

    public boolean remove(Object o) {
        return getData().remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return getData().containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        return getData().addAll(c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return getData().addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return getData().removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return getData().retainAll(c);
    }

    public void clear() {
        getData().clear();
    }

    public E get(int index) {
        return getData().get(index);
    }

    public E set(int index, E element) {
        return getData().set(index, element);
    }

    public void add(int index, E element) {
        getData().add(index, element);
    }

    public E remove(int index) {
        return getData().remove(index);
    }

    public int indexOf(Object o) {
        return getData().indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return getData().lastIndexOf(o);
    }

    public ListIterator<E> listIterator() {
        return getData().listIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return getData().listIterator(index);
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return getData().subList(fromIndex, toIndex);
    }
}
