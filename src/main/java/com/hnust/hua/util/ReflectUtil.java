package com.hnust.hua.util;

import java.lang.reflect.Field;

/**  通过反射设置对象的属性
 * Created by Administrator on 2019/2/13.
 */
public class ReflectUtil {

    /**
     *   设置对象的值
     * @param object  对象
     * @param fieldName  属性名
     * @param value   值
     */
    public static void setValueByFieldName(Object object,String fieldName,Object value){

        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            if (field.isAccessible()){
                field.set(object,value);
            }else{
                field.setAccessible(true);
                field.set(object,value);
                field.setAccessible(false);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     *    根据属性名获取属性值
     * @param object  对象
     * @param fieldName  属性名
     * @return  值
     * @throws IllegalAccessException
     */
    public static Object getValueByFieldName(Object object,String fieldName) {

        Field field =getFieldByFieldName(object,fieldName);
        Object value = null;
        if (field!=null){
            try {
                if (field.isAccessible()){
                    value = field.get(object);
                }else {
                    field.setAccessible(true);
                    value = field.get(object);
                    field.setAccessible(false);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    /**
     *  根据属性名获取属性
     * @param object   对象
     * @param fieldName  属性名
     * @return  属性
     */
    private static Field getFieldByFieldName(Object object,String fieldName){
        for (Class<?> superClass = object.getClass();superClass!=Object.class;superClass=superClass.getSuperclass()){
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                System.out.println("获取对象属性异常！"+e);
            }
        }
        return null;
    }
}
