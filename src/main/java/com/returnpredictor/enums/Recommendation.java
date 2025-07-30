package com.returnpredictor.enums;

public enum Recommendation {
  ALLOW("Allow"),
  FLAG_FOR_MANUAL_REVIEW("Flag for Manual Review"),
  BLOCK_RETURN_PRIVILEGES("Block Return Privileges");

  private final String label;

  Recommendation(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }
}
