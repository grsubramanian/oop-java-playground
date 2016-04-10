package gokul2411s.projects.patternsrepo.directorytraversal;

/**
 * Represents a directory on a filesystem.
 */
interface Directory extends File {

  void addFile(File file);
}
