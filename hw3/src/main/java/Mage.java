class Mage extends Hero implements Castable, Restable{
    private final int maxMana;
    private int mana;

    public Mage(String name, int maxHealth, int baseAttack, int maxMana) {
        super(name, maxHealth, baseAttack);
        this.maxMana = Math.max(maxMana, MIN_STAT_VALUE);
        this.mana = maxMana;
    }

    @Override
    public void attack(Hero target) {
        if(!seesTarget(target)){
            return;
        }
        if (mana>10){
            mana-=10;
            target.takeDamage(getBaseAttack()*2);
            System.out.println(getName() + " выпускает волшебную стрелу");
        } else{
            target.takeDamage(getBaseAttack()/2);
            mana = Math.min(mana+5, maxMana);
            System.out.println(getName()+" бьет посохом");
        }
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
            target.takeDamage(getBaseAttack()*3);
            mana-=25;
            System.out.println(getName()+" кастует Огненную глыбу");
        } else{
            System.out.println(getName()+" не смог скастовать Огненную глыбу");
        }
    }

    @Override
    public boolean canCast() {
        return mana>=25;
    }

    @Override
    public void rest() {
        mana = maxMana;
        heal(getBaseAttack());
        System.out.println(getName()+" провел исцеляющую медитацию");
    }

    @Override
    public boolean needsRest() {
        return (mana==0) || (10*getHealth()<3*getMaxHealth());
    }

    @Override
    public String toString() {
        return String.format("%s, Мана: %d/%d", super.toString(), mana, maxMana);
    }
}