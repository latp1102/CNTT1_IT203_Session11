package mini_project;

public class Main {
    public static void main(String[] args) {
        GameCharacter[] characters = new GameCharacter[3];
        characters[0] = new Warrior("Yasuo", 400, 20, 5);
        characters[1] = new Mage("Veigar", 290, 150, 60);
        characters[2] = new GameCharacter("Goblin", 50, 0) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("Goblin bắn trộm");
                target.takeDamage(10);
            }
        };
        for (int i = 0; i < characters.length; i++){
            if(characters[i] == null){
                continue;
            }
            for (int j =0; j < characters.length; j++){
                if(i != j && characters[j] != null){
                    characters[i].attack(characters[j]);
                }
            }
        }
        ((ISkill) characters[0]).useUltimate(characters[2]);
        ((ISkill) characters[1]).useUltimate(characters[0]);
        System.out.println("\n===== KẾT QUẢ CUỐI =====\n");
        System.out.println("Tổng số nhân vật: " + GameCharacter.count);
        for (GameCharacter c: characters){
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

