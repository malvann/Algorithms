package com.example.graphalgorithms.breadth_first_search;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class WebCrouler {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final Queue<String> queue = new LinkedList<>();
    private final Set<String> discoveredWebSites = new HashSet<>();

    public void discoverWeb(String rootSite) {
        queue.add(rootSite);

        String poll;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            if (discoveredWebSites.contains(poll)) continue;

            discoveredWebSites.add(poll);
            queue.addAll(getRefs(poll));
            System.out.println(poll);
        }
    }

    private Collection<String> getRefs(String url) {
        try (InputStream inputStream = new URL(url).openStream()) {
            String page = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return Pattern.compile("https://(\\w+\\.)*(\\w+)").matcher(page)
                    .results()
                    .map(MatchResult::group)
                    .toList();
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        return Collections.emptyList();
    }
}
