import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Hero fighter1 = createHero(scan);
        Hero fighter2 = createHero(scan);
        Arena arena = new Arena(fighter1, fighter2);
        arena.startTournament();
    }

    private static Hero createHero(Scanner scan){
        Hero hero = null;
        while(hero == null){
            hero = makeHeroOutOfInput(scan);
        }
        System.out.println("\nПерсонаж успешно создан");
        System.out.println(hero.toString());
        System.out.println();
        return hero;
    }

    private static Hero makeHeroOutOfInput(Scanner scan){
        if(scan==null){
            return null;
        }

        String heroClass = null;
        while((heroClass==null) || ((!heroClass.equals("воин")) && (!heroClass.equals("маг")))){
            System.out.print("Введите класс (маг/воин) вашего персонажа одним словом: ");
            if(scan.hasNextLine()){
                heroClass = scan.nextLine().trim();
            }
        }

        String name = null;
        while((name==null) || (name.isEmpty())){
            System.out.print("Введите имя вашего персонажа: ");
            if(scan.hasNextLine()){
                name = scan.nextLine().trim();
            }
        }

        int maxHealth = 0;
        int baseAttack = 0;
        int uniqueParam = 0;
        while(maxHealth <= 0){
            System.out.print("Введите здоровье вашего персонажа (целое число не менее 1): ");
            if(scan.hasNextInt()){
                maxHealth = scan.nextInt();
            } else{
                scan.next();
            }
        }
        while(baseAttack <= 0){
            System.out.print("Введите базовую атаку вашего персонажа (целое число не менее 1): ");
            if(scan.hasNextInt()){
                baseAttack = scan.nextInt();
            } else{
                scan.next();
            }
        }
        while(uniqueParam <= 0){
            System.out.printf("Введите %s вашего персонажа (целое число не менее 1): ", (heroClass.equals("воин")? "броню" : "максимальную ману"));
            if(scan.hasNextInt()){
                uniqueParam = scan.nextInt();
            } else{
                scan.next();
            }
        }

        if(heroClass.equals("воин")){
            return new Warrior(name, maxHealth, baseAttack, uniqueParam);
        } else{
            return new Mage(name, maxHealth, baseAttack, uniqueParam);
        }
    }
}