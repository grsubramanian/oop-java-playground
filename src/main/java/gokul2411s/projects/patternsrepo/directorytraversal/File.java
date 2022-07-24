package gokul2411s.projects.patternsrepo.directorytraversal;

import org.joda.time.Instant;

/**
 * Represents a file on a filesystem.
 */
interface File {

  String getName();

  String getPath();

  Directory getParentDirectory();

  void setParentDirectory(Directory parentDirectory);

  Instant getCreationTimestamp();

  /**
   * Allows a visitor access into the file.
   */
  void allow(FileVisitor fileVisitor);
}
