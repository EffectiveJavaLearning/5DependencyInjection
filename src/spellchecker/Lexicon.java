package spellchecker;

import java.util.function.Supplier;

/**
 * 被当作资源以供{@link BadSpellChecker}使用
 *
 * @author LightDance
 */
public class Lexicon {

    public static Supplier<Lexicon> supplier = () ->new Lexicon();
}
