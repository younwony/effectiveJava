package dev.wony.effectivejava.chapter_1.item_2;

public class NutritionFacts {

    private int servingSize; // (mL, 1회 제공량)     필수
    private int servings;    // (회, 총 n회 제공량) 필수
    private int calories;    // (1회 제공량당)       선택
    private int fat;         // (g/1회 제공량)       선택
    private int sodium;      // (mg/1회 제공량)      선택
    private int carbohydrate;// (g/1회 제공량)       선택

    public NutritionFacts() {
    }

    /**
     * 점층적 생성자 패턴
     *
     * 장점 : 필요한 매개변수만 받는 생성자를 정의할 수 있다.
     * 단점 : 매개변수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.
     *
     */
    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    /**
     * 자바빈즈 패턴
     *
     * 장점 : 점층적 생성자 패턴의 단점을 보완하고, 가독성이 좋다.
     * 단점 : 객체 하나를 만들려면 메서드를 여러 개 호출해야 하고, 객체가 완전히 생성되기 전까지는 일관성이 무너진 상태에 놓이게 된다.
     *
     */

    public NutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    /**
     * 빌더 패턴
     *
     * 장점 : 점층적 생성자 패턴의 안정성과 자바빈즈 패턴의 가독성을 겸비하였다.
     * 단점 : 객체를 생성하려면 빌더부터 생성해야 한다.
     *
     */

    public static class Builder {
        // 필수 매개변수
        private final int servingSize; // (mL, 1회 제공량)     필수
        private final int servings;    // (회, 총 n회 제공량) 필수

        // 선택 매개변수 - 기본값으로 초기화한다.
        private int calories = 0;    // (1회 제공량당)       선택
        private int fat = 0;         // (g/1회 제공량)       선택
        private int sodium = 0;      // (mg/1회 제공량)      선택
        private int carbohydrate = 0;// (g/1회 제공량)       선택

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
}
