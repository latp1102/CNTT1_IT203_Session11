package mini_project;

public abstract class GameCharacter {
    private String name;
    private int hp;
    private int attackPower;
    public static int count = 0;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }
    public abstract void attack(GameCharacter target);
    public void takeDamage(int damage){
        hp -= damage;
        if(hp <= 0){
            hp = 0;
            System.out.println(name + " đã bị hạ gục");
        }
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
