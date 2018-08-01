package spellchecker;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个类用来说明为什么不要用硬编码风格的设计
 *
 * 这段代码看上去完全o**k，但实际上它隐含了“只有唯一一本字典”的前提条件。假设需要换一本完全不同的字典，
 * 比如字典从牛津换成柯林斯，甚至从英语字典换成德语字典，这时只能将{@link #dictionary}
 * 的final关键字去掉，然后编一个换字典方法。但这么干容易出错，而且对于并发很不友好。
 *
 * 对于行为被底层资源参数化的类（翻译过来感觉应该是行为参数化，可以通过策略模式和lambda表达式灵活实现），
 * 把它作为工具类或者作为单例都不是很好，这时候可以通过依赖注入，在类被创建时告知需要何种字典
 *
 * 顺便，关于行为参数化的理解可以参见这篇博客，关键词:策略模式，灵活，Lambda表达式。
 * https://blog.csdn.net/wangnan9279/article/details/71426184?locationNum=13&fps=1
 *
 * @author LightDance
 */
public class BadSpellChecker {
    private static final Lexicon dictionary = new Lexicon();

    /** Non-instantiable*/
    private BadSpellChecker() {}

    public static BadSpellChecker INSTANCE = new BadSpellChecker();

    public boolean isValid(String word) {
        //...
        return false;
    }

    public  List<String> suggestions(String typo){
        //...
        return new ArrayList<>();
    }

}
