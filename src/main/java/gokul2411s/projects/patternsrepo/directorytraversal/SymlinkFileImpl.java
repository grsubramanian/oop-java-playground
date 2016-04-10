package gokul2411s.projects.patternsrepo.directorytraversal;

import com.google.common.base.Preconditions;
import org.joda.time.Instant;

/**
 * Represents a file that acts a symlink to another file.
 */
class SymlinkFileImpl extends AbstractFile implements Symlink {

  private final File target;

  SymlinkFileImpl(String name, Instant creationTimestamp, File target) {
    super(name, creationTimestamp);
    Preconditions.checkArgument(target != this, "Symlink cannot refer to itself");
    this.target = target;
  }

  @Override
  public File getTarget() {
    return target;
  }

  @Override
  public void allow(FileVisitor fileVisitor) {
    fileVisitor.visit(this);
  }
}
