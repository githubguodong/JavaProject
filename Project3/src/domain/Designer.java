package domain;

import service.Status;

/**
 * domain
 * Project
 */
public class Designer extends Programmer{
    private double bonus; // 奖金

    public Designer(){

    }

    public Designer(int id, String name, int age, double salary, double bonus) {
        super(id, name, age, salary);
        this.bonus = bonus;
    }
    public Designer(int id, String name, int age, double salary, Equipment employee, double bonus) {
        super(id, name, age, salary,employee);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + bonus + "\t" +  getEquipment().getDescription() ;
    }

    public String toString1(){
        return super.toString() + "\t" + bonus;
    }


}
