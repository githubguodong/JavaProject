package domain;

import service.Status;

/**
 * domain
 * Project
 */
public class Architect extends Designer {
    private int stock; // 股票

    public Architect(int stock) {
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary, double bonus, int stock) {
        super(id, name, age, salary, bonus);
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        System.out.println("this = " + this.getEquipment().getDescription());
        System.out.println("super = " + super.getEquipment().getDescription());
        System.out.println("  = " + getEquipment().getDescription());
        /*
        this = 联想T4(6000.0)
        super = 联想T4(6000.0)
          = 联想T4(6000.0)
         */
        System.out.println("*************************************************");
        System.out.println("this = " + this.getEquipment());
        System.out.println("super = " + super.getEquipment());
        System.out.println("  = " + getEquipment());
        /*
        this = domain.NoteBook@29453f44
        super = domain.NoteBook@29453f44
          = domain.NoteBook@29453f44
        */
        System.out.println("*************************************************");
        System.out.println("this = " + this.getDescription());
        System.out.println("super = " + super.getDescription());
        System.out.println("  = " + getDescription());
        /*
        this = null
        super = null
          = null
         */

        return super.toString1() + "\t" + stock + "\t" + getEquipment().getDescription();
    }


}
