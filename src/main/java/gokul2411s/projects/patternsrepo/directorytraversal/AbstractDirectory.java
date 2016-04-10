package gokul2411s.projects.patternsrepo.directorytraversal;

import com.google.common.base.Preconditions;
import org.joda.time.Instant;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an abstract {@link Directory} that provides synchronized access to file addition and
 * deletion.
 */
abstract class AbstractDirectory extends AbstractFile implements Directory {

  protected Map<String, File> files = new HashMap<>();

  AbstractDirectory(String name, Instant creationTimestamp) {
    super(name, creationTimestamp);
  }

  @Override
  public synchronized void addFile(File file) {
    File existingFile = files.get(file.getName());
    Preconditions.checkState(
        existingFile == null, "Two files with same name cannot exist in the same directory");
    file.setParentDirectory(this);
    files.put(file.getName(), file);
  }
}
