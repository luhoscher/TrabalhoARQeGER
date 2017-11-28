package br.udesc.modulo2.rss;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;

public class Rome {

    public static void main(String[] args) throws MalformedURLException, IOException, IllegalArgumentException, FeedException {
        String urlstring = "http://jmmwrite.wordpress.com/feed/";
        InputStream is = new URL(urlstring).openConnection().getInputStream();
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = (SyndFeed) input.build(new InputStreamReader(is, Charset.forName("UTF - 8")));

        Iterator entries = feed.getEntries().iterator();
        while (entries.hasNext()) {
            SyndEntry entry = (SyndEntry) entries.next();
            System.out.println("————");
            System.out.println(
                    "Title:" + entry.getTitle()
            );
            System.out.println(
                    "Published:" + entry.getPublishedDate());
            if (entry.getDescription() != null) {
                System.out.println(
                        "Description:" + entry.getDescription().getValue()
                );
            }
            if (entry.getContents().size() > 0) {
                SyndContent content = (SyndContent) entry.getContents().get(0);
                System.out.println(
                        "Content type =" + content.getType());
                System.out.println("Content value =" + content.getValue()
                );
            }
        }
    }
}
