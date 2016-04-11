package gokul2411s.projects.patternsrepo.conditions;

/**
 * Represents truth values.
 */
public enum Truth {
  FALSE,
  TRUE,
  CANT_SAY;

  public static Truth and(Truth first, Truth second) {
    if (first == CANT_SAY || second == CANT_SAY) {
      return CANT_SAY;
    }

    if (first == TRUE && second == TRUE) {
      return TRUE;
    } else {
      return FALSE;
    }
  }

  public static Truth or(Truth first, Truth second) {
    if (first == TRUE || second == TRUE) {
      return TRUE;
    }

    if (first == FALSE && second == FALSE) {
      return FALSE;
    } else {
      return CANT_SAY;
    }
  }

  public static Truth not(Truth base) {
    switch (base) {
      case TRUE:
        return FALSE;
      case FALSE:
        return TRUE;
      case CANT_SAY:
        return CANT_SAY;
      default:
        return CANT_SAY;
    }
  }
}
