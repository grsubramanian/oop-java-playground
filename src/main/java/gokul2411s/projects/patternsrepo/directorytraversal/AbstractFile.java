package gokul2411s.projects.patternsrepo.directorytraversal;

import org.joda.time.Instant;

import java.lang.ref.WeakReference;
import java.util.Stack;

/**
 * Represents an abstract file.
 */
abstract class AbstractFile implements File {

  protected final String name;
  protected final Instant creationTimestamp;
  protected WeakReference<Directory> parentDirectory;

  AbstractFile(String name, Instant creationTimestamp) {
    this.name = name;
    this.creationTimestamp = creationTimestamp;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public synchronized String getPath() {
    Stack<String> pathComponents = new Stack<>();
    File parent = this;
    while (parent != null) {
      pathComponents.push(parent.getName());
      parent = parent.getParentDirectory();
    }

    StringBuilder sb = new StringBuilder();
    while (!pathComponents.empty()) {
      String pathComponent = pathComponents.pop();
      sb.append("/");
      sb.append(pathComponent);
    }
    return sb.toString();
  }

  @Override
  public synchronized Directory getParentDirectory() {
    return parentDirectory != null ? parentDirectory.get() : null;
  }

  @Override
  public synchronized void setParentDirectory(Directory parentDirectory) {
    if (parentDirectory == null) {
      this.parentDirectory = null;
    } else {
      this.parentDirectory = new WeakReference<Directory>(parentDirectory);
    }
  }

  @Override
  public Instant getCreationTimestamp() {
    return creationTimestamp;
  }
}
