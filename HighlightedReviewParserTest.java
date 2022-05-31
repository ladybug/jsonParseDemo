package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class HighlightedReviewParserTest {

  private BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("c:\\Users\\cindyturpin\\code\\chewy\\demo\\src\\main\\resources\\example.json"));
  private BufferedReader bufferedReader;

  private HighlightedReviewParser highlightedReviewParserUnderTest;

  HighlightedReviewParserTest() throws FileNotFoundException {
  }

  @BeforeEach
  void setUp() {
    highlightedReviewParserUnderTest =
        new HighlightedReviewParser(bufferedInputStream, bufferedReader);
  }

  @Test
  void testReadJsonStream() throws Exception {
    // Setup
    final List<ReviewHighlight> expectedResult = Collections.unmodifiableList((List<ReviewHighlight>) bufferedInputStream);
    Highlight highlight = new Highlight(UUID.fromString("46619555-f185-4f45-a1fa-f07b4c920098"), HighlightType.FEATURE, 0, 25);
    ReviewHighlight reviewHighlight = new ReviewHighlight("highlightedreview",
            UUID.fromString("14dd0140-f434-4446-a5c1-97f3883c2748"),
            OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC),
            0,
            "feature",
            "reviewId",
            OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC),
            0.0f,
            "author",
            "title",
            "text",
            UUID.fromString("8ed47d7f-b820-45b2-8cd2-9ca76daf7951"),
            List.of(highlight),
            List.of(highlight),
            0,
            false,
            "providerId",
            "field",
            "nativeLanguage",
            "nativeFeature",
            "enTranslatedTitle",
            "enTranslatedText");
    List.of(
            reviewHighlight);

    // Run the test
    final List<ReviewHighlight> result = highlightedReviewParserUnderTest.readJsonStream();

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test
  void testReadJsonStream_ThrowsIOException() {
    // Setup
    // Run the test
    assertThrows(IOException.class, () -> highlightedReviewParserUnderTest.readJsonStream());
  }
}
