abstract class Hero{
    protected final int MIN_STAT_VALUE = 1;
    private String name;
    private int maxHealth;
    private int baseAttack;
    private int health;

    public Hero(String name, int maxHealth, int baseAttack) {
        this.name = ((name == null)|| (name.isEmpty()))? "Фродо Бэггинс" : name;
        this.maxHealth = Math.max(maxHealth, MIN_STAT_VALUE);
        this.health = Math.max(maxHealth, MIN_STAT_VALUE);
        this.baseAttack = Math.max(baseAttack, MIN_STAT_VALUE);
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getHealth() {
        return health;
    }

    public abstract void attack(Hero target);

    public abstract ActionType makeTurn(Hero target);

    public void takeDamage(int damage){
        if(damage<=0){
            return;
        }
        health = Math.max(health-damage, 0);
        if (health==0){
            System.out.println(name+" пал в бою!");
        }
    }

    public void heal(int amount){
        if(amount>0) {
            health = Math.min(maxHealth, health + amount);
        }
    }

    public boolean isAlive(){
        return health>0;
    }

    protected boolean seesTarget(Hero target){
        if(target==null){
            System.out.println(getName()+" не видит противника");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, Здоровье: %d/%d, Атака: %d", getName(), getHealth(), getMaxHealth(), getBaseAttack());
    }
}