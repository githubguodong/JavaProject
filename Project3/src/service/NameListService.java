/**
 * @program: Project
 * @description:
 * @param:
 * @return:
 * @author zzhd
 **/
package service;

import domain.*;
import org.junit.Test;
import package3.Data;
import package3.TeamException;


import static package3.Data.EMPLOYEES;
import static package3.Data.EQUIPMENTS;

/**
 * service
 * Project
 */

/**
 * @Description: 将date数据
 * @Author: monster
 * @Date: 2021/9/10 上午10:57
 * @param: null
 * @return: null
 **/
public class NameListService {
    // 单元测试方法
    public static void main(String[] args) {
        NameListService nameListService = new NameListService();

//        System.out.println(nameListService); // service.NameListService@29453f44
//        System.out.println(nameListService.toString()); // service.NameListService@29453f44

        Employee[] employees = nameListService.getEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
            /**
             * 对于精准寻找问题：
             * 在构造方法中，我们将每个一维数据的数据根据判断，然后通过 new 的方法存到相应的对象中，
             * 此时 employees[i] 是一个地址值，输出时根据地址进入相应的类，进行相应的输出
             */
            /**
             *  对于 Equipment 输出问题
             *  我们在存储时，我们return new PC() ,new Printer(), new Architect()的方式创建后存储
             *  那么Employee 中 存放的是 地址
             *  我们在输出时，getEquipment().getDescription()
             *  getEquipment()的方式获取实现接口类的地址值
             *  getDescription()根据上一步获取到的地址值，运行重写了接口的方法
             */
        }
    }

    // 查找测试
    @Test
    public void test(){
        new NameListService();
        try {
            System.out.println((getEmployee(6)).toString());
        } catch (TeamException e) {
            e.printStackTrace();
        }
    }


    private Employee[] employees; // 用来保存公司所有员工的对象

    /**
     * 创建父类的对象，后面需要赋子类数据时，只需要创建子类构造器就可以了 ---> 类似于 接口 接口对象 = new  实现接口类
     * 父类  父类对象 =  new  子类
     * 父类对象此时可以使用子类的方法(包括子类重写的方法)
     * @return
     */


    public Employee[] getEmployees() {
        return employees;
    }

    public NameListService() {
        // 根据项目提供的Date类构建相应大小的employees数组
        employees = new Employee[EMPLOYEES.length];
        /**
         *  对于 EMPLOYEES 的 length  获取
         *  1. EMPLOYEES 在 package3 包下，被定义为静态方法
         *  2. 如果想用的话，那么导包时也要定义为静态
         */
        // 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，
        // 以及相关联的Equipment子类的对象
        // 将对象存于数组中
        for (int i = 0; i < employees.length; i++) {
            // 通用属性获取
            // int id, String name, int age, double salary ---> 通用属性
            /**
             在 Date 中的数据是String类型，需要进行拆箱过程
             在 Date 中，数组第一个数据是该数据类型标志，并不是id；
             */
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            employees[i] = new Employee(id, name, age, salary);

            // 特有属性获取
            // 当 数据类型 字符串 为 11
            int total = Integer.parseInt(EMPLOYEES[i][0]);  // ---> 数字
//            char total = EMPLOYEES[inti][0].charAt(0);

            double bonus;
            int stock;
            switch (total) {
                case 11:
                    employees[i] = new Programmer(id, name, age, salary, setEquipment(i));
                    break;
                case 12:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, setEquipment(i), bonus);
                    break;
                case 13:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, setEquipment(i), bonus, stock);
                    break;
            }
        }

    }


    /**
     * @Description: 获取 不同人员领用设备的地址值,并将他们存给匿名接口对象
     * 后面匿名接口对象去调用时，一样是根据地址执行右边 类
     * @Author: monster
     * @Date: 2021/9/10 下午2:20
     * @param: index
     * @return: domain.Equipment
     **/
    public Equipment setEquipment(int index) {
        String s = EQUIPMENTS[index][0];
        String s1;
        String s2;


        switch (s) {
            case "21":
                s1 = EQUIPMENTS[index][1];
                s2 = EQUIPMENTS[index][2];
                return new PC(s1, s2);  // 相当于   Equipment equipment = new PC()
            case "22":
                s1 = EQUIPMENTS[index][1];
                s2 = EQUIPMENTS[index][2];
                double s22 = Double.parseDouble(s2);
                return new NoteBook(s1, s22); // 相当于   Equipment equipment = new NoteBook()
            case "23":
                s1 = EQUIPMENTS[index][1];
                s2 = EQUIPMENTS[index][2];
                return new Printer(s1, s2); // 相当于   Equipment equipment = new Printer()
        }
        return null;
    }

    // 返回所有员工对象数据
    public Employee[] getAllEmployees() {
        return employees;
    }

    // 获取指定员工id对象
    public Employee getEmployee(int id) throws TeamException {

        if(id < 0 || id > employees.length){
            throw new TeamException("找不到指定员工");
        }else {
            return employees[id - 1];
        }
    }
}
