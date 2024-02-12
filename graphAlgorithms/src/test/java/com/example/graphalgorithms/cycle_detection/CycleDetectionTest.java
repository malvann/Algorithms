package com.example.graphalgorithms.cycle_detection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CycleDetectionTest {
    @Test
    void test_detected() {
        DetectionNode b = new DetectionNode("b", List.of());
        DetectionNode d = new DetectionNode("d", List.of());
        DetectionNode c = new DetectionNode("c", List.of(b, d));
        DetectionNode e = new DetectionNode("e", List.of(d));
        DetectionNode a = new DetectionNode("a", List.of(c, e));
        d = new DetectionNode("d", List.of(a));
        assertTrue(new CycleDetection().detect(List.of(a,b,c,d,e)));
    }

    @Test
    void test_undetected() {
        DetectionNode b = new DetectionNode("b", List.of());
        DetectionNode d = new DetectionNode("d", List.of());
        DetectionNode c = new DetectionNode("c", List.of(b, d));
        DetectionNode e = new DetectionNode("e", List.of(d));
        DetectionNode a = new DetectionNode("a", List.of(c, e));
        assertFalse(new CycleDetection().detect(List.of(a,b,c,d,e)));
    }
}