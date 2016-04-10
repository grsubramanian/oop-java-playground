package gokul2411s.projects.patternsrepo.directorytraversal;

import org.joda.time.Instant;

/**
 * A simple implementation of a regular directory.
 */
class RegularDirectoryImpl extends AbstractDirectory {

  RegularDirectoryImpl(String name, Instant creationTimestamp) {
    super(name, creationTimestamp);
  }

  @Override
  public synchronized void allow(FileVisitor fileVisitor) {
    for (File file : files.values()) {
      file.allow(fileVisitor);
    }
    fileVisitor.visit(this);
  }
}
