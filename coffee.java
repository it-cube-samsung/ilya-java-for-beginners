package com.company;

import java.util.Scanner;

public class coffee_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();
        String action;
        do {
            System.out.println("Выберите действие (купить, заполнить, забрать, вывести, выйти)");
            action = scanner.nextLine();
            if (action.equals("buy")) {
                System.out.println("Что вы хоите купить? 1 - экспрессо, 2 - латте, 3 - капуччино");
                String sort = scanner.nextLine();
                switch (sort) {
                    case "1":
                        machine.buyCoffee(250, 0, 16, 4);
                        break;
                    case "2":
                        machine.buyCoffee(350, 75, 20, 7);
                        break;
                    case "3":
                        machine.buyCoffee(200, 100, 12, 6);
                        break;
                    default:
                        break;
                }
                if (sort.equals("back")) {
                    continue;
                }
            }
            if (action.equals("fill")) {
                machine.addCoffee();
            }
            if (action.equals("take")) {
                machine.takeDollars();
            }
            if (action.equals("remaining")) {
                machine.hasMachine();
            }
            if (action.equals("exit")) {
                break;
            }
            System.out.println();
        } while (true);
    }
}

class CoffeeMachine {
    int money;
    int water;
    int milk;
    int beans;
    int glasses;
    Scanner scanner;

    public CoffeeMachine() {
        this.money = 550;
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.glasses = 9;
        this.scanner = new Scanner(System.in);

    }

    void hasMachine() {
        System.out.println("В кофемашине есть:");
        System.out.println(this.water + " мл. воды");
        System.out.println(this.milk + " мл. молока");
        System.out.println(this.beans + " гр. кофейных зёрен");
        System.out.println(this.glasses + " одноразовых стаканчиков");
        System.out.println(this.money + " рублей");
    }

    void buyCoffee(int water, int milk, int beans, int money) {
        if (this.water >= water && this.milk >= milk && this.beans >= beans && this.glasses >= 1) {
            this.water -= water;
            this.beans -= beans;
            this.money += money;
            this.glasses -= 1;
            this.milk -= milk;
            System.out.println("У меня достаточно компонентов, чтобы приготовить вам кофе");
        } else {
            String a_luck_of = "";
            if (this.water < water) {
                a_luck_of = "воды";
            }
            if (this.milk < milk) {
                a_luck_of = "молока";
            }
            if (this.beans < beans) {
                a_luck_of = "кофейных зёрен";
            }
            System.out.println("Не хватает " + a_luck_of);
        }
    }

    void addCoffee() {
        System.out.println("Напишите сколько мл. воды вы хотите добавить:");
        int add = this.scanner.nextInt();
        this.water += add;
        System.out.println("Напишите сколько мл. молока вы хотите добавить:");
        add = scanner.nextInt();
        this.milk += add;
        System.out.println("Напишите сколько гр. кофейных зёрен вы хотите добавить:");
        add = scanner.nextInt();
        this.beans += add;
        System.out.println("Напишите сколько одноразовых стаканчиков вы хотите добавить:");
        add = scanner.nextInt();
        this.glasses += add;
    }

    void takeDollars() {
        System.out.println("Сколько рублей вы хотите взять:");
        int give = this.scanner.nextInt();
        if (give >= this.money) {
            this.money -= give;
        } else {
            System.out.println("В кофемашине нет таких денег");
        }
    }
}
