class Arena{
    private final Hero fighter1;
    private final Hero fighter2;
    private int roundCounter = 0;

    public Arena(Hero fighter1, Hero fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public void startTournament() {
        if ((fighter1==null) || (fighter2==null)){
            System.out.println("Не можем начать бой, один из бойцов отсутствует");
            return;
        }
        Hero first, second;
        while(fighter1.isAlive() && fighter2.isAlive()){
            System.out.printf("\nРаунд %d\n", ++roundCounter);
            if ((int)(Math.random()*2)==1){
                first = fighter1;
                second = fighter2;
            } else{
                first = fighter2;
                second = fighter1;
            }
            turn(first, second);
            if(!second.isAlive()){
                break;
            }
            turn(second, first);
            if(!first.isAlive()){
                break;
            }
            System.out.println(fighter1.toString());
            System.out.println(fighter2.toString());
        }
        System.out.printf("\nПоздравляем игрока %s с победой!\n", (fighter1.isAlive()? fighter1 : fighter2).getName());
    }

    private void turn(Hero attacker, Hero defender){
        if((attacker==null) || (defender==null)){
            System.out.println("Одного из бойцов нет на поле боя");
            return;
        }
        ActionType action = attacker.makeTurn(defender);
        System.out.printf("Игрок %s совершил действие: %s\n", attacker.getName(), action.getActionName());
    }
}