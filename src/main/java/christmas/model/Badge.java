package christmas.model;

public enum Badge {
    NONE("없음", 0),
    STAR("별", 5000),
    TREE("나무", 10000),
    SANTA("산타", 20000);

    private final String badgeName;
    private final int cost;

    Badge(String badgeName, int cost) {
        this.badgeName = badgeName;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getBadgeName() {
        return badgeName;
    }
}