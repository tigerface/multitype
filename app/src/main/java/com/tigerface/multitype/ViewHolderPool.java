package com.tigerface.multitype;


import com.tigerface.multitype.viewholder.ItemViewHolder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewHolderPool {
    private Map<Class, ItemViewHolder> holderMap;
    private List<Class> clazzList;

    public ViewHolderPool register(ItemViewHolder holder) {
        if (holderMap == null) {
            holderMap = new HashMap<>();
        }

        if (clazzList == null) {
            clazzList = new ArrayList<>();
        }

        Class clazz = getSuperClassGenricType(holder.getClass(), 0);
        holderMap.put(clazz, holder);
        clazzList.add(clazz);
        return this;
    }


    /**
     * get adapter item's view type by item
     *
     * @param item
     * @return
     */
    public int getItemViewType(Object item) {
        Class itemClazz = item.getClass();
        return clazzList.indexOf(itemClazz);
    }

    /**
     * get viewholder by item
     *
     * @param item
     * @return
     */
    public ItemViewHolder getViewHolder(Object item) {
        return holderMap.get(item.getClass());
    }

    /**
     * get viewholder by index
     *
     * @param index
     * @return
     */
    public ItemViewHolder getViewHolder(int index) {
        if (index >= clazzList.size() || index < 0) {
            return null;
        }
        Class clazz = clazzList.get(index);
        return holderMap.get(clazz);
    }

    public void destroy() {
        if(holderMap != null){
            holderMap.clear();
        }
        if(clazzList != null){
            clazzList.clear();
        }
    }

    /**
     * @param clazz
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Class<Object> getSuperClassGenricType(final Class clazz, final int index) {

        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        //返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
