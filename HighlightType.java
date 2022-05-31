package com.example.demo;

public enum HighlightType {
  OPINION {
    public boolean isOpinion() {
      return true;
    }
  },
  FEATURE {
    public boolean isFeature() {
      return true;
    }
  };
}
