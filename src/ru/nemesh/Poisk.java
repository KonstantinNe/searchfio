package ru.nemesh;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import sun.security.ssl.BaseSSLSocketImpl;

import java.io.*;
import java.net.*;

public class Poisk {
    public static String poiskfio(String a) throws Exception {
      //  String google = "https://www.google.com/search?q=";
        String vk = "https://vk.com/search?q=";
        String search = a;
        //String charset = "UTF-8";
        String c = null;
        String result = null;

//        try {
//            Document doc = Jsoup.connect("https://www.example.com/").get();
//            Elements elements = doc.select("a");
//            for(Element element : elements){
//                System.out.println(element.absUrl("href"));
//                list.add(element.absUrl("href"));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        URL url = new URL("https://vk.com/search?q=" + a);
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
          //  Document document = Jsoup.connect("https://hh.ru/").get();

            File file = new File("vk.html");
            Document document = Jsoup.parse(file, "UTF-8", "vk.ru");
            
            while (reader.ready()) {

                result = reader.readLine();
//                c = reader.readLine();
//                result = String.valueOf(Check.getCheckfio(a,c));
//                if (result == String.valueOf(true));
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
