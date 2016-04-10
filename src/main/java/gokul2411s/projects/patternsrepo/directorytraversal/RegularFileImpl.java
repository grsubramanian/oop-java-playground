package gokul2411s.projects.patternsrepo.directorytraversal;

import org.joda.time.Instant;

/**
 * A simple implementation of a regular file.
 */
class RegularFileImpl extends AbstractFile {

  RegularFileImpl(String name, Instant creationTimestamp) {
    super(name, creationTimestamp);
  }

  @Override
  public void allow(FileVisitor fileVisitor) {
    fileVisitor.visit(this);
  }
}
