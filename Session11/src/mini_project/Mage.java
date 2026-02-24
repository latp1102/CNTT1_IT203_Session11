package mini_project;

public class Mage extends GameCharacter implements ISkill {
    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {
        if (mana >= 5){
            System.out.println(getName() + " bắn phép thường");

            mana -= 5;
            target.takeDamage(getAttackPower());
        }else {
            System.out.println(getName() + " hết mana, đánh yếu");
            target.takeDamage(getAttackPower() / 2);
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if(mana >= 50){
            System.out.println(getName() + " tung hỏa cầu");
            mana -= 50;
            target.takeDamage(getAttackPower() * 3);
        }else {
            System.out.println(getName() + " không đủ mana để dùng chiêu cuối");
        }
    }

    public int getMana() {
        return mana;
    }
}
