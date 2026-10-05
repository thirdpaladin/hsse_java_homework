enum ActionType {
    BASE_ATTACK("Атака"),
    SPECIAL_SKILL("Умение"),
    REST("Передышка");
    private String actionName;

    ActionType(String actionName){
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }
}