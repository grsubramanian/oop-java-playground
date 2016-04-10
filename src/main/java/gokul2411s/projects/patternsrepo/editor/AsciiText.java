package gokul2411s.projects.patternsrepo.editor;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * A simple implementation of an ASCII text.
 */
class AsciiText {

  /**
   * A very naive choice for representing text given all the insertions and deletions that could
   * happen, but a good enough choice for demonstration purposes.
   */
  private final List<Ascii> asciiChars = new ArrayList<>();

  void append(char asciiChar) {
    Ascii ascii = Ascii.getByAsciiChar(asciiChar);
    Preconditions.checkNotNull(ascii);
    asciiChars.add(ascii);
  }

  void insert(char asciiChar, int index) {
    Ascii ascii = Ascii.getByAsciiChar(asciiChar);
    Preconditions.checkNotNull(ascii);
    asciiChars.add(index, ascii);
  }

  char delete(int index) {
    return asciiChars.remove(index).getAsciiChar();
  }

  int size() {
    return asciiChars.size();
  }

  @Override
  public String toString() {
    StringBuilder sb =  new StringBuilder();
    for (Ascii ascii : asciiChars) {
      sb.append(ascii.getAsciiChar());
    }
    return sb.toString();
  }

  /**
   * Represents the various Ascii characters.
   *
   * <p>Could think of this as the flywheel pattern.
   */
  static enum Ascii {

    ASCII_A('a'),
    ASCII_B('b'),
    ASCII_C('c'),
    ASCII_D('d'),
    ASCII_E('e'),
    ASCII_F('f'),
    ASCII_G('g'),
    ASCII_H('h'),
    ASCII_I('i'),
    ASCII_J('j'),
    ASCII_K('k'),
    ASCII_L('l'),
    ASCII_M('m'),
    ASCII_N('n'),
    ASCII_O('o'),
    ASCII_P('p'),
    ASCII_Q('q'),
    ASCII_R('r'),
    ASCII_S('s'),
    ASCII_T('t'),
    ASCII_U('u'),
    ASCII_V('v'),
    ASCII_W('w'),
    ASCII_X('x'),
    ASCII_Y('y'),
    ASCII_Z('z');

    /**
     * Encapsulated ASCII character.
     */
    private final char asciiChar;

    Ascii(char asciiChar) {
      this.asciiChar = asciiChar;
    }

    char getAsciiChar() {
      return asciiChar;
    }

    /**
     * Lookup of enum object given ASCII character.
     */
    private static final ImmutableMap<Character, Ascii> registry = getRegistry();

    private static ImmutableMap<Character, Ascii> getRegistry() {
      ImmutableMap.Builder<Character, Ascii> registryBuilder = ImmutableMap.builder();
      for(Ascii ascii : EnumSet.allOf(Ascii.class)) {
        registryBuilder.put(ascii.getAsciiChar(), ascii);
      }
      return registryBuilder.build();
    }

    static Ascii getByAsciiChar(char asciiChar) {
      return registry.get(asciiChar);
    }
  }
}
