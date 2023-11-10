package christmas.model;

public enum MenuDivision {
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료");
    private final String name;

    MenuDivision(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
