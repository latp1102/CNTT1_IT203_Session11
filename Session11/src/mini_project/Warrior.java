package mini_project;

public class Warrior extends GameCharacter implements ISkill {
    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(getName() + " chém thường");
        target.takeDamage(getAttackPower());
    }

    @Override
    public void takeDamage(int damage) {
        int realDamage = damage - armor;
        if (realDamage < 0){
            realDamage = 0;
        }
        super.takeDamage(realDamage);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println(getName() + " dùng chiêu đấm ngàn cân");
        target.takeDamage(getAttackPower() * 2);
        int selfDamage = (int) (getHp() * 0.1);
        setHp(getHp() -selfDamage);
    }

    public int getArmor() {
        return armor;
    }
}
