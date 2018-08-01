import spellchecker.BadSpellChecker;
import spellchecker.Lexicon;
import spellchecker.SpellChecker;

/**
 * 很多类要依赖一些资源，比如拼写检查器与字典，和一些安卓开发时的图片、字符串资源依赖。
 * 但有些这样需要依赖其他资源的类被设计得很烂{@link spellchecker.BadSpellChecker}
 *
 * 分析需求，我们需要（或者说为了方便以后的版本更新而需要）一个能够根据需求而使用不同字典，
 * 并且在spellchecker创建时就能将需要的资源告知构造方法的类，这就是依赖注入的形式之一。
 * {@link spellchecker.SpellChecker}
 *
 * 其实看了上述的代码，会发现其实这种方式可能已经被我们多次无意识地使用过了。
 * 但是面对大型项目中成千上万种资源，可能会招架不住。幸亏很多框架比如Spring，
 * 已经帮我们实现了资源注入的管理，我们自己编写的依赖注入可以很好地兼容这些框架。
 *
 * 总之，不要使用硬编码，为了适应多变的需求，应该通过依赖注入提高类的灵活性、可重用性和可测试性。
 *
 * @author LightDance
 */
public class PreferDependencyInjection {

    public static void main(String[] args) {
        //bad
        BadSpellChecker spellChecker1 = BadSpellChecker.INSTANCE;
        spellChecker1.isValid("vegeta");

        //recommend
        SpellChecker spellChecker2 = new SpellChecker(Lexicon.supplier.get());
        spellChecker2.isValid("Kakarotto");
    }

}
