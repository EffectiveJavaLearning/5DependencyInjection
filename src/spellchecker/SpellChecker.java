package spellchecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 改进后的spellchecker，将需要的资源作为参数传入到构造方法中（本例中是构造方法，也适用于Builder，
 * 工厂方法等）。另外，将资源的工厂类传进来可以方便地根据需求创建多个资源对象，创建特定的子类对象，
 * 这也是依赖注入的有用变体之一。Java8中引入的{@link java.util.function.Supplier}接口，
 * 就非常适合这种依赖注入形式，只要在泛型中规定资源父类的类型，就可以根据需要选择该资源的具体子类实现。
 * 例如这一句Java类库中马赛克的例子：Mosaic create(Supplier<? extends Tile> tileFactory) { ... }
 *
 * @author LightDance
 */
public class SpellChecker {

    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        //...
        return false;
    }

    public  List<String> suggestions(String typo){
        //...
        return new ArrayList<>();
    }
}
