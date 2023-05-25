package dev.wony.effectivejava.chapter_2.item_2;

/**
 * 아이템 2
 * 생성자에 매개변수가 많다면 빌더를 고려하라
 */
public class item_2 {
    public static void main(String[] args) {
        // 점층적 생성자 패턴
        NutritionFacts nutritionFacts = new NutritionFacts(1, 2, 3, 4, 5, 6);

        // 자바빈즈 패턴
        NutritionFacts nutritionFacts2 = new NutritionFacts();
        nutritionFacts2.setServingSize(1);
        nutritionFacts2.setServings(2);
        nutritionFacts2.setCalories(3);
        nutritionFacts2.setFat(4);
        nutritionFacts2.setSodium(5);
        nutritionFacts2.setCarbohydrate(6);

        // 빌더 패턴
        NutritionFacts nutritionFacts3 = new NutritionFacts.Builder(1, 2)
                .calories(3)
                .fat(4)
                .sodium(5)
                .carbohydrate(6)
                .build();
    }


}
