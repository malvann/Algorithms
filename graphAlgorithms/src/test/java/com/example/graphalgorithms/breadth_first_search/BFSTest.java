package com.example.graphalgorithms.breadth_first_search;

import org.junit.jupiter.api.Test;

class BFSTest {

    @Test
    void discoverWeb() {
        new WebCrouler().discoverWeb("https://www.w3schools.com/kotlin/index.php");
    }
}