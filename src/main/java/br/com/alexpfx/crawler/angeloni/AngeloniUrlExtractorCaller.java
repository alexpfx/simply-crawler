package br.com.alexpfx.crawler.angeloni;
import br.com.alexpfx.crawler.*;
import br.com.alexpfx.crawler.parser.*;
import br.com.alexpfx.crawler.visitor.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.util.*;


/**
 * Created by alexandre on 17/05/2016.
 */
public class AngeloniUrlExtractorCaller {

    private static final String BASE_URI = "http://www.angeloni.com.br";


    protected final Collection<String> extract(Visitor visitor, Parser parser, String baseUrl) {
        String html = visitor.visit(baseUrl);
        Document doc = (Document)parser.parse(html);
        doc.setBaseUri(BASE_URI);
        Elements elements = doc.select("a.lnkTp01 ");
        Elements tp02 = doc.select("a.lnkTp02 ");
        elements.addAll(tp02);
        return extract(elements);
    }

    private Set<String> extract(Elements elements) {
        Set<String> set = new HashSet<>();
        elements.forEach(e -> {
            String href = e.attr("abs:href");
            set.add(href);
        });
        return set;
    }


}