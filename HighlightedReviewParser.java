package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@PropertySource("classpath:highlight.properties")
public class HighlightedReviewParser {

  private BufferedInputStream bufferedInputStream;
  private BufferedReader bufferedReader;

  @Autowired
  public HighlightedReviewParser(
      @Value("${highlight.review.file:example.json}") BufferedInputStream bufferedInputStream,
      BufferedReader bufferedReader) {
    this.bufferedInputStream = bufferedInputStream;
    this.bufferedReader = bufferedReader;
  }

  public List<ReviewHighlight> readJsonStream() throws IOException {
    bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
    JsonReader reader = new JsonReader(bufferedReader);
    List<ReviewHighlight> reviewHighlights = new ArrayList<>();
    Gson gson = new Gson();
    reader.beginArray();
    while (reader.hasNext()) {
      ReviewHighlight reviewHighlight = gson.fromJson(reader, ReviewHighlight.class);
      reviewHighlights.add(reviewHighlight);
    }
    reader.endArray();
    reader.close();
    return reviewHighlights;
  }
}
