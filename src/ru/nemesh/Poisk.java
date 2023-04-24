package ru.nemesh;

import org.jsoup.Jsoup;
import sun.security.ssl.BaseSSLSocketImpl;

import javax.lang.model.util.Elements;
import javax.swing.text.html.parser.Element;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Poisk {
    public static String poiskfio(String a) throws Exception {
        String google = "http://www.google.com/search?q=";
        String search = a;
        String charset = "UTF-8";
        String userAgent = "ExampleBot 1.0 (+http://example.com/bot)"; // Change this to your company's name and bot homepage!

        Elements links = (Elements) Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select("li.g>h3>a");

        for (Element link : links) {
            String title = link.text();
            String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
            url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

            if (!url.startsWith("http")) {
                continue; // Ads/news/etc.
            }

            System.out.print(url);
            System.out.print("\t\t\t");
            System.out.println(title);

            return a;
        }
    }
}
