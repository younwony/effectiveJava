package dev.wony.effectivejava.chapter_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import static dev.wony.effectivejava.chapter_1.Rank.JACK;
import static dev.wony.effectivejava.chapter_1.Rank.KING;
import static dev.wony.effectivejava.chapter_1.Rank.QUEEN;
import static dev.wony.effectivejava.chapter_1.StackWalker.getInstance;

/**
 * 아이템 1
 * 생성자 대신 정적 팩터리 메서드를 고려하라
 */
public class item_1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        factoryMethodConvention();
    }

    /**
     * 정적 팩터리 메서드의 장점
     * 1. 이름을 가질 수 있다.
     * 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.
     * 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
     * 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
     * 5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
     */

    // 1. 이름을 가질 수 있다.
    // 생성자는 클래스 이름과 같아야 하지만, 정적 팩터리 메서드는 이름을 자유롭게 지을 수 있다.
    public static Boolean valueOf(String s) {
        return s == "true" ? Boolean.TRUE : Boolean.FALSE;
    }

    // 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.
    // 불변 클래스는 인스턴스를 미리 만들어 놓거나 새로 생성한 인스턴스를 캐싱하여 재활용하는 식으로 불필요한 객체 생성을 피할 수 있다.
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    // 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
    // 반환할 객체의 클래스를 자유롭게 선택할 수 있게 하여 클라이언트에게 더욱 유연하게 객체를 반환할 수 있다.
    public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
        return EnumSet.noneOf(elementType); // EnumSet의 정적 팩터리 메서드
    }

    // 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
    // 반환 타입의 하위 타입이기만 하면 어떤 클래스의 객체를 반환하든 상관없다.
    public static <E extends Enum<E>> EnumSet<E> of(E first, E... rest) {
        return EnumSet.of(first, rest); // EnumSet의 정적 팩터리 메서드
    }

    // 5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
    // 서비스 제공자 프레임워크를 만드는 근간이 되는 아이디어이다.
    // JDBC가 그 예이다.
    // JDBC는 데이터베이스에 접근하는 표준 방법을 정의한 인터페이스이다.
    // JDBC를 구현한 각 드라이버는 정적 팩터리 메서드를 통해 자신의 인스턴스를 반환한다.
    // 이 패턴의 장점은 서비스 제공자의 독립성을 유지할 수 있다는 것이다.
    public static <T> T newInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<T> c = (Class<T>) Class.forName(className);
        return c.newInstance();
    }


    /**
     * 정적 팩터리 메서드의 단점
     * 1. 상속을 하려면 public이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
     * 2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다. - API 문서를 잘 써놓자.
     */

    // 1. 상속을 하려면 public이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
    // 상속보다는 컴포지션을 사용하도록 하자. - 컴포지션을 사용하면 불변 타입으로 만들 수 없는 클래스도 불변으로 만들 수 있다. (아래 예제 참고)
    // 컴포지션을 사용하면 불변 타입으로 만들 수 없는 클래스도 불변으로 만들 수 있다.
    // 불변 타입으로 만들 수 없는 클래스를 확장해야 한다면 정적 팩터리 메서드를 제공하면서, public이나 protected 생성자를 추가해야 한다.
    // public이나 protected 생성자를 추가하면 하위 클래스를 만들 수 있으니, 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다는 단점이 사라진다.

    public static class Complex {
        private final double re;
        private final double im;

        private Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public static Complex valueOf(double re, double im) {
            return new Complex(re, im);
        }
    }

    // 2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다. - API 문서를 잘 써놓자.
    // 생성자처럼 API 설명에 명확히 드러나지 않으니 사용자는 정적 팩터리 메서드 방식 클래스를 인스턴스화할 방법을 알아내야 한다.
    // 다음은 Boolean.valueOf(String) 메서드의 API 설명이다.
    // "주어진 문자열이 대소문자를 구분하지 않고 "true"와 일치하면 true를, 그렇지 않으면 false를 반환한다."
    // 이 설명만 보고는 Boolean 클래스가 어떤 식으로 동작하는지 알기 어렵다.
    // 하지만 생성자 대신 정적 팩터리 메서드를 사용하면 반환 타입만 보고도 해당 클래스가 어떤 식으로 동작하는지 알 수 있다.
    // 정적 팩터리 메서드 방식의 유연성을 높이려면 다음과 같은 규약을 지켜야 한다.
    // 이 규약은 선택적이다. 적용할 수 있으면 적용하고, 적용할 수 없으면 생성자만 제공하자.
    // 그러면 사용자는 생성자 대신 정적 팩터리 메서드를 사용할 수 있으며, API를 더 유연하게 진화시킬 수 있다.

    public static void factoryMethodConvention() throws ClassNotFoundException, IOException {
        // from - 매개변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메서드
        Date d = Date.from(Instant.now());

        // of - 여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메서드
        Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);

        // valueOf - from과 of의 더 자세한 버전
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);

        // instance or getInstance - 매개변수로 명시한 인스턴스를 반환하지만, 같은 인스턴스임을 보장하지는 않는다.
        String option = "OPTION";
        StackWalker luke = getInstance(option);

        // create or newInstance - instance or getInstance와 같지만, 매번 새로운 인스턴스를 생성해 반환함을 보장한다.
        Object newArray = Array.newInstance(StackWalker.class, 10);

        // getType - getInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다.
        Path path = Paths.get("README.md");
        FileStore fileStore = Files.getFileStore(path);

        // newType - newInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다.
        BufferedReader br = Files.newBufferedReader(path);

        // type - getType과 newType의 간결한 버전
        Vector<StackWalker> stackWalker = new Vector<>();
        stackWalker.add(luke);
        List<StackWalker> litany = Collections.list(stackWalker.elements());
    }
}
