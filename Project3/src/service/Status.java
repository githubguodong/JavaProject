/**
 * @program: Project
 * @description:
 * @param:
 * @return:
 * @author zzhd
 **/
package service;

/**
 service
 Project
 */

/**
 * @Description: 自定义枚举类，用来封装员工的状态
 * @Author: monster
 * @Date: 2021/9/10 上午10:38
 * @param: null
 * @return: null
 **/
public class Status {
    private final String NAME;

    public Status(String NAME) {
        this.NAME = NAME;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
