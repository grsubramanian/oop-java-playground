package gokul2411s.projects.patternsrepo.directorytraversal;

import org.joda.time.Instant;

import javax.annotation.Nullable;

/**
 * Represents a file on a filesystem.
 */
interface File {

  String getName();

  String getPath();

  Directory getParentDirectory();

  void setParentDirectory(@Nullable Directory parentDirectory);

  Instant getCreationTimestamp();

  /**
   * Allows a visitor access into the file.
   */
  void allow(FileVisitor fileVisitor);
}
