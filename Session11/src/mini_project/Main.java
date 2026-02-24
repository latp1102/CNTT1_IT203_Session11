package mini_project;

public class Main {
    public static void main(String[] args) {
        GameCharacter[] lists = new GameCharacter[3];
        lists[0] = new Warrior("Yasuo", 120, 20, 5);
        lists[1] = new Mage("Veigar", 80, 25, 60);
        lists[2] = new GameCharacter("Goblin", 50, 0) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("Goblin bắn trộm");
                target.takeDamage(10);
            }
        };
        for (int i = 0; i < lists.length; i++){
            if(lists[i] == null){
                continue;
            }
            for (int j =0; j < lists.length; j++){
                if(i != j && lists[j] != null){
                    lists[i].attack(lists[j]);
                }
            }
        }
        ((ISkill) lists[0]).useUltimate(lists[2]);
        ((ISkill) lists[1]).useUltimate(lists[0]);
        System.out.println("\n KẾT QUẢ \n");
        System.out.println("Tổng số nhân vật: " + GameCharacter.count);
        for (GameCharacter c: lists){
            if (c == null){
                continue;
            }
            System.out.println("-" + c.getName());
            System.out.println("HP: " + c.getHp());
            if(c instanceof Mage){
                System.out.println("Mana: " + ((Mage) c).getMana());
            }
            if(c instanceof Warrior){
                System.out.println("Armor: " + ((Warrior)c).getArmor());
            }
        }
    }
}
