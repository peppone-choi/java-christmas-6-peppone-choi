package christmas.model;

import static christmas.config.CommonConfig.MENU_NOT_FOUND_ERROR;
import static christmas.exception.IllegalArgumentExceptionThrower.*;
import static christmas.model.MenuDivision.*;
import static christmas.model.MenuDivision.APPETIZER;
import static christmas.model.MenuDivision.DESSERT;
import static christmas.model.MenuDivision.DRINK;
import static christmas.model.MenuDivision.MAIN;
import static christmas.model.MenuDivision.NONE;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6000, APPETIZER),
    TAPAS("타파스", 5500, APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MAIN),
    BBQ_RIB("바비큐립", 54000, MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MAIN),
    CHOCO_CAKE("초코케이크", 15000, DESSERT),
    ICE_CREAM("아이스크림", 5000, DESSERT),
    ZERO_COLA("제로콜라", 3000, DRINK),
    RED_WINE("레드와인", 60000, DRINK),
    CHAMPAGNE("샴페인", 25000, DRINK),
    NONE("없음", 0, MenuDivision.NONE);

    private final String name;
    private final int cost;
    private final MenuDivision menuDivision;

    Menu(String name, int cost, MenuDivision menuDivision) {
        this.name = name;
        this.cost = cost;
        this.menuDivision = menuDivision;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public MenuDivision getMenuDivision() {
        return menuDivision;
    }

    public static Menu getMenuFromName(String name) {
        for (Menu menu : values()) {
            if (menu.getName().equalsIgnoreCase(name)) {
                return menu;
            }
        }
        throwException(MENU_NOT_FOUND_ERROR.getString());
        return null;
    }

    public static boolean contains(String input) {
        return checkContains(input);
    }

    private static boolean checkContains(String input) {
        for (Menu menu : values()) {
            if (menu.getName().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}
