package com.example.algorithm.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// [PCCP 기출문제] 1번 / 붕대 감기
public class Solution81_2 {
    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        // 5
        //int[] bandage = {3, 2, 7};
        //int health = 20;
        //int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};
        // -1
        //int[] bandage = {4, 2, 7};
        //int health = 20;
        //int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};
        // -1
        //int[] bandage = {1, 1, 1};
        //int health = 5;
        //int[][] attacks = {{1, 2}, {3, 2}};
        // 3

        System.out.println(solution(bandage, health, attacks));
    }

    public static int solution(int[] rawBandage, int rawHealth, int[][] rawAttacks) {
        User user = new User(rawHealth);
        Bandage bandage = new Bandage(rawBandage[0], rawBandage[1], rawBandage[2]);
        Map<Integer, Attack> attacks = Arrays.stream(rawAttacks)
                .collect(HashMap::new, (map, attack) -> map.put(attack[0], new Attack(attack[1])), Map::putAll);
        Monster monster = new Monster(attacks);
        int lastAttackTime = rawAttacks[rawAttacks.length - 1][0];

        return new Game(user, bandage, monster, lastAttackTime).play()
                .getHealth();
    }

    private static class Game {
        private int time = 0;
        private final int lastAttackTime;
        private final User user;
        private final Bandage bandage;
        private final Monster monster;

        public Game(User user, Bandage bandage, Monster monster, int lastAttackTime) {
            this.user = user;
            this.bandage = bandage;
            this.monster = monster;
            this.lastAttackTime = lastAttackTime;
        }

        public User play() {
            while (this.time <= this.lastAttackTime && this.user.isAlive()) {
                Optional<Attack> attack = this.monster.getAttack(this.time);
                attack.ifPresentOrElse(this.user::attack, () -> this.user.recover(this.bandage));
                this.time++;
            }

            return this.user;
        }
    }

    private static class User {
        private final int maxHealth;
        private int health;
        private int continuousRecovery;

        public User(int health) {
            this.maxHealth = health;
            this.health = health;
        }

        public void recover(Bandage bandage) {
            int recoveredHealth = bandage.recover(this.health, ++this.continuousRecovery);

            if (recoveredHealth > this.maxHealth) {
                this.health = this.maxHealth;
            } else {
                this.health = recoveredHealth;
            }
        }

        public void attack(Attack attack) {
            this.health = attack.attack(this.health);
            this.continuousRecovery = 0;
        }

        public int getHealth() {
            return this.health <= 0 ? -1 : this.health;
        }

        public boolean isAlive() {
            return this.health > 0;
        }
    }

    private static class Bandage {
        private final int recoveryTime;
        private final int recovery;
        private final int additionalRecovery;

        public Bandage(int recoveryTime, int recovery, int additionalRecovery) {
            this.recoveryTime = recoveryTime;
            this.recovery = recovery;
            this.additionalRecovery = additionalRecovery;
        }

        public int recover(int health, int continuousRecovery) {
            int recoveredHealth = health + this.recovery;

            if (isReachedMaxHealTime(continuousRecovery)) {
                return recoveredHealth + this.additionalRecovery;
            }

            return recoveredHealth;
        }

        private boolean isReachedMaxHealTime(int continuousRecovery) {
            return this.recoveryTime <= continuousRecovery;
        }
    }

    private static class Monster {
        private final Map<Integer, Attack> attacks;

        public Monster(Map<Integer, Attack> attacks) {
            this.attacks = attacks;
        }

        public Optional<Attack> getAttack(int time) {
            return Optional.ofNullable(this.attacks.get(time));
        }
    }

    private static class Attack {
        private final int damage;

        public Attack(int damage) {
            this.damage = damage;
        }

        public int attack(int health) {
            return health - this.damage;
        }
    }
}