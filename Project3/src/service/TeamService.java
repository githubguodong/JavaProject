package service;

import domain.Employee;
import domain.Programmer;
import package3.TeamException;

/**
 * service
 * Project
 */
public class TeamService {
    private int counter = 1; // 团队成员的团队ID，每个人固定
    private final int MAX_MEMBER  = 5; // 小团队人数限制
    private Programmer[] team = new Programmer[MAX_MEMBER]; // 创建小团队数组
    private int total = 0; // 小团队中的实际人员数量

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getMAX_MEMBER() {
        return MAX_MEMBER;
    }

    /**
     * @Description:
     * @Author: monster
     * @Date: 2021/9/10 下午3:32

     * @return: domain.Programmer[]
     **/
    public Programmer[] getTeam() {
        return team;
    }

    public void setTeam(Programmer[] team) {
        this.team = team;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    /**
     * @Description: 向团队中添加成员
     * @Author: monster
     * @Date: 2021/9/10 下午3:32
     * @param: employee
     * @return: void
     **/
    public void addMember(Employee employee) throws TeamException{
        int TID = counter++;
        int id = employee.getId();
        String name = employee.getName();
        int age = employee.getAge();
        double salary = employee.getSalary();


    }

    public void removeMember(int memberId) throws TeamException{

    }
}
