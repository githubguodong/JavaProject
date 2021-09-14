package domain;

import service.Status;

/**
 * domain
 * Project
 */
public class Programmer extends Employee implements Equipment{
    private int memberId; // 在开发团队中的id，后面不可变

    private Status status = Status.FREE; // 员工在表中的状态，如果就职就是busy

    private Equipment equipment;  // 领用设备

    public Programmer(){

    }

    public Programmer( int id, String name, int age, double salary) {
        super(id,name,age,salary);
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Programmer (int memberId, int id, String name, int age, double salary){
        super(id,name,age,salary);
        this.memberId = memberId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String toString() {
       return super.toString() ;
    }


}
