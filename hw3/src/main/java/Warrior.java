class Warrior extends Hero implements Castable, Restable{
    private final int armor;

    public Warrior(String name, int maxHealth, int baseAttack, int armor){
        super(name, maxHealth, baseAttack);
        this.armor = Math.max(armor, MIN_STAT_VALUE);
    }

    @Override
    public void takeDamage(int damage) {
        final int minDamage = 1;
        super.takeDamage(Math.max(minDamage, damage-armor));
    }

    @Override
    public void attack(Hero target) {
        if(!seesTarget(target)){
            return;
        }
        target.takeDamage(getBaseAttack());
        System.out.println(getName()+" атакует мечом");
    }

    @Override
    public ActionType makeTurn(Hero target) {
        if(!seesTarget(target)){
            return null;
        }
        if(canCast()){
            castSpecialSkill(target);
            return ActionType.SPECIAL_SKILL;
        }
        if(needsRest()) {
            rest();
            return ActionType.REST;
        }
        attack(target);
        return ActionType.BASE_ATTACK;
    }

    @Override
    public void castSpecialSkill(Hero target) {
        if(!seesTarget(target)){
            return;
        }
        if(canCast()){
            target.takeDamage(getBaseAttack() + armor * 2);
            System.out.println(getName()+" атакует щитом");
        } else{
            System.out.println(getName()+" попытался ударить щитом, но потерял равновесие");
        }
    }

    @Override
    public boolean canCast() {
        return getHealth()*2<getMaxHealth();
    }

    @Override
    public void rest() {
        heal(armor * 2);
    }

    @Override
    public boolean needsRest() {
        return 20 * getHealth() < 3 * getMaxHealth();
    }

    @Override
    public String toString() {
        return String.format("%s, Броня: %d", super.toString(), armor);
    }
}