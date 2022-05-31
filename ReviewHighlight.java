package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewHighlight {

  private String type;
  private UUID id;
  private OffsetDateTime lastModificationTime;
  private int productExternalId;
  private String feature;
  private String reviewId;
  private OffsetDateTime reviewDate;
  private Float reviewRating;
  private String author;
  private String title;
  private String text;
  private UUID reviewLegacyId; // content_id
  private List<Highlight> highlightedTexts;
  private List<Highlight> highlightedTitles;
  private int sentiment;
  private boolean isIncentivized;
  private String providerId;
  private String field;
  private String nativeLanguage;
  private String nativeFeature;
  private String enTranslatedTitle;
  private String enTranslatedText;
}
