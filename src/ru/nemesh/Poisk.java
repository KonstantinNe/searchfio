package ru.nemesh;

import org.jsoup.Jsoup;
//import sun.security.ssl.BaseSSLSocketImpl;

import javax.lang.model.util.Elements;
import javax.swing.text.html.parser.Element;
import java.io.*;
import java.net.*;

public class Poisk {
    public static String poiskfio(String a) throws Exception {
        String google = "https://www.google.com/search?q=";
        String search = a;
        String charset = "UTF-8";
        String c = null;
        String result = null;

        URL url = new URL("https://www.google.com/search?q=" + a);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);


        try {
            OutputStream output = connection.getOutputStream();
            PrintStream sender = new PrintStream(output);
            sender.println(a);
        } catch (ConnectException e) {
            System.out.println(e.getMessage());
        }

        try {
            InputStream input = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            while (reader.ready()) {

                c = reader.readLine();
                result = String.valueOf(Check.getCheckfio(a,c));
                if (result == String.valueOf(true));
                return result;
             //   return c;

                //надо седалать вывод только найденных строк (url) где есть значение
            }
        } catch (ConnectException e) {
            System.out.println(e.getMessage());
        }
        return result;
        //return c;

        //  result = JsonConvert.convertJson(c);
    }
}


//        String userAgent = "ExampleBot 1.0 (+http://example.com/bot)"; // Change this to your company's name and bot homepage!
//
//        Elements links = (Elements) Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select("li.g>h3>a");
//
//        for (Element link : links) {
//            String title = link.text();
//            String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
//            url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");
//
//            if (!url.startsWith("http")) {
//                continue; // Ads/news/etc.
//            }
//
//            System.out.print(url);
//            System.out.print("\t\t\t");
//            System.out.println(title);
//
//            return a;
//        }
//    }
//}
